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
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH5Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class H5 extends AppCompatActivity {

    /*private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };
    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};
    */

    ActivityH5Binding bi;
    Intent oF = null;
    String SectionBActivity;
    private DatabaseHelper db;
    private String semisCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h5);
        bi.setCallback(this);
        setupSkip();
    }

    private void setupSkip() {

        //H501
        bi.H501.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H50102.getId() || checkedId == bi.H50103.getId() || checkedId == bi.H50104.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH501a);
                bi.fldGrpCVH501a.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH501b);
                bi.fldGrpCVH501b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH501a.setVisibility(View.VISIBLE);
                bi.fldGrpCVH501b.setVisibility(View.VISIBLE);
            }
        });

        //H501a
        bi.H501a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H501a02.getId() || checkedId == bi.H501a03.getId() || checkedId == bi.H501a04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH501b);
                bi.fldGrpCVH501b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH501b.setVisibility(View.VISIBLE);
            }
        });

        //H502
        bi.H502.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H50202.getId() || checkedId == bi.H50203.getId() || checkedId == bi.H50204.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH502a);
                bi.fldGrpCVH502a.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH502b);
                bi.fldGrpCVH502b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH502a.setVisibility(View.VISIBLE);
                bi.fldGrpCVH502b.setVisibility(View.VISIBLE);
            }
        });

        //H502a
        bi.H502a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H502a02.getId() || checkedId == bi.H502a03.getId() || checkedId == bi.H502a04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH502b);
                bi.fldGrpCVH502b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH502b.setVisibility(View.VISIBLE);
            }
        });

        //H503
        bi.H503.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H50302.getId() || checkedId == bi.H50303.getId() || checkedId == bi.H50304.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH503a);
                bi.fldGrpCVH503a.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH503b);
                bi.fldGrpCVH503b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH503a.setVisibility(View.VISIBLE);
                bi.fldGrpCVH503b.setVisibility(View.VISIBLE);
            }
        });

        //H503a
        bi.H503a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H503a02.getId() || checkedId == bi.H503a03.getId() || checkedId == bi.H503a04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH503b);
                bi.fldGrpCVH503b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH503b.setVisibility(View.VISIBLE);
            }
        });

        //H504
        bi.H504.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H50402.getId() || checkedId == bi.H50403.getId() || checkedId == bi.H50404.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH504a);
                bi.fldGrpCVH504a.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH504b);
                bi.fldGrpCVH504b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH504a.setVisibility(View.VISIBLE);
                bi.fldGrpCVH504b.setVisibility(View.VISIBLE);
            }
        });

        //H504a
        bi.H504a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H504a02.getId() || checkedId == bi.H504a03.getId() || checkedId == bi.H504a04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH504b);
                bi.fldGrpCVH504b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH504b.setVisibility(View.VISIBLE);
            }
        });

        //H505
        bi.H505.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H50502.getId() || checkedId == bi.H50503.getId() || checkedId == bi.H50504.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH505a);
                bi.fldGrpCVH505a.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH505b);
                bi.fldGrpCVH505b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH505a.setVisibility(View.VISIBLE);
                bi.fldGrpCVH505b.setVisibility(View.VISIBLE);
            }
        });

        //H505a
        bi.H505a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H505a02.getId() || checkedId == bi.H505a03.getId() || checkedId == bi.H505a04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH505b);
                bi.fldGrpCVH505b.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH505b.setVisibility(View.VISIBLE);
            }
        });

        //H506
        bi.H506.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H50602.getId() || checkedId == bi.H50603.getId() || checkedId == bi.H50604.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH506a);
                bi.fldGrpCVH506a.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH506b);
                bi.fldGrpCVH506b.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH506c);
                bi.fldGrpCVH506c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH506a.setVisibility(View.VISIBLE);
                bi.fldGrpCVH506b.setVisibility(View.VISIBLE);
                bi.fldGrpCVH506c.setVisibility(View.VISIBLE);
            }
        });

        //H506a
        bi.H506a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H506a02.getId() || checkedId == bi.H506a03.getId() || checkedId == bi.H506a04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH506b);
                bi.fldGrpCVH506b.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH506c);
                bi.fldGrpCVH506c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH506b.setVisibility(View.VISIBLE);
                bi.fldGrpCVH506c.setVisibility(View.VISIBLE);
            }
        });

        //H506b
        bi.H506b.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H506b02.getId() || checkedId == bi.H506b03.getId() || checkedId == bi.H506b04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH506c);
                bi.fldGrpCVH506c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH506c.setVisibility(View.VISIBLE);
            }
        });

        //H507
        bi.H507.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H50702.getId() || checkedId == bi.H50703.getId() || checkedId == bi.H50704.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH507a);
                bi.fldGrpCVH507a.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH507b);
                bi.fldGrpCVH507b.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH507c);
                bi.fldGrpCVH507c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH507a.setVisibility(View.VISIBLE);
                bi.fldGrpCVH507b.setVisibility(View.VISIBLE);
                bi.fldGrpCVH507c.setVisibility(View.VISIBLE);
            }
        });

        //H507a
        bi.H507a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H507a02.getId() || checkedId == bi.H507a03.getId() || checkedId == bi.H507a04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH507b);
                bi.fldGrpCVH507b.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH507c);
                bi.fldGrpCVH507c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH507b.setVisibility(View.VISIBLE);
                bi.fldGrpCVH507c.setVisibility(View.VISIBLE);
            }
        });

        //H507b
        bi.H507b.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H507b02.getId() || checkedId == bi.H507b03.getId() || checkedId == bi.H507b04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH507c);
                bi.fldGrpCVH507c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH507c.setVisibility(View.VISIBLE);
            }
        });

        //H508
        bi.H508.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H50802.getId() || checkedId == bi.H50803.getId() || checkedId == bi.H50804.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH508a);
                bi.fldGrpCVH508a.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH508b);
                bi.fldGrpCVH508b.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH508c);
                bi.fldGrpCVH508c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH508a.setVisibility(View.VISIBLE);
                bi.fldGrpCVH508b.setVisibility(View.VISIBLE);
                bi.fldGrpCVH508c.setVisibility(View.VISIBLE);
            }
        });

        //H508a
        bi.H508a.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H508a02.getId() || checkedId == bi.H508a03.getId() || checkedId == bi.H508a04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH508b);
                bi.fldGrpCVH508b.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVH508c);
                bi.fldGrpCVH508c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH508b.setVisibility(View.VISIBLE);
                bi.fldGrpCVH508c.setVisibility(View.VISIBLE);
            }
        });

        //H508b
        bi.H508b.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H508b02.getId() || checkedId == bi.H508b03.getId() || checkedId == bi.H508b04.getId()) {
                Clear.clearAllFields(bi.fldGrpCVH508c);
                bi.fldGrpCVH508c.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH508c.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, H6.class));
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

        json.put("H501", bi.H50101.isChecked() ? "1"
                : bi.H50102.isChecked() ? "2"
                : bi.H50103.isChecked() ? "98"
                : bi.H50104.isChecked() ? "99"
                : "-1");
        json.put("H501a", bi.H501a01.isChecked() ? "1"
                : bi.H501a02.isChecked() ? "2"
                : bi.H501a03.isChecked() ? "98"
                : bi.H501a04.isChecked() ? "99"
                : "-1");
        json.put("H501b", bi.H501b01.isChecked() ? "1"
                : bi.H501b02.isChecked() ? "2"
                : bi.H501b03.isChecked() ? "98"
                : bi.H501b04.isChecked() ? "99"
                : "-1");

        json.put("H502", bi.H50201.isChecked() ? "1"
                : bi.H50202.isChecked() ? "2"
                : bi.H50203.isChecked() ? "98"
                : bi.H50204.isChecked() ? "99"
                : "-1");
        json.put("H502a", bi.H502a01.isChecked() ? "1"
                : bi.H502a02.isChecked() ? "2"
                : bi.H502a03.isChecked() ? "98"
                : bi.H502a04.isChecked() ? "99"
                : "-1");
        json.put("H502b", bi.H502b01.isChecked() ? "1"
                : bi.H502b02.isChecked() ? "2"
                : bi.H502b03.isChecked() ? "98"
                : bi.H502b04.isChecked() ? "99"
                : "-1");

        json.put("H503", bi.H50301.isChecked() ? "1"
                : bi.H50302.isChecked() ? "2"
                : bi.H50303.isChecked() ? "98"
                : bi.H50304.isChecked() ? "99"
                : "-1");
        json.put("H503a", bi.H503a01.isChecked() ? "1"
                : bi.H503a02.isChecked() ? "2"
                : bi.H503a03.isChecked() ? "98"
                : bi.H503a04.isChecked() ? "99"
                : "-1");
        json.put("H503b", bi.H503b01.isChecked() ? "1"
                : bi.H503b02.isChecked() ? "2"
                : bi.H503b03.isChecked() ? "98"
                : bi.H503b04.isChecked() ? "99"
                : "-1");

        json.put("H504", bi.H50401.isChecked() ? "1"
                : bi.H50402.isChecked() ? "2"
                : bi.H50403.isChecked() ? "98"
                : bi.H50404.isChecked() ? "99"
                : "-1");
        json.put("H504a", bi.H504a01.isChecked() ? "1"
                : bi.H504a02.isChecked() ? "2"
                : bi.H504a03.isChecked() ? "98"
                : bi.H504a04.isChecked() ? "99"
                : "-1");
        json.put("H504b", bi.H504b01.isChecked() ? "1"
                : bi.H504b02.isChecked() ? "2"
                : bi.H504b03.isChecked() ? "98"
                : bi.H504b04.isChecked() ? "99"
                : "-1");

        json.put("H505", bi.H50501.isChecked() ? "1"
                : bi.H50502.isChecked() ? "2"
                : bi.H50503.isChecked() ? "98"
                : bi.H50504.isChecked() ? "99"
                : "-1");
        json.put("H505a", bi.H505a01.isChecked() ? "1"
                : bi.H505a02.isChecked() ? "2"
                : bi.H505a03.isChecked() ? "98"
                : bi.H505a04.isChecked() ? "99"
                : "-1");
        json.put("H505b", bi.H505b01.isChecked() ? "1"
                : bi.H505b02.isChecked() ? "2"
                : bi.H505b03.isChecked() ? "98"
                : bi.H505b04.isChecked() ? "99"
                : "-1");

        json.put("H506", bi.H50601.isChecked() ? "1"
                : bi.H50602.isChecked() ? "2"
                : bi.H50603.isChecked() ? "98"
                : bi.H50604.isChecked() ? "99"
                : "-1");
        json.put("H506a", bi.H506a01.isChecked() ? "1"
                : bi.H506a02.isChecked() ? "2"
                : bi.H506a03.isChecked() ? "98"
                : bi.H506a04.isChecked() ? "99"
                : "-1");
        json.put("H506b", bi.H506b01.isChecked() ? "1"
                : bi.H506b02.isChecked() ? "2"
                : bi.H506b03.isChecked() ? "98"
                : bi.H506b04.isChecked() ? "99"
                : "-1");
        json.put("H506c", bi.H506c01.isChecked() ? "1"
                : bi.H506c02.isChecked() ? "2"
                : bi.H506c03.isChecked() ? "3"
                : bi.H506c04.isChecked() ? "98"
                : bi.H506c05.isChecked() ? "99"
                : "-1");

        json.put("H507", bi.H50701.isChecked() ? "1"
                : bi.H50702.isChecked() ? "2"
                : bi.H50703.isChecked() ? "98"
                : bi.H50704.isChecked() ? "99"
                : "-1");
        json.put("H507a", bi.H507a01.isChecked() ? "1"
                : bi.H507a02.isChecked() ? "2"
                : bi.H507a03.isChecked() ? "98"
                : bi.H507a04.isChecked() ? "99"
                : "-1");
        json.put("H507b", bi.H507b01.isChecked() ? "1"
                : bi.H507b02.isChecked() ? "2"
                : bi.H507b03.isChecked() ? "98"
                : bi.H507b04.isChecked() ? "99"
                : "-1");
        json.put("H507c", bi.H507c01.isChecked() ? "1"
                : bi.H507c02.isChecked() ? "2"
                : bi.H507c03.isChecked() ? "3"
                : bi.H507c04.isChecked() ? "98"
                : bi.H507c05.isChecked() ? "99"
                : "-1");

        json.put("H508", bi.H50801.isChecked() ? "1"
                : bi.H50802.isChecked() ? "2"
                : bi.H50803.isChecked() ? "3"
                : bi.H50804.isChecked() ? "4"
                : "-1");
        json.put("H508a", bi.H508a01.isChecked() ? "1"
                : bi.H508a02.isChecked() ? "2"
                : bi.H508a03.isChecked() ? "3"
                : bi.H508a04.isChecked() ? "4"
                : "-1");
        json.put("H508b", bi.H508b01.isChecked() ? "1"
                : bi.H508b02.isChecked() ? "2"
                : bi.H508b03.isChecked() ? "3"
                : bi.H508b04.isChecked() ? "4"
                : "-1");
        json.put("H508c", bi.H508c01.isChecked() ? "1"
                : bi.H508c02.isChecked() ? "2"
                : bi.H508c03.isChecked() ? "3"
                : bi.H508c04.isChecked() ? "98"
                : bi.H508c05.isChecked() ? "99"
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