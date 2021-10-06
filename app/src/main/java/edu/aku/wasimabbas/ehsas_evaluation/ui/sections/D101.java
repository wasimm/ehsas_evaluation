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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityD101Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class D101 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;
    public String fuid;
    ActivityD101Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_d101);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");
    }

    private void setupSkip() {

        //D101
        bi.D101.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10100.getId() ||
                    idChecked == bi.D10101.getId() ||
                    idChecked == bi.D10103.getId() ||
                    idChecked == bi.D10105.getId() ||
                    idChecked == bi.D10106.getId() ||
                    idChecked == bi.D10110.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10128);
                bi.fldGrpCVD10128.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10128.setVisibility(View.VISIBLE);
            }
        });

        //D102
        bi.D102.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10200.getId() ||
                    idChecked == bi.D10201.getId() ||
                    idChecked == bi.D10203.getId() ||
                    idChecked == bi.D10205.getId() ||
                    idChecked == bi.D10206.getId() ||
                    idChecked == bi.D10210.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10228);
                bi.fldGrpCVD10228.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10228.setVisibility(View.VISIBLE);
            }
        });

        //D103
        bi.D103.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10300.getId() ||
                    idChecked == bi.D10301.getId() ||
                    idChecked == bi.D10303.getId() ||
                    idChecked == bi.D10305.getId() ||
                    idChecked == bi.D10306.getId() ||
                    idChecked == bi.D10310.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10328);
                bi.fldGrpCVD10328.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10328.setVisibility(View.VISIBLE);
            }
        });

        //D104
        bi.D104.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10400.getId() ||
                    idChecked == bi.D10401.getId() ||
                    idChecked == bi.D10403.getId() ||
                    idChecked == bi.D10405.getId() ||
                    idChecked == bi.D10406.getId() ||
                    idChecked == bi.D10410.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10428);
                bi.fldGrpCVD10428.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10428.setVisibility(View.VISIBLE);
            }
        });

        //D105
        bi.D105.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10500.getId() ||
                    idChecked == bi.D10501.getId() ||
                    idChecked == bi.D10503.getId() ||
                    idChecked == bi.D10505.getId() ||
                    idChecked == bi.D10506.getId() ||
                    idChecked == bi.D10510.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10528);
                bi.fldGrpCVD10528.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10528.setVisibility(View.VISIBLE);
            }
        });

        //D106
        bi.D106.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10600.getId() ||
                    idChecked == bi.D10601.getId() ||
                    idChecked == bi.D10603.getId() ||
                    idChecked == bi.D10605.getId() ||
                    idChecked == bi.D10606.getId() ||
                    idChecked == bi.D10610.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10628);
                bi.fldGrpCVD10628.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10628.setVisibility(View.VISIBLE);
            }
        });

        //D107
        bi.D107.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10700.getId() ||
                    idChecked == bi.D10701.getId() ||
                    idChecked == bi.D10703.getId() ||
                    idChecked == bi.D10705.getId() ||
                    idChecked == bi.D10706.getId() ||
                    idChecked == bi.D10710.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10728);
                bi.fldGrpCVD10728.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10728.setVisibility(View.VISIBLE);
            }
        });

        //D108
        bi.D108.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10800.getId() ||
                    idChecked == bi.D10801.getId() ||
                    idChecked == bi.D10803.getId() ||
                    idChecked == bi.D10805.getId() ||
                    idChecked == bi.D10806.getId() ||
                    idChecked == bi.D10810.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10828);
                bi.fldGrpCVD10828.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10828.setVisibility(View.VISIBLE);
            }
        });

        //D109
        bi.D109.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D10900.getId() ||
                    idChecked == bi.D10901.getId() ||
                    idChecked == bi.D10903.getId() ||
                    idChecked == bi.D10905.getId() ||
                    idChecked == bi.D10906.getId() ||
                    idChecked == bi.D10910.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD10928);
                bi.fldGrpCVD10928.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD10928.setVisibility(View.VISIBLE);
            }
        });

        //D110
        bi.D110.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11000.getId() ||
                    idChecked == bi.D11001.getId() ||
                    idChecked == bi.D11003.getId() ||
                    idChecked == bi.D11005.getId() ||
                    idChecked == bi.D11006.getId() ||
                    idChecked == bi.D11010.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11028);
                bi.fldGrpCVD11028.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11028.setVisibility(View.VISIBLE);
            }
        });

        //D111
        bi.D111.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11100.getId() ||
                    idChecked == bi.D11101.getId() ||
                    idChecked == bi.D11103.getId() ||
                    idChecked == bi.D11105.getId() ||
                    idChecked == bi.D11106.getId() ||
                    idChecked == bi.D11110.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11128);
                bi.fldGrpCVD11128.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11128.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, D102.class));
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

        json.put("D101", bi.D10100.isChecked() ? "0"
                : bi.D10101.isChecked() ? "1"
                : bi.D10102.isChecked() ? "2"
                : bi.D10103.isChecked() ? "3"
                : bi.D10104.isChecked() ? "4"
                : bi.D10105.isChecked() ? "5"
                : bi.D10106.isChecked() ? "6"
                : bi.D10107.isChecked() ? "7"
                : bi.D10108.isChecked() ? "8"
                : bi.D10109.isChecked() ? "9"
                : bi.D10110.isChecked() ? "10"
                : bi.D10199.isChecked() ? "99"
                : "-1");

        json.put("D10128", bi.D1012801.isChecked() ? "1"
                : bi.D1012802.isChecked() ? "2"
                : bi.D1012803.isChecked() ? "3"
                : bi.D1012898.isChecked() ? "98"
                : "-1");

        json.put("D102", bi.D10200.isChecked() ? "0"
                : bi.D10201.isChecked() ? "1"
                : bi.D10202.isChecked() ? "2"
                : bi.D10203.isChecked() ? "3"
                : bi.D10204.isChecked() ? "4"
                : bi.D10205.isChecked() ? "5"
                : bi.D10206.isChecked() ? "6"
                : bi.D10207.isChecked() ? "7"
                : bi.D10208.isChecked() ? "8"
                : bi.D10209.isChecked() ? "9"
                : bi.D10210.isChecked() ? "10"
                : bi.D10299.isChecked() ? "99"
                : "-1");

        json.put("D10228", bi.D1022801.isChecked() ? "1"
                : bi.D1022802.isChecked() ? "2"
                : bi.D1022803.isChecked() ? "3"
                : bi.D1022898.isChecked() ? "98"
                : "-1");

        json.put("D103", bi.D10300.isChecked() ? "0"
                : bi.D10301.isChecked() ? "1"
                : bi.D10302.isChecked() ? "2"
                : bi.D10303.isChecked() ? "3"
                : bi.D10304.isChecked() ? "4"
                : bi.D10305.isChecked() ? "5"
                : bi.D10306.isChecked() ? "6"
                : bi.D10307.isChecked() ? "7"
                : bi.D10308.isChecked() ? "8"
                : bi.D10309.isChecked() ? "9"
                : bi.D10310.isChecked() ? "10"
                : bi.D10399.isChecked() ? "99"
                : "-1");

        json.put("D10328", bi.D1032801.isChecked() ? "1"
                : bi.D1032802.isChecked() ? "2"
                : bi.D1032803.isChecked() ? "3"
                : bi.D1032898.isChecked() ? "98"
                : "-1");

        json.put("D104", bi.D10400.isChecked() ? "0"
                : bi.D10401.isChecked() ? "1"
                : bi.D10402.isChecked() ? "2"
                : bi.D10403.isChecked() ? "3"
                : bi.D10404.isChecked() ? "4"
                : bi.D10405.isChecked() ? "5"
                : bi.D10406.isChecked() ? "6"
                : bi.D10407.isChecked() ? "7"
                : bi.D10408.isChecked() ? "8"
                : bi.D10409.isChecked() ? "9"
                : bi.D10410.isChecked() ? "10"
                : bi.D10499.isChecked() ? "99"
                : "-1");

        json.put("D10428", bi.D1042801.isChecked() ? "1"
                : bi.D1042802.isChecked() ? "2"
                : bi.D1042803.isChecked() ? "3"
                : bi.D1042898.isChecked() ? "98"
                : "-1");

        json.put("D105", bi.D10500.isChecked() ? "0"
                : bi.D10501.isChecked() ? "1"
                : bi.D10502.isChecked() ? "2"
                : bi.D10503.isChecked() ? "3"
                : bi.D10504.isChecked() ? "4"
                : bi.D10505.isChecked() ? "5"
                : bi.D10506.isChecked() ? "6"
                : bi.D10507.isChecked() ? "7"
                : bi.D10508.isChecked() ? "8"
                : bi.D10509.isChecked() ? "9"
                : bi.D10510.isChecked() ? "10"
                : bi.D10599.isChecked() ? "99"
                : "-1");

        json.put("D10528", bi.D1052801.isChecked() ? "1"
                : bi.D1052802.isChecked() ? "2"
                : bi.D1052803.isChecked() ? "3"
                : bi.D1052898.isChecked() ? "98"
                : "-1");

        json.put("D106", bi.D10600.isChecked() ? "0"
                : bi.D10601.isChecked() ? "1"
                : bi.D10602.isChecked() ? "2"
                : bi.D10603.isChecked() ? "3"
                : bi.D10604.isChecked() ? "4"
                : bi.D10605.isChecked() ? "5"
                : bi.D10606.isChecked() ? "6"
                : bi.D10607.isChecked() ? "7"
                : bi.D10608.isChecked() ? "8"
                : bi.D10609.isChecked() ? "9"
                : bi.D10610.isChecked() ? "10"
                : bi.D10699.isChecked() ? "99"
                : "-1");

        json.put("D10628", bi.D1062801.isChecked() ? "1"
                : bi.D1062802.isChecked() ? "2"
                : bi.D1062803.isChecked() ? "3"
                : bi.D1062898.isChecked() ? "98"
                : "-1");

        json.put("D107", bi.D10700.isChecked() ? "0"
                : bi.D10701.isChecked() ? "1"
                : bi.D10702.isChecked() ? "2"
                : bi.D10703.isChecked() ? "3"
                : bi.D10704.isChecked() ? "4"
                : bi.D10705.isChecked() ? "5"
                : bi.D10706.isChecked() ? "6"
                : bi.D10707.isChecked() ? "7"
                : bi.D10708.isChecked() ? "8"
                : bi.D10709.isChecked() ? "9"
                : bi.D10710.isChecked() ? "10"
                : bi.D10799.isChecked() ? "99"
                : "-1");

        json.put("D10728", bi.D1072801.isChecked() ? "1"
                : bi.D1072802.isChecked() ? "2"
                : bi.D1072803.isChecked() ? "3"
                : bi.D1072898.isChecked() ? "98"
                : "-1");

        json.put("D108", bi.D10800.isChecked() ? "0"
                : bi.D10801.isChecked() ? "1"
                : bi.D10802.isChecked() ? "2"
                : bi.D10803.isChecked() ? "3"
                : bi.D10804.isChecked() ? "4"
                : bi.D10805.isChecked() ? "5"
                : bi.D10806.isChecked() ? "6"
                : bi.D10807.isChecked() ? "7"
                : bi.D10808.isChecked() ? "8"
                : bi.D10809.isChecked() ? "9"
                : bi.D10810.isChecked() ? "10"
                : bi.D10899.isChecked() ? "99"
                : "-1");

        json.put("D10828", bi.D1082801.isChecked() ? "1"
                : bi.D1082802.isChecked() ? "2"
                : bi.D1082803.isChecked() ? "3"
                : bi.D1082898.isChecked() ? "98"
                : "-1");

        json.put("D109", bi.D10900.isChecked() ? "0"
                : bi.D10901.isChecked() ? "1"
                : bi.D10902.isChecked() ? "2"
                : bi.D10903.isChecked() ? "3"
                : bi.D10904.isChecked() ? "4"
                : bi.D10905.isChecked() ? "5"
                : bi.D10906.isChecked() ? "6"
                : bi.D10907.isChecked() ? "7"
                : bi.D10908.isChecked() ? "8"
                : bi.D10909.isChecked() ? "9"
                : bi.D10910.isChecked() ? "10"
                : bi.D10999.isChecked() ? "99"
                : "-1");

        json.put("D10928", bi.D1092801.isChecked() ? "1"
                : bi.D1092802.isChecked() ? "2"
                : bi.D1092803.isChecked() ? "3"
                : bi.D1092898.isChecked() ? "98"
                : "-1");

        json.put("D110", bi.D11000.isChecked() ? "0"
                : bi.D11001.isChecked() ? "1"
                : bi.D11002.isChecked() ? "2"
                : bi.D11003.isChecked() ? "3"
                : bi.D11004.isChecked() ? "4"
                : bi.D11005.isChecked() ? "5"
                : bi.D11006.isChecked() ? "6"
                : bi.D11007.isChecked() ? "7"
                : bi.D11008.isChecked() ? "8"
                : bi.D11009.isChecked() ? "9"
                : bi.D11010.isChecked() ? "10"
                : bi.D11099.isChecked() ? "99"
                : "-1");

        json.put("D11028", bi.D1102801.isChecked() ? "1"
                : bi.D1102802.isChecked() ? "2"
                : bi.D1102803.isChecked() ? "3"
                : bi.D1102898.isChecked() ? "98"
                : "-1");

        json.put("D111", bi.D11100.isChecked() ? "0"
                : bi.D11101.isChecked() ? "1"
                : bi.D11102.isChecked() ? "2"
                : bi.D11103.isChecked() ? "3"
                : bi.D11104.isChecked() ? "4"
                : bi.D11105.isChecked() ? "5"
                : bi.D11106.isChecked() ? "6"
                : bi.D11107.isChecked() ? "7"
                : bi.D11108.isChecked() ? "8"
                : bi.D11109.isChecked() ? "9"
                : bi.D11110.isChecked() ? "10"
                : bi.D11199.isChecked() ? "99"
                : "-1");

        json.put("D11128", bi.D1112801.isChecked() ? "1"
                : bi.D1112802.isChecked() ? "2"
                : bi.D1112803.isChecked() ? "3"
                : bi.D1112898.isChecked() ? "98"
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
}