package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import static edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.form;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleChildrenContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityC1Binding;
import edu.aku.wasimabbas.ehsas_evaluation.models.EligibleChild;


public class C1 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;
    public String fuid;
    ActivityC1Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_c1);
        bi.setCallback(this);

        setupSkip();


        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");

        fuid = form.getUid();

        Toast.makeText(this, "C1: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();

        bi.C101.setText(name);
        bi.C102.setText(String.valueOf(serialNO));


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
            startActivity(new Intent(this, C2.class).putExtra("id", id).putExtra("uid", uid));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        MainApp.openEndActivity(this);
    }

    private boolean UpdateDB() {
        db = new DatabaseHelper(this);
        long updcount = db.addChild(MainApp.child);
        MainApp.child.setId(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.child.setUid(MainApp.child.getDeviceid() + MainApp.child.getId());
            db.updatesChildColumn(EligibleChildrenContract.ChildrenTable.COLUMN_UID, MainApp.child.getUid());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        MainApp.child = new EligibleChild();
        MainApp.child.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        MainApp.child.setUsername(MainApp.userName);
        MainApp.child.setDeviceid(MainApp.appInfo.getDeviceID());
        MainApp.child.setDeviceTagid(MainApp.appInfo.getDeviceID());
        MainApp.child.setAppversion(MainApp.appInfo.getDeviceID());
        MainApp.child.setMuid(uid);
        MainApp.child.setFuid(form.getUid());

        JSONObject json = new JSONObject();

        json.put("C101", bi.C101.getText().toString().trim().isEmpty() ? "-1" : bi.C101.getText().toString().trim());
        json.put("C102", bi.C102.getText().toString().trim().isEmpty() ? "-1" : bi.C102.getText().toString().trim());
        json.put("C103", bi.C103.getText().toString().trim().isEmpty() ? "-1" : bi.C103.getText().toString().trim());
        json.put("C104", bi.C104.getText().toString().trim().isEmpty() ? "-1" : bi.C104.getText().toString().trim());


        MainApp.child.setJSON(String.valueOf(json));
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }
}