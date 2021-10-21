package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import static edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.form;
import static edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.mc;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityE1Binding;
import edu.aku.wasimabbas.ehsas_evaluation.models.Member;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;


public class E1 extends AppCompatActivity {

    public Cursor cursor;
    public String muid;
    public int age;
    ActivityE1Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_e1);
        bi.setCallback(this);

        setupSkip();

        db = new DatabaseHelper(this);
        cursor = db.getAllMembers(form.getUid());

        if (cursor.getCount() == 0) {
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            cursor.moveToFirst();
            muid = cursor.getString(cursor.getColumnIndex("uid"));
            age = Integer.parseInt(cursor.getString(cursor.getColumnIndex("H20603")));
            if (age <= 5) {
                Clear.clearAllFields(bi.fldGrpCVE105);
                bi.fldGrpCVE105.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVE105.setVisibility(View.VISIBLE);
            }
        }
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
            startActivity(new Intent(E1.this, E1.class));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        MainApp.openEndActivity(this);
    }

    private boolean UpdateDB() {

        long updcount = db.addMemberAnthro(mc, muid);
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        mc = new Member();

        mc.setE101(bi.E101.getText().toString().trim().isEmpty() ? "-1" : bi.E101.getText().toString().trim());

        mc.setE102(bi.E102.getText().toString().trim().isEmpty() ? "-1" : bi.E102.getText().toString().trim());

        mc.setE103(bi.E103.getText().toString().trim().isEmpty() ? "-1" : bi.E103.getText().toString().trim());

        mc.setE104(bi.E104.getText().toString().trim().isEmpty() ? "-1" : bi.E104.getText().toString().trim());

        mc.setE105(bi.E10501.isChecked() ? "1"
                : bi.E10502.isChecked() ? "2"
                : "-1");

        mc.setE106(bi.E10601.isChecked() ? "1"
                : bi.E10602.isChecked() ? "2"
                : bi.E10603.isChecked() ? "3"
                : "-1");
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }
}