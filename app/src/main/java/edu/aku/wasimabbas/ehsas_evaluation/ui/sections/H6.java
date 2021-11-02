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

        //H608
        bi.H608.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H60801.getId() || idChecked == bi.H60802.getId() || idChecked == bi.H60896.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH609);
                bi.fldGrpCVH609.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH609.setVisibility(View.VISIBLE);
            }
        });

        //H61401
        bi.H61401.setOnCheckedChangeListener((group, isChecked) -> {
            if (isChecked) {
                bi.fldGrpCVH609.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH609);
                bi.fldGrpCVH609.setVisibility(View.GONE);
            }
        });

        //H620
        bi.H620.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H62001.getId()) {
                bi.fldGrpCVH621.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH621);
                bi.fldGrpCVH621.setVisibility(View.GONE);
            }
        });

        //H622
        bi.H622.setOnCheckedChangeListener((group, idChecked) -> {

            if (idChecked == bi.H61902.getId()) {

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
                Clear.clearAllFields(bi.fldGrpCVH639);
                Clear.clearAllFields(bi.fldGrpCVH640);
                Clear.clearAllFields(bi.fldGrpCVH641);
                Clear.clearAllFields(bi.fldGrpCVH642);


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
                bi.fldGrpCVH639.setVisibility(View.GONE);
                bi.fldGrpCVH640.setVisibility(View.GONE);
                bi.fldGrpCVH641.setVisibility(View.GONE);
                bi.fldGrpCVH642.setVisibility(View.GONE);

            } else {
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
                bi.fldGrpCVH639.setVisibility(View.VISIBLE);
                bi.fldGrpCVH640.setVisibility(View.VISIBLE);
                bi.fldGrpCVH641.setVisibility(View.VISIBLE);
                bi.fldGrpCVH642.setVisibility(View.VISIBLE);
            }
        });

        //H629
        bi.H629.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H62901.getId() || idChecked == bi.H62902.getId() || idChecked == bi.H62996.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH630);
                bi.fldGrpCVH630.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH630.setVisibility(View.VISIBLE);
            }
        });

        //H63501
        bi.H63501.setOnCheckedChangeListener((group, isChecked) -> {
            if (isChecked) {
                Clear.clearAllFields(bi.fldGrpCVH636);
                bi.fldGrpCVH636.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH636.setVisibility(View.VISIBLE);
            }
        });

        //H641
        bi.H641.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H64101.getId()) {
                bi.fldGrpCVH642.setVisibility(View.VISIBLE);
                Clear.clearAllFields(bi.fldGrpCVH643);
                Clear.clearAllFields(bi.fldGrpCVH644);
                bi.fldGrpCVH643.setVisibility(View.GONE);
                bi.fldGrpCVH644.setVisibility(View.GONE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH642);
                Clear.clearAllFields(bi.fldGrpCVH643);
                Clear.clearAllFields(bi.fldGrpCVH644);
                bi.fldGrpCVH642.setVisibility(View.GONE);
                bi.fldGrpCVH643.setVisibility(View.GONE);
                bi.fldGrpCVH644.setVisibility(View.GONE);
            }
        });

        //H643
        bi.H643.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.H64302.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH644);
                bi.fldGrpCVH644.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH644.setVisibility(View.VISIBLE);
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

        json.put("H602", bi.H602.getText().toString().trim().isEmpty() ? "-1" : bi.H602.getText().toString().trim());

        json.put("H603", bi.H60301.isChecked() ? "1"
                : bi.H60302.isChecked() ? "2"
                : bi.H60303.isChecked() ? "3"
                : bi.H60304.isChecked() ? "4"
                : bi.H60305.isChecked() ? "5"
                : bi.H60396.isChecked() ? "96"
                : "-1");
        json.put("H60396x", bi.H60396x.getText().toString().trim().isEmpty() ? "-1" : bi.H60396x.getText().toString().trim());

        json.put("H60498", bi.H60498.isChecked() ? "98" : "-1");
        json.put("H604", bi.H604.getText().toString().trim().isEmpty() ? "-1" : bi.H604.getText().toString().trim());

        json.put("H60598", bi.H60598.isChecked() ? "98" : "-1");
        json.put("H605", bi.H605.getText().toString().trim().isEmpty() ? "-1" : bi.H605.getText().toString().trim());

        json.put("H606", bi.H606.getText().toString().trim().isEmpty() ? "-1" : bi.H606.getText().toString().trim());

        json.put("H607", bi.H607.getText().toString().trim().isEmpty() ? "-1" : bi.H607.getText().toString().trim());

        json.put("H608", bi.H60801.isChecked() ? "1"
                : bi.H60802.isChecked() ? "2"
                : bi.H60803.isChecked() ? "3"
                : bi.H60804.isChecked() ? "4"
                : bi.H60896.isChecked() ? "96"
                : "-1");
        json.put("H60896x", bi.H60896x.getText().toString().trim().isEmpty() ? "-1" : bi.H60896x.getText().toString().trim());

        json.put("H609", bi.H609.getText().toString().trim().isEmpty() ? "-1" : bi.H609.getText().toString().trim());

        json.put("H610", bi.H61001.isChecked() ? "1"
                : bi.H61002.isChecked() ? "2"
                : bi.H61003.isChecked() ? "3"
                : bi.H61004.isChecked() ? "4"
                : bi.H61096.isChecked() ? "96"
                : "-1");
        json.put("H61096x", bi.H61096x.getText().toString().trim().isEmpty() ? "-1" : bi.H61096x.getText().toString().trim());

        json.put("H611", bi.H61101.isChecked() ? "1"
                : bi.H61102.isChecked() ? "2"
                : "-1");

        json.put("H61201", bi.H61201.isChecked() ? "1" : "-1");
        json.put("H61202", bi.H61202.isChecked() ? "2" : "-1");
        json.put("H61203", bi.H61203.isChecked() ? "3" : "-1");
        json.put("H61204", bi.H61204.isChecked() ? "4" : "-1");
        json.put("H61296", bi.H61296.isChecked() ? "96" : "-1");
        json.put("H61296x", bi.H61296x.getText().toString().trim().isEmpty() ? "-1" : bi.H61296x.getText().toString().trim());

        json.put("H61301", bi.H61301.isChecked() ? "1" : "-1");
        json.put("H61302", bi.H61302.isChecked() ? "2" : "-1");
        json.put("H61303", bi.H61303.isChecked() ? "3" : "-1");
        json.put("H61304", bi.H61304.isChecked() ? "4" : "-1");
        json.put("H61396", bi.H61396.isChecked() ? "96" : "-1");
        json.put("H61396x", bi.H61396x.getText().toString().trim().isEmpty() ? "-1" : bi.H61396x.getText().toString().trim());

        json.put("H61401", bi.H61401.isChecked() ? "1" : "-1");
        json.put("H61402", bi.H61402.isChecked() ? "2" : "-1");
        json.put("H61403", bi.H61403.isChecked() ? "3" : "-1");
        json.put("H61404", bi.H61404.isChecked() ? "4" : "-1");
        json.put("H61496", bi.H61496.isChecked() ? "96" : "-1");
        json.put("H61496x", bi.H61496x.getText().toString().trim().isEmpty() ? "-1" : bi.H61496x.getText().toString().trim());

        json.put("H615", bi.H61501.isChecked() ? "1"
                : bi.H61502.isChecked() ? "2"
                : bi.H61503.isChecked() ? "3"
                : bi.H61504.isChecked() ? "4"
                : bi.H61596.isChecked() ? "96"
                : "-1");
        json.put("H61596x", bi.H61596x.getText().toString().trim().isEmpty() ? "-1" : bi.H61596x.getText().toString().trim());

        json.put("H616", bi.H616.getText().toString().trim().isEmpty() ? "-1" : bi.H616.getText().toString().trim());

        json.put("H617", bi.H617.getText().toString().trim().isEmpty() ? "-1" : bi.H617.getText().toString().trim());

        json.put("H618", bi.H618.getText().toString().trim().isEmpty() ? "-1" : bi.H618.getText().toString().trim());

        json.put("H619", bi.H61901.isChecked() ? "1"
                : bi.H61902.isChecked() ? "2"
                : bi.H61903.isChecked() ? "3"
                : bi.H61904.isChecked() ? "4"
                : bi.H61996.isChecked() ? "96"
                : "-1");
        json.put("H61996x", bi.H61996x.getText().toString().trim().isEmpty() ? "-1" : bi.H61996x.getText().toString().trim());

        json.put("H620", bi.H62001.isChecked() ? "1"
                : bi.H62002.isChecked() ? "2"
                : "-1");

        json.put("H621", bi.H621.getText().toString().trim().isEmpty() ? "-1" : bi.H621.getText().toString().trim());

        json.put("H622", bi.H62201.isChecked() ? "1"
                : bi.H62202.isChecked() ? "2"
                : "-1");

        json.put("H623", bi.H62301.isChecked() ? "1"
                : bi.H62302.isChecked() ? "2"
                : bi.H62303.isChecked() ? "3"
                : bi.H62396.isChecked() ? "96"
                : "-1");
        json.put("H62396x", bi.H62396x.getText().toString().trim().isEmpty() ? "-1" : bi.H62396x.getText().toString().trim());

        json.put("H624", bi.H624.getText().toString().trim().isEmpty() ? "-1" : bi.H624.getText().toString().trim());

        json.put("H625", bi.H62501.isChecked() ? "1"
                : bi.H62502.isChecked() ? "2"
                : "-1");

        json.put("H62698", bi.H62698.isChecked() ? "98" : "-1");
        json.put("H626", bi.H626.getText().toString().trim().isEmpty() ? "-1" : bi.H626.getText().toString().trim());

        json.put("H62701", bi.H62701.getText().toString().trim().isEmpty() ? "-1" : bi.H62701.getText().toString().trim());
        json.put("H62702", bi.H62702.getText().toString().trim().isEmpty() ? "-1" : bi.H62702.getText().toString().trim());
        json.put("H62798", bi.H62798.isChecked() ? "98" : "-1");

        json.put("H628", bi.H628.getText().toString().trim().isEmpty() ? "-1" : bi.H628.getText().toString().trim());

        json.put("H629", bi.H62901.isChecked() ? "1"
                : bi.H62902.isChecked() ? "2"
                : bi.H62903.isChecked() ? "3"
                : bi.H62904.isChecked() ? "4"
                : bi.H62996.isChecked() ? "96"
                : "-1");
        json.put("H62996x", bi.H62996x.getText().toString().trim().isEmpty() ? "-1" : bi.H62996x.getText().toString().trim());

        json.put("H630", bi.H630.getText().toString().trim().isEmpty() ? "-1" : bi.H630.getText().toString().trim());

        json.put("H631", bi.H63101.isChecked() ? "1"
                : bi.H63102.isChecked() ? "2"
                : bi.H63103.isChecked() ? "3"
                : bi.H63104.isChecked() ? "4"
                : bi.H63196.isChecked() ? "96"
                : "-1");
        json.put("H63196x", bi.H63196x.getText().toString().trim().isEmpty() ? "-1" : bi.H63196x.getText().toString().trim());

        json.put("H632", bi.H63201.isChecked() ? "1"
                : bi.H63202.isChecked() ? "2"
                : "-1");

        json.put("H63301", bi.H63301.isChecked() ? "1" : "-1");
        json.put("H63302", bi.H63302.isChecked() ? "2" : "-1");
        json.put("H63303", bi.H63303.isChecked() ? "3" : "-1");
        json.put("H63304", bi.H63304.isChecked() ? "4" : "-1");
        json.put("H63396", bi.H63396.isChecked() ? "96" : "-1");
        json.put("H63396x", bi.H63396x.getText().toString().trim().isEmpty() ? "-1" : bi.H63396x.getText().toString().trim());

        json.put("H63401", bi.H63401.isChecked() ? "1" : "-1");
        json.put("H63402", bi.H63402.isChecked() ? "2" : "-1");
        json.put("H63403", bi.H63403.isChecked() ? "3" : "-1");
        json.put("H63404", bi.H63404.isChecked() ? "4" : "-1");
        json.put("H63496", bi.H63496.isChecked() ? "96" : "-1");
        json.put("H63496x", bi.H63496x.getText().toString().trim().isEmpty() ? "-1" : bi.H63496x.getText().toString().trim());

        json.put("H63501", bi.H63501.isChecked() ? "1" : "-1");
        json.put("H63502", bi.H63502.isChecked() ? "2" : "-1");
        json.put("H63503", bi.H63503.isChecked() ? "3" : "-1");
        json.put("H63504", bi.H63504.isChecked() ? "4" : "-1");
        json.put("H63596", bi.H63596.isChecked() ? "96" : "-1");
        json.put("H63596x", bi.H63596x.getText().toString().trim().isEmpty() ? "-1" : bi.H63596x.getText().toString().trim());

        json.put("H636", bi.H63601.isChecked() ? "1"
                : bi.H63602.isChecked() ? "2"
                : bi.H63603.isChecked() ? "3"
                : bi.H63604.isChecked() ? "4"
                : bi.H63696.isChecked() ? "96"
                : "-1");
        json.put("H63696x", bi.H63696x.getText().toString().trim().isEmpty() ? "-1" : bi.H63696x.getText().toString().trim());

        json.put("H637", bi.H637.getText().toString().trim().isEmpty() ? "-1" : bi.H637.getText().toString().trim());

        json.put("H638", bi.H638.getText().toString().trim().isEmpty() ? "-1" : bi.H638.getText().toString().trim());

        json.put("H63901", bi.H63901.getText().toString().trim().isEmpty() ? "-1" : bi.H63901.getText().toString().trim());
        json.put("H63902", bi.H63902.getText().toString().trim().isEmpty() ? "-1" : bi.H63902.getText().toString().trim());

        json.put("H640", bi.H64001.isChecked() ? "1"
                : bi.H64002.isChecked() ? "2"
                : bi.H64003.isChecked() ? "3"
                : bi.H64004.isChecked() ? "4"
                : bi.H64096.isChecked() ? "96"
                : "-1");
        json.put("H64096x", bi.H64096x.getText().toString().trim().isEmpty() ? "-1" : bi.H64096x.getText().toString().trim());

        json.put("H641", bi.H64101.isChecked() ? "1"
                : bi.H64102.isChecked() ? "2"
                : "-1");

        json.put("H642", bi.H642.getText().toString().trim().isEmpty() ? "-1" : bi.H642.getText().toString().trim());

        json.put("H643", bi.H64301.isChecked() ? "1"
                : bi.H64302.isChecked() ? "2"
                : "-1");

        json.put("H644", bi.H644.getText().toString().trim().isEmpty() ? "-1" : bi.H644.getText().toString().trim());

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