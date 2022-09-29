package com.example.shoppingappnew;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModelDetail{
    String itemName;
    ArrayList<Model> modelData;

    public ModelDetail(String itemName, ArrayList<Model> modelData) {
        this.itemName = itemName;
        this.modelData = modelData;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ArrayList<Model> getModelData() {
        return modelData;
    }

    public void setModelData(ArrayList<Model> modelData) {
        this.modelData = modelData;
    }
}
