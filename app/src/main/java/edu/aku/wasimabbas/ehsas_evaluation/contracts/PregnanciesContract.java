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
        public static final String COLUMN_PROJECT_NAME = "EHSAAS_NASHONUMA";

        public static final String COLUMN_W114 = "W114";
        public static final String COLUMN_W115 = "W115";
        public static final String COLUMN_W116 = "W116";
        public static final String COLUMN_W117 = "W117";

        public static final String COLUMN_W11801 = "W11801";
        public static final String COLUMN_W11802 = "W11802";
        public static final String COLUMN_W11803 = "W11803";

        public static final String COLUMN_W11901 = "W11901";
        public static final String COLUMN_W11902 = "W11902";
        public static final String COLUMN_W11903 = "W11903";

        public static final String COLUMN_W117C2 = "W117C2";

        public static final String COLUMN_W118C201 = "W118C201";
        public static final String COLUMN_W118C202 = "W118C202";
        public static final String COLUMN_W118C203 = "W118C203";

        public static final String COLUMN_W119C201 = "W119C201";
        public static final String COLUMN_W119C202 = "W119C202";
        public static final String COLUMN_W119C203 = "W119C203";

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
