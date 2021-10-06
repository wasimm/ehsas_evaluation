package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleMWRAsContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityW3Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class W3 extends AppCompatActivity {

    /*public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;*/
    public long id;
    ActivityW3Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_w3);
        bi.setCallback(this);

        setupSkip();


        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
    }

    private void setupSkip() {

        //W306
        bi.W306.setOnCheckedChangeListener((RadioGroup, idChecked) -> {
            if (idChecked == bi.W30602.getId() || idChecked == bi.W30698.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW307);
                bi.fldGrpCVW307.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW307.setVisibility(View.VISIBLE);
            }
        });

        //W307
        bi.W307.setOnCheckedChangeListener((RadioGroup, idChecked) -> {
            if (idChecked == bi.W30798.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW308);
                bi.fldGrpCVW308.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW308.setVisibility(View.VISIBLE);
            }
        });

        //W214
        bi.W31403.setOnCheckedChangeListener(this::onCheckedChanged);
        bi.W31404.setOnCheckedChangeListener(this::onCheckedChanged);
        bi.W31405.setOnCheckedChangeListener(this::onCheckedChanged);
        bi.W31496.setOnCheckedChangeListener(this::onCheckedChanged);
        bi.W31498.setOnCheckedChangeListener(this::onCheckedChanged);

        //W316
        bi.W316.setOnCheckedChangeListener((RadioGroup, idChecked) -> {
            if (idChecked == bi.W31602.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW317);
                bi.fldGrpCVW317.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW318);
                bi.fldGrpCVW318.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW319);
                bi.fldGrpCVW319.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW320);
                bi.fldGrpCVW320.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW317.setVisibility(View.VISIBLE);
                bi.fldGrpCVW318.setVisibility(View.VISIBLE);
                bi.fldGrpCVW319.setVisibility(View.VISIBLE);
                bi.fldGrpCVW320.setVisibility(View.VISIBLE);
            }
        });

        //W321
        bi.W321.setOnCheckedChangeListener((RadioGroup, idChecked) -> {
            if (idChecked == bi.W32102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW322);
                bi.fldGrpCVW322.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW323);
                bi.fldGrpCVW323.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW324);
                bi.fldGrpCVW324.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW325);
                bi.fldGrpCVW325.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW326);
                bi.fldGrpCVW326.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW327);
                bi.fldGrpCVW327.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW328);
                bi.fldGrpCVW328.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW322.setVisibility(View.VISIBLE);
                bi.fldGrpCVW323.setVisibility(View.VISIBLE);
                bi.fldGrpCVW324.setVisibility(View.VISIBLE);
                bi.fldGrpCVW325.setVisibility(View.VISIBLE);
                bi.fldGrpCVW326.setVisibility(View.VISIBLE);
                bi.fldGrpCVW327.setVisibility(View.VISIBLE);
                bi.fldGrpCVW328.setVisibility(View.VISIBLE);
            }
        });

    }

    public void onCheckedChanged(CompoundButton checkBoxView, boolean isChecked) {

        if (checkBoxView.getId() == bi.W31403.getId() ||
                checkBoxView.getId() == bi.W31404.getId() ||
                checkBoxView.getId() == bi.W31405.getId() ||
                checkBoxView.getId() == bi.W31496.getId() ||
                checkBoxView.getId() == bi.W31498.getId()) {

            Clear.clearAllFields(bi.fldGrpCVW315);
            bi.fldGrpCVW315.setVisibility(View.GONE);
        } else {
            bi.fldGrpCVW315.setVisibility(View.VISIBLE);
        }
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
            startActivity(new Intent(this, W4.class).putExtra("id", id));
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
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        //json.put("H601", bi.H601.getText().toString().trim().isEmpty() ? "-1" : bi.H601.getText().toString().trim());

        json.put("W301", bi.W30101.isChecked() ? "1"
                : bi.W30102.isChecked() ? "2"
                : bi.W30103.isChecked() ? "3"
                : bi.W30104.isChecked() ? "4"
                : bi.W30105.isChecked() ? "5"
                : bi.W30106.isChecked() ? "6"
                : bi.W30107.isChecked() ? "7"
                : bi.W30196.isChecked() ? "96"
                : "-1");
        json.put("W30196x", bi.W30196x.getText().toString().trim().isEmpty() ? "-1" : bi.W30196x.getText().toString().trim());

        json.put("W30201", bi.W30201.isChecked() ? "1" : "-1");
        json.put("W30202", bi.W30202.isChecked() ? "2" : "-1");
        json.put("W30203", bi.W30203.isChecked() ? "3" : "-1");
        json.put("W30204", bi.W30204.isChecked() ? "4" : "-1");
        json.put("W30205", bi.W30205.isChecked() ? "5" : "-1");
        json.put("W30206", bi.W30206.isChecked() ? "6" : "-1");
        json.put("W30207", bi.W30207.isChecked() ? "7" : "-1");
        json.put("W30296", bi.W30296.isChecked() ? "96" : "-1");
        json.put("W30299", bi.W30299.isChecked() ? "99" : "-1");
        json.put("W30296x", bi.W30296x.getText().toString().trim().isEmpty() ? "-1" : bi.W30296x.getText().toString().trim());

        json.put("W303", bi.W30301.isChecked() ? "1"
                : bi.W30302.isChecked() ? "2"
                : bi.W303961.isChecked() ? "961"
                : bi.W303962.isChecked() ? "962"
                : bi.W303963.isChecked() ? "963"
                : "-1");
        json.put("W303961x", bi.W303961x.getText().toString().trim().isEmpty() ? "-1" : bi.W303961x.getText().toString().trim());
        json.put("W303962x", bi.W303962x.getText().toString().trim().isEmpty() ? "-1" : bi.W303962x.getText().toString().trim());
        json.put("W303963x", bi.W303963x.getText().toString().trim().isEmpty() ? "-1" : bi.W303963x.getText().toString().trim());

        json.put("W304", bi.W30401.isChecked() ? "1"
                : bi.W30402.isChecked() ? "2"
                : bi.W30403.isChecked() ? "3"
                : "-1");

        json.put("W305", bi.W305.getText().toString().trim().isEmpty() ? "-1" : bi.W305.getText().toString().trim());

        json.put("W306", bi.W30601.isChecked() ? "1"
                : bi.W30602.isChecked() ? "2"
                : bi.W30698.isChecked() ? "98"
                : "-1");

        json.put("W307", bi.W30701.isChecked() ? "1"
                : bi.W30702.isChecked() ? "2"
                : bi.W30798.isChecked() ? "98"
                : "-1");
        json.put("W30701x", bi.W30701x.getText().toString().trim().isEmpty() ? "-1" : bi.W30701x.getText().toString().trim());
        json.put("W30702x", bi.W30702x.getText().toString().trim().isEmpty() ? "-1" : bi.W30702x.getText().toString().trim());

        json.put("W308", bi.W30801.isChecked() ? "1"
                : bi.W30802.isChecked() ? "2"
                : bi.W30803.isChecked() ? "3"
                : bi.W30804.isChecked() ? "4"
                : bi.W30805.isChecked() ? "5"
                : bi.W30898.isChecked() ? "98"
                : "-1");

        json.put("W309", bi.W30901.isChecked() ? "1"
                : bi.W30902.isChecked() ? "2"
                : bi.W30998.isChecked() ? "98"
                : "-1");

        json.put("W310", bi.W31001.isChecked() ? "1"
                : bi.W31002.isChecked() ? "2"
                : bi.W31098.isChecked() ? "98"
                : "-1");

        json.put("W311", bi.W31101.isChecked() ? "1"
                : bi.W31102.isChecked() ? "2"
                : bi.W31198.isChecked() ? "98"
                : "-1");

        json.put("W312", bi.W31201.isChecked() ? "1"
                : bi.W31202.isChecked() ? "2"
                : bi.W31203.isChecked() ? "3"
                : bi.W31297.isChecked() ? "97"
                : bi.W31298.isChecked() ? "98"
                : "-1");
        json.put("W31202x", bi.W31202x.getText().toString().trim().isEmpty() ? "-1" : bi.W31202x.getText().toString().trim());
        json.put("W31203x", bi.W31203x.getText().toString().trim().isEmpty() ? "-1" : bi.W31203x.getText().toString().trim());

        json.put("W313", bi.W31301.isChecked() ? "1"
                : bi.W31302.isChecked() ? "2"
                : bi.W31398.isChecked() ? "98"
                : "-1");

        json.put("W31401", bi.W31401.isChecked() ? "1" : "-1");
        json.put("W31402", bi.W31402.isChecked() ? "2" : "-1");
        json.put("W31403", bi.W31403.isChecked() ? "3" : "-1");
        json.put("W31404", bi.W31404.isChecked() ? "4" : "-1");
        json.put("W31405", bi.W31405.isChecked() ? "5" : "-1");
        json.put("W31496", bi.W31496.isChecked() ? "96" : "-1");
        json.put("W31498", bi.W31498.isChecked() ? "98" : "-1");
        json.put("W31496x", bi.W31496x.getText().toString().trim().isEmpty() ? "-1" : bi.W31496x.getText().toString().trim());

        json.put("W315", bi.W315961.isChecked() ? "961"
                : bi.W315962.isChecked() ? "962"
                : bi.W315963.isChecked() ? "963"
                : "-1");
        json.put("W315961x", bi.W315961x.getText().toString().trim().isEmpty() ? "-1" : bi.W315961x.getText().toString().trim());
        json.put("W315962x", bi.W315962x.getText().toString().trim().isEmpty() ? "-1" : bi.W315962x.getText().toString().trim());
        json.put("W315963x", bi.W315963x.getText().toString().trim().isEmpty() ? "-1" : bi.W315963x.getText().toString().trim());

        json.put("W316", bi.W31601.isChecked() ? "1"
                : bi.W31602.isChecked() ? "2"
                : "-1");

        json.put("W31701", bi.W31701.isChecked() ? "1" : "-1");
        json.put("W31702", bi.W31702.isChecked() ? "2" : "-1");
        json.put("W31703", bi.W31703.isChecked() ? "3" : "-1");
        json.put("W31704", bi.W31704.isChecked() ? "4" : "-1");
        json.put("W31705", bi.W31705.isChecked() ? "5" : "-1");
        json.put("W31706", bi.W31706.isChecked() ? "6" : "-1");
        json.put("W31707", bi.W31707.isChecked() ? "7" : "-1");
        json.put("W31708", bi.W31708.isChecked() ? "8" : "-1");
        json.put("W31796", bi.W31796.isChecked() ? "96" : "-1");
        json.put("W31796x", bi.W31796x.getText().toString().trim().isEmpty() ? "-1" : bi.W31796x.getText().toString().trim());

        json.put("W318", bi.W31801.isChecked() ? "1"
                : bi.W31802.isChecked() ? "2"
                : bi.W31803.isChecked() ? "3"
                : bi.W31898.isChecked() ? "98"
                : "-1");
        json.put("W31801x", bi.W31801x.getText().toString().trim().isEmpty() ? "-1" : bi.W31801x.getText().toString().trim());
        json.put("W31802x", bi.W31802x.getText().toString().trim().isEmpty() ? "-1" : bi.W31802x.getText().toString().trim());
        json.put("W31803x", bi.W31803x.getText().toString().trim().isEmpty() ? "-1" : bi.W31803x.getText().toString().trim());

        json.put("W319", bi.W319.getText().toString().trim().isEmpty() ? "-1" : bi.W319.getText().toString().trim());

        json.put("W32001", bi.W32001.isChecked() ? "1" : "-1");
        json.put("W32002", bi.W32002.isChecked() ? "2" : "-1");
        json.put("W32003", bi.W32003.isChecked() ? "3" : "-1");
        json.put("W32004", bi.W32004.isChecked() ? "4" : "-1");
        json.put("W32005", bi.W32005.isChecked() ? "5" : "-1");
        json.put("W32006", bi.W32006.isChecked() ? "6" : "-1");
        json.put("W32007", bi.W32007.isChecked() ? "7" : "-1");
        json.put("W32008", bi.W32008.isChecked() ? "8" : "-1");
        json.put("W32096", bi.W32096.isChecked() ? "96" : "-1");
        json.put("W32096x", bi.W32096x.getText().toString().trim().isEmpty() ? "-1" : bi.W32096x.getText().toString().trim());

        json.put("W321", bi.W32101.isChecked() ? "1"
                : bi.W32102.isChecked() ? "2"
                : "-1");

        json.put("W32201", bi.W32201.isChecked() ? "1" : "-1");
        json.put("W32202", bi.W32202.isChecked() ? "2" : "-1");
        json.put("W32203", bi.W32203.isChecked() ? "3" : "-1");
        json.put("W32204", bi.W32204.isChecked() ? "4" : "-1");
        json.put("W32205", bi.W32205.isChecked() ? "5" : "-1");
        json.put("W32206", bi.W32206.isChecked() ? "6" : "-1");
        json.put("W32207", bi.W32207.isChecked() ? "7" : "-1");
        json.put("W32208", bi.W32208.isChecked() ? "8" : "-1");
        json.put("W32296", bi.W32296.isChecked() ? "96" : "-1");
        json.put("W32296x", bi.W32296x.getText().toString().trim().isEmpty() ? "-1" : bi.W32296x.getText().toString().trim());

        json.put("W323", bi.W32301.isChecked() ? "1"
                : bi.W32302.isChecked() ? "2"
                : bi.W32303.isChecked() ? "3"
                : bi.W32398.isChecked() ? "98"
                : "-1");
        json.put("W32301x", bi.W32301x.getText().toString().trim().isEmpty() ? "-1" : bi.W32301x.getText().toString().trim());
        json.put("W32302x", bi.W32302x.getText().toString().trim().isEmpty() ? "-1" : bi.W32302x.getText().toString().trim());
        json.put("W32303x", bi.W32303x.getText().toString().trim().isEmpty() ? "-1" : bi.W32303x.getText().toString().trim());

        json.put("W324", bi.W324.getText().toString().trim().isEmpty() ? "-1" : bi.W324.getText().toString().trim());

        json.put("W32501", bi.W32501.isChecked() ? "1" : "-1");
        json.put("W32502", bi.W32502.isChecked() ? "2" : "-1");
        json.put("W32503", bi.W32503.isChecked() ? "3" : "-1");
        json.put("W32504", bi.W32504.isChecked() ? "4" : "-1");
        json.put("W32596", bi.W32596.isChecked() ? "96" : "-1");
        json.put("W32596x", bi.W32596x.getText().toString().trim().isEmpty() ? "-1" : bi.W32596x.getText().toString().trim());

        json.put("W326", bi.W32601.isChecked() ? "1"
                : bi.W32602.isChecked() ? "2"
                : "-1");

        json.put("W327", bi.W32701.isChecked() ? "1"
                : bi.W32702.isChecked() ? "2"
                : "-1");

        json.put("W328", bi.W32801.isChecked() ? "1"
                : bi.W32802.isChecked() ? "2"
                : bi.W32803.isChecked() ? "3"
                : bi.W32804.isChecked() ? "4"
                : bi.W32805.isChecked() ? "5"
                : bi.W32806.isChecked() ? "6"
                : bi.W32807.isChecked() ? "7"
                : bi.W32808.isChecked() ? "8"
                : bi.W32809.isChecked() ? "9"
                : bi.W32810.isChecked() ? "10"
                : bi.W32811.isChecked() ? "11"
                : bi.W32812.isChecked() ? "12"
                : bi.W32813.isChecked() ? "13"
                : bi.W32814.isChecked() ? "14"
                : bi.W32815.isChecked() ? "15"
                : bi.W32816.isChecked() ? "16"
                : bi.W32896.isChecked() ? "96"
                : "-1");
        json.put("W32896x", bi.W32896x.getText().toString().trim().isEmpty() ? "-1" : bi.W32896x.getText().toString().trim());

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