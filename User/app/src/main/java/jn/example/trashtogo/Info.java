package jn.example.trashtogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Info extends AppCompatActivity {

    private Button btnNext;
    private EditText NameCall,TelCall,AmountCall,DetailCall;
    private FirebaseUser user;
    private TextView textView;
    private ImageView view;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        user = FirebaseAuth.getInstance().getCurrentUser();
        NameCall = findViewById(R.id.NameCall);
        NameCall.setText(user.getDisplayName());
        TelCall = findViewById(R.id.telInfo);
        AmountCall = findViewById(R.id.amountInfo);
        DetailCall = findViewById(R.id.detailInfo);
        btnNext = findViewById(R.id.btnNext);
        textView = findViewById(R.id.TxtbackInfo);
        view = findViewById(R.id.imgBackInfo);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Request");



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMap();
            }
        });
    }

    public void OpenMap(){
        Intent intent = new Intent(this,Profile.class);
        String name = NameCall.getText().toString().trim();
        String tel = TelCall.getText().toString().trim();
        String amount = AmountCall.getText().toString().trim();
        String detail = DetailCall.getText().toString().trim();
        Request request = new Request(name,tel,amount,detail,user.getUid(),"","Pending");

        DatabaseReference r = reference.push();
        reference.child(r.getKey()).setValue(request);
        startActivity(intent);
    }


}