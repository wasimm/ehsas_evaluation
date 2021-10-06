package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.PregnanciesContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityW102Binding;
import edu.aku.wasimabbas.ehsas_evaluation.models.Pregnancy;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;


public class W102 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int np;
    ActivityW102Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_w102);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");
        Toast.makeText(this, "" + uid, Toast.LENGTH_SHORT).show();
        np = intent.getIntExtra("np", 0);
        np = np - 1;
        counter = intent.getIntExtra("counter", 0);
        counter = counter + 1;
        bi.W116.setText(counter);
    }

    private void setupSkip() {

        //W118
        bi.W118.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W11802.getId() || checkedId == bi.W11805.getId() || checkedId == bi.W11806.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW119);
                bi.fldGrpCVW119.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW120);
                bi.fldGrpCVW120.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW121);
                bi.fldGrpCVW121.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW119.setVisibility(View.VISIBLE);
                bi.fldGrpCVW120.setVisibility(View.VISIBLE);
                bi.fldGrpCVW121.setVisibility(View.VISIBLE);
            }
        });

        //W119
        bi.W119.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W11902.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW120);
                bi.fldGrpCVW120.setVisibility(View.GONE);
                bi.fldGrpCVW121.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVW121);
                bi.fldGrpCVW121.setVisibility(View.GONE);
                bi.fldGrpCVW120.setVisibility(View.VISIBLE);
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
            if (np > 0) {
                startActivity(new Intent(this, W102.class).putExtra("np", np).putExtra("id", id).putExtra("uid", uid).putExtra("counter", counter));
            } else {
                startActivity(new Intent(this, W2.class).putExtra("id", id).putExtra("uid", uid));
            }
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        oF = new Intent(this, EndingActivity.class);
        startActivity(oF);
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

        MainApp.p.setW116(bi.W116.getText().toString().trim().isEmpty() ? "-1" : bi.W116.getText().toString().trim());

        MainApp.p.setW11701(bi.W11701.getText().toString().trim().isEmpty() ? "-1" : bi.W11701.getText().toString().trim());
        MainApp.p.setW11702(bi.W11702.getText().toString().trim().isEmpty() ? "-1" : bi.W11702.getText().toString().trim());
        MainApp.p.setW11703(bi.W11703.getText().toString().trim().isEmpty() ? "-1" : bi.W11703.getText().toString().trim());

        MainApp.p.setW118(bi.W11801.isChecked() ? "1"
                : bi.W11802.isChecked() ? "2"
                : bi.W11803.isChecked() ? "3"
                : bi.W11804.isChecked() ? "4"
                : bi.W11805.isChecked() ? "5"
                : bi.W11806.isChecked() ? "6"
                : "-1");

        MainApp.p.setW119(bi.W11901.isChecked() ? "1"
                : bi.W11902.isChecked() ? "2"
                : "-1");

        MainApp.p.setW12001(bi.W12001.getText().toString().trim().isEmpty() ? "-1" : bi.W12001.getText().toString().trim());
        MainApp.p.setW12002(bi.W12002.getText().toString().trim().isEmpty() ? "-1" : bi.W12002.getText().toString().trim());
        MainApp.p.setW12003(bi.W12003.getText().toString().trim().isEmpty() ? "-1" : bi.W12003.getText().toString().trim());

        MainApp.p.setW12101(bi.W12101.getText().toString().trim().isEmpty() ? "-1" : bi.W12101.getText().toString().trim());
        MainApp.p.setW12102(bi.W12102.getText().toString().trim().isEmpty() ? "-1" : bi.W12102.getText().toString().trim());
        MainApp.p.setW12103(bi.W12103.getText().toString().trim().isEmpty() ? "-1" : bi.W12103.getText().toString().trim());
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }
}