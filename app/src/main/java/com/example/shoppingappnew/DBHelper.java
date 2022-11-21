package com.example.shoppingappnew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME= "shopping";
    int [] images;
    public DBHelper(Context context) {
        super(context,"shopping",null,1);
    }

    @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create Table items(name TEXT , category TEXT,price TEXT, description TEXT )");

        }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists items");
    }
    public boolean insertData(String name, String category, String price, String description )
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("category",category);
        contentValues.put("price",price);
        contentValues.put("description",description);
        //contentValues.put("image",imagee);


        long result  = MyDB.insert("items",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public ArrayList<Model> readItems(){
        images = new int[]{R.drawable.dresshirt, R.drawable.cottonpent, R.drawable.jeanspent,R.drawable.shirt,R.drawable.trouser,R.drawable.coa,R.drawable.shoes,R.drawable.ring};

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursoritems = db.rawQuery("Select * from items",null);
        ArrayList<Model> items = new ArrayList<>();

        if(cursoritems.moveToFirst())
        {
            do{
                items.add(new Model(cursoritems.getString(0),
                        cursoritems.getString(1),
                        cursoritems.getString(2),
                        cursoritems.getString(3)));
                        //cursoritems.getBlob(5)));
            }
            while (cursoritems.moveToNext());
        }
        cursoritems.close();
        return items;
    }
}
