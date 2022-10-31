package com.example.shoppingappnew;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.DisposableHandle;

public class CartActivity extends AppCompatActivity {

    RecyclerView cart_recycler;
    Button cart_order_place;

    TextView ccart_name, ccart_category, ccart_price, ccart_description;
    ImageView ccart_image;

    List<Cart> cartList = new ArrayList<>();
    String name,category,price,description;
    int image;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        Intent intent = getIntent();


        cart_recycler = (RecyclerView) findViewById(R.id.cartItem);

        name = intent.getStringExtra("cname");
        category = intent.getStringExtra("ccategory");
        price = intent.getStringExtra("cprice");
        description = intent.getStringExtra("cdescription");
        image = intent.getExtras().getInt("cimage");

        ccart_name =(TextView) findViewById(R.id.cart_name);
        ccart_category = (TextView) findViewById(R.id.cart_category);
        ccart_price = (TextView) findViewById(R.id.cart_price);
        //ccart_description =(TextView) findViewById(R.id.cart_description);
        ccart_image = (ImageView) findViewById(R.id.cart_image);

        cartList.add(new Cart(name,category,price,description,image));


        /*
        ccart_name.setText(name);
        ccart_category.setText(category);
        ccart_price.setText(price);
        ccart_description.setText(description);
        ccart_image.setImageResource(image);
    */

        cart_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        CartAdapter cartAdapter = new CartAdapter(getApplicationContext(), cartList);
        cart_recycler.setAdapter(cartAdapter);
        //cart_order_place = (Button) findViewById(R.id.placeOrder);


    }


}
