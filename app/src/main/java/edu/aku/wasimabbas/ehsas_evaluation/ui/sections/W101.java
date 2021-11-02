package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import static edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.form;
import static edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.mwra;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleMWRAsContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityW101Binding;
import edu.aku.wasimabbas.ehsas_evaluation.models.EligibleMWRA;


public class W101 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;
    public String fuid;
    ActivityW101Binding bi;
    Intent oF = null;
    int skipToW5 = 0;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_w101);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");

        fuid = form.getUid();

        Toast.makeText(this, "W101: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();

        bi.W102.setText(name);
        bi.W103.setText(String.valueOf(serialNO));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //fuid = form.getUid();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private void setupSkip() {

        //W105
        bi.W105.setOnCheckedChangeListener((group, idChecked) -> {

            if (idChecked == bi.W10502.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW106);
                bi.fldGrpCVW106.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW106.setVisibility(View.VISIBLE);
            }

        });

        //W106
        bi.W106.setOnCheckedChangeListener((group, idChecked) -> {

            if (idChecked == bi.W10601.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW107);
                Clear.clearAllFields(bi.fldGrpCVW108);
                Clear.clearAllFields(bi.fldGrpCVW109);
                Clear.clearAllFields(bi.fldGrpCVW110);
                Clear.clearAllFields(bi.fldGrpCVW111);
                Clear.clearAllFields(bi.fldGrpCVW112);
                Clear.clearAllFields(bi.fldGrpCVW113);
                bi.fldGrpCVW107.setVisibility(View.GONE);
                bi.fldGrpCVW108.setVisibility(View.GONE);
                bi.fldGrpCVW109.setVisibility(View.GONE);
                bi.fldGrpCVW110.setVisibility(View.GONE);
                bi.fldGrpCVW111.setVisibility(View.GONE);
                bi.fldGrpCVW112.setVisibility(View.GONE);
                bi.fldGrpCVW113.setVisibility(View.GONE);
                skipToW5 = 1;
            } else {
                bi.fldGrpCVW107.setVisibility(View.VISIBLE);
                bi.fldGrpCVW108.setVisibility(View.VISIBLE);
                bi.fldGrpCVW109.setVisibility(View.VISIBLE);
                bi.fldGrpCVW110.setVisibility(View.VISIBLE);
                bi.fldGrpCVW111.setVisibility(View.VISIBLE);
                bi.fldGrpCVW112.setVisibility(View.VISIBLE);
                bi.fldGrpCVW113.setVisibility(View.VISIBLE);
                skipToW5 = 0;
            }

        });

        // W108
        bi.W108.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 0) {

                    if (Integer.parseInt(s.toString()) == 0) {
                        Clear.clearAllFields(bi.fldGrpCVW109);
                        Clear.clearAllFields(bi.fldGrpCVW110);
                        Clear.clearAllFields(bi.fldGrpCVW111);
                        Clear.clearAllFields(bi.fldGrpCVW112);
                        bi.fldGrpCVW109.setVisibility(View.GONE);
                        bi.fldGrpCVW110.setVisibility(View.GONE);
                        bi.fldGrpCVW111.setVisibility(View.GONE);
                        bi.fldGrpCVW112.setVisibility(View.GONE);
                    } else {
                        bi.fldGrpCVW109.setVisibility(View.VISIBLE);
                        bi.fldGrpCVW110.setVisibility(View.VISIBLE);
                        bi.fldGrpCVW111.setVisibility(View.VISIBLE);
                        bi.fldGrpCVW112.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
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

            if (skipToW5 > 0) {
                startActivity(new Intent(this, W4.class).putExtra("id", id).putExtra("uid", uid));
            } else {
                int np = Integer.parseInt(bi.W107.getText().toString()) - 1;
                int tp = np;
                startActivity(new Intent(this, W102.class).putExtra("np", np).putExtra("id", id).putExtra("uid", uid).putExtra("counter", 0).putExtra("tp", tp).putExtra("name", name));
            }


        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        MainApp.openEndActivity(this);
    }

    private boolean UpdateDB() {
        db = new DatabaseHelper(this);
        long updcount = db.addMWRA(mwra);
        mwra.setId(String.valueOf(updcount));
        if (updcount > 0) {
            mwra.setUid(mwra.getDeviceid() + mwra.getId());
            db.updatesMWRAColumn(EligibleMWRAsContract.MWRAsTable.COLUMN_UID, mwra.getUid());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        mwra = new EligibleMWRA();
        mwra.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        mwra.setUsername(MainApp.userName);
        mwra.setDeviceid(MainApp.appInfo.getDeviceID());
        mwra.setDeviceTagid(MainApp.appInfo.getDeviceID());
        mwra.setAppversion(MainApp.appInfo.getDeviceID());
        mwra.setMuid(uid);
        mwra.setFuid(form.getUid());

        JSONObject json = new JSONObject();

        json.put("W101", bi.W101.getText().toString().trim().isEmpty() ? "-1" : bi.W101.getText().toString().trim());

        json.put("W102", bi.W102.getText().toString().trim().isEmpty() ? "-1" : bi.W102.getText().toString().trim());

        json.put("W103", bi.W103.getText().toString().trim().isEmpty() ? "-1" : bi.W103.getText().toString().trim());

        json.put("W104", bi.W104.getText().toString().trim().isEmpty() ? "-1" : bi.W104.getText().toString().trim());

        json.put("W105", bi.W10501.isChecked() ? "1"
                : bi.W10502.isChecked() ? "2"
                : "-1");

        json.put("W106", bi.W10601.isChecked() ? "1"
                : bi.W10602.isChecked() ? "2"
                : "-1");

        json.put("W107", bi.W107.getText().toString().trim().isEmpty() ? "-1" : bi.W107.getText().toString().trim());

        json.put("W108", bi.W108.getText().toString().trim().isEmpty() ? "-1" : bi.W108.getText().toString().trim());

        json.put("W109", bi.W10901.isChecked() ? "1"
                : bi.W10902.isChecked() ? "2"
                : "-1");

        json.put("W110", bi.W110.getText().toString().trim().isEmpty() ? "-1" : bi.W110.getText().toString().trim());

        json.put("W111", bi.W111.getText().toString().trim().isEmpty() ? "-1" : bi.W111.getText().toString().trim());

        json.put("W112", bi.W112.getText().toString().trim().isEmpty() ? "-1" : bi.W112.getText().toString().trim());

        json.put("W113", bi.W11301.isChecked() ? "1"
                : bi.W11302.isChecked() ? "2"
                : "-1");


        mwra.setJSON(String.valueOf(json));
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }
}