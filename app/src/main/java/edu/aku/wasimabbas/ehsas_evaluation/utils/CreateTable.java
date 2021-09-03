package edu.aku.wasimabbas.ehsas_evaluation.utils;

import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract.FormsTable;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.SchoolsContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.UsersContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.VersionAppContract;

public final class CreateTable {

    public static final String DATABASE_NAME = "enp.db";
    public static final String DB_NAME = "enp_copy.db";
    public static final String PROJECT_NAME = "enp";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsTable.COLUMN_H1 + " TEXT,"
            + FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsTable.COLUMN_ISTATUS96x + " TEXT,"
            + FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";


    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.UsersTable.TABLE_NAME + "("
            + UsersContract.UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersContract.UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersContract.UsersTable.COLUMN_FULL_NAME + " TEXT"
            + " );";


    public static final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";


    public static final String SQL_CREATE_SCHOOLS = "CREATE TABLE " + SchoolsContract.TableSchool.TABLE_NAME + " (" +
            SchoolsContract.TableSchool.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SchoolsContract.TableSchool.COLUMN_SERVER_ID + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_SEMIS_CODE + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_DIVISION_CODE + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_DIVISION_NAME + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_DISTRICT_CODE + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_DISTRICT_NAME + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_TEHSIL_CODE + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_TEHSIL_NAME + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_S_NAME + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_S_HEAD + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_S_LEVEL + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_S_TYPE + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_S_MEDIUM + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_S_CURRENT_STATUS + " TEXT, " +
            SchoolsContract.TableSchool.COLUMN_STATUS + " TEXT " +
            ");";
}
