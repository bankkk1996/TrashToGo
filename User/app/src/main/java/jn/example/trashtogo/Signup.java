package jn.example.trashtogo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    private EditText editName,editEmail,editPassword,editCFPassword;
    private FirebaseAuth auth;
    private TextView btnLogin;
    private Button btnSignup;
    private ImageView back;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editName = findViewById(R.id.editTxtNameSignUp);
        editEmail = findViewById(R.id.editTxtEmailSignUp);
        editPassword = findViewById(R.id.editTxtPassSignUp);
        editCFPassword = findViewById(R.id.editTxtCmPassSignUp);
        btnLogin = findViewById(R.id.txtBack);
        back = findViewById(R.id.imgBack);
        btnSignup = findViewById(R.id.btnSignUp);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("User");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    public void Back(){
        onBackPressed();
    }

    private void registerUser(){
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String cmpassword = editCFPassword.getText().toString().trim();
        final String name = editName.getText().toString().trim();
        if(name.isEmpty()){
            editName.setError("Name is required");
            editName.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editEmail.setError("Email is required");
            editEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Please enter a valid email");
            editEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editPassword.setError("Password is required");
            editPassword.requestFocus();
            return;
        }
        if(cmpassword.isEmpty()){
            editCFPassword.setError("Password Confirm is required");
            editCFPassword.requestFocus();
            return;
        }
        //Create User
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(auth.getUid().toString(),"user");
                    DatabaseReference reference = myRef.push();
                    myRef.child(reference.getKey()).setValue(user);
                    UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    firebaseUser.updateProfile(request);
                    OpenBegin();
                }else{
                }
            }
        });
    }

    public void OpenBegin(){
        Intent intent = new Intent(this,Begin.class);
        startActivity(intent);
    }
}