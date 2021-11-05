package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import static edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.form;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH1Binding;
import edu.aku.wasimabbas.ehsas_evaluation.models.Form;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;


public class H1 extends AppCompatActivity {

    ActivityH1Binding bi;
    Intent oF = null;
    private DatabaseHelper db;
    private List<String> clusters;
    private String clusterNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h1);
        bi.setCallback(this);
        setupSkip();
        populateSpinner(this);

        bi.H102.setEnabled(false);
        bi.H103.setEnabled(false);
        bi.H104.setEnabled(false);
        bi.H105.setEnabled(false);
        bi.H106.setEnabled(false);

        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        TextWatcher textwatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() < 8) {
                    Clear.clearAllFields(bi.H102TOH117);
                    bi.H102TOH117.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        bi.H101.addTextChangedListener(textwatcher);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void populateSpinner(final Context context) {

        db = MainApp.appInfo.getDbHelper();
        Cursor clustersList = db.getRecords();
        if (clustersList.getCount() > 0) {
            clustersList.moveToFirst();
            clusters = new ArrayList<>();
            clusters.add("....");
            for (int i = 0; i < clustersList.getCount(); i++) {
                clusters.add(clustersList.getString(clustersList.getColumnIndex("clusterNo")));
                clustersList.moveToNext();
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, clusters);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView activity = findViewById(R.id.H101);
        activity.setThreshold(1);//will start working from first character
        activity.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        activity.setTextColor(Color.parseColor("#16A085"));
    }

    private void setupSkip() {

        // H101
        /*bi.H101.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clusterNo = bi.H101.getText().toString().trim();
                db = MainApp.appInfo.getDbHelper();
                Cursor cluster = db.getCluster(clusterNo);
                if (cluster.getCount() > 0) {
                    cluster.moveToFirst();
                    bi.H102.setText(cluster.getString(cluster.getColumnIndex("provinceName")));
                    bi.H103.setText(cluster.getString(cluster.getColumnIndex("districtName")));
                    bi.H104.setText(cluster.getString(cluster.getColumnIndex("tehsil")));
                    bi.H105.setText(cluster.getString(cluster.getColumnIndex("unionCouncil")));
                    bi.H106.setText(cluster.getString(cluster.getColumnIndex("city")));
                    bi.H102TOH117.setVisibility(View.VISIBLE);
                } else {
                    bi.H101.setError("No such Cluster, please check");
                    bi.H102TOH117.setVisibility(View.GONE);
                }
            }
        });*/

        //H110
        bi.H110.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start, int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if (cs.equals("")) { // for backspace
                            return cs;
                        }
                        if (cs.toString().matches("[a-zA-Z ]+")) {
                            return cs;
                        }
                        return "";
                    }
                }
        });

        //H111
        bi.H111.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start, int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if (cs.equals("")) { // for backspace
                            return cs;
                        }
                        if (cs.toString().matches("[a-zA-Z ]+")) {
                            return cs;
                        }
                        return "";
                    }
                }
        });

        //H112
        bi.H112.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H11202.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH113);
                Clear.clearAllFields(bi.fldGrpCVH114);
                Clear.clearAllFields(bi.fldGrpCVH115);
                Clear.clearAllFields(bi.fldGrpCVH116);
                Clear.clearAllFields(bi.fldGrpCVH117);

                bi.fldGrpCVH113.setVisibility(View.GONE);
                bi.fldGrpCVH114.setVisibility(View.GONE);
                bi.fldGrpCVH115.setVisibility(View.GONE);
                bi.fldGrpCVH116.setVisibility(View.GONE);
                bi.fldGrpCVH117.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH113.setVisibility(View.VISIBLE);
                bi.fldGrpCVH114.setVisibility(View.VISIBLE);
                bi.fldGrpCVH115.setVisibility(View.VISIBLE);
                bi.fldGrpCVH116.setVisibility(View.VISIBLE);
                bi.fldGrpCVH117.setVisibility(View.VISIBLE);
            }
        });

        //H115
        bi.H115.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H11501.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH116);
                bi.fldGrpCVH116.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH116.setVisibility(View.VISIBLE);
            }
        });

        //H116
        bi.H11696x.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start, int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if (cs.equals("")) { // for backspace
                            return cs;
                        }
                        if (cs.toString().matches("[a-zA-Z ]+")) {
                            return cs;
                        }
                        return "";
                    }
                }
        });

    }

    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();

            if (bi.H11202.isChecked()) {
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
            } else {
                startActivity(new Intent(this, MemberList.class));
            }

        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {
        db = new DatabaseHelper(this);
        long updcount = db.addForm(form);
        form.setId(String.valueOf(updcount));
        if (updcount > 0) {
            form.setUid(form.getDeviceid() + form.getId());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.getUid());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        MainApp.form = new Form();
        MainApp.form.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        MainApp.form.setUsername(MainApp.userName);
        MainApp.form.setDeviceid(MainApp.appInfo.getDeviceID());
        MainApp.form.setDevicetagid(MainApp.appInfo.getDeviceID());
        MainApp.form.setH213("0");
        MainApp.form.setH214("0");
        MainApp.form.setH21501("0");
        MainApp.form.setH21502("0");
        MainApp.form.setH21601("0");
        MainApp.form.setH21602("0");
        MainApp.form.setH21701("0");
        MainApp.form.setH21702("0");

        JSONObject json = new JSONObject();

        MainApp.interviewDate = bi.H108.getText().toString().trim().trim().isEmpty() ? "-1" : bi.H108.getText().toString().trim();

        json.put("H101", bi.H101.getText().toString().trim().isEmpty() ? "-1" : bi.H101.getText().toString().trim());
        json.put("H102", bi.H102.getText().toString().trim().isEmpty() ? "-1" : bi.H102.getText().toString().trim());
        json.put("H103", bi.H103.getText().toString().trim().isEmpty() ? "-1" : bi.H103.getText().toString().trim());
        json.put("H104", bi.H104.getText().toString().trim().isEmpty() ? "-1" : bi.H104.getText().toString().trim());
        json.put("H105", bi.H105.getText().toString().trim().isEmpty() ? "-1" : bi.H105.getText().toString().trim());
        json.put("H106", bi.H106.getText().toString().trim().isEmpty() ? "-1" : bi.H106.getText().toString().trim());
        json.put("H107", bi.H107.getText().toString().trim().isEmpty() ? "-1" : bi.H107.getText().toString().trim());
        json.put("H108", bi.H108.getText().toString().trim().isEmpty() ? "-1" : bi.H108.getText().toString().trim());
        json.put("H109", bi.H109.getText().toString().trim().isEmpty() ? "-1" : bi.H109.getText().toString().trim());
        json.put("H110", bi.H110.getText().toString().trim().isEmpty() ? "-1" : bi.H110.getText().toString().trim());
        json.put("H111", bi.H111.getText().toString().trim().isEmpty() ? "-1" : bi.H111.getText().toString().trim());

        json.put("H112", bi.H11201.isChecked() ? "1"
                : bi.H11202.isChecked() ? "2"
                : "-1");

        json.put("H113", bi.H113.getText().toString().trim().isEmpty() ? "-1" : bi.H113.getText().toString().trim());

        json.put("H114", bi.H11401.isChecked() ? "1"
                : bi.H11402.isChecked() ? "2"
                : "-1");

        json.put("H115", bi.H11501.isChecked() ? "1"
                : bi.H11502.isChecked() ? "2"
                : "-1");

        json.put("H116", bi.H11601.isChecked() ? "1"
                : bi.H11602.isChecked() ? "2"
                : bi.H11603.isChecked() ? "3"
                : bi.H11696.isChecked() ? "96"
                : "-1");
        json.put("H11696x", bi.H11696x.getText().toString().trim().isEmpty() ? "-1" : bi.H11696x.getText().toString().trim());

        json.put("H117", bi.H11701.isChecked() ? "1"
                : bi.H11702.isChecked() ? "2"
                : "-1");

        MainApp.form.setJSON(String.valueOf(json));
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void FetchCluster(View view) {

        /*if (formValidation()) {

            String mrno = bi.wfa101.getText().toString();
            db = MainApp.appInfo.getDbHelper();
            Cursor followups = db.getFollowups(mrno);

            //oast.makeText(this, "" + mrno, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "" + followups.getCount(), Toast.LENGTH_SHORT).show();

            if (followups.getCount() > 0) {

                //Toast.makeText(this, "" + followups.getString(followups.getColumnIndex("s1q501")), Toast.LENGTH_SHORT).show();

                followups.moveToFirst();

                bi.wmError.setVisibility(View.GONE);
                bi.pbarMR.setVisibility(View.GONE);
                bi.checkMR.setVisibility(View.VISIBLE);

                col_id = Integer.parseInt(followups.getString(followups.getColumnIndex("id")));
                if (!followups.getString(followups.getColumnIndex("curfupweek")).equals("") && followups.getString(followups.getColumnIndex("curfupweek")) != null) {

                    if (!followups.getString(followups.getColumnIndex("curfupdt")).equals("") && followups.getString(followups.getColumnIndex("curfupdt")) != null) {

                        String str = followups.getString(followups.getColumnIndex("sf6a"));
                        String str2 = followups.getString(followups.getColumnIndex("pFollowUpDate"));
                        delivery_date = str.replace("-", "/");

                        String[] wfb108 = str2.split("-");
                        String day = wfb108[2];
                        String month = wfb108[1];
                        String year = wfb108[0];
                        pFollowUpDate = day + "/" + month + "/" + year;

                        bi.wfa10401.setMinDate(delivery_date);

                        try {
                            bi.wfa10401.setMinDate(DateUtils.getNextDate(delivery_date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        bi.wfa11001.setMinDate(delivery_date);

                        Toast.makeText(SectionWFA01Activity.this, "Child followup found.", Toast.LENGTH_SHORT).show();

                        bi.wfa102.setText(followups.getString(followups.getColumnIndex("sf20")));
                        bi.wfa103.setText(followups.getString(followups.getColumnIndex("s1q3")));
                        bi.wfa105.setText(followups.getString(followups.getColumnIndex("curfupweek")));
                        bi.studySite.setText(followups.getString(followups.getColumnIndex("studySite")));

                        bi.wfa105.setEnabled(true);
                        bi.llsectionwfa01.setVisibility(View.VISIBLE);
                        // CONTINUE VISIBLE
                        bi.btnContinue.setVisibility(View.VISIBLE);
                        bi.btnEnd.setVisibility(View.GONE);
                        // Clear.clearAllFields(bi.llsectionwfa01);
                    } else {
                        Toast.makeText(SectionWFA01Activity.this, followups.getString(followups.getColumnIndex("curfupweek")), Toast.LENGTH_SHORT).show();
                        bi.llsectionwfa01.setVisibility(View.GONE);

                        // CONTINUE VISIBLE
                        bi.btnContinue.setVisibility(View.GONE);
                        bi.btnEnd.setVisibility(View.VISIBLE);
                        Clear.clearAllFields(bi.llsectionwfa01);
                        bi.wmError.setText(followups.getString(followups.getColumnIndex("curfupweek")));
                        bi.wmError.setVisibility(View.VISIBLE);

                    }

                } else {

                    Toast.makeText(SectionWFA01Activity.this, "Child follow-up not found.", Toast.LENGTH_SHORT).show();
                    bi.llsectionwfa01.setVisibility(View.GONE);
                    bi.wmError.setText("Child follow-up not found.");
                    bi.wmError.setVisibility(View.VISIBLE);
                    // CONTINUE VISIBLE
                    bi.btnContinue.setVisibility(View.GONE);
                    bi.btnEnd.setVisibility(View.VISIBLE);
                    Clear.clearAllFields(bi.llsectionwfa01);
                }

            } else {

                bi.pbarMR.setVisibility(View.GONE);
                bi.checkMR.setVisibility(View.VISIBLE);
                //String message = workInfo.getOutputData().getString("error");
                bi.wmError.setText("MR No not found");
                bi.wmError.setVisibility(View.VISIBLE);

            }
        }*/

        //bi.checkCluster.setVisibility(View.GONE);

        if (formValidation()) {
            clusterNo = bi.H101.getText().toString().trim();

            if (clusterNo.length() == 8) {

                db = MainApp.appInfo.getDbHelper();
                Cursor cluster = db.getCluster(clusterNo);
                if (cluster.getCount() > 0) {
                    cluster.moveToFirst();
                    bi.H102.setText(cluster.getString(cluster.getColumnIndex("provinceName")));
                    bi.H103.setText(cluster.getString(cluster.getColumnIndex("districtName")));
                    bi.H104.setText(cluster.getString(cluster.getColumnIndex("tehsil")));
                    bi.H105.setText(cluster.getString(cluster.getColumnIndex("unionCouncil")));
                    bi.H106.setText(cluster.getString(cluster.getColumnIndex("city")));
                    bi.H102TOH117.setVisibility(View.VISIBLE);
                } else {
                    bi.H101.setError("No such Cluster, please check");
                    Clear.clearAllFields(bi.H102TOH117);
                    bi.H102TOH117.setVisibility(View.GONE);
                    bi.checkCluster.setVisibility(View.VISIBLE);
                }

            } else {

                Clear.clearAllFields(bi.H102TOH117);
                bi.H102TOH117.setVisibility(View.GONE);
                bi.checkCluster.setVisibility(View.VISIBLE);
            }
        }
    }

}