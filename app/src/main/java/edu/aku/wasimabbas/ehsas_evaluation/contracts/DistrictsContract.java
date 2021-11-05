package edu.aku.wasimabbas.ehsas_evaluation.contracts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class DistrictsContract {
    public static String CONTENT_AUTHORITY = "edu.aku.wasimabbas.ehsas_evaluation";

    public static abstract class DistrictsTable implements BaseColumns {

        public static final String TABLE_NAME = "districts";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_CODE = "code";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PROVINCE_CODE = "provinceCode";
        public static final String COLUMN_PROVINCE_NAME = "provinceName";
        public static final String SERVER_URI = "districts.php";
        public static String PATH = "districts";
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        //        public static final String REGION_DSS = "region";
        public static Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY)
                .buildUpon().appendPath(PATH).build();

        public static String getMovieKeyFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static Uri buildUriWithId(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}