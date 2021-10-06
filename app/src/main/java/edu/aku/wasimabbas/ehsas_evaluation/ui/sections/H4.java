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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH4Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class H4 extends AppCompatActivity {

    /*private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };
    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};
    */

    ActivityH4Binding bi;
    Intent oF = null;
    String SectionBActivity;
    private DatabaseHelper db;
    private String semisCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h4);
        bi.setCallback(this);
        setupSkip();
    }

    private void setupSkip() {

        //H401
        bi.H401.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H40102.getId() || checkedId == bi.H40103.getId() || checkedId == bi.H40104.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH402);
                bi.fldGrpCVH402.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH403);
                bi.fldGrpCVH403.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH402.setVisibility(View.VISIBLE);
                bi.fldGrpCVH403.setVisibility(View.VISIBLE);
            }
        });

        //H404
        bi.H404.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H40402.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH405);
                bi.fldGrpCVH405.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH405.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, H5.class));
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

        json.put("H401", bi.H40101.isChecked() ? "1"
                : bi.H40102.isChecked() ? "2"
                : bi.H40103.isChecked() ? "3"
                : bi.H40104.isChecked() ? "4"
                : "-1");

        json.put("H402", bi.H40201.isChecked() ? "1"
                : bi.H40202.isChecked() ? "2"
                : "-1");

        json.put("H403", bi.H40301.isChecked() ? "1"
                : bi.H40302.isChecked() ? "2"
                : bi.H40303.isChecked() ? "3"
                : bi.H40304.isChecked() ? "4"
                : bi.H40305.isChecked() ? "5"
                : "-1");

        json.put("H404", bi.H40401.isChecked() ? "1"
                : bi.H40402.isChecked() ? "2"
                : "-1");

        json.put("H405", bi.H40501.isChecked() ? "1"
                : bi.H40502.isChecked() ? "2"
                : bi.H40503.isChecked() ? "3"
                : bi.H40504.isChecked() ? "4"
                : bi.H40505.isChecked() ? "5"
                : "-1");

        json.put("H406", bi.H40601.isChecked() ? "1"
                : bi.H40602.isChecked() ? "2"
                : bi.H40603.isChecked() ? "3"
                : bi.H40604.isChecked() ? "4"
                : bi.H40605.isChecked() ? "5"
                : bi.H40606.isChecked() ? "6"
                : bi.H40607.isChecked() ? "7"
                : bi.H40608.isChecked() ? "8"
                : bi.H40609.isChecked() ? "9"
                : bi.H40696.isChecked() ? "96"
                : "-1");

        json.put("H40696x", bi.H40696x.getText().toString().trim().isEmpty() ? "-1" : bi.H40696x.getText().toString().trim());

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