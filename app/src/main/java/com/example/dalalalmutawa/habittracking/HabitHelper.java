package com.example.dalalalmutawa.habittracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.dalalalmutawa.habittracking.HabitContract.HabitEntry;

/**
 * Created by dalalalmutawa on 4/29/17.
 */

public class HabitHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "Habit.db";
    private static final int DB_VERSION = 1;

    public HabitHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " CREATE TABLE " + HabitEntry.TABLE_NAME + " ( " +
                HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL , " +
                HabitEntry.COLUMN_START_DATe + " TEXT ," +
                HabitEntry.COLUMN_TYPE + " TEXT );";
        db.execSQL(CREATE_TABLE);
// close

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
