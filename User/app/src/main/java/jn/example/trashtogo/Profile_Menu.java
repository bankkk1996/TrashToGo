package jn.example.trashtogo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private TextView name;
    private FirebaseUser user;
    private NavigationView navigation;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__menu);
        name = (TextView) findViewById(R.id.TxtNameProfileMenu);
        user = FirebaseAuth.getInstance().getCurrentUser();
        auth = FirebaseAuth.getInstance();
        navigation = findViewById(R.id.navView);

//        if(user.getDisplayName()!=""){
//            name.setText(user.getDisplayName()+"");
//        }
//        else{
//            name.setText("Hello User");
//        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_logout){
            auth.signOut();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return false;
    }

}