package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
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
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class H4 extends AppCompatActivity {

    ActivityH4Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h4);
        bi.setCallback(this);
        setupSkip();

        Toast.makeText(this, "H4: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
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

        //H40305
        bi.H40305.setOnCheckedChangeListener((group, isChecked) -> {
            if (isChecked) {

                bi.H40301.setChecked(false);
                bi.H40302.setChecked(false);
                bi.H40303.setChecked(false);
                bi.H40304.setChecked(false);

                bi.H40301.setEnabled(false);
                bi.H40302.setEnabled(false);
                bi.H40303.setEnabled(false);
                bi.H40304.setEnabled(false);

            } else {

                bi.H40301.setEnabled(true);
                bi.H40302.setEnabled(true);
                bi.H40303.setEnabled(true);
                bi.H40304.setEnabled(true);
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

        //H40505
        bi.H40505.setOnCheckedChangeListener((group, isChecked) -> {
            if (isChecked) {

                bi.H40501.setChecked(false);
                bi.H40502.setChecked(false);
                bi.H40503.setChecked(false);
                bi.H40504.setChecked(false);

                bi.H40501.setEnabled(false);
                bi.H40502.setEnabled(false);
                bi.H40503.setEnabled(false);
                bi.H40504.setEnabled(false);

            } else {

                bi.H40501.setEnabled(true);
                bi.H40502.setEnabled(true);
                bi.H40503.setEnabled(true);
                bi.H40504.setEnabled(true);
            }
        });

        //H40696
        bi.H40696x.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start, int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if (cs.equals("")) { // for backspace
                            return cs;
                        }
                        if (cs.toString().matches("[a-zA-Z ]+")) {
                            return cs;
                        }
                        return "";
                    }
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

        json.put("H401", bi.H40101.isChecked() ? "1"
                : bi.H40102.isChecked() ? "2"
                : bi.H40103.isChecked() ? "3"
                : bi.H40104.isChecked() ? "4"
                : "-1");

        json.put("H402", bi.H40201.isChecked() ? "1"
                : bi.H40202.isChecked() ? "2"
                : "-1");

        json.put("H40301", bi.H40301.isChecked() ? "1" : "-1");
        json.put("H40302", bi.H40302.isChecked() ? "2" : "-1");
        json.put("H40303", bi.H40303.isChecked() ? "3" : "-1");
        json.put("H40304", bi.H40304.isChecked() ? "4" : "-1");
        json.put("H40305", bi.H40305.isChecked() ? "5" : "-1");

        json.put("H404", bi.H40401.isChecked() ? "1"
                : bi.H40402.isChecked() ? "2"
                : "-1");

        json.put("H40501", bi.H40501.isChecked() ? "1" : "-1");
        json.put("H40502", bi.H40502.isChecked() ? "2" : "-1");
        json.put("H40503", bi.H40503.isChecked() ? "3" : "-1");
        json.put("H40504", bi.H40504.isChecked() ? "4" : "-1");
        json.put("H40505", bi.H40505.isChecked() ? "5" : "-1");

        json.put("H40601", bi.H40601.isChecked() ? "1" : "-1");
        json.put("H40602", bi.H40602.isChecked() ? "2" : "-1");
        json.put("H40603", bi.H40603.isChecked() ? "3" : "-1");
        json.put("H40604", bi.H40604.isChecked() ? "4" : "-1");
        json.put("H40605", bi.H40605.isChecked() ? "5" : "-1");
        json.put("H40606", bi.H40606.isChecked() ? "6" : "-1");
        json.put("H40607", bi.H40607.isChecked() ? "7" : "-1");
        json.put("H40608", bi.H40608.isChecked() ? "8" : "-1");
        json.put("H40609", bi.H40609.isChecked() ? "9" : "-1");
        json.put("H40696", bi.H40696.isChecked() ? "96" : "-1");
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