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
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleMWRAsContract;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.MembersContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityW4Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class W4 extends AppCompatActivity {

    public long id;
    ActivityW4Binding bi;
    DatabaseHelper db;
    Intent oF = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_w4);
        bi.setCallback(this);

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);

        setupSkip();

        Toast.makeText(this, "W4: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
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
            startActivity(new Intent(this, W6.class).putExtra("id", id));
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
        int updcount = db.updatesMWRAColumn(EligibleMWRAsContract.MWRAsTable.COLUMN_JSON, MainApp.mwra.getJSON());
        if (updcount == 1) {
            db.updateCollectedColumn(MembersContract.MembersTable.COLUMN_COLLECTED, 1, id);
            //Toast.makeText(this, "MUID ID: " + MainApp.mwra.getId(), Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("W40101", bi.W40101.isChecked() ? "1" : "-1");
        json.put("W40102", bi.W40102.isChecked() ? "2" : "-1");
        json.put("W40103", bi.W40103.isChecked() ? "3" : "-1");
        json.put("W40104", bi.W40104.isChecked() ? "4" : "-1");
        json.put("W40105", bi.W40105.isChecked() ? "5" : "-1");
        json.put("W40106", bi.W40106.isChecked() ? "6" : "-1");
        json.put("W40107", bi.W40107.isChecked() ? "7" : "-1");

        json.put("W40201", bi.W40201.isChecked() ? "1" : "-1");
        json.put("W40202", bi.W40202.isChecked() ? "2" : "-1");
        json.put("W40203", bi.W40203.isChecked() ? "3" : "-1");
        json.put("W40204", bi.W40204.isChecked() ? "4" : "-1");
        json.put("W40205", bi.W40205.isChecked() ? "5" : "-1");
        json.put("W40206", bi.W40206.isChecked() ? "6" : "-1");
        json.put("W40207", bi.W40207.isChecked() ? "7" : "-1");

        json.put("W40301", bi.W40301.isChecked() ? "1" : "-1");
        json.put("W40302", bi.W40302.isChecked() ? "2" : "-1");
        json.put("W40303", bi.W40303.isChecked() ? "3" : "-1");
        json.put("W40304", bi.W40304.isChecked() ? "4" : "-1");
        json.put("W40305", bi.W40305.isChecked() ? "5" : "-1");
        json.put("W40306", bi.W40306.isChecked() ? "6" : "-1");
        json.put("W40307", bi.W40307.isChecked() ? "7" : "-1");

        json.put("W40401", bi.W40401.isChecked() ? "1" : "-1");
        json.put("W40402", bi.W40402.isChecked() ? "2" : "-1");
        json.put("W40403", bi.W40403.isChecked() ? "3" : "-1");
        json.put("W40404", bi.W40404.isChecked() ? "4" : "-1");
        json.put("W40405", bi.W40405.isChecked() ? "5" : "-1");
        json.put("W40406", bi.W40406.isChecked() ? "6" : "-1");
        json.put("W40407", bi.W40407.isChecked() ? "7" : "-1");

        json.put("W40501", bi.W40501.isChecked() ? "1" : "-1");
        json.put("W40502", bi.W40502.isChecked() ? "2" : "-1");
        json.put("W40503", bi.W40503.isChecked() ? "3" : "-1");
        json.put("W40504", bi.W40504.isChecked() ? "4" : "-1");
        json.put("W40505", bi.W40505.isChecked() ? "5" : "-1");
        json.put("W40506", bi.W40506.isChecked() ? "6" : "-1");
        json.put("W40507", bi.W40507.isChecked() ? "7" : "-1");

        json.put("W40601", bi.W40601.isChecked() ? "1" : "-1");
        json.put("W40602", bi.W40602.isChecked() ? "2" : "-1");
        json.put("W40603", bi.W40603.isChecked() ? "3" : "-1");
        json.put("W40604", bi.W40604.isChecked() ? "4" : "-1");
        json.put("W40605", bi.W40605.isChecked() ? "5" : "-1");
        json.put("W40606", bi.W40606.isChecked() ? "6" : "-1");
        json.put("W40607", bi.W40607.isChecked() ? "7" : "-1");

        json.put("W40701", bi.W40701.isChecked() ? "1" : "-1");
        json.put("W40702", bi.W40702.isChecked() ? "2" : "-1");
        json.put("W40703", bi.W40703.isChecked() ? "3" : "-1");
        json.put("W40704", bi.W40704.isChecked() ? "4" : "-1");
        json.put("W40705", bi.W40705.isChecked() ? "5" : "-1");
        json.put("W40706", bi.W40706.isChecked() ? "6" : "-1");
        json.put("W40707", bi.W40707.isChecked() ? "7" : "-1");

        json.put("W40801", bi.W40801.isChecked() ? "1" : "-1");
        json.put("W40802", bi.W40802.isChecked() ? "2" : "-1");
        json.put("W40803", bi.W40803.isChecked() ? "3" : "-1");
        json.put("W40804", bi.W40804.isChecked() ? "4" : "-1");
        json.put("W40805", bi.W40805.isChecked() ? "5" : "-1");
        json.put("W40806", bi.W40806.isChecked() ? "6" : "-1");
        json.put("W40807", bi.W40807.isChecked() ? "7" : "-1");

        json.put("W40901", bi.W40901.isChecked() ? "1" : "-1");
        json.put("W40902", bi.W40902.isChecked() ? "2" : "-1");
        json.put("W40903", bi.W40903.isChecked() ? "3" : "-1");
        json.put("W40904", bi.W40904.isChecked() ? "4" : "-1");
        json.put("W40905", bi.W40905.isChecked() ? "5" : "-1");
        json.put("W40906", bi.W40906.isChecked() ? "6" : "-1");
        json.put("W40907", bi.W40907.isChecked() ? "7" : "-1");

        json.put("W41001", bi.W41001.isChecked() ? "1" : "-1");
        json.put("W41002", bi.W41002.isChecked() ? "2" : "-1");
        json.put("W41003", bi.W41003.isChecked() ? "3" : "-1");
        json.put("W41004", bi.W41004.isChecked() ? "4" : "-1");
        json.put("W41005", bi.W41005.isChecked() ? "5" : "-1");
        json.put("W41006", bi.W41006.isChecked() ? "6" : "-1");
        json.put("W41007", bi.W41007.isChecked() ? "7" : "-1");

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