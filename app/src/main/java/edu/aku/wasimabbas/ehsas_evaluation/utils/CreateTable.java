package edu.aku.wasimabbas.ehsas_evaluation.utils;

import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleChildrenContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleMWRAsContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract.FormsTable;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.MembersContract.MembersTable;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.PregnanciesContract;
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
            + FormsTable.COLUMN_JSON + " TEXT,"
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

    public static final String SQL_CREATE_MEMBERS = "CREATE TABLE "
            + MembersTable.TABLE_NAME + "("
            + MembersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MembersTable.COLUMN_UID + " TEXT,"
            + MembersTable.COLUMN_FUID + " TEXT,"
            + MembersTable.COLUMN_DEVICEID + " TEXT,"
            + MembersTable.COLUMN_USERNAME + " TEXT,"
            + MembersTable.COLUMN_SYSDATE + " TEXT,"
            + MembersTable.COLUMN_DEVICETAGID + " TEXT,"
            + MembersTable.COLUMN_APPVERSION + " TEXT,"
            + MembersTable.COLUMN_SYNCED + " TEXT,"
            + MembersTable.COLUMN_SYNCED_DATE + " TEXT,"
            + MembersTable.COLUMN_H201 + " TEXT,"
            + MembersTable.COLUMN_H202 + " TEXT,"
            + MembersTable.COLUMN_H203 + " TEXT,"
            + MembersTable.COLUMN_H204 + " TEXT,"
            + MembersTable.COLUMN_H20501 + " TEXT,"
            + MembersTable.COLUMN_H20502 + " TEXT,"
            + MembersTable.COLUMN_H20503 + " TEXT,"
            + MembersTable.COLUMN_H20601 + " TEXT,"
            + MembersTable.COLUMN_H20602 + " TEXT,"
            + MembersTable.COLUMN_H20603 + " TEXT,"
            + MembersTable.COLUMN_H20701 + " TEXT,"
            + MembersTable.COLUMN_H20702 + " TEXT,"
            + MembersTable.COLUMN_H20703 + " TEXT,"
            + MembersTable.COLUMN_H20704 + " TEXT,"
            + MembersTable.COLUMN_H20796 + " TEXT,"
            + MembersTable.COLUMN_H20796x + " TEXT,"
            + MembersTable.COLUMN_H208 + " TEXT,"
            + MembersTable.COLUMN_H209 + " TEXT,"
            + MembersTable.COLUMN_H210 + " TEXT,"
            + MembersTable.COLUMN_H211 + " TEXT,"
            + MembersTable.COLUMN_H212 + " TEXT,"
            + MembersTable.COLUMN_H21296X + " TEXT,"
            + MembersTable.COLUMN_COLLECTED + " TEXT,"
            + MembersTable.COLUMN_E101 + " TEXT,"
            + MembersTable.COLUMN_E102 + " TEXT,"
            + MembersTable.COLUMN_E103 + " TEXT,"
            + MembersTable.COLUMN_E104 + " TEXT,"
            + MembersTable.COLUMN_E105 + " TEXT,"
            + MembersTable.COLUMN_E106 + " TEXT"
            + " );";

    public static final String SQL_CREATE_MWRAS = "CREATE TABLE "
            + EligibleMWRAsContract.MWRAsTable.TABLE_NAME + "("
            + EligibleMWRAsContract.MWRAsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_UID + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_MUID + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_FUID + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICEID + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_USERNAME + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_SYSDATE + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICETAGID + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_APPVERSION + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_JSON + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS96x + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_SYNCED + " TEXT,"
            + EligibleMWRAsContract.MWRAsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    public static final String SQL_CREATE_MEMBER_PREGNANCIES = "CREATE TABLE "
            + PregnanciesContract.PregnanciesTable.TABLE_NAME + "("
            + PregnanciesContract.PregnanciesTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_UID + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_MUID + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_FUID + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_DEVICEID + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_USERNAME + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_SYSDATE + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_DEVICETAGID + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_APPVERSION + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_SYNCED + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_SYNCED_DATE + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W116 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W11701 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W11702 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W11703 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W118 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W119 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W12001 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W12002 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W12003 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W12101 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W12102 + " TEXT,"
            + PregnanciesContract.PregnanciesTable.COLUMN_W12103 + " TEXT"
            + " );";

    public static final String SQL_CREATE_CHILDREN = "CREATE TABLE "
            + EligibleChildrenContract.ChildrenTable.TABLE_NAME + "("
            + EligibleChildrenContract.ChildrenTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_UID + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_MUID + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_FUID + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_DEVICEID + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_USERNAME + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_SYSDATE + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_DEVICETAGID + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_APPVERSION + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_JSON + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_ISTATUS + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_ISTATUS96x + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_SYNCED + " TEXT,"
            + EligibleChildrenContract.ChildrenTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";
}
