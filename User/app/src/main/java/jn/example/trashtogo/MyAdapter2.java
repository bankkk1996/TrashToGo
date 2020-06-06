package jn.example.trashtogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private Context context;
    private ArrayList<Trash> trashes;

    public MyAdapter2(Context c, ArrayList<Trash> f){
        context = c;
        trashes = f;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(trashes.get(position).getName());
        holder.price.setText("Price : "+trashes.get(position).getPrice());
        holder.type.setText("Type : "+trashes.get(position).getType());
        Picasso.get().load(trashes.get(position).getImage()).into(holder.view);
    }

    @Override
    public int getItemCount() {
        return trashes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView price;
        private TextView type;
        private ImageView view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtNametrash);
            price = itemView.findViewById(R.id.txtprice);
            type = itemView.findViewById(R.id.txtType);
            view = itemView.findViewById(R.id.imgTrash);
        }
    }
}
