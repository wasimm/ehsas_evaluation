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
import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityW6Binding;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class W6 extends AppCompatActivity {

    ActivityW6Binding bi;
    Intent oF = null;
    private DatabaseHelper db;
    public long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_w6);
        bi.setCallback(this);

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);

        setupSkip();

        Toast.makeText(this, "W6: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
    }

    private void setupSkip() {

        //W60101
        bi.W60101.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W6010101.getId()) {

                bi.fldGrpCVW60102.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60103.setVisibility(View.VISIBLE);

                bi.fldGrpCVW602.setVisibility(View.VISIBLE);

                bi.fldGrpCVW60301.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60302.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60303.setVisibility(View.VISIBLE);

                bi.fldGrpCVW60401.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60402.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60403.setVisibility(View.VISIBLE);

                bi.fldGrpCVW60501.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60502.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60503.setVisibility(View.VISIBLE);

                bi.fldGrpCVW60601.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60602.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60603.setVisibility(View.VISIBLE);

                bi.fldGrpCVW60701.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60702.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60703.setVisibility(View.VISIBLE);

                bi.fldGrpCVW608.setVisibility(View.VISIBLE);
                bi.fldGrpCVW609.setVisibility(View.VISIBLE);
                bi.fldGrpCVW610.setVisibility(View.VISIBLE);

            } else {

                Clear.clearAllFields(bi.fldGrpCVW60102);
                Clear.clearAllFields(bi.fldGrpCVW60103);
                Clear.clearAllFields(bi.fldGrpCVW602);
                Clear.clearAllFields(bi.fldGrpCVW60301);
                Clear.clearAllFields(bi.fldGrpCVW60302);
                Clear.clearAllFields(bi.fldGrpCVW60303);
                Clear.clearAllFields(bi.fldGrpCVW60401);
                Clear.clearAllFields(bi.fldGrpCVW60402);
                Clear.clearAllFields(bi.fldGrpCVW60403);
                Clear.clearAllFields(bi.fldGrpCVW60501);
                Clear.clearAllFields(bi.fldGrpCVW60502);
                Clear.clearAllFields(bi.fldGrpCVW60503);
                Clear.clearAllFields(bi.fldGrpCVW60601);
                Clear.clearAllFields(bi.fldGrpCVW60602);
                Clear.clearAllFields(bi.fldGrpCVW60603);
                Clear.clearAllFields(bi.fldGrpCVW60701);
                Clear.clearAllFields(bi.fldGrpCVW60702);
                Clear.clearAllFields(bi.fldGrpCVW60703);
                Clear.clearAllFields(bi.fldGrpCVW608);
                Clear.clearAllFields(bi.fldGrpCVW609);
                Clear.clearAllFields(bi.fldGrpCVW610);

                bi.fldGrpCVW60102.setVisibility(View.GONE);
                bi.fldGrpCVW60103.setVisibility(View.GONE);
                bi.fldGrpCVW602.setVisibility(View.GONE);
                bi.fldGrpCVW60301.setVisibility(View.GONE);
                bi.fldGrpCVW60302.setVisibility(View.GONE);
                bi.fldGrpCVW60303.setVisibility(View.GONE);
                bi.fldGrpCVW60401.setVisibility(View.GONE);
                bi.fldGrpCVW60402.setVisibility(View.GONE);
                bi.fldGrpCVW60403.setVisibility(View.GONE);
                bi.fldGrpCVW60501.setVisibility(View.GONE);
                bi.fldGrpCVW60502.setVisibility(View.GONE);
                bi.fldGrpCVW60503.setVisibility(View.GONE);
                bi.fldGrpCVW60601.setVisibility(View.GONE);
                bi.fldGrpCVW60602.setVisibility(View.GONE);
                bi.fldGrpCVW60603.setVisibility(View.GONE);
                bi.fldGrpCVW60701.setVisibility(View.GONE);
                bi.fldGrpCVW60702.setVisibility(View.GONE);
                bi.fldGrpCVW60703.setVisibility(View.GONE);
                bi.fldGrpCVW608.setVisibility(View.GONE);
                bi.fldGrpCVW609.setVisibility(View.GONE);
                bi.fldGrpCVW610.setVisibility(View.GONE);
            }
        });

        //W60301
        bi.W60301.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W6030102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW60302);
                Clear.clearAllFields(bi.fldGrpCVW60303);
                bi.fldGrpCVW60302.setVisibility(View.GONE);
                bi.fldGrpCVW60303.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW60302.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60303.setVisibility(View.VISIBLE);
            }
        });

        //W60401
        bi.W60401.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W6040102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW60402);
                Clear.clearAllFields(bi.fldGrpCVW60403);
                bi.fldGrpCVW60402.setVisibility(View.GONE);
                bi.fldGrpCVW60403.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW60402.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60403.setVisibility(View.VISIBLE);
            }
        });

        //W60501
        bi.W60501.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W6050102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW60502);
                Clear.clearAllFields(bi.fldGrpCVW60503);
                bi.fldGrpCVW60502.setVisibility(View.GONE);
                bi.fldGrpCVW60503.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW60502.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60503.setVisibility(View.VISIBLE);
            }
        });

        //W60601
        bi.W60601.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W6060102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW60602);
                Clear.clearAllFields(bi.fldGrpCVW60603);
                bi.fldGrpCVW60602.setVisibility(View.GONE);
                bi.fldGrpCVW60603.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW60602.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60603.setVisibility(View.VISIBLE);
            }
        });

        //W60701
        bi.W60701.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W6070102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW60702);
                Clear.clearAllFields(bi.fldGrpCVW60703);
                bi.fldGrpCVW60702.setVisibility(View.GONE);
                bi.fldGrpCVW60703.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW60702.setVisibility(View.VISIBLE);
                bi.fldGrpCVW60703.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, EndingMWRA.class).putExtra("id", id).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        MainApp.openEndActivity(this);
    }

    private boolean UpdateDB() {
        db = new DatabaseHelper(this);
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_JSON, MainApp.form.getJSON());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("W60101", bi.W6010101.isChecked() ? "1"
                : bi.W6010102.isChecked() ? "2"
                : "-1");
        json.put("W60102", bi.W60102.getText().toString().trim().isEmpty() ? "-1" : bi.W60102.getText().toString().trim());
        json.put("W60103", bi.W6010301.isChecked() ? "1"
                : bi.W6010302.isChecked() ? "2"
                : bi.W6010303.isChecked() ? "3"
                : "-1");

        json.put("W602", bi.W602.getText().toString().trim().isEmpty() ? "-1" : bi.W602.getText().toString().trim());

        json.put("W60301", bi.W6030101.isChecked() ? "1"
                : bi.W6030102.isChecked() ? "2"
                : "-1");
        json.put("W60302", bi.W60302.getText().toString().trim().isEmpty() ? "-1" : bi.W60302.getText().toString().trim());
        json.put("W60303", bi.W6030301.isChecked() ? "1"
                : bi.W6030302.isChecked() ? "2"
                : bi.W6030303.isChecked() ? "3"
                : "-1");

        json.put("W60401", bi.W6040101.isChecked() ? "1"
                : bi.W6040102.isChecked() ? "2"
                : "-1");
        json.put("W60402", bi.W60402.getText().toString().trim().isEmpty() ? "-1" : bi.W60402.getText().toString().trim());
        json.put("W60403", bi.W6040301.isChecked() ? "1"
                : bi.W6040302.isChecked() ? "2"
                : bi.W6040303.isChecked() ? "3"
                : "-1");

        json.put("W60501", bi.W6050101.isChecked() ? "1"
                : bi.W6050102.isChecked() ? "2"
                : "-1");
        json.put("W60502", bi.W60502.getText().toString().trim().isEmpty() ? "-1" : bi.W60502.getText().toString().trim());
        json.put("W60503", bi.W6050301.isChecked() ? "1"
                : bi.W6050302.isChecked() ? "2"
                : bi.W6050303.isChecked() ? "3"
                : "-1");

        json.put("W60601", bi.W6060101.isChecked() ? "1"
                : bi.W6060102.isChecked() ? "2"
                : "-1");
        json.put("W60602", bi.W60602.getText().toString().trim().isEmpty() ? "-1" : bi.W60602.getText().toString().trim());
        json.put("W60603", bi.W6060301.isChecked() ? "1"
                : bi.W6060302.isChecked() ? "2"
                : bi.W6060303.isChecked() ? "3"
                : "-1");

        json.put("W60701", bi.W6070101.isChecked() ? "1"
                : bi.W6070102.isChecked() ? "2"
                : "-1");
        json.put("W6070101x", bi.W6070101x.getText().toString().trim().isEmpty() ? "-1" : bi.W6070101x.getText().toString().trim());
        json.put("W60702", bi.W60702.getText().toString().trim().isEmpty() ? "-1" : bi.W60702.getText().toString().trim());
        json.put("W60703", bi.W6070301.isChecked() ? "1"
                : bi.W6070302.isChecked() ? "2"
                : bi.W6070303.isChecked() ? "3"
                : "-1");

        json.put("W608", bi.W608.getText().toString().trim().isEmpty() ? "-1" : bi.W608.getText().toString().trim());

        json.put("W609", bi.W609.getText().toString().trim().isEmpty() ? "-1" : bi.W609.getText().toString().trim());

        json.put("W610", bi.W610.getText().toString().trim().isEmpty() ? "-1" : bi.W610.getText().toString().trim());

        try {
            JSONObject json_merged = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.mwra.getJSON()), json);
            MainApp.mwra.setJSON(String.valueOf(json_merged));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }

}