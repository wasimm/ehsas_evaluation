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
import org.json.JSONObject;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleChildrenContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.MembersContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityC4Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class C4 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;
    public String fuid;
    ActivityC4Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_c4);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");
    }

    private void setupSkip() {

        //C401
        bi.C401.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C40102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC40201);
                Clear.clearAllFields(bi.fldGrpCVC40202);
                Clear.clearAllFields(bi.fldGrpCVC40203);
                Clear.clearAllFields(bi.fldGrpCVC40204);
                Clear.clearAllFields(bi.fldGrpCVC40205);
                Clear.clearAllFields(bi.fldGrpCVC40206);
                Clear.clearAllFields(bi.fldGrpCVC40207);
                Clear.clearAllFields(bi.fldGrpCVC40208);
                Clear.clearAllFields(bi.fldGrpCVC40296);
                Clear.clearAllFields(bi.fldGrpCVC403);
                Clear.clearAllFields(bi.fldGrpCVC404);
                Clear.clearAllFields(bi.fldGrpCVC405);

                bi.fldGrpCVC40201.setVisibility(View.GONE);
                bi.fldGrpCVC40202.setVisibility(View.GONE);
                bi.fldGrpCVC40203.setVisibility(View.GONE);
                bi.fldGrpCVC40204.setVisibility(View.GONE);
                bi.fldGrpCVC40205.setVisibility(View.GONE);
                bi.fldGrpCVC40206.setVisibility(View.GONE);
                bi.fldGrpCVC40207.setVisibility(View.GONE);
                bi.fldGrpCVC40208.setVisibility(View.GONE);
                bi.fldGrpCVC40296.setVisibility(View.GONE);
                bi.fldGrpCVC403.setVisibility(View.GONE);
                bi.fldGrpCVC404.setVisibility(View.GONE);
                bi.fldGrpCVC405.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC40201.setVisibility(View.VISIBLE);
                bi.fldGrpCVC40202.setVisibility(View.VISIBLE);
                bi.fldGrpCVC40203.setVisibility(View.VISIBLE);
                bi.fldGrpCVC40204.setVisibility(View.VISIBLE);
                bi.fldGrpCVC40205.setVisibility(View.VISIBLE);
                bi.fldGrpCVC40206.setVisibility(View.VISIBLE);
                bi.fldGrpCVC40207.setVisibility(View.VISIBLE);
                bi.fldGrpCVC40208.setVisibility(View.VISIBLE);
                bi.fldGrpCVC40296.setVisibility(View.VISIBLE);
                bi.fldGrpCVC403.setVisibility(View.VISIBLE);
                bi.fldGrpCVC404.setVisibility(View.VISIBLE);
                bi.fldGrpCVC405.setVisibility(View.VISIBLE);
            }
        });

        //C403
        bi.C403.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C40302.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC404);
                Clear.clearAllFields(bi.fldGrpCVC405);

                bi.fldGrpCVC404.setVisibility(View.GONE);
                bi.fldGrpCVC405.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC404.setVisibility(View.VISIBLE);
                bi.fldGrpCVC405.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, ChildrenList.class));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        oF = new Intent(this, EndingActivity.class);
        startActivity(oF);
    }

    private boolean UpdateDB() {
        db = new DatabaseHelper(this);
        int updcount = db.updatesChildColumn(EligibleChildrenContract.ChildrenTable.COLUMN_JSON, MainApp.child.getJSON());
        if (updcount == 1) {
            db.updateCollectedColumn(MembersContract.MembersTable.COLUMN_COLLECTED, 1, id);
            Toast.makeText(this, "Member ID: " + id, Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("C401", bi.C40101.isChecked() ? "1"
                : bi.C40102.isChecked() ? "2"
                : "-1");

        json.put("C40201", bi.C4020101.isChecked() ? "1"
                : bi.C4020102.isChecked() ? "2"
                : "-1");

        json.put("C40202", bi.C4020201.isChecked() ? "1"
                : bi.C4020202.isChecked() ? "2"
                : "-1");

        json.put("C40203", bi.C4020301.isChecked() ? "1"
                : bi.C4020302.isChecked() ? "2"
                : "-1");

        json.put("C40204", bi.C4020401.isChecked() ? "1"
                : bi.C4020402.isChecked() ? "2"
                : "-1");

        json.put("C40205", bi.C4020501.isChecked() ? "1"
                : bi.C4020502.isChecked() ? "2"
                : "-1");

        json.put("C40206", bi.C4020601.isChecked() ? "1"
                : bi.C4020602.isChecked() ? "2"
                : "-1");

        json.put("C40207", bi.C4020701.isChecked() ? "1"
                : bi.C4020702.isChecked() ? "2"
                : "-1");

        json.put("C40208", bi.C4020801.isChecked() ? "1"
                : bi.C4020802.isChecked() ? "2"
                : "-1");

        json.put("C40296", bi.C4029601.isChecked() ? "1"
                : bi.C4029602.isChecked() ? "2"
                : "-1");
        json.put("C4029601x", bi.C4029601x.getText().toString().trim().isEmpty() ? "-1" : bi.C4029601x.getText().toString().trim());

        json.put("C403", bi.C40301.isChecked() ? "1"
                : bi.C40302.isChecked() ? "2"
                : "-1");

        json.put("C404", bi.C40401.isChecked() ? "1"
                : bi.C40402.isChecked() ? "2"
                : bi.C40403.isChecked() ? "3"
                : bi.C40404.isChecked() ? "4"
                : bi.C40405.isChecked() ? "5"
                : bi.C40406.isChecked() ? "6"
                : bi.C40407.isChecked() ? "7"
                : bi.C40408.isChecked() ? "8"
                : bi.C40496.isChecked() ? "96"
                : "-1");
        json.put("C40496x", bi.C40496x.getText().toString().trim().isEmpty() ? "-1" : bi.C40496x.getText().toString().trim());

        json.put("C405", bi.C40501.isChecked() ? "1"
                : bi.C40502.isChecked() ? "2"
                : bi.C40503.isChecked() ? "3"
                : bi.C40504.isChecked() ? "4"
                : bi.C40505.isChecked() ? "5"
                : bi.C40506.isChecked() ? "6"
                : bi.C40507.isChecked() ? "7"
                : bi.C40508.isChecked() ? "8"
                : bi.C40509.isChecked() ? "9"
                : bi.C40510.isChecked() ? "10"
                : bi.C40511.isChecked() ? "11"
                : bi.C40596.isChecked() ? "96"
                : "-1");
        json.put("C40596x", bi.C40596x.getText().toString().trim().isEmpty() ? "-1" : bi.C40596x.getText().toString().trim());

        try {
            JSONObject json_merged = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.child.getJSON()), json);
            MainApp.child.setJSON(String.valueOf(json_merged));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }
}