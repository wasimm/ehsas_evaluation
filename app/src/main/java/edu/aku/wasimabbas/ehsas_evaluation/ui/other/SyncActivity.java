package edu.aku.wasimabbas.ehsas_evaluation.ui.other;

import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.DATABASE_NAME;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.DB_NAME;
import static edu.aku.wasimabbas.ehsas_evaluation.utils.CreateTable.PROJECT_NAME;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.wasimabbas.ehsas_evaluation.CONSTANTS;
import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.adapter.SyncListAdapter;
import edu.aku.wasimabbas.ehsas_evaluation.adapter.UploadListAdapter;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleChildrenContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleMWRAsContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.MembersContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.PregnanciesContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivitySyncBinding;
import edu.aku.wasimabbas.ehsas_evaluation.models.EligibleChild;
import edu.aku.wasimabbas.ehsas_evaluation.models.EligibleMWRA;
import edu.aku.wasimabbas.ehsas_evaluation.models.Form;
import edu.aku.wasimabbas.ehsas_evaluation.models.Member;
import edu.aku.wasimabbas.ehsas_evaluation.models.Pregnancy;
import edu.aku.wasimabbas.ehsas_evaluation.models.SyncModel;
import edu.aku.wasimabbas.ehsas_evaluation.sync.GetAllData;
import edu.aku.wasimabbas.ehsas_evaluation.sync.SyncAllData;
import edu.aku.wasimabbas.ehsas_evaluation.sync.SyncAllPhotos;
import edu.aku.wasimabbas.ehsas_evaluation.sync.SyncDevice;

public class SyncActivity extends AppCompatActivity implements SyncDevice.SyncDevicInterface {
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    String DirectoryName;
    DatabaseHelper db;
    SyncListAdapter syncListAdapter;
    UploadListAdapter uploadListAdapter;
    ActivitySyncBinding bi;
    SyncModel model;
    SyncModel uploadmodel;
    List<SyncModel> list;
    List<SyncModel> uploadlist;
    Boolean listActivityCreated;
    Boolean uploadlistActivityCreated;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    //ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_sync);
        bi.setCallback(this);
        list = new ArrayList<>();
        uploadlist = new ArrayList<>();
        listActivityCreated = true;
        uploadlistActivityCreated = true;
        sharedPref = getSharedPreferences("src", MODE_PRIVATE);
        editor = sharedPref.edit();
        db = new DatabaseHelper(this);
        dbBackup();

        boolean sync_flag = getIntent().getBooleanExtra(CONSTANTS.SYNC_LOGIN, false);

        bi.btnSync.setOnClickListener(v -> onSyncDataClick());
        bi.btnUpload.setOnClickListener(v -> syncServer());
        setAdapter();
        setUploadAdapter();
    }

    public void onSyncDataClick() {

        bi.activityTitle.setText(getString(R.string.btnSync));
        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            /*if (sync_flag) new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(true);
            else new SyncDevice(SyncActivity.this, true).execute();*/
            new SyncDevice(SyncActivity.this, true).execute();
            new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(true);
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    void setAdapter() {
        syncListAdapter = new SyncListAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        bi.rvSyncList.setLayoutManager(mLayoutManager);
        bi.rvSyncList.setItemAnimator(new DefaultItemAnimator());
        bi.rvSyncList.setAdapter(syncListAdapter);
        syncListAdapter.notifyDataSetChanged();
    }

    void setUploadAdapter() {
        uploadListAdapter = new UploadListAdapter(uploadlist);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        bi.rvUploadList.setLayoutManager(mLayoutManager2);
        bi.rvUploadList.setItemAnimator(new DefaultItemAnimator());
        bi.rvUploadList.setAdapter(uploadListAdapter);
        uploadListAdapter.notifyDataSetChanged();
    }

    public void syncServer() {

        bi.activityTitle.setText(getString(R.string.btnUpload));
        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            DatabaseHelper db = new DatabaseHelper(this);

            //new SyncDevice(this, false).execute();
            //  *******************************************************Forms*********************************

            //Toast.makeText(getApplicationContext(), String.format("Syncing Forms"), Toast.LENGTH_SHORT).show();

            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "HHInformation",
                    "updateSyncedHHInformation",
                    Form.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    FormsContract.FormsTable.TABLE_NAME,
                    db.getUnsyncedHHInformation(), 0, uploadListAdapter, uploadlist
            ).execute();

            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "HHMembers",
                    "updateSyncedHHMembers",
                    Member.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    MembersContract.MembersTable.TABLE_NAME,
                    db.getUnsyncedHHMembers(), 1, uploadListAdapter, uploadlist
            ).execute();

            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "MemberPregnancies",
                    "updateSyncedMemberPregnancies",
                    Pregnancy.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    PregnanciesContract.PregnanciesTable.TABLE_NAME,
                    db.getUnsyncedMemberPregnancies(), 2, uploadListAdapter, uploadlist
            ).execute();

            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "MWRAs",
                    "updateSyncedMWRAs",
                    EligibleMWRA.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    EligibleMWRAsContract.MWRAsTable.TABLE_NAME,
                    db.getUnsyncedMWRAs(), 3, uploadListAdapter, uploadlist
            ).execute();

            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Children",
                    "updateSyncedChildren",
                    EligibleChild.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    EligibleChildrenContract.ChildrenTable.TABLE_NAME,
                    db.getUnsyncedChildren(), 4, uploadListAdapter, uploadlist
            ).execute();

            uploadlistActivityCreated = false;

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastDataUpload", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }


    public void dbBackup() {


        if (sharedPref.getBoolean("flag", false)) {

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()));

            if (!dt.equals(new SimpleDateFormat("dd-MM-yy").format(new Date()))) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()));
                editor.apply();
            }
            File folder = new File(this.getExternalFilesDir(
                    Environment.DIRECTORY_PICTURES), PROJECT_NAME);
/*
            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + PROJECT_NAME);
*/

            //Toast.makeText(this, "My Toast: "+folder, Toast.LENGTH_SHORT).show();

            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {
                DirectoryName = folder.getPath() + File.separator + sharedPref.getString("dt", "");
                folder = new File(DirectoryName);
                if (!folder.exists()) {
                    success = folder.mkdirs();
                }
                if (success) {

                    try {
                        File dbFile = new File(this.getDatabasePath(DATABASE_NAME).getPath());
                        FileInputStream fis = new FileInputStream(dbFile);

                        String outFileName = DirectoryName + File.separator + DB_NAME;

                        // Open the empty db as the output stream
                        OutputStream output = new FileOutputStream(outFileName);

                        // Transfer bytes from the inputfile to the outputfile
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            output.write(buffer, 0, length);
                        }
                        // Close the streams
                        output.flush();
                        output.close();
                        fis.close();
                    } catch (IOException e) {
                        Log.e("dbBackup:", e.getMessage());
                    }

                }

            } else {
                Toast.makeText(this, "Database Backup folder could not created.", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void processFinish(boolean flag) {
        if (flag) {
            MainApp.appInfo.updateTagName(this);
//            new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(sync_flag);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_OK);
        finish();
    }

    public void uploadPhoto(View view) {
        dialogBuilder = new AlertDialog.Builder(this)
                .setTitle("Photo Upload")
                .setMessage("Uploading 0 of");
        alertDialog = dialogBuilder.create();
        alertDialog.setMessage("First method call");
        alertDialog.show();
    }

    public void uploadPhotos(View view) {

        //pd = new ProgressDialog(SyncActivity.this);
        /*File sdDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);*/
        File sdDir = new File(this.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), PROJECT_NAME);
        Log.d("Files", "Path: " + sdDir);
        //sdDir = new File(String.valueOf(sdDir), PROJECT_NAME);
        Log.d("Directory", "uploadPhotos: " + sdDir);
        if (sdDir.exists()) {
            File[] files = sdDir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return (file.getPath().endsWith(".jpg") || file.getPath().endsWith(".jpeg"));
                }
            });


            Log.d("Files", "Count: " + files.length);
            if (files.length > 0) {

          /*      new AlertDialog.Builder(this)
                        .setTitle("Photo Upload")
                        .setMessage("Are you sure you want to delete this entry?")


                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();*/

                dialogBuilder = new AlertDialog.Builder(this);
                        /*.setTitle("Photo Upload")
                        .setMessage("Uploading 0 of" + files.length);*/

                LayoutInflater inflater = this.getLayoutInflater();
                View dialogLayout = inflater.inflate(R.layout.photo_sync_dialog, null);
                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                TextView textView = dialogLayout.findViewById(R.id.txtMessage);
                TextView uploadCount = dialogLayout.findViewById(R.id.uploadCount);
                dialogBuilder.setView(dialogLayout);

                alertDialog = dialogBuilder.create();
                alertDialog.show();
                int fcount = Math.min(files.length, 30);

                for (int i = 0; i < fcount; i++) {

                    File file = files[i];
                    Log.d("Files", "FileName:" + file.getName());
                  /*  alertDialog.setTitle("Photo Upload ("+i+"/"+files.length+")");
                    alertDialog.setMessage("STARTING: "+ file.getName());
                    alertDialog.show();*/
                    SyncAllPhotos syncAllPhotos = new SyncAllPhotos(file.getName(), this, textView);
                    syncAllPhotos.execute();
                    Log.d("Uploads", "uploadPhotos: " + syncAllPhotos.getStatus());

                   /* if(syncAllPhotos.getStatus() == AsyncTask.Status.PENDING){
                        // My AsyncTask has not started yet
                        try {
                            alertDialog.setTitle("Photo Upload ("+i+"/"+files.length+")");
                            alertDialog.setMessage("PENDING: "+ file.getName());
                            alertDialog.show();
                            i--;
                            //3000 ms delay to process upload of next file.
                            Thread.sleep(500);


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if(syncAllPhotos.getStatus() == AsyncTask.Status.RUNNING){
                        // My AsyncTask is currently doing work in doInBackground()
                        try {
                            alertDialog.setTitle("Photo Upload ("+i+"/"+files.length+")");
                            alertDialog.setMessage("UPLOADING: "+ file.getName());
                            alertDialog.show();
                            i--;
                            //3000 ms delay to process upload of next file.
                            Thread.sleep(500);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if(syncAllPhotos.getStatus() == AsyncTask.Status.FINISHED){
                        // My AsyncTask is done and onPostExecute was called

                    }*/

                }
                editor.putString("LastPhotoUpload", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
                editor.apply();
            } else {
                Toast.makeText(this, "No photos to upload.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No photos were taken", Toast.LENGTH_SHORT).show();
        }

    }

    /*    public void updateCount(int total,){

        uploadCount.setText("(")

    }*/

    private class SyncData extends AsyncTask<Boolean, String, String> {

        private final Context mContext;
        private final String distID;

        private SyncData(Context mContext, String districtId) {
            this.mContext = mContext;
            this.distID = districtId;
        }

        @Override
        protected String doInBackground(Boolean... booleans) {
            runOnUiThread(() -> {

                String[] syncItems = {"Users", "Districts", "Clusters"};

                for (String syncItem : syncItems) {
                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, syncItem, syncListAdapter, list).execute();
                }

                /*if (booleans[0]) {
                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "Users", syncListAdapter, list).execute();

                    if (listActivityCreated) {
                        model = new SyncModel();
                        model.setstatusID(0);
                        list.add(model);
                    }
                    new GetAllData(mContext, "Schools", syncListAdapter, list).execute();

                }*/

                listActivityCreated = false;
            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(() -> {
                editor.putString("LastDataDownload", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
                editor.apply();
                editor.putBoolean("flag", true);
                editor.commit();

                dbBackup();

            }, 1200);
        }
    }
}
