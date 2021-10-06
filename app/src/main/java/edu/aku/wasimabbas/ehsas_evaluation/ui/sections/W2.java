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
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleMWRAsContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityW2Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class W2 extends AppCompatActivity {

    /*public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;*/
    public long id;
    ActivityW2Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_w2);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
    }

    private void setupSkip() {

        //W201
        bi.W201.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W20102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW202);
                bi.fldGrpCVW202.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW203);
                bi.fldGrpCVW203.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW204);
                bi.fldGrpCVW204.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW205);
                bi.fldGrpCVW205.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20601);
                bi.fldGrpCVW20601.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20602);
                bi.fldGrpCVW20602.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20603);
                bi.fldGrpCVW20603.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20604);
                bi.fldGrpCVW20604.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20605);
                bi.fldGrpCVW20605.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20606);
                bi.fldGrpCVW20606.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20607);
                bi.fldGrpCVW20607.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20608);
                bi.fldGrpCVW20608.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20609);
                bi.fldGrpCVW20609.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW20696);
                bi.fldGrpCVW20696.setVisibility(View.GONE);

            } else {
                bi.fldGrpCVW202.setVisibility(View.VISIBLE);
                bi.fldGrpCVW203.setVisibility(View.VISIBLE);
                bi.fldGrpCVW204.setVisibility(View.VISIBLE);
                bi.fldGrpCVW205.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20601.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20602.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20603.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20604.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20605.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20606.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20607.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20608.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20609.setVisibility(View.VISIBLE);
                bi.fldGrpCVW20696.setVisibility(View.VISIBLE);
            }
        });

        //W207
        bi.W207.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W20702.getId() || checkedId == bi.W20798.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW208);
                bi.fldGrpCVW208.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW209);
                bi.fldGrpCVW209.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW210);
                bi.fldGrpCVW210.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW211);
                bi.fldGrpCVW211.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW212);
                bi.fldGrpCVW212.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW208.setVisibility(View.VISIBLE);
                bi.fldGrpCVW209.setVisibility(View.VISIBLE);
                bi.fldGrpCVW210.setVisibility(View.VISIBLE);
                bi.fldGrpCVW211.setVisibility(View.VISIBLE);
                bi.fldGrpCVW212.setVisibility(View.VISIBLE);
            }
        });

        //W213
        bi.W213.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W21302.getId() || checkedId == bi.W21398.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW214);
                bi.fldGrpCVW214.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW215);
                bi.fldGrpCVW215.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW216);
                bi.fldGrpCVW216.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW217);
                bi.fldGrpCVW217.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW214.setVisibility(View.VISIBLE);
                bi.fldGrpCVW215.setVisibility(View.VISIBLE);
                bi.fldGrpCVW216.setVisibility(View.VISIBLE);
                bi.fldGrpCVW217.setVisibility(View.VISIBLE);
            }
        });

        //W218
        bi.W218.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W21802.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW219);
                bi.fldGrpCVW219.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW219.setVisibility(View.VISIBLE);
            }
        });

        //W224
        bi.W224.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W22404.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW225);
                bi.fldGrpCVW225.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW226);
                bi.fldGrpCVW226.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW227);
                bi.fldGrpCVW227.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW228);
                bi.fldGrpCVW228.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW225.setVisibility(View.VISIBLE);
                bi.fldGrpCVW226.setVisibility(View.VISIBLE);
                bi.fldGrpCVW227.setVisibility(View.VISIBLE);
                bi.fldGrpCVW228.setVisibility(View.VISIBLE);
            }
        });

        //W225
        bi.W225.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.W22502.getId()) {
                Clear.clearAllFields(bi.fldGrpCVW226);
                bi.fldGrpCVW226.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW227);
                bi.fldGrpCVW227.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVW228);
                bi.fldGrpCVW228.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVW226.setVisibility(View.VISIBLE);
                bi.fldGrpCVW227.setVisibility(View.VISIBLE);
                bi.fldGrpCVW228.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, W3.class).putExtra("id", id));
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
        //MainApp.mwra.setFuid(MainApp.mwra.getFuid());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        //mc = new Member();
        //mc.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        //mc.setUsername(MainApp.userName);
        //mc.setDeviceid(MainApp.appInfo.getDeviceID());
        //mc.setDevicetagid(MainApp.appInfo.getDeviceID());
        //mc.setAppversion(MainApp.appInfo.getAppVersion());
        //mc.setFuid(form.getUid());
        //mc.setFuid("FormNo91");

        //mc.setH201(String.valueOf(counter));
        //MainApp.mwra.setFuid(MainApp.form.getUid());

        JSONObject json = new JSONObject();

        json.put("W201", bi.W20101.isChecked() ? "1"
                : bi.W20102.isChecked() ? "2"
                : "-1");

        json.put("W20201", bi.W20201.isChecked() ? "1" : "-1");
        json.put("W20202", bi.W20202.isChecked() ? "2" : "-1");
        json.put("W20203", bi.W20203.isChecked() ? "3" : "-1");
        json.put("W20204", bi.W20204.isChecked() ? "4" : "-1");
        json.put("W20205", bi.W20205.isChecked() ? "5" : "-1");
        json.put("W20206", bi.W20206.isChecked() ? "6" : "-1");
        json.put("W20207", bi.W20207.isChecked() ? "7" : "-1");
        json.put("W20208", bi.W20208.isChecked() ? "8" : "-1");
        json.put("W20296", bi.W20296.isChecked() ? "96" : "-1");
        json.put("W20296x", bi.W20296x.getText().toString().trim().isEmpty() ? "-1" : bi.W20296x.getText().toString().trim());

        json.put("W203", bi.W20301.isChecked() ? "1"
                : bi.W20302.isChecked() ? "2"
                : bi.W203961.isChecked() ? "961"
                : bi.W203962.isChecked() ? "962"
                : bi.W203963.isChecked() ? "963"
                : "-1");

        json.put("W203961x", bi.W203961x.getText().toString().trim().isEmpty() ? "-1" : bi.W203961x.getText().toString().trim());
        json.put("W203962x", bi.W203962x.getText().toString().trim().isEmpty() ? "-1" : bi.W203962x.getText().toString().trim());
        json.put("W203963x", bi.W203963x.getText().toString().trim().isEmpty() ? "-1" : bi.W203963x.getText().toString().trim());

        json.put("W20401", bi.W20401.getText().toString().trim().isEmpty() ? "-1" : bi.W20401.getText().toString().trim());
        json.put("W20402", bi.W20402.getText().toString().trim().isEmpty() ? "-1" : bi.W20402.getText().toString().trim());
        json.put("W20498", bi.W20498.isChecked() ? "98" : "-1");

        json.put("W20501", bi.W20501.getText().toString().trim().isEmpty() ? "-1" : bi.W20501.getText().toString().trim());
        json.put("W20598", bi.W20598.isChecked() ? "98" : "-1");

        json.put("W20601", bi.W2060101.isChecked() ? "1"
                : bi.W2060102.isChecked() ? "2"
                : "-1");

        json.put("W20602", bi.W2060201.isChecked() ? "1"
                : bi.W2060202.isChecked() ? "2"
                : "-1");

        json.put("W20603", bi.W2060301.isChecked() ? "1"
                : bi.W2060302.isChecked() ? "2"
                : "-1");

        json.put("W20604", bi.W2060401.isChecked() ? "1"
                : bi.W2060402.isChecked() ? "2"
                : "-1");

        json.put("W20605", bi.W2060501.isChecked() ? "1"
                : bi.W2060502.isChecked() ? "2"
                : "-1");

        json.put("W20606", bi.W2060601.isChecked() ? "1"
                : bi.W2060602.isChecked() ? "2"
                : "-1");

        json.put("W20607", bi.W2060701.isChecked() ? "1"
                : bi.W2060702.isChecked() ? "2"
                : "-1");

        json.put("W20608", bi.W2060801.isChecked() ? "1"
                : bi.W2060802.isChecked() ? "2"
                : "-1");

        json.put("W20609", bi.W2060901.isChecked() ? "1"
                : bi.W2060902.isChecked() ? "2"
                : "-1");

        json.put("W20696", bi.W2069601.isChecked() ? "1"
                : bi.W2069602.isChecked() ? "2"
                : "-1");
        json.put("W2069601x", bi.W2069601x.getText().toString().trim().isEmpty() ? "-1" : bi.W2069601x.getText().toString().trim());

        json.put("W207", bi.W20701.isChecked() ? "1"
                : bi.W20702.isChecked() ? "2"
                : "-1");

        json.put("W208", bi.W20801.isChecked() ? "1"
                : bi.W20802.isChecked() ? "2"
                : bi.W20803.isChecked() ? "3"
                : "-1");

        json.put("W209", bi.W20901.isChecked() ? "1"
                : bi.W20902.isChecked() ? "2"
                : bi.W20903.isChecked() ? "3"
                : bi.W20904.isChecked() ? "4"
                : bi.W20905.isChecked() ? "5"
                : bi.W20906.isChecked() ? "6"
                : bi.W20907.isChecked() ? "7"
                : bi.W20908.isChecked() ? "8"
                : bi.W20996.isChecked() ? "96"
                : "-1");
        json.put("W20996x", bi.W20996x.getText().toString().trim().isEmpty() ? "-1" : bi.W20996x.getText().toString().trim());

        json.put("W210961", bi.W210961.isChecked() ? "961" : "-1");
        json.put("W210962", bi.W210962.isChecked() ? "962" : "-1");
        json.put("W210963", bi.W210963.isChecked() ? "963" : "-1");
        json.put("W210961x", bi.W210961x.getText().toString().trim().isEmpty() ? "-1" : bi.W210961x.getText().toString().trim());
        json.put("W210962x", bi.W210962x.getText().toString().trim().isEmpty() ? "-1" : bi.W210962x.getText().toString().trim());
        json.put("W210963x", bi.W210963x.getText().toString().trim().isEmpty() ? "-1" : bi.W210963x.getText().toString().trim());

        json.put("W211", bi.W21101.isChecked() ? "1"
                : bi.W21102.isChecked() ? "2"
                : bi.W21103.isChecked() ? "3"
                : bi.W21104.isChecked() ? "4"
                : bi.W21105.isChecked() ? "5"
                : "-1");

        json.put("W21201", bi.W21201.getText().toString().trim().isEmpty() ? "-1" : bi.W21201.getText().toString().trim());
        json.put("W21202", bi.W21202.getText().toString().trim().isEmpty() ? "-1" : bi.W21202.getText().toString().trim());

        json.put("W213", bi.W21301.isChecked() ? "1"
                : bi.W21302.isChecked() ? "2"
                : bi.W21398.isChecked() ? "98"
                : "-1");

        json.put("W214", bi.W21401.isChecked() ? "1"
                : bi.W21402.isChecked() ? "2"
                : bi.W21403.isChecked() ? "3"
                : bi.W21404.isChecked() ? "4"
                : bi.W21405.isChecked() ? "5"
                : bi.W21406.isChecked() ? "6"
                : bi.W21407.isChecked() ? "7"
                : bi.W21408.isChecked() ? "8"
                : bi.W21496.isChecked() ? "96"
                : "-1");
        json.put("W21496x", bi.W21496x.getText().toString().trim().isEmpty() ? "-1" : bi.W21496x.getText().toString().trim());

        json.put("W215961", bi.W215961.isChecked() ? "961" : "-1");
        json.put("W215962", bi.W215962.isChecked() ? "962" : "-1");
        json.put("W215963", bi.W215963.isChecked() ? "963" : "-1");
        json.put("W215961x", bi.W215961x.getText().toString().trim().isEmpty() ? "-1" : bi.W215961x.getText().toString().trim());
        json.put("W215962x", bi.W215962x.getText().toString().trim().isEmpty() ? "-1" : bi.W215962x.getText().toString().trim());
        json.put("W215963x", bi.W215963x.getText().toString().trim().isEmpty() ? "-1" : bi.W215963x.getText().toString().trim());

        json.put("W216", bi.W21601.isChecked() ? "1"
                : bi.W21602.isChecked() ? "2"
                : bi.W21603.isChecked() ? "3"
                : bi.W21604.isChecked() ? "4"
                : bi.W21605.isChecked() ? "5"
                : "-1");

        json.put("W21701", bi.W21701.getText().toString().trim().isEmpty() ? "-1" : bi.W21701.getText().toString().trim());
        json.put("W21702", bi.W21702.getText().toString().trim().isEmpty() ? "-1" : bi.W21702.getText().toString().trim());

        json.put("W218", bi.W21801.isChecked() ? "1"
                : bi.W21802.isChecked() ? "2"
                : bi.W21898.isChecked() ? "98"
                : "-1");

        json.put("W219", bi.W21901.isChecked() ? "1"
                : bi.W21902.isChecked() ? "2"
                : bi.W21998.isChecked() ? "98"
                : "-1");

        json.put("W220", bi.W22001.isChecked() ? "1"
                : bi.W22002.isChecked() ? "2"
                : bi.W22098.isChecked() ? "98"
                : "-1");

        json.put("W22101", bi.W22101.getText().toString().trim().isEmpty() ? "-1" : bi.W22101.getText().toString().trim());
        json.put("W22102", bi.W22102.getText().toString().trim().isEmpty() ? "-1" : bi.W22102.getText().toString().trim());
        json.put("W22198", bi.W22198.isChecked() ? "98" : "-1");

        json.put("W222", bi.W22201.isChecked() ? "1"
                : bi.W22202.isChecked() ? "2"
                : bi.W22203.isChecked() ? "3"
                : bi.W22204.isChecked() ? "4"
                : bi.W22205.isChecked() ? "5"
                : bi.W22296.isChecked() ? "96"
                : "-1");
        json.put("W22296x", bi.W22296x.getText().toString().trim().isEmpty() ? "-1" : bi.W22296x.getText().toString().trim());

        json.put("W223", bi.W22301.isChecked() ? "1"
                : bi.W22302.isChecked() ? "2"
                : bi.W22303.isChecked() ? "3"
                : bi.W22304.isChecked() ? "4"
                : bi.W22305.isChecked() ? "5"
                : bi.W22306.isChecked() ? "6"
                : bi.W22307.isChecked() ? "7"
                : bi.W22308.isChecked() ? "8"
                : bi.W22396.isChecked() ? "96"
                : "-1");
        json.put("W22396x", bi.W22396x.getText().toString().trim().isEmpty() ? "-1" : bi.W22396x.getText().toString().trim());

        json.put("W224", bi.W22401.isChecked() ? "1"
                : bi.W22402.isChecked() ? "2"
                : bi.W22403.isChecked() ? "3"
                : bi.W22404.isChecked() ? "4"
                : "-1");

        json.put("W225", bi.W22501.isChecked() ? "1"
                : bi.W22502.isChecked() ? "2"
                : "-1");

        json.put("W226", bi.W22601.isChecked() ? "1"
                : bi.W22602.isChecked() ? "2"
                : bi.W22603.isChecked() ? "3"
                : bi.W22604.isChecked() ? "4"
                : "-1");

        json.put("W227", bi.W22701.isChecked() ? "1"
                : bi.W22702.isChecked() ? "2"
                : bi.W22798.isChecked() ? "98"
                : "-1");

        json.put("W22801", bi.W22801.getText().toString().trim().isEmpty() ? "-1" : bi.W22801.getText().toString().trim());
        json.put("W22898", bi.W22898.isChecked() ? "98" : "-1");

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