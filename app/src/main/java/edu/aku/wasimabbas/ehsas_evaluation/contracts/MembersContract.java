package edu.aku.wasimabbas.ehsas_evaluation.contracts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;


public class MembersContract {

    public static String CONTENT_AUTHORITY = "edu.aku.wasimabbas.ehsas_evaluation";

    public static abstract class MembersTable implements BaseColumns {

        public static final String TABLE_NAME = "HHMembers";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "EHSAS_NASHONUMA";

        public static final String COLUMN_H201 = "H201";
        public static final String COLUMN_H202 = "H202";
        public static final String COLUMN_H203 = "H203";
        public static final String COLUMN_H204 = "H204";
        public static final String COLUMN_H20501 = "H20501";
        public static final String COLUMN_H20502 = "H20502";
        public static final String COLUMN_H20503 = "H20503";
        public static final String COLUMN_H20601 = "H20601";
        public static final String COLUMN_H20602 = "H20602";
        public static final String COLUMN_H20603 = "H20603";

        public static final String COLUMN_H20701 = "H20701";
        public static final String COLUMN_H20702 = "H20702";
        public static final String COLUMN_H20703 = "H20703";
        public static final String COLUMN_H20704 = "H20704";
        public static final String COLUMN_H20796 = "H20796";
        public static final String COLUMN_H20796x = "H20796x";

        public static final String COLUMN_H208 = "H208";
        public static final String COLUMN_H209 = "H209";
        public static final String COLUMN_H210 = "H210";
        public static final String COLUMN_H211 = "H211";
        public static final String COLUMN_H212 = "H212";
        public static final String COLUMN_H21296X = "H21296x";

        public static final String COLUMN_E101 = "E101";
        public static final String COLUMN_E102 = "E102";
        public static final String COLUMN_E103 = "E103";
        public static final String COLUMN_E104 = "E104";
        public static final String COLUMN_E105 = "E105";
        public static final String COLUMN_E106 = "E106";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_FUID = "fuid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_COLLECTED = "collected";

        public static String PATH = "forms";
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY)
                .buildUpon().appendPath(PATH).build();
        public static String SERVER_URL = "sync.php";


        public static String getMovieKeyFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static Uri buildUriWithId(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
