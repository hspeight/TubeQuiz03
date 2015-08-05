package com.tubequiz.tubequiz03;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "tubequiz.db";
    private static final int DATABASE_VERSION = 7;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }

    public Cursor getStations() {

        //int x = 1;

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"_id","station"};
        String sqlTables = "stations";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }
}
