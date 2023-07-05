package com.pushnotification.company_bookproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static  String name = "Book";
    public static  int version = 9;

    public DBHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS booksdata (id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT , author TEXT, price TEXT,image TEXT , offer TEXT)");

    }
    public void addbookinfo(String Name,String Price ,String Author,String image,String Offer){

        ContentValues values = new ContentValues();
        values.put("name",Name);
        values.put("price",Price);
        values.put("author",Author);
        values.put("image",image);
        values.put("offer",Offer);
        SQLiteDatabase db =this.getWritableDatabase();
        db.insert("booksdata",null,values);
        db.close();
    }
    @SuppressLint("Range")
    public List<bookinfo>getinfo(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM booksdata";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<bookinfo>list = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                String id= cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String offer = cursor.getString(cursor.getColumnIndex("offer"));
                list.add(new bookinfo(id,name,price,author,image,offer));
            }
            while (cursor.moveToNext());
        }


        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 // db.execSQL("DROP TABLE IF EXISTS booksdata");

    }
}
