package com.example.a20f_1066_smd_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbQueries extends SQLiteOpenHelper {
    public DbQueries(@Nullable Context context) {
        super(context, "VehiclesDB", null, 1);
        Log.d("TAG", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Query = "CREATE TABLE CONTACTS("+ "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+ "Name TEXT,"+ "CNIC INTEGER,"+ "City TEXT,"+ "Color TEXT,"+ "Model TEXT,"+ "CC INTEGER)";
        sqLiteDatabase.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //adding data in database
    public void AddContacts(HashMap<String, String> contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", contact.get("_id"));
        contentValues.put("Name", contact.get("name"));
        contentValues.put("CNIC", contact.get("cnic"));
        contentValues.put("City", contact.get("city"));
        contentValues.put("Color", contact.get("color"));
        contentValues.put("Model", contact.get("carmodel"));
        contentValues.put("CC", contact.get("engine"));
        db.insert("RECORDS", null, contentValues);
        //long i = db.insert("CONTACTS", null, contentValues);  We can check by if else by checking -1
    }

}
