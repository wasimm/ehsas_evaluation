package edu.aku.wasimabbas.ehsas_evaluation.contracts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;


public class FormsContract {

    public static String CONTENT_AUTHORITY = "edu.aku.wasimabbas.ehsas_evaluation";

    public static abstract class FormsTable implements BaseColumns {
        public static final String TABLE_NAME = "HHInformation";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "EHSAS_NASHONUMA";

        public static final String COLUMN_JSON = "form_json";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS96x = "istatus96x";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_H213 = "H213";
        public static final String COLUMN_H214 = "H214";
        public static final String COLUMN_H21501 = "H21501";
        public static final String COLUMN_H21502 = "H21502";
        public static final String COLUMN_H21601 = "H21601";
        public static final String COLUMN_H21602 = "H21602";
        public static final String COLUMN_H21701 = "H21701";
        public static final String COLUMN_H21702 = "H21702";

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
