package jn.example.trashtogo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Type extends AppCompatActivity {
    private DatabaseReference reference;
    private RecyclerView recyclerView;
    private ArrayList<Trash> list;
    private MyAdapter2 myAdapter;
    private ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerviewType);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Trash>();
        view = findViewById(R.id.imageView3);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        reference = FirebaseDatabase.getInstance().getReference().child("Trash");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> name = new ArrayList<>();
                ArrayList<String> price = new ArrayList<>();
                ArrayList<String> type = new ArrayList<>();
                ArrayList<String> image = new ArrayList<>();
                ArrayList<String> imageName = new ArrayList<>();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    name.add(snapshot.child("name").getValue().toString());
                    price.add(snapshot.child("price").getValue().toString());
                    type.add(snapshot.child("type").getValue().toString());
                    image.add(snapshot.child("image").getValue().toString());
                    imageName.add(snapshot.child("imageName").getValue().toString());
                }
                for (int i = 0; i<name.size();i++){
                    list.add(new Trash(name.get(i),imageName.get(i),image.get(i),price.get(i),type.get(i)));
                }
                myAdapter = new MyAdapter2(Type.this,list);
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Type.this,"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}