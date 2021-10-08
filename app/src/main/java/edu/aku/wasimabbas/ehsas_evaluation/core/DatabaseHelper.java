package edu.aku.wasimabbas.ehsas_evaluation.core;

import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.DATABASE_NAME;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.DATABASE_VERSION;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.SQL_CREATE_CHILDREN;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.SQL_CREATE_FORMS;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.SQL_CREATE_MEMBERS;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.SQL_CREATE_MEMBER_PREGNANCIES;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.SQL_CREATE_MWRAS;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.SQL_CREATE_USERS;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.SQL_CREATE_VERSIONAPP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.BLRandomContract.BLRandomTable;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleChildrenContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleMWRAsContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract.FormsTable;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.MembersContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.PregnanciesContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.UsersContract.UsersTable;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.VersionAppContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.VersionAppContract.VersionAppTable;
import edu.aku.wasimabbas.ehsas_evaluation.models.BLRandom;
import edu.aku.wasimabbas.ehsas_evaluation.models.EligibleChild;
import edu.aku.wasimabbas.ehsas_evaluation.models.EligibleMWRA;
import edu.aku.wasimabbas.ehsas_evaluation.models.Form;
import edu.aku.wasimabbas.ehsas_evaluation.models.Member;
import edu.aku.wasimabbas.ehsas_evaluation.models.Pregnancy;
import edu.aku.wasimabbas.ehsas_evaluation.models.Users;
import edu.aku.wasimabbas.ehsas_evaluation.models.VersionApp;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.MWRAs;


public class DatabaseHelper extends SQLiteOpenHelper {

    Context context;
    private final String TAG = "DatabaseHelper";

    List<MWRAs> MWRAsList = new ArrayList<>();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_MEMBERS);
        db.execSQL(SQL_CREATE_MEMBER_PREGNANCIES);
        db.execSQL(SQL_CREATE_MWRAS);
        db.execSQL(SQL_CREATE_CHILDREN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int syncBLRandom(JSONArray blList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BLRandomTable.TABLE_NAME, null, null);

        JSONArray jsonArray = blList;
        int insertCount = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObjectCC = null;
            try {
                jsonObjectCC = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            BLRandom Vc = new BLRandom();
            Vc.Sync(jsonObjectCC);
            Log.d(TAG, "syncBLRandom: " + Vc.get_ID());
            ContentValues values = new ContentValues();

            values.put(BLRandomTable.COLUMN_ID, Vc.get_ID());
            values.put(BLRandomTable.COLUMN_LUID, Vc.getLUID());
            values.put(BLRandomTable.COLUMN_STRUCTURE_NO, Vc.getStructure());
            values.put(BLRandomTable.COLUMN_FAMILY_EXT_CODE, Vc.getExtension());
            values.put(BLRandomTable.COLUMN_HH, Vc.getHh());
            values.put(BLRandomTable.COLUMN_EB_CODE, Vc.getEbcode());
            values.put(BLRandomTable.COLUMN_P_CODE, Vc.getpCode());
            values.put(BLRandomTable.COLUMN_RANDOMDT, Vc.getRandomDT());
            values.put(BLRandomTable.COLUMN_HH_HEAD, Vc.getHhhead());
            values.put(BLRandomTable.COLUMN_CONTACT, Vc.getContact());
            values.put(BLRandomTable.COLUMN_HH_SELECTED_STRUCT, Vc.getSelStructure());
            values.put(BLRandomTable.COLUMN_SNO_HH, Vc.getSno());

            long row = db.insert(BLRandomTable.TABLE_NAME, null, values);
            if (row != -1) insertCount++;
        }
        return insertCount;
    }

    public Integer syncVersionApp(JSONObject VersionList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppContract.VersionAppTable.TABLE_NAME, null, null);
        long count = 0;
        try {
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionAppContract.VersionAppTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionApp Vc = new VersionApp();
            Vc.Sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppContract.VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionAppContract.VersionAppTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }

        return (int) count;
    }

    public VersionApp getVersionApp() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VersionAppTable._ID,
                VersionAppTable.COLUMN_VERSION_CODE,
                VersionAppTable.COLUMN_VERSION_NAME,
                VersionAppTable.COLUMN_PATH_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = null;

        VersionApp allVC = new VersionApp();
        try {
            c = db.query(
                    VersionAppTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allVC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
    }

    public int syncUser(JSONArray userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                Users user = new Users();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersTable.COLUMN_FULL_NAME, user.getFull_name());
                long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersTable.TABLE_NAME + " WHERE " + UsersTable.COLUMN_USERNAME + "=? AND " + UsersTable.COLUMN_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {

                if (mCursor.moveToFirst()) {
//                    MainApp.DIST_ID = mCursor.getString(mCursor.getColumnIndex(Users.UsersTable.ROW_USERNAME));
                }
                return true;
            }
        }
        return false;
    }

    public Long addForm(Form form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, form.getUid());
        values.put(FormsTable.COLUMN_DEVICEID, form.getDeviceid());
        values.put(FormsTable.COLUMN_DEVICETAGID, form.getDeviceid());
        values.put(FormsTable.COLUMN_USERNAME, form.getUsername());
        values.put(FormsTable.COLUMN_SYSDATE, form.getSysdate());
        values.put(FormsTable.COLUMN_APPVERSION, form.getAppversion());
        values.put(FormsTable.COLUMN_ISTATUS, form.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS96x, form.getIstatus96x());
        values.put(FormsTable.COLUMN_JSON, form.getJSON());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.form.getId());

        // Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public int updateEnding() {

        SQLiteDatabase db = this.getReadableDatabase();
        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.form.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS96x, MainApp.form.getIstatus96x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, MainApp.form.getEndingdatetime());
        values.put(FormsTable.COLUMN_JSON, MainApp.form.getJSON());

        // Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public Collection<Form> getTodayForms(String sysdate) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {

                FormsTable.COLUMN_ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS96x,
                FormsTable.COLUMN_JSON,

        };
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form form = new Form();
                //form.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                //form.set_UID(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                //form.setFormtype(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMTYPE)));
                //form.setUsername(c.getString(c.getColumnIndex(FormsTable.COLUMN_USERNAME)));
                //form.setSysdate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                //form.setMp101(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP101)));
                //form.setMp102(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP102)));
                //form.setMp103(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP103)));
                //form.setMp104(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP104)));
                //form.setMp105(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP105)));
                //form.setMp106(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP106)));
                //form.setMp107(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP107)));
                //form.setMp108(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP108)));
                //form.setPid(c.getString(c.getColumnIndex(FormsTable.COLUMN_PID)));
                form.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                form.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allForms.add(form);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public Collection<Form> getFormsByCluster(String cluster) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN_ID,
                FormsTable.COLUMN_UID,
                //FormsTable.COLUMN_SEEM_VID,
                //FormsTable.COLUMN_MPSYSDATE,
                //FormsTable.COLUMN_FORMTYPE,
                //FormsTable.COLUMN_SYSDATE,
                //FormsTable.COLUMN_MP101,
                //FormsTable.COLUMN_MP102,
                //FormsTable.COLUMN_MP103,
                //FormsTable.COLUMN_ISTATUS,
                //FormsTable.COLUMN_SYNCED,

        };
        //String whereClause = FormsTable.COLUMN_MP101 + " = ? ";
        String[] whereArgs = new String[]{cluster};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForms = new ArrayList<>();
        /*try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form form = new Form();
                form.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                form.set_UID(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                form.setFormtype(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMTYPE)));
                form.setSysdate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                form.setMp101(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP101)));
                form.setMp102(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP102)));
                form.setMp103(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP103)));
                form.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                form.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allForms.add(form);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }*/
        return allForms;
    }

    public ArrayList<Form> getUnclosedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN_ID,
                FormsTable.COLUMN_UID,
                //FormsTable.COLUMN_SEEM_VID,
                //FormsTable.COLUMN_MPSYSDATE,
                //FormsTable.COLUMN_FORMTYPE,
                FormsTable.COLUMN_SYSDATE,
                //FormsTable.COLUMN_MP102,
                //FormsTable.COLUMN_MP103,
                //FormsTable.COLUMN_MP101,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,
        };
        String whereClause = FormsTable.COLUMN_ISTATUS + " = ''";
        String[] whereArgs = null;
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form form = new Form();
                //form.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                //form.set_UID(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                //form.setFormtype(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMTYPE)));
                //form.setSysdate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                //form.setMp101(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP101)));
                //form.setMp102(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP102)));
                //form.setMp103(c.getString(c.getColumnIndex(FormsTable.COLUMN_MP103)));
                //form.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                //form.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allForms.add(form);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public Collection<Form> getUnsyncedForms() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {

                FormsTable.COLUMN_ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS96x,
                FormsTable.COLUMN_JSON,
                FormsTable.COLUMN_ENDINGDATETIME,
        };

        String whereClause;
        String[] whereArgs;

        whereClause = FormsTable.COLUMN_SYNCED + " is null OR " + FormsTable.COLUMN_SYNCED + " == ''";
        whereArgs = null;

        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedForms: " + c.getCount());
                Form form = new Form();
                allForms.add(form.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    // Family Members

    public Long addFamilyMember(Member mc) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(MembersContract.MembersTable.COLUMN_UID, mc.getDeviceid() + mc.getId());
        values.put(MembersContract.MembersTable.COLUMN_FUID, mc.getFuid());
        values.put(MembersContract.MembersTable.COLUMN_SYSDATE, mc.getSysdate());
        values.put(MembersContract.MembersTable.COLUMN_USERNAME, mc.getUsername());
        values.put(MembersContract.MembersTable.COLUMN_DEVICEID, mc.getDeviceid());
        values.put(MembersContract.MembersTable.COLUMN_DEVICETAGID, mc.getDevicetagid());
        values.put(MembersContract.MembersTable.COLUMN_APPVERSION, mc.getAppversion());
        values.put(MembersContract.MembersTable.COLUMN_H201, mc.getH201());
        values.put(MembersContract.MembersTable.COLUMN_H202, mc.getH202());
        values.put(MembersContract.MembersTable.COLUMN_H203, mc.getH203());
        values.put(MembersContract.MembersTable.COLUMN_H204, mc.getH204());
        values.put(MembersContract.MembersTable.COLUMN_H20501, mc.getH20501());
        values.put(MembersContract.MembersTable.COLUMN_H20502, mc.getH20502());
        values.put(MembersContract.MembersTable.COLUMN_H20503, mc.getH20503());
        values.put(MembersContract.MembersTable.COLUMN_H20601, mc.getH20601());
        values.put(MembersContract.MembersTable.COLUMN_H20602, mc.getH20602());
        values.put(MembersContract.MembersTable.COLUMN_H20603, mc.getH20603());
        values.put(MembersContract.MembersTable.COLUMN_H20701, mc.getH20701());
        values.put(MembersContract.MembersTable.COLUMN_H20702, mc.getH20702());
        values.put(MembersContract.MembersTable.COLUMN_H20703, mc.getH20703());
        values.put(MembersContract.MembersTable.COLUMN_H20704, mc.getH20704());
        values.put(MembersContract.MembersTable.COLUMN_H20796, mc.getH20796());
        values.put(MembersContract.MembersTable.COLUMN_H20796x, mc.getH20796x());
        values.put(MembersContract.MembersTable.COLUMN_H208, mc.getH208());
        values.put(MembersContract.MembersTable.COLUMN_H209, mc.getH209());
        values.put(MembersContract.MembersTable.COLUMN_H210, mc.getH210());
        values.put(MembersContract.MembersTable.COLUMN_H211, mc.getH211());
        values.put(MembersContract.MembersTable.COLUMN_H212, mc.getH212());
        values.put(MembersContract.MembersTable.COLUMN_H21296X, mc.getH21296x());
        values.put(MembersContract.MembersTable.COLUMN_COLLECTED, 0);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MembersContract.MembersTable.TABLE_NAME,
                MembersContract.MembersTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public int updatesFamilyMemberColumn(String column, String value, String valueID) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = MembersContract.MembersTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(valueID)};

        return db.update(MembersContract.MembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public SimpleCursorAdapter populateListView(String fuid) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = MembersContract.MembersTable.COLUMN_FUID + " =? ";
        String[] selectionArgs = {String.valueOf(fuid)};
        String[] columns = {MembersContract.MembersTable.COLUMN_ID, MembersContract.MembersTable.COLUMN_H201, MembersContract.MembersTable.COLUMN_H202};
        Cursor cursor = db.query(MembersContract.MembersTable.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        String[] fromFieldNames = new String[]{
                MembersContract.MembersTable.COLUMN_ID, MembersContract.MembersTable.COLUMN_H201, MembersContract.MembersTable.COLUMN_H202
        };
        int[] toViewIDs = new int[]{R.id.item_id, R.id.serial, R.id.name};

        SimpleCursorAdapter contactAdaptor = new SimpleCursorAdapter(
                context,
                R.layout.single_item,
                cursor,
                fromFieldNames,
                toViewIDs
        );

        return contactAdaptor;
    }

    public List<MWRAs> getAllMWRAs(String fuid) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "fuid=? AND H204=? AND H20603 BETWEEN ? AND ? AND collected=?";
        String[] selectionArgs = {String.valueOf(fuid), "2", "15", "49", "0"};
        String[] columns = {MembersContract.MembersTable.COLUMN_ID, MembersContract.MembersTable.COLUMN_H201, MembersContract.MembersTable.COLUMN_H202, MembersContract.MembersTable.COLUMN_UID, MembersContract.MembersTable.COLUMN_H20603};
        Cursor cursor = db.query(MembersContract.MembersTable.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_ID);
            int rowid = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H201);
            int serial = cursor.getInt(index2);
            int index3 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H202);
            String name = cursor.getString(index3);
            int index4 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_UID);
            String uid = cursor.getString(index4);
            int index5 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20603);
            String age = cursor.getString(index5);

            MWRAs MWRA = new MWRAs(rowid, serial, name, uid, age);
            MWRAsList.add(MWRA);
        }

        return MWRAsList;
    }

    public Long addMWRA(EligibleMWRA mwra) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_UID, mwra.getUid());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_MUID, mwra.getMuid());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_FUID, mwra.getFuid());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICEID, mwra.getDeviceid());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICETAGID, mwra.getDeviceid());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_USERNAME, mwra.getUsername());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_SYSDATE, mwra.getSysdate());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_APPVERSION, mwra.getAppversion());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS, mwra.getIstatus());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS96x, mwra.getIstatus96x());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_JSON, mwra.getJSON());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                EligibleMWRAsContract.MWRAsTable.TABLE_NAME,
                EligibleMWRAsContract.MWRAsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public int updatesMWRAColumn(String column, String value) {

        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = EligibleMWRAsContract.MWRAsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.mwra.getId())};

        return db.update(EligibleMWRAsContract.MWRAsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public Long addPregnancy(Pregnancy p) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PregnanciesContract.PregnanciesTable.COLUMN_UID, p.getDeviceid() + p.getId());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_MUID, p.getMuid());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_FUID, p.getFuid());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_SYSDATE, p.getSysdate());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_USERNAME, p.getUsername());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_DEVICEID, p.getDeviceid());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_DEVICETAGID, p.getDevicetagid());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_APPVERSION, p.getAppversion());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W116, p.getW116());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W11701, p.getW11701());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W11702, p.getW11702());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W11703, p.getW11703());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W118, p.getW118());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W119, p.getW119());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W12001, p.getW12001());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W12002, p.getW12002());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W12003, p.getW12003());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W12101, p.getW12101());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W12102, p.getW12102());
        values.put(PregnanciesContract.PregnanciesTable.COLUMN_W12103, p.getW12103());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                PregnanciesContract.PregnanciesTable.TABLE_NAME,
                PregnanciesContract.PregnanciesTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public int updatesPregnancyColumn(String column, String value, String valueID) {

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = PregnanciesContract.PregnanciesTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(valueID)};

        return db.update(PregnanciesContract.PregnanciesTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateCollectedColumn(String column, int value, Long id) {

        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = MembersContract.MembersTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(id)};

        return db.update(MembersContract.MembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public List<MWRAs> getAllChildren(String fuid) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "fuid=? AND H20603 BETWEEN ? AND ? AND collected=?";
        String[] selectionArgs = {String.valueOf(fuid), "0", "1", "0"};
        String[] columns = {MembersContract.MembersTable.COLUMN_ID, MembersContract.MembersTable.COLUMN_H201, MembersContract.MembersTable.COLUMN_H202, MembersContract.MembersTable.COLUMN_UID, MembersContract.MembersTable.COLUMN_H20603};
        Cursor cursor = db.query(MembersContract.MembersTable.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_ID);
            int rowid = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H201);
            int serial = cursor.getInt(index2);
            int index3 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H202);
            String name = cursor.getString(index3);
            int index4 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_UID);
            String uid = cursor.getString(index4);
            int index5 = cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20603);
            String age = cursor.getString(index5);

            MWRAs MWRA = new MWRAs(rowid, serial, name, uid, age);
            MWRAsList.add(MWRA);
        }

        return MWRAsList;
    }

    public Long addChild(EligibleChild child) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_UID, child.getUid());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_MUID, child.getMuid());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_FUID, child.getFuid());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_DEVICEID, child.getDeviceid());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_DEVICETAGID, child.getDeviceid());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_USERNAME, child.getUsername());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_SYSDATE, child.getSysdate());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_APPVERSION, child.getAppversion());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_ISTATUS, child.getIstatus());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_ISTATUS96x, child.getIstatus96x());
        values.put(EligibleChildrenContract.ChildrenTable.COLUMN_JSON, child.getJSON());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                EligibleChildrenContract.ChildrenTable.TABLE_NAME,
                EligibleChildrenContract.ChildrenTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public int updatesChildColumn(String column, String value) {

        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = EligibleChildrenContract.ChildrenTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.child.getId())};

        return db.update(EligibleChildrenContract.ChildrenTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int addMemberAnthro(Member mc, String muid) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(MembersContract.MembersTable.COLUMN_E101, mc.getE101());
        values.put(MembersContract.MembersTable.COLUMN_E102, mc.getE102());
        values.put(MembersContract.MembersTable.COLUMN_E103, mc.getE103());
        values.put(MembersContract.MembersTable.COLUMN_E104, mc.getE104());
        values.put(MembersContract.MembersTable.COLUMN_E105, mc.getE105());
        values.put(MembersContract.MembersTable.COLUMN_E106, mc.getE106());

        String selection = MembersContract.MembersTable.COLUMN_UID + " =? ";
        String[] selectionArgs = {muid};

        return db.update(MembersContract.MembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public Cursor getAllMembers(String fuid) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM HHMembers WHERE fuid = '" + fuid + "' AND (E101 = '-1' OR E101 = '' OR E101 is NULL) ORDER BY CAST(H201 AS INTEGER) ASC LIMIT 1", null);
        return cursor;
    }

    public int updateMWRAEnding() {

        SQLiteDatabase db = this.getReadableDatabase();
        // New value for one column
        ContentValues values = new ContentValues();
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS, MainApp.mwra.getIstatus());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS96x, MainApp.mwra.getIstatus96x());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ENDINGDATETIME, MainApp.mwra.getEndingdatetime());
        values.put(EligibleMWRAsContract.MWRAsTable.COLUMN_JSON, MainApp.mwra.getJSON());

        // Which row to update, based on the ID
        String selection = EligibleMWRAsContract.MWRAsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.mwra.getId())};

        return db.update(EligibleMWRAsContract.MWRAsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }
}