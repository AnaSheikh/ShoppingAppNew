package com.example.shoppingappnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> itemList = new ArrayList<>();
    ItemAdapter adapter;
    String [] name;
    String [] category;
    String [] price;
    String [] description;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewitemnew);
        DisplayItems();


    }
    public void DisplayItems()
    {
        name= new String[]{"Anas","Muhammad","Sheikh","Ali","Maaz","Ammar","Adil","Rasheed"};
        category = new String[]{"Pakistan","India","Nepal","Switerzland","Canada","Sri Lanka","Paris","France"};
        price = new String[]{"0332","0445","0987","8723","2423","2341","2341","4135","5623"};
        description = new String[]{"Pakistan","India","Nepal","Switerzland","Canada","Sri Lanka","Paris","France"};
        for(int i = 0;i< name.length;i++)
        {
            Model model = new Model(name[i],category[i],price[i],description[i]);
            itemList.add(model);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new ItemAdapter(itemList,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}