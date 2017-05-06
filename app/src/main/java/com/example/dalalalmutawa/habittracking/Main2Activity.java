package com.example.dalalalmutawa.habittracking;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dalalalmutawa.habittracking.HabitContract.HabitEntry;

import static com.example.dalalalmutawa.habittracking.HabitContract.HabitEntry.COLUMN_HABIT_NAME;

public class Main2Activity extends AppCompatActivity {
    private HabitHelper habitHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        habitHelper = new HabitHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        insertHabit();
        Cursor cursor = readHabit();

        Log.d(" ", "The Habit table contains " + cursor.getCount() + " habit.\n\n");
        Log.d("", HabitEntry._ID + " - " +
                HabitEntry.COLUMN_HABIT_NAME + " - " +
                HabitEntry.COLUMN_START_DATe + " - " +
                HabitEntry.COLUMN_TYPE
        );
        int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
        int date = cursor.getColumnIndex(HabitEntry.COLUMN_START_DATe);
        int typeColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_TYPE);
        while (cursor.moveToNext()) {
            String currentName = cursor.getString(nameColumnIndex);
            String currentDate = cursor.getString(date);
            String currentType = cursor.getString(typeColumnIndex);
            Log.d("", "ID : " + "" + "\t Name : " + currentName + "\t Date : " + currentDate + "\t Type : " + currentType);
        }
    }

    public void insertHabit() {

        SQLiteDatabase db = habitHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_HABIT_NAME, "Drow");
        values.put(HabitEntry.COLUMN_TYPE, "ART");
        values.put(HabitEntry.COLUMN_START_DATe, "5 MAY 2017");

        long addID = db.insert(HabitEntry.TABLE_NAME, null, values);
        Log.d("Id is :", addID + "");

        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_HABIT_NAME, "Graphic Design ");
        values1.put(HabitEntry.COLUMN_TYPE, "ART");
        values1.put(HabitEntry.COLUMN_START_DATe, "5 April 2017");
        long addID2 = db.insert(HabitEntry.TABLE_NAME, null, values1);
        Log.d("Id is :", addID2 + "");

    }

    public Cursor readHabit() {
        SQLiteDatabase db = habitHelper.getReadableDatabase();
        String[] projection = {HabitEntry.COLUMN_HABIT_NAME, HabitEntry.COLUMN_TYPE, HabitEntry.COLUMN_START_DATe};
       return  db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);
    }
}
