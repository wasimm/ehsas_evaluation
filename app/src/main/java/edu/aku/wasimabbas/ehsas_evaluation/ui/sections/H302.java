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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH302Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class H302 extends AppCompatActivity {

    ActivityH302Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h302);
        bi.setCallback(this);
        setupSkip();

        Toast.makeText(this, "H302: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
    }

    private void setupSkip() {

        //H314
        bi.H314.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H31402.getId() || checkedId == bi.H31403.getId() || checkedId == bi.H31496.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH315);
                bi.fldGrpCVH315.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH315.setVisibility(View.VISIBLE);
            }
        });

        //H320
        bi.H320.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H32002.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH321);
                bi.fldGrpCVH321.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH321.setVisibility(View.VISIBLE);
            }
        });

        //H322
        bi.H322.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H32202.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH323);
                bi.fldGrpCVH323.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH323.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, H4.class));
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

        json.put("H31201", bi.H3120101.isChecked() ? "1"
                : bi.H3120102.isChecked() ? "2"
                : "-1");

        json.put("H31202", bi.H3120201.isChecked() ? "1"
                : bi.H3120202.isChecked() ? "2"
                : "-1");

        json.put("H31203", bi.H3120301.isChecked() ? "1"
                : bi.H3120302.isChecked() ? "2"
                : "-1");

        json.put("H31204", bi.H3120401.isChecked() ? "1"
                : bi.H3120402.isChecked() ? "2"
                : "-1");

        json.put("H31205", bi.H3120501.isChecked() ? "1"
                : bi.H3120502.isChecked() ? "2"
                : "-1");

        json.put("H31206", bi.H3120601.isChecked() ? "1"
                : bi.H3120602.isChecked() ? "2"
                : "-1");

        json.put("H31207", bi.H3120701.isChecked() ? "1"
                : bi.H3120702.isChecked() ? "2"
                : "-1");

        json.put("H313", bi.H31301.isChecked() ? "1"
                : bi.H31302.isChecked() ? "2"
                : bi.H31303.isChecked() ? "3"
                : bi.H31304.isChecked() ? "4"
                : bi.H31305.isChecked() ? "5"
                : bi.H31306.isChecked() ? "6"
                : bi.H31307.isChecked() ? "7"
                : bi.H31308.isChecked() ? "8"
                : bi.H31309.isChecked() ? "9"
                : bi.H31310.isChecked() ? "10"
                : bi.H31311.isChecked() ? "11"
                : bi.H31396.isChecked() ? "96"
                : "-1");
        json.put("H31396x", bi.H31396x.getText().toString().trim().isEmpty() ? "-1" : bi.H31396x.getText().toString().trim());

        json.put("H314", bi.H31401.isChecked() ? "1"
                : bi.H31402.isChecked() ? "2"
                : bi.H31403.isChecked() ? "3"
                : bi.H31496.isChecked() ? "96"
                : "-1");
        json.put("H31496x", bi.H31496x.getText().toString().trim().isEmpty() ? "-1" : bi.H31496x.getText().toString().trim());

        json.put("H315", bi.H31501.isChecked() ? "1"
                : bi.H31502.isChecked() ? "2"
                : "-1");

        json.put("H316", bi.H31611.isChecked() ? "11"
                : bi.H31612.isChecked() ? "12"
                : bi.H31621.isChecked() ? "21"
                : bi.H31622.isChecked() ? "22"
                : bi.H31631.isChecked() ? "31"
                : bi.H31632.isChecked() ? "32"
                : bi.H31633.isChecked() ? "33"
                : bi.H31634.isChecked() ? "34"
                : bi.H31635.isChecked() ? "35"
                : bi.H31636.isChecked() ? "36"
                : bi.H31637.isChecked() ? "37"
                : bi.H31696.isChecked() ? "96"
                : "-1");
        json.put("H31696x", bi.H31696x.getText().toString().trim().isEmpty() ? "-1" : bi.H31696x.getText().toString().trim());

        json.put("H317", bi.H31711.isChecked() ? "11"
                : bi.H31712.isChecked() ? "12"
                : bi.H31713.isChecked() ? "13"
                : bi.H31721.isChecked() ? "21"
                : bi.H31722.isChecked() ? "22"
                : bi.H31723.isChecked() ? "23"
                : bi.H31724.isChecked() ? "24"
                : bi.H31731.isChecked() ? "31"
                : bi.H31732.isChecked() ? "32"
                : bi.H31733.isChecked() ? "33"
                : bi.H31734.isChecked() ? "34"
                : bi.H31735.isChecked() ? "35"
                : bi.H31736.isChecked() ? "36"
                : bi.H31737.isChecked() ? "37"
                : bi.H31796.isChecked() ? "96"
                : "-1");
        json.put("H31796x", bi.H31796x.getText().toString().trim().isEmpty() ? "-1" : bi.H31796x.getText().toString().trim());

        json.put("H318", bi.H31811.isChecked() ? "11"
                : bi.H31812.isChecked() ? "12"
                : bi.H31813.isChecked() ? "13"
                : bi.H31821.isChecked() ? "21"
                : bi.H31822.isChecked() ? "22"
                : bi.H31823.isChecked() ? "23"
                : bi.H31824.isChecked() ? "24"
                : bi.H31825.isChecked() ? "25"
                : bi.H31826.isChecked() ? "26"
                : bi.H31827.isChecked() ? "27"
                : bi.H31831.isChecked() ? "31"
                : bi.H31832.isChecked() ? "32"
                : bi.H31833.isChecked() ? "33"
                : bi.H31834.isChecked() ? "34"
                : bi.H31835.isChecked() ? "35"
                : bi.H31836.isChecked() ? "36"
                : bi.H31896.isChecked() ? "96"
                : "-1");
        json.put("H31896x", bi.H31896x.getText().toString().trim().isEmpty() ? "-1" : bi.H31896x.getText().toString().trim());

        json.put("H319", bi.H319.getText().toString().trim().isEmpty() ? "-1" : bi.H319.getText().toString().trim());

        json.put("H320", bi.H32001.isChecked() ? "1"
                : bi.H32002.isChecked() ? "2"
                : "-1");

        json.put("H32101", bi.H32101.getText().toString().trim().isEmpty() ? "-1" : bi.H32101.getText().toString().trim());
        json.put("H32102", bi.H32102.getText().toString().trim().isEmpty() ? "-1" : bi.H32102.getText().toString().trim());
        json.put("H32198", bi.H32198.isChecked() ? "1" : "-1");

        json.put("H322", bi.H32201.isChecked() ? "1"
                : bi.H32202.isChecked() ? "2"
                : "-1");

        json.put("H32301", bi.H32301.getText().toString().trim().isEmpty() ? "-1" : bi.H32301.getText().toString().trim());
        json.put("H32302", bi.H32302.getText().toString().trim().isEmpty() ? "-1" : bi.H32302.getText().toString().trim());
        json.put("H32303", bi.H32303.getText().toString().trim().isEmpty() ? "-1" : bi.H32303.getText().toString().trim());
        json.put("H32304", bi.H32304.getText().toString().trim().isEmpty() ? "-1" : bi.H32304.getText().toString().trim());
        json.put("H32305", bi.H32305.getText().toString().trim().isEmpty() ? "-1" : bi.H32305.getText().toString().trim());
        json.put("H32306", bi.H32306.getText().toString().trim().isEmpty() ? "-1" : bi.H32306.getText().toString().trim());

        try {
            JSONObject json_merged = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.form.getJSON()), json);
            MainApp.form.setJSON(String.valueOf(json_merged));
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