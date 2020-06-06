package jn.example.trashtogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Factory> factories;

    public MyAdapter(Context c,ArrayList<Factory> f){
        context = c;
        factories = f;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(factories.get(position).getName());
        holder.address.setText(factories.get(position).getAddress());

        Picasso.get().load(factories.get(position).getImage()).into(holder.view);
    }

    @Override
    public int getItemCount() {
        return factories.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView address;
        private ImageView view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtNameFac);
            address = itemView.findViewById(R.id.txtaddress);
            view = itemView.findViewById(R.id.imgFac);
        }
    }
}
