package com.example.shoppingappnew;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModelDetail extends AppCompatActivity {

    ImageView img, back;
    TextView detail_name, detail_category, detail_price, detail_description;
    ImageView detail_image;

    String name, category, price, description;
    int image;
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

        detail_name.setText(name);
        detail_category.setText(category);
        detail_price.setText(price);
        detail_description.setText(description);
        detail_image.setImageResource(image);

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
