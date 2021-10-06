package edu.aku.wasimabbas.ehsas_evaluation.contracts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;


public class PregnanciesContract {

    public static String CONTENT_AUTHORITY = "edu.aku.wasimabbas.ehsas_evaluation";

    public static abstract class PregnanciesTable implements BaseColumns {

        public static final String TABLE_NAME = "MemberPregnancies";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "EHSAS_NASHONUMA";

        public static final String COLUMN_W116 = "W116";

        public static final String COLUMN_W11701 = "W11701";
        public static final String COLUMN_W11702 = "W11702";
        public static final String COLUMN_W11703 = "W11703";

        public static final String COLUMN_W118 = "W118";
        public static final String COLUMN_W119 = "W119";

        public static final String COLUMN_W12001 = "W12001";
        public static final String COLUMN_W12002 = "W12002";
        public static final String COLUMN_W12003 = "W12003";

        public static final String COLUMN_W12101 = "W12101";
        public static final String COLUMN_W12102 = "W12102";
        public static final String COLUMN_W12103 = "W12103";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_MUID = "muid";
        public static final String COLUMN_FUID = "fuid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";

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
