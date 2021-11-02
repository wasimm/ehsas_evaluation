package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.PregnanciesContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityW102Binding;
import edu.aku.wasimabbas.ehsas_evaluation.models.Pregnancy;


public class W102 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int np;
    public int tp;
    ActivityW102Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_w102);
        bi.setCallback(this);

        setupSkip();

        Toast.makeText(this, "W102: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");
        Toast.makeText(this, "" + uid, Toast.LENGTH_SHORT).show();
        np = intent.getIntExtra("np", 0);
        tp = intent.getIntExtra("tp", 0);
        np = np - 1;
        counter = intent.getIntExtra("counter", 0);
        counter = counter + 1;
        bi.name.setText(name);
        bi.pop.setText(counter + "/" + tp + "حمل نمبر:");
        bi.W114.setText(String.valueOf(counter));
    }

    public static boolean isValidDate(String inDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
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
            if (np > 0) {
                startActivity(new Intent(this, W102.class).putExtra("np", np).putExtra("id", id).putExtra("uid", uid).putExtra("counter", counter).putExtra("tp", tp).putExtra("name", name));
            } else {
                startActivity(new Intent(this, W2.class).putExtra("id", id).putExtra("uid", uid));
            }
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public static int MonthsToDays(int tMonth, int tYear) {

        if (tMonth == 1 || tMonth == 3 || tMonth == 5 || tMonth == 7
                || tMonth == 8 || tMonth == 10 || tMonth == 12) {
            return 31;
        } else if (tMonth == 2) {
            if (tYear % 4 == 0) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 30;
        }
    }

    private boolean UpdateDB() {

        db = MainApp.appInfo.getDbHelper();
        long updcount = db.addPregnancy(MainApp.p);
        MainApp.p.setId(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.p.setUid(MainApp.p.getDeviceid() + MainApp.p.getId());
            db.updatesPregnancyColumn(PregnanciesContract.PregnanciesTable.COLUMN_UID, MainApp.p.getUid(), MainApp.p.getId());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        MainApp.p = new Pregnancy();

        MainApp.p.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        MainApp.p.setUsername(MainApp.userName);
        MainApp.p.setDeviceid(MainApp.appInfo.getDeviceID());
        MainApp.p.setDevicetagid(MainApp.appInfo.getDeviceID());
        MainApp.p.setAppversion(MainApp.appInfo.getAppVersion());
        MainApp.p.setMuid(MainApp.mwra.getUid());
        MainApp.p.setFuid(MainApp.form.getUid());

        MainApp.p.setW116(bi.W114.getText().toString().trim().isEmpty() ? "-1" : bi.W114.getText().toString().trim());

        MainApp.p.setW116(bi.W115.getText().toString().trim().isEmpty() ? "-1" : bi.W115.getText().toString().trim());

        MainApp.p.setW116(bi.W11601.isChecked() ? "1"
                : bi.W11602.isChecked() ? "2"
                : bi.W11603.isChecked() ? "3"
                : bi.W11604.isChecked() ? "4"
                : bi.W11605.isChecked() ? "5"
                : bi.W11606.isChecked() ? "6"
                : "-1");

        MainApp.p.setW117(bi.W11701.isChecked() ? "1"
                : bi.W11702.isChecked() ? "2"
                : "-1");

        MainApp.p.setW11801(bi.W11801.getText().toString().trim().isEmpty() ? "-1" : bi.W11801.getText().toString().trim());
        MainApp.p.setW11802(bi.W11802.getText().toString().trim().isEmpty() ? "-1" : bi.W11802.getText().toString().trim());
        MainApp.p.setW11803(bi.W11803.getText().toString().trim().isEmpty() ? "-1" : bi.W11803.getText().toString().trim());

        MainApp.p.setW11901(bi.W11901.getText().toString().trim().isEmpty() ? "-1" : bi.W11901.getText().toString().trim());
        MainApp.p.setW11902(bi.W11902.getText().toString().trim().isEmpty() ? "-1" : bi.W11902.getText().toString().trim());
        MainApp.p.setW11903(bi.W11903.getText().toString().trim().isEmpty() ? "-1" : bi.W11903.getText().toString().trim());

        // Second Child if W11603 is checked
        MainApp.p.setW117C2(bi.W117C201.isChecked() ? "1"
                : bi.W117C202.isChecked() ? "2"
                : "-1");

        MainApp.p.setW118C201(bi.W118C201.getText().toString().trim().isEmpty() ? "-1" : bi.W118C201.getText().toString().trim());
        MainApp.p.setW118C202(bi.W118C202.getText().toString().trim().isEmpty() ? "-1" : bi.W118C202.getText().toString().trim());
        MainApp.p.setW118C203(bi.W118C203.getText().toString().trim().isEmpty() ? "-1" : bi.W118C203.getText().toString().trim());

        MainApp.p.setW119C201(bi.W119C201.getText().toString().trim().isEmpty() ? "-1" : bi.W119C201.getText().toString().trim());
        MainApp.p.setW119C202(bi.W119C202.getText().toString().trim().isEmpty() ? "-1" : bi.W119C202.getText().toString().trim());
        MainApp.p.setW119C203(bi.W119C203.getText().toString().trim().isEmpty() ? "-1" : bi.W119C203.getText().toString().trim());
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }

    private void setupSkip() {

        // W116
        bi.W116.setOnCheckedChangeListener((group, idChecked) -> {

            if (idChecked == bi.W11603.getId()) {

                bi.fldGrpCVW117.setVisibility(View.VISIBLE);
                bi.fldGrpCVW118.setVisibility(View.VISIBLE);
                bi.fldGrpCVW119.setVisibility(View.VISIBLE);
                bi.child2.setVisibility(View.VISIBLE);

            } else if (idChecked == bi.W11602.getId() || idChecked == bi.W11605.getId() || idChecked == bi.W11606.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW117);
                Clear.clearAllFields(bi.fldGrpCVW118);
                Clear.clearAllFields(bi.fldGrpCVW119);
                Clear.clearAllFields(bi.child2);
                bi.fldGrpCVW117.setVisibility(View.GONE);
                bi.fldGrpCVW118.setVisibility(View.GONE);
                bi.fldGrpCVW119.setVisibility(View.GONE);
                bi.child2.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW117.setVisibility(View.VISIBLE);
                bi.fldGrpCVW118.setVisibility(View.VISIBLE);
                bi.fldGrpCVW119.setVisibility(View.VISIBLE);
                Clear.clearAllFields(bi.child2);
                bi.child2.setVisibility(View.GONE);
            }
        });

        // W119
        /*bi.W119.setOnCheckedChangeListener((group, isChecked) -> {
            if (isChecked == bi.W11902.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW120);
                bi.fldGrpCVW120.setVisibility(View.GONE);
                bi.fldGrpCVW121.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVW121);
                bi.fldGrpCVW121.setVisibility(View.GONE);
                bi.fldGrpCVW120.setVisibility(View.VISIBLE);


                if (!bi.W11701.getText().toString().equals("98") && !bi.W11702.getText().toString().equals("98") && !bi.W11703.getText().toString().equals("9998")) {

                    String dob = bi.W11701.getText().toString() + "/" + bi.W11702.getText().toString() + "/" + bi.W11703.getText().toString();

                    if (!isValidDate(dob)) {

                        bi.W11701.setError("Kindly enter a valid Date of Birth");
                        bi.W11701.requestFocus();

                    } else {

                        int[] Age = calculateAge(dob, MainApp.interviewDate);
                        int days = Age[0];
                        int months = Age[1];
                        int years = Age[2];
                        bi.W12003.setText(String.valueOf(days));
                        bi.W12002.setText(String.valueOf(months));
                        bi.W12001.setText(String.valueOf(years));
                    }

                } else {

                    if (bi.W11703.getText().toString().equals("9998")) {

                        bi.W12001.setEnabled(true);
                        bi.W12001.setText(null);

                        bi.W12002.setEnabled(true);
                        bi.W12002.setText(null);

                        bi.W12003.setEnabled(true);
                        bi.W12003.setText(null);

                    } else {

                        String dob = bi.W11701.getText().toString() + "/" + bi.W11702.getText().toString() + "/" + bi.W11703.getText().toString();

                        int[] Age = calculateAge(dob, MainApp.interviewDate);
                        int days = Age[0];
                        int months = Age[1];
                        int years = Age[2];
                        bi.W12003.setText(String.valueOf(days));
                        bi.W12002.setText(String.valueOf(months));
                        bi.W12001.setText(String.valueOf(years));
                    }
                }
            }
        })*/
    }

    public void BtnEnd() {
        MainApp.openEndActivity(this);
    }

    public int[] calculateAge(String dob, String curd) {

        String[] dob_sep = dob.split("/");
        String[] curd_sep = curd.split("/");

        String dob_day = dob_sep[0];
        String dob_month = dob_sep[1];
        String dob_year = dob_sep[2];
        String curd_day = curd_sep[0];
        String curd_month = curd_sep[1];
        String curd_year = curd_sep[2];

        int mYearDiff, mMonDiff, mDayDiff;

        if (parseInt(dob_year) == 9998 || parseInt(curd_year) == 9998) {

            mYearDiff = 0;

        } else {

            mYearDiff = parseInt(curd_year) - parseInt(dob_year);
        }

        if (parseInt(dob_month) == 98 || parseInt(curd_month) == 98) {

            mMonDiff = 0;

        } else {

            mMonDiff = parseInt(curd_month) - parseInt(dob_month);

            if (mMonDiff < 0) {
                mYearDiff = mYearDiff - 1;
                mMonDiff = mMonDiff + 12;
            }
        }

        if (parseInt(dob_day) == 98 || parseInt(curd_day) == 98) {

            mDayDiff = 0;

        } else {

            mDayDiff = parseInt(curd_day) - parseInt(dob_day);
        }

        if (mDayDiff < 0) {
            if (mMonDiff > 0) {
                mMonDiff = mMonDiff - 1;
                mDayDiff = mDayDiff + MonthsToDays(parseInt(curd_month) - 1, parseInt(curd_year));

            } else {
                mYearDiff = mYearDiff - 1;
                mMonDiff = 11;
                mDayDiff = mDayDiff + MonthsToDays(parseInt(curd_month) - 1, parseInt(curd_year));
            }

        }

        int[] Age = new int[]{mDayDiff, mMonDiff, mYearDiff};

        return Age;
    }
}