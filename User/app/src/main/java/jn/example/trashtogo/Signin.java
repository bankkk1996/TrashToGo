package jn.example.trashtogo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    private TextView txtSignup;
    private Button btnLogin;
    private EditText EditEmail;
    private EditText EditPassword;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        EditEmail = findViewById(R.id.editEmailSignIn);
        EditPassword = findViewById(R.id.editPassSignIn);
        txtSignup = findViewById(R.id.txtSingUp);
        btnLogin = findViewById(R.id.btnLoginSignIn);
        auth = FirebaseAuth.getInstance();
        if(auth!=null){
//            auth.signOut();
//            openBegin();
        }
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    public void Login(){
        String email = EditEmail.getText().toString().trim();
        String password = EditPassword.getText().toString().trim();
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    openbegin();
                }
            }
        });
    }


    public void opensignup(){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }


    public void openbegin(){
        Intent intent = new Intent(this,Begin.class);
        startActivity(intent);
    }
    public void openBegin() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}