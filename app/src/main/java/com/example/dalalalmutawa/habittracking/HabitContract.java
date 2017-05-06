package com.example.dalalalmutawa.habittracking;

import android.provider.BaseColumns;

/**
 * Created by dalalalmutawa on 4/29/17.
 */


public class HabitContract {
    private HabitContract() {
    }


    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "Habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_NAME = "name";
        public final static String COLUMN_START_DATe = "start";
        public final static String COLUMN_TYPE = "type";


    }
}