package com.example.shoppingappnew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModelDetail extends AppCompatActivity {

    ImageView img, back;
    TextView detail_name, detail_category, detail_price, detail_description;
    ImageView detail_image;
    Button cart;
    Context context;

    String name, category, price, description;
    int image;


    public ModelDetail() {
    }

    public ModelDetail(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_view);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        category = intent.getStringExtra("category");
        price = intent.getStringExtra("price");
        description = intent.getStringExtra("description");
        image = intent.getExtras().getInt("image");

        detail_name = findViewById(R.id.detail_name);
        detail_category = findViewById(R.id.detail_category);
        detail_price = findViewById(R.id.detail_price);
        detail_description = findViewById(R.id.detail_description);
        detail_image = findViewById(R.id.big_image);
        cart = findViewById(R.id.add_to_cart);


        detail_name.setText(name);
        detail_category.setText(category);
        detail_price.setText(price);
        detail_description.setText(description);
        detail_image.setImageResource(image);
/*

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModelDetail.this,CartActivity.class);
                i.putExtra("name",detail_name.getText());
                i.putExtra("category",detail_category.getText());
                i.putExtra("price",detail_price.getText());
                i.putExtra("description",detail_description.getText());
                i.putExtra("image",detail_image.getImageAlpha());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        });

 */
/*
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ModelDetail.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

 */
    }
}
