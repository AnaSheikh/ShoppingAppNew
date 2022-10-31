package com.example.shoppingappnew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>implements Filterable {

    ArrayList<Model> itemList;
    ArrayList<Model> itemListFull;
    Context context;


    public ItemAdapter(ArrayList<Model> itemListNew) {
        this.itemList = itemListNew;
        this.itemListFull = itemListNew;
    }

    public ItemAdapter(ArrayList<Model> itemListNew, Context context) {
        this.itemList = itemListNew;
        this.itemListFull = itemListNew;
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
        holder.imageView.setImageResource(itemList.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context,ModelDetail.class);
                i.putExtra("name",itemList.get(position).getName());
                i.putExtra("category",itemList.get(position).getCategory());
                i.putExtra("price",itemList.get(position).getPrice());
                i.putExtra("description",itemList.get(position).getDescription());
                i.putExtra("image",itemList.get(position).getImage());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
                /*
                Intent intent= new Intent(context,ModelDetail.class);
                intent.putExtra("name",name);
                context.startActivity(intent);

                 */
        }});
        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,CartActivity.class);
                i.putExtra("cname",itemList.get(position).getName());
                i.putExtra("ccategory",itemList.get(position).getCategory());
                i.putExtra("cprice",itemList.get(position).getPrice());
                i.putExtra("cdescription",itemList.get(position).getDescription());
                i.putExtra("cimage",itemList.get(position).getImage());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

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


    @Override
    public Filter getFilter(){
        Filter exampleFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
              FilterResults filterResults = new FilterResults();
              if(charSequence == null || charSequence.length()==0)
              {
                  filterResults.values = itemListFull;
                  filterResults.count = itemListFull.size();
              }
              else {
                  String searchString = charSequence.toString().toLowerCase(Locale.ROOT);
                  List<Model> newData = new ArrayList<>();
                  for(Model model: itemListFull)
                  {
                      if(model.getName().toLowerCase(Locale.ROOT).contains(searchString))
                      {
                          newData.add(model);
                      }
                  }
                  filterResults.values = newData;
                  filterResults.count = newData.size();
              }
              return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                itemList = (ArrayList<Model>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return exampleFilter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,category,price,description;
        ImageView imageView;
        Button cart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
            description= itemView.findViewById(R.id.detail_description);
            imageView = itemView.findViewById(R.id.imageView);
            cart = itemView.findViewById(R.id.add_cart);

        }
    }
}
