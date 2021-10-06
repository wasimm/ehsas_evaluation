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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityD103Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class D103 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;
    public String fuid;
    ActivityD103Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_d103);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");
    }

    private void setupSkip() {

        //D121
        bi.D121.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D12100.getId() ||
                    idChecked == bi.D12101.getId() ||
                    idChecked == bi.D12103.getId() ||
                    idChecked == bi.D12105.getId() ||
                    idChecked == bi.D12106.getId() ||
                    idChecked == bi.D12110.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD12128);
                bi.fldGrpCVD12128.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD12128.setVisibility(View.VISIBLE);
            }
        });

        //D122
        bi.D122.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D12200.getId() ||
                    idChecked == bi.D12201.getId() ||
                    idChecked == bi.D12203.getId() ||
                    idChecked == bi.D12205.getId() ||
                    idChecked == bi.D12206.getId() ||
                    idChecked == bi.D12210.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD12228);
                bi.fldGrpCVD12228.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD12228.setVisibility(View.VISIBLE);
            }
        });

        //D123
        bi.D123.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D12300.getId() ||
                    idChecked == bi.D12301.getId() ||
                    idChecked == bi.D12303.getId() ||
                    idChecked == bi.D12305.getId() ||
                    idChecked == bi.D12306.getId() ||
                    idChecked == bi.D12310.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD12328);
                bi.fldGrpCVD12328.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD12328.setVisibility(View.VISIBLE);
            }
        });

        //D124
        bi.D124.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D12400.getId() ||
                    idChecked == bi.D12401.getId() ||
                    idChecked == bi.D12403.getId() ||
                    idChecked == bi.D12405.getId() ||
                    idChecked == bi.D12406.getId() ||
                    idChecked == bi.D12410.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD12428);
                bi.fldGrpCVD12428.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD12428.setVisibility(View.VISIBLE);
            }
        });

        //D125
        bi.D125.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D12500.getId() ||
                    idChecked == bi.D12501.getId() ||
                    idChecked == bi.D12503.getId() ||
                    idChecked == bi.D12505.getId() ||
                    idChecked == bi.D12506.getId() ||
                    idChecked == bi.D12510.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD12528);
                bi.fldGrpCVD12528.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD12528.setVisibility(View.VISIBLE);
            }
        });

        //D126
        bi.D126.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D12600.getId() ||
                    idChecked == bi.D12601.getId() ||
                    idChecked == bi.D12603.getId() ||
                    idChecked == bi.D12605.getId() ||
                    idChecked == bi.D12606.getId() ||
                    idChecked == bi.D12610.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD12628);
                bi.fldGrpCVD12628.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD12628.setVisibility(View.VISIBLE);
            }
        });

        //D127
        bi.D127.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.D12700.getId() ||
                    idChecked == bi.D12701.getId() ||
                    idChecked == bi.D12703.getId() ||
                    idChecked == bi.D12705.getId() ||
                    idChecked == bi.D12706.getId() ||
                    idChecked == bi.D12710.getId()) {

                Clear.clearAllFields(bi.fldGrpCVD12728);
                bi.fldGrpCVD12728.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVD12728.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, D2.class));
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

        json.put("D121", bi.D12100.isChecked() ? "0"
                : bi.D12101.isChecked() ? "1"
                : bi.D12102.isChecked() ? "2"
                : bi.D12103.isChecked() ? "3"
                : bi.D12104.isChecked() ? "4"
                : bi.D12105.isChecked() ? "5"
                : bi.D12106.isChecked() ? "6"
                : bi.D12107.isChecked() ? "7"
                : bi.D12108.isChecked() ? "8"
                : bi.D12109.isChecked() ? "9"
                : bi.D12110.isChecked() ? "10"
                : bi.D12199.isChecked() ? "99"
                : "-1");

        json.put("D12128", bi.D1212801.isChecked() ? "1"
                : bi.D1212802.isChecked() ? "2"
                : bi.D1212803.isChecked() ? "3"
                : bi.D1212898.isChecked() ? "98"
                : "-1");

        json.put("D122", bi.D12200.isChecked() ? "0"
                : bi.D12201.isChecked() ? "1"
                : bi.D12202.isChecked() ? "2"
                : bi.D12203.isChecked() ? "3"
                : bi.D12204.isChecked() ? "4"
                : bi.D12205.isChecked() ? "5"
                : bi.D12206.isChecked() ? "6"
                : bi.D12207.isChecked() ? "7"
                : bi.D12208.isChecked() ? "8"
                : bi.D12209.isChecked() ? "9"
                : bi.D12210.isChecked() ? "10"
                : bi.D12299.isChecked() ? "99"
                : "-1");

        json.put("D12228", bi.D1222801.isChecked() ? "1"
                : bi.D1222802.isChecked() ? "2"
                : bi.D1222803.isChecked() ? "3"
                : bi.D1222898.isChecked() ? "98"
                : "-1");

        json.put("D123", bi.D12300.isChecked() ? "0"
                : bi.D12301.isChecked() ? "1"
                : bi.D12302.isChecked() ? "2"
                : bi.D12303.isChecked() ? "3"
                : bi.D12304.isChecked() ? "4"
                : bi.D12305.isChecked() ? "5"
                : bi.D12306.isChecked() ? "6"
                : bi.D12307.isChecked() ? "7"
                : bi.D12308.isChecked() ? "8"
                : bi.D12309.isChecked() ? "9"
                : bi.D12310.isChecked() ? "10"
                : bi.D12399.isChecked() ? "99"
                : "-1");

        json.put("D12328", bi.D1232801.isChecked() ? "1"
                : bi.D1232802.isChecked() ? "2"
                : bi.D1232803.isChecked() ? "3"
                : bi.D1232898.isChecked() ? "98"
                : "-1");

        json.put("D124", bi.D12400.isChecked() ? "0"
                : bi.D12401.isChecked() ? "1"
                : bi.D12402.isChecked() ? "2"
                : bi.D12403.isChecked() ? "3"
                : bi.D12404.isChecked() ? "4"
                : bi.D12405.isChecked() ? "5"
                : bi.D12406.isChecked() ? "6"
                : bi.D12407.isChecked() ? "7"
                : bi.D12408.isChecked() ? "8"
                : bi.D12409.isChecked() ? "9"
                : bi.D12410.isChecked() ? "10"
                : bi.D12499.isChecked() ? "99"
                : "-1");

        json.put("D12428", bi.D1242801.isChecked() ? "1"
                : bi.D1242802.isChecked() ? "2"
                : bi.D1242803.isChecked() ? "3"
                : bi.D1242898.isChecked() ? "98"
                : "-1");

        json.put("D125", bi.D12500.isChecked() ? "0"
                : bi.D12501.isChecked() ? "1"
                : bi.D12502.isChecked() ? "2"
                : bi.D12503.isChecked() ? "3"
                : bi.D12504.isChecked() ? "4"
                : bi.D12505.isChecked() ? "5"
                : bi.D12506.isChecked() ? "6"
                : bi.D12507.isChecked() ? "7"
                : bi.D12508.isChecked() ? "8"
                : bi.D12509.isChecked() ? "9"
                : bi.D12510.isChecked() ? "10"
                : bi.D12599.isChecked() ? "99"
                : "-1");

        json.put("D12528", bi.D1252801.isChecked() ? "1"
                : bi.D1252802.isChecked() ? "2"
                : bi.D1252803.isChecked() ? "3"
                : bi.D1252898.isChecked() ? "98"
                : "-1");

        json.put("D126", bi.D12600.isChecked() ? "0"
                : bi.D12601.isChecked() ? "1"
                : bi.D12602.isChecked() ? "2"
                : bi.D12603.isChecked() ? "3"
                : bi.D12604.isChecked() ? "4"
                : bi.D12605.isChecked() ? "5"
                : bi.D12606.isChecked() ? "6"
                : bi.D12607.isChecked() ? "7"
                : bi.D12608.isChecked() ? "8"
                : bi.D12609.isChecked() ? "9"
                : bi.D12610.isChecked() ? "10"
                : bi.D12699.isChecked() ? "99"
                : "-1");

        json.put("D12628", bi.D1262801.isChecked() ? "1"
                : bi.D1262802.isChecked() ? "2"
                : bi.D1262803.isChecked() ? "3"
                : bi.D1262898.isChecked() ? "98"
                : "-1");

        json.put("D127", bi.D12700.isChecked() ? "0"
                : bi.D12701.isChecked() ? "1"
                : bi.D12702.isChecked() ? "2"
                : bi.D12703.isChecked() ? "3"
                : bi.D12704.isChecked() ? "4"
                : bi.D12705.isChecked() ? "5"
                : bi.D12706.isChecked() ? "6"
                : bi.D12707.isChecked() ? "7"
                : bi.D12708.isChecked() ? "8"
                : bi.D12709.isChecked() ? "9"
                : bi.D12710.isChecked() ? "10"
                : bi.D12799.isChecked() ? "99"
                : "-1");

        json.put("D12728", bi.D1272801.isChecked() ? "1"
                : bi.D1272802.isChecked() ? "2"
                : bi.D1272803.isChecked() ? "3"
                : bi.D1272898.isChecked() ? "98"
                : "-1");

        json.put("D128", bi.D12801.isChecked() ? "1"
                : bi.D12802.isChecked() ? "2"
                : bi.D12803.isChecked() ? "3"
                : bi.D12898.isChecked() ? "98"
                : "-1");

        json.put("D129", bi.D12901.isChecked() ? "1"
                : bi.D12902.isChecked() ? "2"
                : "-1");

        json.put("D130", bi.D13001.isChecked() ? "1"
                : bi.D13002.isChecked() ? "2"
                : "-1");

        json.put("D131", bi.D13101.isChecked() ? "1"
                : bi.D13102.isChecked() ? "2"
                : "-1");

        json.put("D132", bi.D132.getText().toString().trim().isEmpty() ? "-1" : bi.D132.getText().toString().trim());

        json.put("D133", bi.D13301.isChecked() ? "1"
                : bi.D13302.isChecked() ? "2"
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