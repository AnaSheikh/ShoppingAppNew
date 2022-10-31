package com.example.shoppingappnew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    Context context;
    List<Cart> cartList;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);

        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.cart_name.setText(cartList.get(position).getName());
        holder.cart_category.setText(cartList.get(position).getCategory());
//        holder.cart_description.setText(cartList.get(position).getDescription());
        holder.cart_price.setText(cartList.get(position).getPrice());
        holder.cart_image.setImageResource(cartList.get(position).getImage());

        holder.cart_number.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                Cart cart = cartList.get(position);
                cart.amount = i1;


            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder
    {

        TextView cart_name, cart_category, cart_price, cart_description;
        ImageView cart_image;
        NumberPicker cart_number;
        Button cart_button;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cart_image = (ImageView) itemView.findViewById(R.id.cart_image);
            cart_name = (TextView) itemView.findViewById(R.id.cart_name);
            cart_category = (TextView) itemView.findViewById(R.id.cart_category);
            cart_price = (TextView) itemView.findViewById(R.id.cart_price);
           // cart_description = (TextView) itemView.findViewById(R.id.cart_description);
            cart_button = (Button)itemView.findViewById(R.id.add_cart);

            cart_number = (NumberPicker) itemView.findViewById(R.id.cart_number_picker);
        }


    }
}
