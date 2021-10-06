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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH301Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class H301 extends AppCompatActivity {

    /*private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };
    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};
    */

    ActivityH301Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h301);
        bi.setCallback(this);
        setupSkip();
    }

    private void setupSkip() {

        //H30301
        bi.H30301.setOnCheckedChangeListener((group, checkedId) -> {

            bi.H30302.clearCheck();

            if (checkedId == bi.H3030101.getId()) {

                bi.H3030201.setEnabled(true);
                bi.H3030202.setEnabled(true);
                bi.H3030203.setEnabled(false);
                bi.H3030204.setEnabled(false);
                bi.H3030205.setEnabled(false);
                bi.H3030206.setEnabled(false);
                bi.H3030207.setEnabled(false);
                bi.H3030208.setEnabled(false);
                bi.H3030209.setEnabled(false);
                bi.H3030210.setEnabled(false);
                bi.H3030211.setEnabled(false);
                bi.H3030212.setEnabled(false);
                bi.H3030213.setEnabled(false);
                bi.H3030214.setEnabled(false);
                bi.H3030215.setEnabled(false);
                bi.H3030216.setEnabled(false);
                bi.H3030296.setEnabled(false);
            } else {
                bi.H3030201.setEnabled(false);
                bi.H3030202.setEnabled(false);
                bi.H3030203.setEnabled(true);
                bi.H3030204.setEnabled(true);
                bi.H3030205.setEnabled(true);
                bi.H3030206.setEnabled(true);
                bi.H3030207.setEnabled(true);
                bi.H3030208.setEnabled(true);
                bi.H3030209.setEnabled(true);
                bi.H3030210.setEnabled(true);
                bi.H3030211.setEnabled(true);
                bi.H3030212.setEnabled(true);
                bi.H3030213.setEnabled(true);
                bi.H3030214.setEnabled(true);
                bi.H3030215.setEnabled(true);
                bi.H3030216.setEnabled(true);
                bi.H3030296.setEnabled(true);
            }
        });

        //H30302
        bi.H30302.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H3030201.getId() || checkedId == bi.H3030202.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH304);
                bi.fldGrpCVH304.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH304.setVisibility(View.VISIBLE);
            }
        });

        //H305
        bi.H305.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H30502.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH306);
                bi.fldGrpCVH306.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH306.setVisibility(View.VISIBLE);
            }
        });

        //H307
        bi.H307.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H30708.getId() || checkedId == bi.H30709.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH308);
                bi.fldGrpCVH308.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH309);
                bi.fldGrpCVH309.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH308.setVisibility(View.VISIBLE);
                bi.fldGrpCVH309.setVisibility(View.VISIBLE);
            }
        });

        //H308
        bi.H308.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H30802.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH309);
                bi.fldGrpCVH309.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH309.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, H302.class));
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

        json.put("H301", bi.H30101.isChecked() ? "1"
                : bi.H30102.isChecked() ? "2"
                : bi.H30103.isChecked() ? "3"
                : bi.H30104.isChecked() ? "4"
                : bi.H30105.isChecked() ? "5"
                : bi.H30106.isChecked() ? "6"
                : bi.H30107.isChecked() ? "7"
                : bi.H30108.isChecked() ? "8"
                : bi.H30109.isChecked() ? "9"
                : bi.H30110.isChecked() ? "10"
                : bi.H30111.isChecked() ? "11"
                : bi.H30112.isChecked() ? "12"
                : bi.H30113.isChecked() ? "13"
                : bi.H30196.isChecked() ? "96"
                : "-1");
        json.put("H30196x", bi.H30196x.getText().toString().trim().isEmpty() ? "-1" : bi.H30196x.getText().toString().trim());

        json.put("H302", bi.H30201.isChecked() ? "1"
                : bi.H30202.isChecked() ? "2"
                : bi.H30296.isChecked() ? "96"
                : "-1");
        json.put("H30296x", bi.H30296x.getText().toString().trim().isEmpty() ? "-1" : bi.H30296x.getText().toString().trim());


        json.put("H30301", bi.H3030101.isChecked() ? "1"
                : bi.H3030102.isChecked() ? "2"
                : "-1");

        json.put("H30302", bi.H3030201.isChecked() ? "1"
                : bi.H3030202.isChecked() ? "2"
                : bi.H3030203.isChecked() ? "3"
                : bi.H3030204.isChecked() ? "4"
                : bi.H3030205.isChecked() ? "5"
                : bi.H3030206.isChecked() ? "6"
                : bi.H3030207.isChecked() ? "7"
                : bi.H3030208.isChecked() ? "8"
                : bi.H3030209.isChecked() ? "9"
                : bi.H3030210.isChecked() ? "10"
                : bi.H3030211.isChecked() ? "11"
                : bi.H3030212.isChecked() ? "12"
                : bi.H3030213.isChecked() ? "13"
                : bi.H3030214.isChecked() ? "14"
                : bi.H3030215.isChecked() ? "15"
                : bi.H3030216.isChecked() ? "16"
                : bi.H3030296.isChecked() ? "96"
                : "-1");
        json.put("H3030296x", bi.H3030296x.getText().toString().trim().isEmpty() ? "-1" : bi.H3030296x.getText().toString().trim());

        json.put("H304", bi.H304.getText().toString().trim().isEmpty() ? "-1" : bi.H304.getText().toString().trim());

        json.put("H305", bi.H30501.isChecked() ? "1"
                : bi.H30502.isChecked() ? "2"
                : "-1");

        json.put("H306", bi.H30601.isChecked() ? "1"
                : bi.H30602.isChecked() ? "2"
                : bi.H30603.isChecked() ? "3"
                : bi.H30604.isChecked() ? "4"
                : bi.H30605.isChecked() ? "5"
                : bi.H30606.isChecked() ? "6"
                : bi.H30696.isChecked() ? "96"
                : "-1");
        json.put("H30696x", bi.H30696x.getText().toString().trim().isEmpty() ? "-1" : bi.H30696x.getText().toString().trim());

        json.put("H307", bi.H30701.isChecked() ? "1"
                : bi.H30702.isChecked() ? "2"
                : bi.H30703.isChecked() ? "3"
                : bi.H30704.isChecked() ? "4"
                : bi.H30705.isChecked() ? "5"
                : bi.H30706.isChecked() ? "6"
                : bi.H30707.isChecked() ? "7"
                : bi.H30708.isChecked() ? "8"
                : bi.H30709.isChecked() ? "9"
                : bi.H30796.isChecked() ? "96"
                : "-1");
        json.put("H30796x", bi.H30796x.getText().toString().trim().isEmpty() ? "-1" : bi.H30796x.getText().toString().trim());


        json.put("H308", bi.H30801.isChecked() ? "1"
                : bi.H30802.isChecked() ? "2"
                : "-1");

        json.put("H309", bi.H309.getText().toString().trim().isEmpty() ? "-1" : bi.H309.getText().toString().trim());

        json.put("H310", bi.H31001.isChecked() ? "1"
                : bi.H31002.isChecked() ? "2"
                : bi.H31003.isChecked() ? "3"
                : bi.H31004.isChecked() ? "4"
                : bi.H31005.isChecked() ? "5"
                : bi.H31006.isChecked() ? "6"
                : bi.H31007.isChecked() ? "7"
                : bi.H31008.isChecked() ? "8"
                : bi.H31096.isChecked() ? "96"
                : "-1");
        json.put("H31096x", bi.H31096x.getText().toString().trim().isEmpty() ? "-1" : bi.H31096x.getText().toString().trim());

        json.put("H31101", bi.H3110101.isChecked() ? "1"
                : bi.H3110102.isChecked() ? "2"
                : "-1");

        json.put("H31102", bi.H3110201.isChecked() ? "1"
                : bi.H3110202.isChecked() ? "2"
                : "-1");

        json.put("H31103", bi.H3110301.isChecked() ? "1"
                : bi.H3110302.isChecked() ? "2"
                : "-1");

        json.put("H31104", bi.H3110401.isChecked() ? "1"
                : bi.H3110402.isChecked() ? "2"
                : "-1");

        json.put("H31105", bi.H3110501.isChecked() ? "1"
                : bi.H3110502.isChecked() ? "2"
                : "-1");

        json.put("H31106", bi.H3110601.isChecked() ? "1"
                : bi.H3110602.isChecked() ? "2"
                : "-1");

        json.put("H31107", bi.H3110701.isChecked() ? "1"
                : bi.H3110702.isChecked() ? "2"
                : "-1");

        json.put("H31108", bi.H3110801.isChecked() ? "1"
                : bi.H3110802.isChecked() ? "2"
                : "-1");

        json.put("H31109", bi.H3110901.isChecked() ? "1"
                : bi.H3110902.isChecked() ? "2"
                : "-1");

        json.put("H31110", bi.H3111001.isChecked() ? "1"
                : bi.H3111002.isChecked() ? "2"
                : "-1");

        json.put("H31111", bi.H3111101.isChecked() ? "1"
                : bi.H3111102.isChecked() ? "2"
                : "-1");

        json.put("H31112", bi.H3111201.isChecked() ? "1"
                : bi.H3111202.isChecked() ? "2"
                : "-1");

        json.put("H31113", bi.H3111301.isChecked() ? "1"
                : bi.H3111302.isChecked() ? "2"
                : "-1");

        json.put("H31114", bi.H3111401.isChecked() ? "1"
                : bi.H3111402.isChecked() ? "2"
                : "-1");

        json.put("H31115", bi.H3111501.isChecked() ? "1"
                : bi.H3111502.isChecked() ? "2"
                : "-1");

        json.put("H31116", bi.H3111601.isChecked() ? "1"
                : bi.H3111602.isChecked() ? "2"
                : "-1");

        json.put("H31117", bi.H3111701.isChecked() ? "1"
                : bi.H3111702.isChecked() ? "2"
                : "-1");

        json.put("H31118", bi.H3111801.isChecked() ? "1"
                : bi.H3111802.isChecked() ? "2"
                : "-1");

        json.put("H31119", bi.H3111901.isChecked() ? "1"
                : bi.H3111902.isChecked() ? "2"
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