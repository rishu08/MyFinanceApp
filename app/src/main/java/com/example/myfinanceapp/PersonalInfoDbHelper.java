package com.example.myfinanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// PersonalInfoDbHelper.java
public class PersonalInfoDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = " .db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "personal_info";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_SALARY = "salary";
    private static final String COLUMN_RetAGE = "RetAge";
    private static final String COLUMN_AvgIncrement = "increment";

    // Add other columns here

    public PersonalInfoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME + " TEXT,"+
                COLUMN_AGE + "TEXT,"+
                COLUMN_SALARY + "TEXT,"+
                COLUMN_AvgIncrement + "TEXT"+
                COLUMN_RetAGE + "TEXT)";
        // Add other columns to the CREATE TABLE statement
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement if needed
    }

    public void insertPersonalInfo(PersonalInfo personalInfo) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, personalInfo.getName());
        values.put(COLUMN_AGE, personalInfo.getAge());
        values.put(COLUMN_SALARY, personalInfo.getCurSalary());
        values.put(COLUMN_AvgIncrement, personalInfo.getAvgIncrement());
        values.put(COLUMN_RetAGE, personalInfo.getRetAge());

        // Add other values for other columns
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public PersonalInfo getPersonalInfo() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        PersonalInfo personalInfo = null;
        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String age = cursor.getString(cursor.getColumnIndex(COLUMN_AGE));
            String salary = cursor.getString(cursor.getColumnIndex(COLUMN_SALARY));
            String avgIncrement = cursor.getString(cursor.getColumnIndex(COLUMN_AvgIncrement));
            String retAge = cursor.getString(cursor.getColumnIndex(COLUMN_RetAGE));

            // Retrieve other columns as needed
            personalInfo = new PersonalInfo(name, age, salary, avgIncrement, retAge);

        }
        cursor.close();
        db.close();
        return personalInfo;
    }
}
