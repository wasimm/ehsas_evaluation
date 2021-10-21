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

        //H606
        bi.H606.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H60601.getId() || idChecked == bi.H60602.getId() || idChecked == bi.H60696.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH607);
                bi.fldGrpCVH607.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH607.setVisibility(View.VISIBLE);
            }
        });


        //H61201
        bi.H61201.setOnCheckedChangeListener((group, isChecked) -> {
            if (isChecked) {
                bi.fldGrpCVH613.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH613);
                bi.fldGrpCVH613.setVisibility(View.GONE);
            }
        });

        //H617
        bi.H617.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H61701.getId()) {
                bi.fldGrpCVH618.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH618);
                bi.fldGrpCVH618.setVisibility(View.GONE);
            }
        });

        //H619
        bi.H619.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H61902.getId()) {

                Clear.clearAllFields(bi.fldGrpCVH620);
                Clear.clearAllFields(bi.fldGrpCVH621);
                Clear.clearAllFields(bi.fldGrpCVH622);
                Clear.clearAllFields(bi.fldGrpCVH623);
                Clear.clearAllFields(bi.fldGrpCVH624);
                Clear.clearAllFields(bi.fldGrpCVH625);
                Clear.clearAllFields(bi.fldGrpCVH626);
                Clear.clearAllFields(bi.fldGrpCVH627);
                Clear.clearAllFields(bi.fldGrpCVH628);
                Clear.clearAllFields(bi.fldGrpCVH629);
                Clear.clearAllFields(bi.fldGrpCVH630);
                Clear.clearAllFields(bi.fldGrpCVH631);
                Clear.clearAllFields(bi.fldGrpCVH632);
                Clear.clearAllFields(bi.fldGrpCVH633);
                Clear.clearAllFields(bi.fldGrpCVH634);
                Clear.clearAllFields(bi.fldGrpCVH635);
                Clear.clearAllFields(bi.fldGrpCVH636);
                Clear.clearAllFields(bi.fldGrpCVH637);
                Clear.clearAllFields(bi.fldGrpCVH638);

                bi.fldGrpCVH620.setVisibility(View.GONE);
                bi.fldGrpCVH621.setVisibility(View.GONE);
                bi.fldGrpCVH622.setVisibility(View.GONE);
                bi.fldGrpCVH623.setVisibility(View.GONE);
                bi.fldGrpCVH624.setVisibility(View.GONE);
                bi.fldGrpCVH625.setVisibility(View.GONE);
                bi.fldGrpCVH626.setVisibility(View.GONE);
                bi.fldGrpCVH627.setVisibility(View.GONE);
                bi.fldGrpCVH628.setVisibility(View.GONE);
                bi.fldGrpCVH629.setVisibility(View.GONE);
                bi.fldGrpCVH630.setVisibility(View.GONE);
                bi.fldGrpCVH631.setVisibility(View.GONE);
                bi.fldGrpCVH632.setVisibility(View.GONE);
                bi.fldGrpCVH633.setVisibility(View.GONE);
                bi.fldGrpCVH634.setVisibility(View.GONE);
                bi.fldGrpCVH635.setVisibility(View.GONE);
                bi.fldGrpCVH636.setVisibility(View.GONE);
                bi.fldGrpCVH637.setVisibility(View.GONE);
                bi.fldGrpCVH638.setVisibility(View.GONE);

            } else {
                bi.fldGrpCVH620.setVisibility(View.VISIBLE);
                bi.fldGrpCVH621.setVisibility(View.VISIBLE);
                bi.fldGrpCVH622.setVisibility(View.VISIBLE);
                bi.fldGrpCVH623.setVisibility(View.VISIBLE);
                bi.fldGrpCVH624.setVisibility(View.VISIBLE);
                bi.fldGrpCVH625.setVisibility(View.VISIBLE);
                bi.fldGrpCVH626.setVisibility(View.VISIBLE);
                bi.fldGrpCVH627.setVisibility(View.VISIBLE);
                bi.fldGrpCVH628.setVisibility(View.VISIBLE);
                bi.fldGrpCVH629.setVisibility(View.VISIBLE);
                bi.fldGrpCVH630.setVisibility(View.VISIBLE);
                bi.fldGrpCVH631.setVisibility(View.VISIBLE);
                bi.fldGrpCVH632.setVisibility(View.VISIBLE);
                bi.fldGrpCVH633.setVisibility(View.VISIBLE);
                bi.fldGrpCVH634.setVisibility(View.VISIBLE);
                bi.fldGrpCVH635.setVisibility(View.VISIBLE);
                bi.fldGrpCVH636.setVisibility(View.VISIBLE);
                bi.fldGrpCVH637.setVisibility(View.VISIBLE);
                bi.fldGrpCVH638.setVisibility(View.VISIBLE);
            }
        });

        //H626
        bi.H626.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H62601.getId() || idChecked == bi.H62602.getId() || idChecked == bi.H62696.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH627);
                bi.fldGrpCVH627.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH627.setVisibility(View.VISIBLE);
            }
        });

        //H632
        bi.H632.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H63201.getId()) {
                bi.fldGrpCVH633.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH633);
                bi.fldGrpCVH633.setVisibility(View.GONE);
            }
        });

        //H637
        bi.H637.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H63701.getId()) {
                bi.fldGrpCVH638.setVisibility(View.VISIBLE);
                Clear.clearAllFields(bi.fldGrpCVH639);
                Clear.clearAllFields(bi.fldGrpCVH640);
                bi.fldGrpCVH639.setVisibility(View.GONE);
                bi.fldGrpCVH640.setVisibility(View.GONE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH638);
                Clear.clearAllFields(bi.fldGrpCVH639);
                Clear.clearAllFields(bi.fldGrpCVH640);
                bi.fldGrpCVH638.setVisibility(View.GONE);
                bi.fldGrpCVH639.setVisibility(View.GONE);
                bi.fldGrpCVH640.setVisibility(View.GONE);
            }
        });

        //H639
        bi.H639.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H63901.getId()) {
                bi.fldGrpCVH640.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH640);
                bi.fldGrpCVH640.setVisibility(View.GONE);
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

        json.put("H601", bi.H601.getText().toString().trim().isEmpty() ? "-1" : bi.H601.getText().toString().trim());

        json.put("H602", bi.H60201.isChecked() ? "1"
                : bi.H60202.isChecked() ? "2"
                : "-1");

        json.put("H603", bi.H603.getText().toString().trim().isEmpty() ? "-1" : bi.H603.getText().toString().trim());

        json.put("H604", bi.H604.getText().toString().trim().isEmpty() ? "-1" : bi.H604.getText().toString().trim());

        json.put("H605", bi.H605.getText().toString().trim().isEmpty() ? "-1" : bi.H605.getText().toString().trim());

        json.put("H606", bi.H60601.isChecked() ? "1"
                : bi.H60602.isChecked() ? "2"
                : bi.H60603.isChecked() ? "3"
                : bi.H60604.isChecked() ? "4"
                : bi.H60696.isChecked() ? "96"
                : "-1");
        json.put("H60696x", bi.H60696x.getText().toString().trim().isEmpty() ? "-1" : bi.H60696x.getText().toString().trim());

        json.put("H607", bi.H607.getText().toString().trim().isEmpty() ? "-1" : bi.H607.getText().toString().trim());

        json.put("H608", bi.H60801.isChecked() ? "1"
                : bi.H60802.isChecked() ? "2"
                : bi.H60803.isChecked() ? "3"
                : bi.H60804.isChecked() ? "4"
                : bi.H60805.isChecked() ? "5"
                : bi.H60896.isChecked() ? "96"
                : "-1");
        json.put("H60896x", bi.H60896x.getText().toString().trim().isEmpty() ? "-1" : bi.H60896x.getText().toString().trim());

        json.put("H609", bi.H60901.isChecked() ? "1"
                : bi.H60902.isChecked() ? "2"
                : "-1");

        json.put("H610", bi.H61001.isChecked() ? "1"
                : bi.H61002.isChecked() ? "2"
                : bi.H61003.isChecked() ? "3"
                : bi.H61004.isChecked() ? "4"
                : bi.H61005.isChecked() ? "5"
                : bi.H61096.isChecked() ? "96"
                : "-1");
        json.put("H61096x", bi.H61096x.getText().toString().trim().isEmpty() ? "-1" : bi.H61096x.getText().toString().trim());

        json.put("H611", bi.H61101.isChecked() ? "1"
                : bi.H61102.isChecked() ? "2"
                : bi.H61103.isChecked() ? "3"
                : bi.H61104.isChecked() ? "4"
                : bi.H61105.isChecked() ? "5"
                : bi.H61196.isChecked() ? "96"
                : "-1");
        json.put("H61196x", bi.H61196x.getText().toString().trim().isEmpty() ? "-1" : bi.H61196x.getText().toString().trim());

        json.put("H612", bi.H61201.isChecked() ? "1"
                : bi.H61202.isChecked() ? "2"
                : bi.H61203.isChecked() ? "3"
                : bi.H61204.isChecked() ? "4"
                : bi.H61296.isChecked() ? "96"
                : "-1");
        json.put("H61296x", bi.H61296x.getText().toString().trim().isEmpty() ? "-1" : bi.H61296x.getText().toString().trim());

        json.put("H613", bi.H613.getText().toString().trim().isEmpty() ? "-1" : bi.H613.getText().toString().trim());

        json.put("H614", bi.H614.getText().toString().trim().isEmpty() ? "-1" : bi.H614.getText().toString().trim());


        json.put("H61598", bi.H61598.isChecked() ? "1" : "-1");
        json.put("H61501", bi.H61501.getText().toString().trim().isEmpty() ? "-1" : bi.H61501.getText().toString().trim());
        json.put("H61502", bi.H61502.getText().toString().trim().isEmpty() ? "-1" : bi.H61502.getText().toString().trim());

        json.put("H616", bi.H61601.isChecked() ? "1"
                : bi.H61602.isChecked() ? "2"
                : bi.H61603.isChecked() ? "3"
                : bi.H61604.isChecked() ? "4"
                : bi.H61696.isChecked() ? "96"
                : "-1");
        json.put("H61696x", bi.H61696x.getText().toString().trim().isEmpty() ? "-1" : bi.H61696x.getText().toString().trim());

        json.put("H617", bi.H61701.isChecked() ? "1"
                : bi.H61702.isChecked() ? "2"
                : "-1");

        json.put("H618", bi.H618.getText().toString().trim().isEmpty() ? "-1" : bi.H618.getText().toString().trim());

        json.put("H619", bi.H61901.isChecked() ? "1"
                : bi.H61902.isChecked() ? "2"
                : "-1");

        json.put("H620", bi.H62001.isChecked() ? "1"
                : bi.H62002.isChecked() ? "2"
                : bi.H62003.isChecked() ? "3"
                : bi.H62096.isChecked() ? "96"
                : "-1");
        json.put("H62096x", bi.H62096x.getText().toString().trim().isEmpty() ? "-1" : bi.H62096x.getText().toString().trim());

        json.put("H621", bi.H621.getText().toString().trim().isEmpty() ? "-1" : bi.H621.getText().toString().trim());

        json.put("H622", bi.H62201.isChecked() ? "1"
                : bi.H62202.isChecked() ? "2"
                : "-1");

        json.put("H623", bi.H62301.isChecked() ? "1"
                : bi.H62302.isChecked() ? "2"
                : "-1");

        json.put("H624", bi.H624.getText().toString().trim().isEmpty() ? "-1" : bi.H624.getText().toString().trim());

        json.put("H625", bi.H625.getText().toString().trim().isEmpty() ? "-1" : bi.H625.getText().toString().trim());

        json.put("H626", bi.H62601.isChecked() ? "1"
                : bi.H62602.isChecked() ? "2"
                : bi.H62603.isChecked() ? "3"
                : bi.H62604.isChecked() ? "4"
                : bi.H62696.isChecked() ? "96"
                : "-1");
        json.put("H62696x", bi.H62696x.getText().toString().trim().isEmpty() ? "-1" : bi.H62696x.getText().toString().trim());

        json.put("H627", bi.H627.getText().toString().trim().isEmpty() ? "-1" : bi.H627.getText().toString().trim());

        json.put("H628", bi.H62801.isChecked() ? "1"
                : bi.H62802.isChecked() ? "2"
                : bi.H62803.isChecked() ? "3"
                : bi.H62804.isChecked() ? "4"
                : bi.H62805.isChecked() ? "5"
                : bi.H62896.isChecked() ? "96"
                : "-1");
        json.put("H62896x", bi.H62896x.getText().toString().trim().isEmpty() ? "-1" : bi.H62896x.getText().toString().trim());

        json.put("H629", bi.H62901.isChecked() ? "1"
                : bi.H62902.isChecked() ? "2"
                : "-1");

        json.put("H630", bi.H63001.isChecked() ? "1"
                : bi.H63002.isChecked() ? "2"
                : bi.H63003.isChecked() ? "3"
                : bi.H63004.isChecked() ? "4"
                : bi.H63005.isChecked() ? "5"
                : bi.H63096.isChecked() ? "96"
                : "-1");
        json.put("H63096x", bi.H63096x.getText().toString().trim().isEmpty() ? "-1" : bi.H63096x.getText().toString().trim());

        json.put("H631", bi.H63101.isChecked() ? "1"
                : bi.H63102.isChecked() ? "2"
                : bi.H63103.isChecked() ? "3"
                : bi.H63104.isChecked() ? "4"
                : bi.H63105.isChecked() ? "5"
                : bi.H63196.isChecked() ? "96"
                : "-1");
        json.put("H63196x", bi.H63196x.getText().toString().trim().isEmpty() ? "-1" : bi.H63196x.getText().toString().trim());

        json.put("H632", bi.H63201.isChecked() ? "1"
                : bi.H63202.isChecked() ? "2"
                : bi.H63203.isChecked() ? "3"
                : bi.H63204.isChecked() ? "4"
                : bi.H63296.isChecked() ? "96"
                : "-1");
        json.put("H63296x", bi.H63296x.getText().toString().trim().isEmpty() ? "-1" : bi.H63296x.getText().toString().trim());

        json.put("H633", bi.H633.getText().toString().trim().isEmpty() ? "-1" : bi.H633.getText().toString().trim());

        json.put("H634", bi.H634.getText().toString().trim().isEmpty() ? "-1" : bi.H634.getText().toString().trim());

        json.put("H63598", bi.H63598.isChecked() ? "1" : "-1");
        json.put("H63501", bi.H63501.getText().toString().trim().isEmpty() ? "-1" : bi.H63501.getText().toString().trim());
        json.put("H63502", bi.H63502.getText().toString().trim().isEmpty() ? "-1" : bi.H63502.getText().toString().trim());

        json.put("H636", bi.H63601.isChecked() ? "1"
                : bi.H63602.isChecked() ? "2"
                : bi.H63603.isChecked() ? "3"
                : bi.H63604.isChecked() ? "4"
                : bi.H63696.isChecked() ? "96"
                : "-1");
        json.put("H63696x", bi.H63696x.getText().toString().trim().isEmpty() ? "-1" : bi.H63696x.getText().toString().trim());

        json.put("H637", bi.H63701.isChecked() ? "1"
                : bi.H63702.isChecked() ? "2"
                : "-1");

        json.put("H638", bi.H638.getText().toString().trim().isEmpty() ? "-1" : bi.H638.getText().toString().trim());

        json.put("H639", bi.H63901.isChecked() ? "1"
                : bi.H63902.isChecked() ? "2"
                : "-1");

        json.put("H640", bi.H640.getText().toString().trim().isEmpty() ? "-1" : bi.H640.getText().toString().trim());

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