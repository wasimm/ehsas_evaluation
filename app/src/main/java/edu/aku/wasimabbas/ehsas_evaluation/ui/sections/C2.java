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
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleChildrenContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityC2Binding;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class C2 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;
    public String fuid;
    ActivityC2Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_c2);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");

        Toast.makeText(this, "C2: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
    }


    private void setupSkip() {

        //C201
        bi.C201.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C20102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC202);
                bi.fldGrpCVC202.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC202.setVisibility(View.VISIBLE);
            }
        });

        //C206B
        bi.C206B.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C206B02.getId() || idChecked == bi.C206B98.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC206C);
                bi.fldGrpCVC206C.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC206C.setVisibility(View.VISIBLE);
            }
        });

        //C206D
        bi.C206D.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C206D02.getId() || idChecked == bi.C206D98.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC206E);
                bi.fldGrpCVC206E.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC206F);
                bi.fldGrpCVC206F.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC206E.setVisibility(View.VISIBLE);
                bi.fldGrpCVC206F.setVisibility(View.VISIBLE);
            }
        });

        //C206G
        bi.C206G.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C206G02.getId() || idChecked == bi.C206G98.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC206H);
                bi.fldGrpCVC206H.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC206I);
                bi.fldGrpCVC206I.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC206H.setVisibility(View.VISIBLE);
                bi.fldGrpCVC206I.setVisibility(View.VISIBLE);
            }
        });

        //C206M
        bi.C206M.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C206M02.getId() || idChecked == bi.C206M98.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC206N);
                bi.fldGrpCVC206N.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC206N.setVisibility(View.VISIBLE);
            }
        });

        //C206P
        bi.C206P.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C206P02.getId() || idChecked == bi.C206P98.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC206Q);
                bi.fldGrpCVC206Q.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC206Q.setVisibility(View.VISIBLE);
            }
        });

        //C207A
        bi.C207A.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C207A02.getId() || idChecked == bi.C207A98.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC207B);
                bi.fldGrpCVC207B.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC207B.setVisibility(View.VISIBLE);
            }
        });

        //C207R
        bi.C207R.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C207R01.getId()
                    || bi.C207A01.isChecked()
                    || bi.C207C01.isChecked()
                    || bi.C207D01.isChecked()
                    || bi.C207E01.isChecked()
                    || bi.C207F01.isChecked()
                    || bi.C207G01.isChecked()
                    || bi.C207H01.isChecked()
                    || bi.C207I01.isChecked()
                    || bi.C207J01.isChecked()
                    || bi.C207K01.isChecked()
                    || bi.C207L01.isChecked()
                    || bi.C207M01.isChecked()
                    || bi.C207N01.isChecked()
                    || bi.C207O01.isChecked()
                    || bi.C207P01.isChecked()
                    || bi.C207Q01.isChecked()) {

                bi.fldGrpCVC208.setVisibility(View.VISIBLE);
            } else {

                Clear.clearAllFields(bi.fldGrpCVC208);
                bi.fldGrpCVC208.setVisibility(View.GONE);
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
            startActivity(new Intent(this, C3.class).putExtra("id", id).putExtra("uid", uid));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        MainApp.openEndActivity(this);
    }

    private boolean UpdateDB() {

        db = new DatabaseHelper(this);

        int updcount = db.updatesChildColumn(EligibleChildrenContract.ChildrenTable.COLUMN_JSON, MainApp.child.getJSON());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("C201", bi.C20101.isChecked() ? "1"
                : bi.C20102.isChecked() ? "2"
                : "-1");

        json.put("C202", bi.C20200.isChecked() ? "000"
                : bi.C20201.isChecked() ? "1"
                : bi.C20202.isChecked() ? "2"
                : "-1");
        json.put("C20201x", bi.C20201x.getText().toString().trim().isEmpty() ? "-1" : bi.C20201x.getText().toString().trim());
        json.put("C20202x", bi.C20202x.getText().toString().trim().isEmpty() ? "-1" : bi.C20202x.getText().toString().trim());

        json.put("C203", bi.C20301.isChecked() ? "1"
                : bi.C20302.isChecked() ? "2"
                : "-1");

        json.put("C204", bi.C20401.isChecked() ? "1"
                : bi.C20402.isChecked() ? "2"
                : bi.C20498.isChecked() ? "98"
                : "-1");

        json.put("C205", bi.C20501.isChecked() ? "1"
                : bi.C20502.isChecked() ? "2"
                : bi.C20598.isChecked() ? "98"
                : "-1");

        json.put("C206A", bi.C206A01.isChecked() ? "1"
                : bi.C206A02.isChecked() ? "2"
                : bi.C206A98.isChecked() ? "98"
                : "-1");

        json.put("C206B", bi.C206B01.isChecked() ? "1"
                : bi.C206B02.isChecked() ? "2"
                : bi.C206B98.isChecked() ? "98"
                : "-1");

        json.put("C206C", bi.C206C.getText().toString().trim().isEmpty() ? "-1" : bi.C206C.getText().toString().trim());

        json.put("C206D", bi.C206D01.isChecked() ? "1"
                : bi.C206D02.isChecked() ? "2"
                : bi.C206D98.isChecked() ? "98"
                : "-1");

        json.put("C206E", bi.C206E.getText().toString().trim().isEmpty() ? "-1" : bi.C206E.getText().toString().trim());

        json.put("C206F", bi.C206F01.isChecked() ? "1"
                : bi.C206F02.isChecked() ? "2"
                : bi.C206F98.isChecked() ? "98"
                : "-1");

        json.put("C206G", bi.C206G01.isChecked() ? "1"
                : bi.C206G02.isChecked() ? "2"
                : bi.C206G98.isChecked() ? "98"
                : "-1");

        json.put("C206H", bi.C206H.getText().toString().trim().isEmpty() ? "-1" : bi.C206H.getText().toString().trim());

        json.put("C206I", bi.C206I01.isChecked() ? "1"
                : bi.C206I02.isChecked() ? "2"
                : bi.C206I98.isChecked() ? "98"
                : "-1");

        json.put("C206J", bi.C206J01.isChecked() ? "1"
                : bi.C206J02.isChecked() ? "2"
                : bi.C206J98.isChecked() ? "98"
                : "-1");

        json.put("C206K", bi.C206K01.isChecked() ? "1"
                : bi.C206K02.isChecked() ? "2"
                : bi.C206K98.isChecked() ? "98"
                : "-1");

        json.put("C206L", bi.C206L01.isChecked() ? "1"
                : bi.C206L02.isChecked() ? "2"
                : bi.C206L98.isChecked() ? "98"
                : "-1");

        json.put("C206M", bi.C206M01.isChecked() ? "1"
                : bi.C206M02.isChecked() ? "2"
                : bi.C206M98.isChecked() ? "98"
                : "-1");

        json.put("C206N", bi.C206N01.isChecked() ? "1"
                : bi.C206N02.isChecked() ? "2"
                : bi.C206N98.isChecked() ? "98"
                : "-1");

        json.put("C206O", bi.C206O01.isChecked() ? "1"
                : bi.C206O02.isChecked() ? "2"
                : bi.C206O98.isChecked() ? "98"
                : "-1");

        json.put("C206P", bi.C206P01.isChecked() ? "1"
                : bi.C206P02.isChecked() ? "2"
                : bi.C206P98.isChecked() ? "98"
                : "-1");
        json.put("C206Q", bi.C206Q.getText().toString().trim().isEmpty() ? "-1" : bi.C206Q.getText().toString().trim());

        json.put("C207A", bi.C207A01.isChecked() ? "1"
                : bi.C207A02.isChecked() ? "2"
                : bi.C207A98.isChecked() ? "98"
                : "-1");

        json.put("C207B", bi.C207B.getText().toString().trim().isEmpty() ? "-1" : bi.C207B.getText().toString().trim());

        json.put("C207C", bi.C207C01.isChecked() ? "1"
                : bi.C207C02.isChecked() ? "2"
                : bi.C207C98.isChecked() ? "98"
                : "-1");

        json.put("C207D", bi.C207D01.isChecked() ? "1"
                : bi.C207D02.isChecked() ? "2"
                : bi.C207D98.isChecked() ? "98"
                : "-1");

        json.put("C207E", bi.C207E01.isChecked() ? "1"
                : bi.C207E02.isChecked() ? "2"
                : bi.C207E98.isChecked() ? "98"
                : "-1");

        json.put("C207F", bi.C207F01.isChecked() ? "1"
                : bi.C207F02.isChecked() ? "2"
                : bi.C207F98.isChecked() ? "98"
                : "-1");

        json.put("C207G", bi.C207G01.isChecked() ? "1"
                : bi.C207G02.isChecked() ? "2"
                : bi.C207G98.isChecked() ? "98"
                : "-1");

        json.put("C207H", bi.C207H01.isChecked() ? "1"
                : bi.C207H02.isChecked() ? "2"
                : bi.C207H98.isChecked() ? "98"
                : "-1");

        json.put("C207I", bi.C207I01.isChecked() ? "1"
                : bi.C207I02.isChecked() ? "2"
                : bi.C207I98.isChecked() ? "98"
                : "-1");

        json.put("C207J", bi.C207J01.isChecked() ? "1"
                : bi.C207J02.isChecked() ? "2"
                : bi.C207J98.isChecked() ? "98"
                : "-1");

        json.put("C207K", bi.C207K01.isChecked() ? "1"
                : bi.C207K02.isChecked() ? "2"
                : bi.C207K98.isChecked() ? "98"
                : "-1");

        json.put("C207L", bi.C207L01.isChecked() ? "1"
                : bi.C207L02.isChecked() ? "2"
                : bi.C207L98.isChecked() ? "98"
                : "-1");

        json.put("C207M", bi.C207M01.isChecked() ? "1"
                : bi.C207M02.isChecked() ? "2"
                : bi.C207M98.isChecked() ? "98"
                : "-1");

        json.put("C207N", bi.C207N01.isChecked() ? "1"
                : bi.C207N02.isChecked() ? "2"
                : bi.C207N98.isChecked() ? "98"
                : "-1");

        json.put("C207O", bi.C207O01.isChecked() ? "1"
                : bi.C207O02.isChecked() ? "2"
                : bi.C207O98.isChecked() ? "98"
                : "-1");

        json.put("C207P", bi.C207P01.isChecked() ? "1"
                : bi.C207P02.isChecked() ? "2"
                : bi.C207P98.isChecked() ? "98"
                : "-1");

        json.put("C207Q", bi.C207Q01.isChecked() ? "1"
                : bi.C207Q02.isChecked() ? "2"
                : bi.C207Q98.isChecked() ? "98"
                : "-1");

        json.put("C207R", bi.C207R01.isChecked() ? "1"
                : bi.C207R02.isChecked() ? "2"
                : bi.C207R98.isChecked() ? "98"
                : "-1");

        json.put("C207S", bi.C207S01.isChecked() ? "1"
                : bi.C207S02.isChecked() ? "2"
                : bi.C207S98.isChecked() ? "98"
                : "-1");

        json.put("C207S01x", bi.C207S01x.getText().toString().trim().isEmpty() ? "-1" : bi.C207S01x.getText().toString().trim());

        json.put("C208", bi.C20801.isChecked() ? "1"
                : bi.C20802.isChecked() ? "2"
                : "-1");

        json.put("C209", bi.C209.getText().toString().trim().isEmpty() ? "-1" : bi.C209.getText().toString().trim());

        try {
            JSONObject json_merged = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.child.getJSON()), json);
            MainApp.child.setJSON(String.valueOf(json_merged));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }
}