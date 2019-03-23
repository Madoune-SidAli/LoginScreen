package com.example.sid_ali.loginscreen2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final  int DATABASE_VERSION =1;
    public static final  String DATABASE_NAME ="User.db";
    public static final  String TABLE_NAME ="User";
    public static final  String COLUMME_1 ="id";
    public static final  String COLUMME_2 ="name";
    public static final  String COLUMME_3 ="email";
    public static final  String COLUMME_4 ="password";
    SQLiteDatabase db;

    public static final String CREATE_TABLE= "create table "+ TABLE_NAME +
            "(id integer primary key autoincrement not null," +
            "name text not null," +
            "email text not null," +
            "password text not null )" ;






    public Database( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db=db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String query= "DROP TABLE IF EXISTS "+TABLE_NAME;
    db.execSQL(query);
    this.onCreate(db);
    }


    public String searchpass(String name) {
        db=getReadableDatabase();
        String query= "SELECT * FROM "+TABLE_NAME;
        Cursor cursor= db.rawQuery(query,null);

        String uname,upassword;
        upassword="Password not Exist";
        if (cursor.moveToFirst()) {
            do {
                uname = cursor.getString(0);
                if (uname.equals(name)) {
                    upassword = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return upassword;
    }
}
