package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH302Binding;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class H302 extends AppCompatActivity {

    ActivityH302Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h302);
        bi.setCallback(this);
        setupSkip();

        Toast.makeText(this, "H302: " + MainApp.form.getUid(), Toast.LENGTH_LONG).show();
    }

    private void setupSkip() {

        //H319
        bi.H319.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H31902.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH320);
                bi.fldGrpCVH320.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH320.setVisibility(View.VISIBLE);
            }
        });

        //H321
        bi.H321.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H32102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH322);
                bi.fldGrpCVH322.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH322.setVisibility(View.VISIBLE);
            }
        });

        //H313
        bi.H31396x.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start, int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if (cs.equals("")) { // for backspace
                            return cs;
                        }
                        if (cs.toString().matches("[a-zA-Z ]+")) {
                            return cs;
                        }
                        return "";
                    }
                }
        });

        //H315
        bi.H31596x.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start, int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if (cs.equals("")) { // for backspace
                            return cs;
                        }
                        if (cs.toString().matches("[a-zA-Z ]+")) {
                            return cs;
                        }
                        return "";
                    }
                }
        });

        //H316
        bi.H31696x.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start, int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if (cs.equals("")) { // for backspace
                            return cs;
                        }
                        if (cs.toString().matches("[a-zA-Z ]+")) {
                            return cs;
                        }
                        return "";
                    }
                }
        });

        //H317
        bi.H31796x.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start, int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if (cs.equals("")) { // for backspace
                            return cs;
                        }
                        if (cs.toString().matches("[a-zA-Z ]+")) {
                            return cs;
                        }
                        return "";
                    }
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
            startActivity(new Intent(this, H4.class));
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

        json.put("H31201", bi.H3120101.isChecked() ? "1"
                : bi.H3120102.isChecked() ? "2"
                : "-1");

        json.put("H31202", bi.H3120201.isChecked() ? "1"
                : bi.H3120202.isChecked() ? "2"
                : "-1");

        json.put("H31203", bi.H3120301.isChecked() ? "1"
                : bi.H3120302.isChecked() ? "2"
                : "-1");

        json.put("H31204", bi.H3120401.isChecked() ? "1"
                : bi.H3120402.isChecked() ? "2"
                : "-1");

        json.put("H31205", bi.H3120501.isChecked() ? "1"
                : bi.H3120502.isChecked() ? "2"
                : "-1");

        json.put("H31206", bi.H3120601.isChecked() ? "1"
                : bi.H3120602.isChecked() ? "2"
                : "-1");

        json.put("H31207", bi.H3120701.isChecked() ? "1"
                : bi.H3120702.isChecked() ? "2"
                : "-1");

        json.put("H313", bi.H31301.isChecked() ? "1"
                : bi.H31302.isChecked() ? "2"
                : bi.H31303.isChecked() ? "3"
                : bi.H31304.isChecked() ? "4"
                : bi.H31305.isChecked() ? "5"
                : bi.H31306.isChecked() ? "6"
                : bi.H31307.isChecked() ? "7"
                : bi.H31308.isChecked() ? "8"
                : bi.H31309.isChecked() ? "9"
                : bi.H31310.isChecked() ? "10"
                : bi.H31311.isChecked() ? "11"
                : bi.H31396.isChecked() ? "96"
                : "-1");
        json.put("H31396x", bi.H31396x.getText().toString().trim().isEmpty() ? "-1" : bi.H31396x.getText().toString().trim());

        json.put("H314", bi.H31401.isChecked() ? "1"
                : bi.H31402.isChecked() ? "2"
                : "-1");

        json.put("H315", bi.H31511.isChecked() ? "11"
                : bi.H31512.isChecked() ? "12"
                : bi.H31521.isChecked() ? "21"
                : bi.H31522.isChecked() ? "22"
                : bi.H31531.isChecked() ? "31"
                : bi.H31532.isChecked() ? "32"
                : bi.H31533.isChecked() ? "33"
                : bi.H31534.isChecked() ? "34"
                : bi.H31535.isChecked() ? "35"
                : bi.H31536.isChecked() ? "36"
                : bi.H31537.isChecked() ? "37"
                : bi.H31596.isChecked() ? "96"
                : "-1");
        json.put("H31596x", bi.H31596x.getText().toString().trim().isEmpty() ? "-1" : bi.H31596x.getText().toString().trim());

        json.put("H316", bi.H31611.isChecked() ? "11"
                : bi.H31612.isChecked() ? "12"
                : bi.H31613.isChecked() ? "13"
                : bi.H31621.isChecked() ? "21"
                : bi.H31622.isChecked() ? "22"
                : bi.H31623.isChecked() ? "23"
                : bi.H31624.isChecked() ? "24"
                : bi.H31631.isChecked() ? "31"
                : bi.H31632.isChecked() ? "32"
                : bi.H31633.isChecked() ? "33"
                : bi.H31634.isChecked() ? "34"
                : bi.H31635.isChecked() ? "35"
                : bi.H31636.isChecked() ? "36"
                : bi.H31637.isChecked() ? "37"
                : bi.H31696.isChecked() ? "96"
                : "-1");
        json.put("H31696x", bi.H31696x.getText().toString().trim().isEmpty() ? "-1" : bi.H31696x.getText().toString().trim());

        json.put("H317", bi.H31711.isChecked() ? "11"
                : bi.H31712.isChecked() ? "12"
                : bi.H31713.isChecked() ? "13"
                : bi.H31721.isChecked() ? "21"
                : bi.H31722.isChecked() ? "22"
                : bi.H31723.isChecked() ? "23"
                : bi.H31724.isChecked() ? "24"
                : bi.H31725.isChecked() ? "25"
                : bi.H31726.isChecked() ? "26"
                : bi.H31727.isChecked() ? "27"
                : bi.H31731.isChecked() ? "31"
                : bi.H31732.isChecked() ? "32"
                : bi.H31733.isChecked() ? "33"
                : bi.H31734.isChecked() ? "34"
                : bi.H31735.isChecked() ? "35"
                : bi.H31736.isChecked() ? "36"
                : bi.H31796.isChecked() ? "96"
                : "-1");
        json.put("H31796x", bi.H31796x.getText().toString().trim().isEmpty() ? "-1" : bi.H31796x.getText().toString().trim());

        json.put("H318", bi.H318.getText().toString().trim().isEmpty() ? "-1" : bi.H318.getText().toString().trim());

        json.put("H319", bi.H31901.isChecked() ? "1"
                : bi.H31902.isChecked() ? "2"
                : "-1");

        json.put("H32001", bi.H32001.getText().toString().trim().isEmpty() ? "-1" : bi.H32001.getText().toString().trim());
        json.put("H32002", bi.H32002.getText().toString().trim().isEmpty() ? "-1" : bi.H32002.getText().toString().trim());
        json.put("H32098", bi.H32098.isChecked() ? "1" : "-1");

        json.put("H321", bi.H32101.isChecked() ? "1"
                : bi.H32102.isChecked() ? "2"
                : "-1");

        json.put("H32201", bi.H32201.getText().toString().trim().isEmpty() ? "-1" : bi.H32201.getText().toString().trim());
        json.put("H32202", bi.H32202.getText().toString().trim().isEmpty() ? "-1" : bi.H32202.getText().toString().trim());
        json.put("H32203", bi.H32203.getText().toString().trim().isEmpty() ? "-1" : bi.H32203.getText().toString().trim());
        json.put("H32204", bi.H32204.getText().toString().trim().isEmpty() ? "-1" : bi.H32204.getText().toString().trim());
        json.put("H32205", bi.H32205.getText().toString().trim().isEmpty() ? "-1" : bi.H32205.getText().toString().trim());
        json.put("H32206", bi.H32206.getText().toString().trim().isEmpty() ? "-1" : bi.H32206.getText().toString().trim());

        try {
            JSONObject json_merged = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.form.getJSON()), json);
            MainApp.form.setJSON(String.valueOf(json_merged));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean formValidation() {

        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) {
            return false;
        }

        if ((Integer.parseInt(bi.H32001.getText().toString()) + Integer.parseInt(bi.H32002.getText().toString())) == 0) {
            bi.H32001.setError("Sum of Acre and Canal cannot be zero");
            return false;
        }

        return true;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }

}