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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityD102Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class D102 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;
    public String fuid;
    ActivityD102Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_d102);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");

        Toast.makeText(this, "D102: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
    }

    private void setupSkip() {

        //D112
        bi.D112.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11200.getId() ||
                    idChecked == bi.D11201.getId() ||
                    idChecked == bi.D11203.getId() ||
                    idChecked == bi.D11205.getId() ||
                    idChecked == bi.D11206.getId() ||
                    idChecked == bi.D11210.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11228);
                bi.fldGrpCVD11228.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11228.setVisibility(View.VISIBLE);
            }
        });

        //D113
        bi.D113.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11300.getId() ||
                    idChecked == bi.D11301.getId() ||
                    idChecked == bi.D11303.getId() ||
                    idChecked == bi.D11305.getId() ||
                    idChecked == bi.D11306.getId() ||
                    idChecked == bi.D11310.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11328);
                bi.fldGrpCVD11328.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11328.setVisibility(View.VISIBLE);
            }
        });

        //D114
        bi.D114.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11400.getId() ||
                    idChecked == bi.D11401.getId() ||
                    idChecked == bi.D11403.getId() ||
                    idChecked == bi.D11405.getId() ||
                    idChecked == bi.D11406.getId() ||
                    idChecked == bi.D11410.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11428);
                bi.fldGrpCVD11428.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11428.setVisibility(View.VISIBLE);
            }
        });

        //D115
        bi.D115.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11500.getId() ||
                    idChecked == bi.D11501.getId() ||
                    idChecked == bi.D11503.getId() ||
                    idChecked == bi.D11505.getId() ||
                    idChecked == bi.D11506.getId() ||
                    idChecked == bi.D11510.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11528);
                bi.fldGrpCVD11528.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11528.setVisibility(View.VISIBLE);
            }
        });

        //D116
        bi.D116.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11600.getId() ||
                    idChecked == bi.D11601.getId() ||
                    idChecked == bi.D11603.getId() ||
                    idChecked == bi.D11605.getId() ||
                    idChecked == bi.D11606.getId() ||
                    idChecked == bi.D11610.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11628);
                bi.fldGrpCVD11628.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11628.setVisibility(View.VISIBLE);
            }
        });

        //D117
        bi.D117.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11700.getId() ||
                    idChecked == bi.D11701.getId() ||
                    idChecked == bi.D11703.getId() ||
                    idChecked == bi.D11705.getId() ||
                    idChecked == bi.D11706.getId() ||
                    idChecked == bi.D11710.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11728);
                bi.fldGrpCVD11728.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11728.setVisibility(View.VISIBLE);
            }
        });

        //D118
        bi.D118.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11800.getId() ||
                    idChecked == bi.D11801.getId() ||
                    idChecked == bi.D11803.getId() ||
                    idChecked == bi.D11805.getId() ||
                    idChecked == bi.D11806.getId() ||
                    idChecked == bi.D11810.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11828);
                bi.fldGrpCVD11828.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11828.setVisibility(View.VISIBLE);
            }
        });

        //D118a
        bi.D118a.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D118a00.getId() ||
                    idChecked == bi.D118a01.getId() ||
                    idChecked == bi.D118a03.getId() ||
                    idChecked == bi.D118a05.getId() ||
                    idChecked == bi.D118a06.getId() ||
                    idChecked == bi.D118a10.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD118a28);
                bi.fldGrpCVD118a28.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD118a28.setVisibility(View.VISIBLE);
            }
        });

        //D119
        bi.D119.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D11900.getId() ||
                    idChecked == bi.D11901.getId() ||
                    idChecked == bi.D11903.getId() ||
                    idChecked == bi.D11905.getId() ||
                    idChecked == bi.D11906.getId() ||
                    idChecked == bi.D11910.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD11928);
                bi.fldGrpCVD11928.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD11928.setVisibility(View.VISIBLE);
            }
        });

        //D120
        bi.D120.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D12000.getId() ||
                    idChecked == bi.D12001.getId() ||
                    idChecked == bi.D12003.getId() ||
                    idChecked == bi.D12005.getId() ||
                    idChecked == bi.D12006.getId() ||
                    idChecked == bi.D12010.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD12028);
                bi.fldGrpCVD12028.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD12028.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, D103.class));
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

        json.put("D112", bi.D11200.isChecked() ? "0"
                : bi.D11201.isChecked() ? "1"
                : bi.D11202.isChecked() ? "2"
                : bi.D11203.isChecked() ? "3"
                : bi.D11204.isChecked() ? "4"
                : bi.D11205.isChecked() ? "5"
                : bi.D11206.isChecked() ? "6"
                : bi.D11207.isChecked() ? "7"
                : bi.D11208.isChecked() ? "8"
                : bi.D11209.isChecked() ? "9"
                : bi.D11210.isChecked() ? "10"
                : bi.D11299.isChecked() ? "99"
                : "-1");

        json.put("D11228", bi.D1122801.isChecked() ? "1"
                : bi.D1122802.isChecked() ? "2"
                : bi.D1122803.isChecked() ? "3"
                : bi.D1122898.isChecked() ? "98"
                : "-1");

        json.put("D113", bi.D11300.isChecked() ? "0"
                : bi.D11301.isChecked() ? "1"
                : bi.D11302.isChecked() ? "2"
                : bi.D11303.isChecked() ? "3"
                : bi.D11304.isChecked() ? "4"
                : bi.D11305.isChecked() ? "5"
                : bi.D11306.isChecked() ? "6"
                : bi.D11307.isChecked() ? "7"
                : bi.D11308.isChecked() ? "8"
                : bi.D11309.isChecked() ? "9"
                : bi.D11310.isChecked() ? "10"
                : bi.D11399.isChecked() ? "99"
                : "-1");

        json.put("D11328", bi.D1132801.isChecked() ? "1"
                : bi.D1132802.isChecked() ? "2"
                : bi.D1132803.isChecked() ? "3"
                : bi.D1132898.isChecked() ? "98"
                : "-1");

        json.put("D114", bi.D11400.isChecked() ? "0"
                : bi.D11401.isChecked() ? "1"
                : bi.D11402.isChecked() ? "2"
                : bi.D11403.isChecked() ? "3"
                : bi.D11404.isChecked() ? "4"
                : bi.D11405.isChecked() ? "5"
                : bi.D11406.isChecked() ? "6"
                : bi.D11407.isChecked() ? "7"
                : bi.D11408.isChecked() ? "8"
                : bi.D11409.isChecked() ? "9"
                : bi.D11410.isChecked() ? "10"
                : bi.D11499.isChecked() ? "99"
                : "-1");

        json.put("D11428", bi.D1142801.isChecked() ? "1"
                : bi.D1142802.isChecked() ? "2"
                : bi.D1142803.isChecked() ? "3"
                : bi.D1142898.isChecked() ? "98"
                : "-1");

        json.put("D115", bi.D11500.isChecked() ? "0"
                : bi.D11501.isChecked() ? "1"
                : bi.D11502.isChecked() ? "2"
                : bi.D11503.isChecked() ? "3"
                : bi.D11504.isChecked() ? "4"
                : bi.D11505.isChecked() ? "5"
                : bi.D11506.isChecked() ? "6"
                : bi.D11507.isChecked() ? "7"
                : bi.D11508.isChecked() ? "8"
                : bi.D11509.isChecked() ? "9"
                : bi.D11510.isChecked() ? "10"
                : bi.D11599.isChecked() ? "99"
                : "-1");

        json.put("D11528", bi.D1152801.isChecked() ? "1"
                : bi.D1152802.isChecked() ? "2"
                : bi.D1152803.isChecked() ? "3"
                : bi.D1152898.isChecked() ? "98"
                : "-1");

        json.put("D116", bi.D11600.isChecked() ? "0"
                : bi.D11601.isChecked() ? "1"
                : bi.D11602.isChecked() ? "2"
                : bi.D11603.isChecked() ? "3"
                : bi.D11604.isChecked() ? "4"
                : bi.D11605.isChecked() ? "5"
                : bi.D11606.isChecked() ? "6"
                : bi.D11607.isChecked() ? "7"
                : bi.D11608.isChecked() ? "8"
                : bi.D11609.isChecked() ? "9"
                : bi.D11610.isChecked() ? "10"
                : bi.D11699.isChecked() ? "99"
                : "-1");

        json.put("D11628", bi.D1162801.isChecked() ? "1"
                : bi.D1162802.isChecked() ? "2"
                : bi.D1162803.isChecked() ? "3"
                : bi.D1162898.isChecked() ? "98"
                : "-1");

        json.put("D117", bi.D11700.isChecked() ? "0"
                : bi.D11701.isChecked() ? "1"
                : bi.D11702.isChecked() ? "2"
                : bi.D11703.isChecked() ? "3"
                : bi.D11704.isChecked() ? "4"
                : bi.D11705.isChecked() ? "5"
                : bi.D11706.isChecked() ? "6"
                : bi.D11707.isChecked() ? "7"
                : bi.D11708.isChecked() ? "8"
                : bi.D11709.isChecked() ? "9"
                : bi.D11710.isChecked() ? "10"
                : bi.D11799.isChecked() ? "99"
                : "-1");

        json.put("D11728", bi.D1172801.isChecked() ? "1"
                : bi.D1172802.isChecked() ? "2"
                : bi.D1172803.isChecked() ? "3"
                : bi.D1172898.isChecked() ? "98"
                : "-1");

        json.put("D118", bi.D11800.isChecked() ? "0"
                : bi.D11801.isChecked() ? "1"
                : bi.D11802.isChecked() ? "2"
                : bi.D11803.isChecked() ? "3"
                : bi.D11804.isChecked() ? "4"
                : bi.D11805.isChecked() ? "5"
                : bi.D11806.isChecked() ? "6"
                : bi.D11807.isChecked() ? "7"
                : bi.D11808.isChecked() ? "8"
                : bi.D11809.isChecked() ? "9"
                : bi.D11810.isChecked() ? "10"
                : bi.D11899.isChecked() ? "99"
                : "-1");

        json.put("D11828", bi.D1182801.isChecked() ? "1"
                : bi.D1182802.isChecked() ? "2"
                : bi.D1182803.isChecked() ? "3"
                : bi.D1182898.isChecked() ? "98"
                : "-1");

        json.put("D118a", bi.D118a00.isChecked() ? "0"
                : bi.D118a01.isChecked() ? "1"
                : bi.D118a02.isChecked() ? "2"
                : bi.D118a03.isChecked() ? "3"
                : bi.D118a04.isChecked() ? "4"
                : bi.D118a05.isChecked() ? "5"
                : bi.D118a06.isChecked() ? "6"
                : bi.D118a07.isChecked() ? "7"
                : bi.D118a08.isChecked() ? "8"
                : bi.D118a09.isChecked() ? "9"
                : bi.D118a10.isChecked() ? "10"
                : bi.D118a99.isChecked() ? "99"
                : "-1");

        json.put("D118a28", bi.D118a2801.isChecked() ? "1"
                : bi.D118a2802.isChecked() ? "2"
                : bi.D118a2803.isChecked() ? "3"
                : bi.D118a2898.isChecked() ? "98"
                : "-1");

        json.put("D119", bi.D11900.isChecked() ? "0"
                : bi.D11901.isChecked() ? "1"
                : bi.D11902.isChecked() ? "2"
                : bi.D11903.isChecked() ? "3"
                : bi.D11904.isChecked() ? "4"
                : bi.D11905.isChecked() ? "5"
                : bi.D11906.isChecked() ? "6"
                : bi.D11907.isChecked() ? "7"
                : bi.D11908.isChecked() ? "8"
                : bi.D11909.isChecked() ? "9"
                : bi.D11910.isChecked() ? "10"
                : bi.D11999.isChecked() ? "99"
                : "-1");

        json.put("D11928", bi.D1192801.isChecked() ? "1"
                : bi.D1192802.isChecked() ? "2"
                : bi.D1192803.isChecked() ? "3"
                : bi.D1192898.isChecked() ? "98"
                : "-1");

        json.put("D120", bi.D12000.isChecked() ? "0"
                : bi.D12001.isChecked() ? "1"
                : bi.D12002.isChecked() ? "2"
                : bi.D12003.isChecked() ? "3"
                : bi.D12004.isChecked() ? "4"
                : bi.D12005.isChecked() ? "5"
                : bi.D12006.isChecked() ? "6"
                : bi.D12007.isChecked() ? "7"
                : bi.D12008.isChecked() ? "8"
                : bi.D12009.isChecked() ? "9"
                : bi.D12010.isChecked() ? "10"
                : bi.D12099.isChecked() ? "99"
                : "-1");

        json.put("D12028", bi.D1202801.isChecked() ? "1"
                : bi.D1202802.isChecked() ? "2"
                : bi.D1202803.isChecked() ? "3"
                : bi.D1202898.isChecked() ? "98"
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