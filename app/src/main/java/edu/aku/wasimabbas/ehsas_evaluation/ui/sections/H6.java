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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH6Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class H6 extends AppCompatActivity {

    ActivityH6Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h6);
        bi.setCallback(this);
        setupSkip();

        Toast.makeText(this, "H6: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
    }

    private void setupSkip() {

        //H612
        bi.H612.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H61201.getId()) {
                bi.fldGrpCVH613.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH613);
                bi.fldGrpCVH613.setVisibility(View.GONE);
            }
        });

        //H616
        bi.H616.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H61601.getId()) {
                bi.fldGrpCVH617.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH617);
                bi.fldGrpCVH617.setVisibility(View.GONE);
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
            startActivity(new Intent(this, MWRAsList.class));
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

        json.put("H601", bi.H601.getText().toString().trim().isEmpty() ? "-1" : bi.H601.getText().toString().trim());

        json.put("H602", bi.H602.getText().toString().trim().isEmpty() ? "-1" : bi.H602.getText().toString().trim());

        json.put("H603", bi.H60301.isChecked() ? "1"
                : bi.H60302.isChecked() ? "2"
                : bi.H60303.isChecked() ? "3"
                : bi.H60304.isChecked() ? "4"
                : bi.H60396.isChecked() ? "96"
                : "-1");
        json.put("H60396x", bi.H60396x.getText().toString().trim().isEmpty() ? "-1" : bi.H60396x.getText().toString().trim());

        json.put("H604", bi.H604.getText().toString().trim().isEmpty() ? "-1" : bi.H604.getText().toString().trim());


        json.put("H605", bi.H60501.isChecked() ? "1"
                : bi.H60502.isChecked() ? "2"
                : bi.H60596.isChecked() ? "96"
                : "-1");
        json.put("H60596x", bi.H60596x.getText().toString().trim().isEmpty() ? "-1" : bi.H60596x.getText().toString().trim());

        json.put("H606", bi.H60601.isChecked() ? "1"
                : bi.H60602.isChecked() ? "2"
                : "-1");

        json.put("H607", bi.H607.getText().toString().trim().isEmpty() ? "-1" : bi.H607.getText().toString().trim());

        json.put("H608", bi.H608.getText().toString().trim().isEmpty() ? "-1" : bi.H608.getText().toString().trim());

        json.put("H609", bi.H60901.isChecked() ? "1"
                : bi.H60902.isChecked() ? "2"
                : bi.H60903.isChecked() ? "3"
                : bi.H60904.isChecked() ? "4"
                : bi.H60996.isChecked() ? "96"
                : "-1");
        json.put("H60996x", bi.H60996x.getText().toString().trim().isEmpty() ? "-1" : bi.H60996x.getText().toString().trim());

        json.put("H610", bi.H61001.isChecked() ? "1"
                : bi.H61002.isChecked() ? "2"
                : bi.H61003.isChecked() ? "3"
                : bi.H61004.isChecked() ? "4"
                : bi.H61096.isChecked() ? "96"
                : "-1");
        json.put("H61096x", bi.H61096x.getText().toString().trim().isEmpty() ? "-1" : bi.H61096x.getText().toString().trim());

        json.put("H611", bi.H61101.isChecked() ? "1"
                : bi.H61102.isChecked() ? "2"
                : bi.H61103.isChecked() ? "3"
                : bi.H61104.isChecked() ? "4"
                : bi.H61196.isChecked() ? "96"
                : "-1");
        json.put("H61196x", bi.H61196x.getText().toString().trim().isEmpty() ? "-1" : bi.H61196x.getText().toString().trim());


        json.put("H612", bi.H61201.isChecked() ? "1"
                : bi.H61202.isChecked() ? "2"
                : bi.H61203.isChecked() ? "3"
                : "-1");

        json.put("H613", bi.H613.getText().toString().trim().isEmpty() ? "-1" : bi.H613.getText().toString().trim());

        json.put("H614", bi.H614.getText().toString().trim().isEmpty() ? "-1" : bi.H614.getText().toString().trim());

        json.put("H615", bi.H61501.isChecked() ? "1"
                : bi.H61502.isChecked() ? "2"
                : bi.H61503.isChecked() ? "3"
                : bi.H61504.isChecked() ? "4"
                : bi.H61596.isChecked() ? "96"
                : "-1");
        json.put("H61596x", bi.H61596x.getText().toString().trim().isEmpty() ? "-1" : bi.H61596x.getText().toString().trim());

        json.put("H616", bi.H61601.isChecked() ? "1"
                : bi.H61602.isChecked() ? "2"
                : "-1");

        json.put("H617", bi.H617.getText().toString().trim().isEmpty() ? "-1" : bi.H617.getText().toString().trim());

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