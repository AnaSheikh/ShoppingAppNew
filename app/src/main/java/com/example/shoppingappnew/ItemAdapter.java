package com.example.shoppingappnew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    ArrayList<Model> itemList;
    Context context;


    public ItemAdapter(ArrayList<Model> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }


    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(itemList.get(position).getName());
        holder.category.setText(itemList.get(position).getCategory());
        holder.price.setText(itemList.get(position).getPrice());
        //holder.description.setText(itemList.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context,ModelDetail.class);
                i.putExtra("name",itemList.get(position).getName());
                i.putExtra("category",itemList.get(position).getCategory());
                i.putExtra("price",itemList.get(position).getPrice());
                i.putExtra("description",itemList.get(position).getDescription());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
                /*
                Intent intent= new Intent(context,ModelDetail.class);
                intent.putExtra("name",name);
                context.startActivity(intent);

                 */
        }});

        }


        public Model getModelBasedOnName(String name)
        {
            for(Model temp:itemList)
            {
                if(temp.name == name)
                {
                    return temp;
                }
            }
            return null;
        }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,category,price,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
            description= itemView.findViewById(R.id.detail_description);

        }
    }
}
