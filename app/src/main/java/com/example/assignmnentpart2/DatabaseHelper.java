package com.example.assignmnentpart2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Store.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "store";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_4 = "AGE";
    public static final String COL_5 = "PHONE";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table product (id integer primary key autoincrement, name varchar, age varchar,phone number)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists store");
        onCreate(db);

    }

    public boolean addItems (String name, String age, String phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("phone", phone);
        db.insert("store", null, contentValues);
        db.close();
        return true;
    }

//    public boolean updateItems (String id,String name, String age, String phone ) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("id", id);
//        contentValues.put("name", name);
//        contentValues.put("age", age);
//        contentValues.put("phone", phone);
//        db.update(TABLE_NAME, contentValues, " ID = ? ", new String[] {id});
//        return true;
//    }

    //it returns the rows to be deleted which is an integer value
    public Integer deleteProduct (String id)  {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, " ID = ? ", new String[] {id});
    }

    public Cursor viewAllProduct() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" select * from " + TABLE_NAME, null);
        return  res;
    }
}

