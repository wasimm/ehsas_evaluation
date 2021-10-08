package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityD2Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class D2 extends AppCompatActivity {

    ActivityD2Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_d2);
        bi.setCallback(this);
        setupSkip();

        Toast.makeText(this, "D2: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
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
            startActivity(new Intent(this, E1.class));
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

        json.put("D201", bi.D201.getText().toString().trim().isEmpty() ? "-1" : bi.D201.getText().toString().trim());

        json.put("D202", bi.D20201.isChecked() ? "1"
                : bi.D20202.isChecked() ? "2"
                : bi.D20203.isChecked() ? "3"
                : bi.D20204.isChecked() ? "4"
                : bi.D20205.isChecked() ? "5"
                : bi.D20296.isChecked() ? "96"
                : "-1");
        json.put("D20296x", bi.D20296x.getText().toString().trim().isEmpty() ? "-1" : bi.D20296x.getText().toString().trim());

        json.put("D202a", bi.D202a01.isChecked() ? "1"
                : bi.D202a02.isChecked() ? "2"
                : bi.D202a03.isChecked() ? "3"
                : "-1");

        json.put("D203", bi.D20301.isChecked() ? "1"
                : bi.D20302.isChecked() ? "2"
                : "-1");

        json.put("D203a", bi.D203a01.isChecked() ? "1"
                : bi.D203a02.isChecked() ? "2"
                : bi.D203a03.isChecked() ? "3"
                : "-1");

        json.put("D204", bi.D20401.isChecked() ? "1"
                : bi.D20402.isChecked() ? "2"
                : "-1");

        json.put("D205", bi.D20501.isChecked() ? "1"
                : bi.D20502.isChecked() ? "2"
                : "-1");

        json.put("D206", bi.D20601.isChecked() ? "1"
                : bi.D20602.isChecked() ? "2"
                : bi.D20603.isChecked() ? "3"
                : bi.D20604.isChecked() ? "4"
                : bi.D20605.isChecked() ? "5"
                : bi.D20696.isChecked() ? "96"
                : "-1");

        json.put("D206a", bi.D206a01.isChecked() ? "1"
                : bi.D206a02.isChecked() ? "2"
                : bi.D206a03.isChecked() ? "3"
                : "-1");

        json.put("D207", bi.D207.getText().toString().trim().isEmpty() ? "-1" : bi.D207.getText().toString().trim());

        json.put("D208", bi.D208.getText().toString().trim().isEmpty() ? "-1" : bi.D208.getText().toString().trim());

        json.put("D209", bi.D209.getText().toString().trim().isEmpty() ? "-1" : bi.D209.getText().toString().trim());

        json.put("D210", bi.D210.getText().toString().trim().isEmpty() ? "-1" : bi.D210.getText().toString().trim());

        json.put("D211", bi.D211.getText().toString().trim().isEmpty() ? "-1" : bi.D211.getText().toString().trim());


        json.put("D212", bi.D21201.isChecked() ? "1"
                : bi.D21202.isChecked() ? "2"
                : "-1");

        json.put("D213", bi.D21301.isChecked() ? "1"
                : bi.D21302.isChecked() ? "2"
                : "-1");

        json.put("D214", bi.D21401.isChecked() ? "1"
                : bi.D21402.isChecked() ? "2"
                : "-1");

        json.put("D215", bi.D21501.isChecked() ? "1"
                : bi.D21502.isChecked() ? "2"
                : "-1");

        json.put("D216", bi.D21601.isChecked() ? "1"
                : bi.D21602.isChecked() ? "2"
                : "-1");

        json.put("D217", bi.D21701.isChecked() ? "1"
                : bi.D21702.isChecked() ? "2"
                : "-1");

        json.put("D218a", bi.D218a01.isChecked() ? "1"
                : bi.D218a02.isChecked() ? "2"
                : bi.D218a03.isChecked() ? "3"
                : bi.D218a99.isChecked() ? "99"
                : "-1");

        json.put("D21901", bi.D2190101.isChecked() ? "1"
                : bi.D2190102.isChecked() ? "2"
                : "-1");


        json.put("D21902", bi.D2190201.isChecked() ? "1"
                : bi.D2190202.isChecked() ? "2"
                : "-1");

        json.put("D21903", bi.D2190301.isChecked() ? "1"
                : bi.D2190302.isChecked() ? "2"
                : "-1");

        json.put("D21904", bi.D2190401.isChecked() ? "1"
                : bi.D2190402.isChecked() ? "2"
                : "-1");

        json.put("D21905", bi.D2190501.isChecked() ? "1"
                : bi.D2190502.isChecked() ? "2"
                : "-1");

        json.put("D21906", bi.D2190601.isChecked() ? "1"
                : bi.D2190602.isChecked() ? "2"
                : "-1");

        json.put("D21907", bi.D2190701.isChecked() ? "1"
                : bi.D2190702.isChecked() ? "2"
                : "-1");

        json.put("D21908", bi.D2190801.isChecked() ? "1"
                : bi.D2190802.isChecked() ? "2"
                : "-1");

        json.put("D21909", bi.D2190901.isChecked() ? "1"
                : bi.D2190902.isChecked() ? "2"
                : "-1");

        json.put("D21910", bi.D2191001.isChecked() ? "1"
                : bi.D2191002.isChecked() ? "2"
                : "-1");

        json.put("D21911", bi.D2191101.isChecked() ? "1"
                : bi.D2191102.isChecked() ? "2"
                : "-1");

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