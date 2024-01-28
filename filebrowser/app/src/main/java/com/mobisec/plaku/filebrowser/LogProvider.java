package com.mobisec.plaku.filebrowser;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;

public class LogProvider extends ContentProvider {
    static final String ARG = "arg";
    static final Uri CONTENT_URI;
    static final String CREATE_TABLE = " CREATE TABLE log (id INTEGER PRIMARY KEY AUTOINCREMENT,  oper TEXT NOT NULL,  arg TEXT NOT NULL);";
    static final String DATABASE_NAME = "LogDb";
    static final int DATABASE_VERSION = 1;
    static final int ENTRY = 1;
    static final int ENTRY_ID = 2;
    static final String ID = "id";
    static final String OPER = "oper";
    static final String PROVIDER_NAME = "com.mobisec.plaku.provider.Log";
    static final String TABLE_NAME = "log";
    static final String URL = "content://com.mobisec.plaku.provider.Log/log";
    private static HashMap<String, String> infoMap;
    static final UriMatcher uriMatcher = new UriMatcher(-1);
    private SQLiteDatabase database;
    DBHelper dbHelper;

    private static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, LogProvider.DATABASE_NAME, null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(LogProvider.CREATE_TABLE);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String name = DBHelper.class.getName();
            StringBuilder sb = new StringBuilder();
            sb.append("Upgrading database from version ");
            sb.append(oldVersion);
            sb.append(" to ");
            sb.append(newVersion);
            sb.append(". Old data will be destroyed");
            Log.w(name, sb.toString());
            db.execSQL("DROP TABLE IF EXISTS log");
            onCreate(db);
        }
    }

    static {
        CONTENT_URI = Uri.parse(URL);
        UriMatcher uriMatcher2 = uriMatcher;
        String str = PROVIDER_NAME;
        uriMatcher2.addURI(str, TABLE_NAME, 1);
        uriMatcher.addURI(str, "log/#", 2);
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count;
        String str;
        int match = uriMatcher.match(uri);
        String str2 = TABLE_NAME;
        if (match == 1) {
            count = this.database.delete(str2, selection, selectionArgs);
        } else if (match == 2) {
            String id = uri.getLastPathSegment();
            SQLiteDatabase sQLiteDatabase = this.database;
            StringBuilder sb = new StringBuilder();
            sb.append("id = ");
            sb.append(id);
            if (!TextUtils.isEmpty(selection)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" AND (");
                sb2.append(selection);
                sb2.append(')');
                str = sb2.toString();
            } else {
                str = BuildConfig.FLAVOR;
            }
            sb.append(str);
            count = sQLiteDatabase.delete(str2, sb.toString(), selectionArgs);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsupported URI ");
            sb3.append(uri);
            throw new IllegalArgumentException(sb3.toString());
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    public String getType(Uri uri) {
        int match = uriMatcher.match(uri);
        if (match == 1) {
            return "vnd.android.cursor.dir/vnd.example.log";
        }
        if (match == 2) {
            return "vnd.android.cursor.item/vnd.example.log";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported URI: ");
        sb.append(uri);
        throw new IllegalArgumentException(sb.toString());
    }

    public Uri insert(Uri uri, ContentValues values) {
        long row = this.database.insert(TABLE_NAME, BuildConfig.FLAVOR, values);
        if (row > 0) {
            Uri newUri = ContentUris.withAppendedId(CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(newUri, null);
            return newUri;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fail to add a new record into ");
        sb.append(uri);
        throw new SQLException(sb.toString());
    }

    public boolean onCreate() {
        this.dbHelper = new DBHelper(getContext());
        this.database = this.dbHelper.getWritableDatabase();
        if (this.database == null) {
            return false;
        }
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(TABLE_NAME);
        int match = uriMatcher.match(uri);
        if (match == 1) {
            queryBuilder.setProjectionMap(infoMap);
        } else if (match == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("id=");
            sb.append(uri.getLastPathSegment());
            queryBuilder.appendWhere(sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown URI ");
            sb2.append(uri);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (sortOrder == null || sortOrder == BuildConfig.FLAVOR) {
            sortOrder = OPER;
        }
        Cursor cursor = queryBuilder.query(this.database, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}