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
    int skipToW4 = 0;
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

        bi.W111.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 0) {

                    if (Integer.parseInt(s.toString()) == 0) {

                        skipToW4 = 1;

                        Clear.clearAllFields(bi.fldGrpCVW112);
                        bi.fldGrpCVW112.setVisibility(View.GONE);

                        Clear.clearAllFields(bi.fldGrpCVW113);
                        bi.fldGrpCVW113.setVisibility(View.GONE);

                        Clear.clearAllFields(bi.fldGrpCVW114);
                        bi.fldGrpCVW114.setVisibility(View.GONE);

                        Clear.clearAllFields(bi.fldGrpCVW115);
                        bi.fldGrpCVW115.setVisibility(View.GONE);

                    } else {

                        bi.fldGrpCVW112.setVisibility(View.VISIBLE);
                        bi.fldGrpCVW113.setVisibility(View.VISIBLE);
                        bi.fldGrpCVW114.setVisibility(View.VISIBLE);
                        bi.fldGrpCVW115.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        bi.W113.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 0) {

                    if (Integer.parseInt(s.toString()) == 0) {

                        skipToW4 = 1;

                        Clear.clearAllFields(bi.fldGrpCVW114);
                        bi.fldGrpCVW114.setVisibility(View.GONE);

                        Clear.clearAllFields(bi.fldGrpCVW115);
                        bi.fldGrpCVW115.setVisibility(View.GONE);

                    } else {

                        bi.fldGrpCVW114.setVisibility(View.VISIBLE);
                        bi.fldGrpCVW115.setVisibility(View.VISIBLE);
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

            if (skipToW4 > 0) {
                startActivity(new Intent(this, W4.class).putExtra("id", id).putExtra("uid", uid));
            } else {
                int np;
                if (bi.W10901.isChecked()) {
                    np = Integer.parseInt(bi.W110.getText().toString()) - 1;
                } else {
                    np = Integer.parseInt(bi.W110.getText().toString());
                }

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

        json.put("W10501", bi.W10501.getText().toString().trim().isEmpty() ? "-1" : bi.W10501.getText().toString().trim());
        json.put("W10502", bi.W10502.getText().toString().trim().isEmpty() ? "-1" : bi.W10502.getText().toString().trim());
        json.put("W10503", bi.W10503.getText().toString().trim().isEmpty() ? "-1" : bi.W10503.getText().toString().trim());

        json.put("W106", bi.W106.getText().toString().trim().isEmpty() ? "-1" : bi.W106.getText().toString().trim());

        json.put("W107", bi.W107.getText().toString().trim().isEmpty() ? "-1" : bi.W107.getText().toString().trim());

        json.put("W108", bi.W108.getText().toString().trim().isEmpty() ? "-1" : bi.W108.getText().toString().trim());

        json.put("W109", bi.W10901.isChecked() ? "1"
                : bi.W10902.isChecked() ? "2"
                : "-1");

        json.put("W110", bi.W110.getText().toString().trim().isEmpty() ? "-1" : bi.W110.getText().toString().trim());

        json.put("W111", bi.W111.getText().toString().trim().isEmpty() ? "-1" : bi.W111.getText().toString().trim());

        json.put("W112", bi.W112.getText().toString().trim().isEmpty() ? "-1" : bi.W112.getText().toString().trim());

        json.put("W113", bi.W113.getText().toString().trim().isEmpty() ? "-1" : bi.W113.getText().toString().trim());

        json.put("W114", bi.W114.getText().toString().trim().isEmpty() ? "-1" : bi.W114.getText().toString().trim());

        json.put("W115", bi.W11501.isChecked() ? "1"
                : bi.W11502.isChecked() ? "2"
                : "-1");

        mwra.setJSON(String.valueOf(json));
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }
}