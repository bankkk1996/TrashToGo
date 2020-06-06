package jn.example.trashtogo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class trashFac extends AppCompatActivity {
    private DatabaseReference reference;
    private RecyclerView recyclerView;
    private ArrayList<Factory> list;
    private MyAdapter myAdapter;
    private TextView textView;
    private ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_fac);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Factory>();
        textView = findViewById(R.id.txtBackFac);
        view = findViewById(R.id.imgBackFac);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        reference = FirebaseDatabase.getInstance().getReference().child("Factory");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> name = new ArrayList<>();
                ArrayList<String> address = new ArrayList<>();
                ArrayList<String> image = new ArrayList<>();
                ArrayList<String> imageName = new ArrayList<>();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    name.add(snapshot.child("name").getValue().toString());
                    address.add(snapshot.child("address").getValue().toString());
                    image.add(snapshot.child("image").getValue().toString());
                    imageName.add(snapshot.child("imageName").getValue().toString());
                }
                for (int i = 0; i<name.size();i++){
                    list.add(new Factory(address.get(i),image.get(i),imageName.get(i),name.get(i)));
                }
                myAdapter = new MyAdapter(trashFac.this,list);
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(trashFac.this,"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}