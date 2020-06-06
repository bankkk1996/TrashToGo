package jn.example.trashtogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class Profile extends AppCompatActivity {
    private TextView name;
    private TextView time;
    private ImageView view;
    private FirebaseUser user;
    private TextView TxtCall,TxtFac,TxtType;
    private ImageView imgCall,imgFac,imgType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.TxtNameProfileMenu);
        time = findViewById(R.id.TxtTimeProfile);
        view = findViewById(R.id.imgProfile);
        user = FirebaseAuth.getInstance().getCurrentUser();
        TxtCall = findViewById(R.id.txtCall);
        TxtFac = findViewById(R.id.txtFac);
        TxtType = findViewById(R.id.txtType);
        imgCall = findViewById(R.id.imgCall);
        imgFac = findViewById(R.id.imgFac);
        imgType = findViewById(R.id.imgType);
        Calendar now = Calendar.getInstance();
        if(now.get(Calendar.AM_PM)==Calendar.AM){
            time.setText("Good Morning");
        }else{
            time.setText("Good Night");
        }
        if(user.getDisplayName()!=""){
            name.setText(user.getDisplayName());
        }
        else{
            name.setText("Hello User");
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenu();
            }
        });

        //Call page
        TxtCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenInfor();
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenInfor();
            }
        });

        //Fac Page
        TxtFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFac();
            }
        });

        imgFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFac();
            }
        });

        //Type Page
        TxtType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenType();
            }
        });

        imgType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenType();
            }
        });

    }

    public void OpenMenu(){
        Intent intent = new Intent(this,Profile_Menu.class);
        startActivity(intent);
    }

    public void OpenInfor(){
        Intent intent = new Intent(this,Info.class);
        startActivity(intent);
    }

    public void OpenFac(){
        Intent intent = new Intent(this,trashFac.class);
        startActivity(intent);
    }

    public void OpenType(){
        Intent intent = new Intent(this,Type.class);
        startActivity(intent);
    }
}