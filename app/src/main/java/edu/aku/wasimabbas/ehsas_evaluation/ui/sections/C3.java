package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleChildrenContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityC3Binding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils;


public class C3 extends AppCompatActivity {

    public int counter;
    public long id;
    public int serialNO;
    public String uid;
    public String name;
    public int itemPosition;
    public String fuid;
    ActivityC3Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_c3);
        bi.setCallback(this);

        setupSkip();

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        serialNO = intent.getIntExtra("serialNo", 0);
        name = intent.getStringExtra("name");
        uid = intent.getStringExtra("uid");
    }

    private void setupSkip() {

        //C301
        bi.C301.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C30102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC302);
                bi.fldGrpCVC302.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC302A);
                bi.fldGrpCVC302A.setVisibility(View.GONE);
                bi.fldGrpCVC303.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVC302.setVisibility(View.VISIBLE);
                bi.fldGrpCVC302A.setVisibility(View.VISIBLE);
                bi.fldGrpCVC303.setVisibility(View.VISIBLE);
            }
        });

        //C302
        bi.C302.setOnCheckedChangeListener((group, idChecked) -> {

            if (idChecked == bi.C30202.getId()) {

                bi.fldGrpCVC302A.setVisibility(View.VISIBLE);

                Clear.clearAllFields(bi.fldGrpCVC303);
                bi.fldGrpCVC303.setVisibility(View.GONE);

                Clear.clearAllFields(bi.fldGrpCVC304);
                bi.fldGrpCVC304.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30501);
                bi.fldGrpCVC30501.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30502);
                bi.fldGrpCVC30502.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30503);
                bi.fldGrpCVC30503.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30504);
                bi.fldGrpCVC30504.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30505);
                bi.fldGrpCVC30505.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30506);
                bi.fldGrpCVC30506.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30507);
                bi.fldGrpCVC30507.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30508);
                bi.fldGrpCVC30508.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30509);
                bi.fldGrpCVC30509.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30510);
                bi.fldGrpCVC30510.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30511);
                bi.fldGrpCVC30511.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30512);
                bi.fldGrpCVC30512.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30513);
                bi.fldGrpCVC30513.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30514);
                bi.fldGrpCVC30514.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30515);
                bi.fldGrpCVC30515.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC30516);
                bi.fldGrpCVC30516.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC306);
                bi.fldGrpCVC306.setVisibility(View.GONE);

            } else {

                Clear.clearAllFields(bi.fldGrpCVC302A);
                bi.fldGrpCVC302A.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC303);
                bi.fldGrpCVC303.setVisibility(View.GONE);

                bi.fldGrpCVC304.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30501.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30502.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30503.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30504.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30505.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30506.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30507.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30508.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30509.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30510.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30511.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30512.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30513.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30514.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30515.setVisibility(View.VISIBLE);
                bi.fldGrpCVC30516.setVisibility(View.VISIBLE);
                bi.fldGrpCVC306.setVisibility(View.VISIBLE);
            }
        });

        // C305
        /*TextWatcher textwatcher = new TextWatcher() {

            EditTextPicker day;
            EditTextPicker month;
            EditTextPicker year;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (bi.C3050101.isFocused()) {
                    day   = bi.C3050101;
                    month = bi.C3050102;
                    year  = bi.C3050103;
                } else if (bi.C3050201.isFocused()) {
                    day   = bi.C3050201;
                    month = bi.C3050202;
                    year  = bi.C3050203;
                } else if (bi.C3050301.isFocused()) {
                    day   = bi.C3050301;
                    month = bi.C3050302;
                    year  = bi.C3050303;
                } else if (bi.C3050401.isFocused()) {
                    day   = bi.C3050401;
                    month = bi.C3050402;
                    year  = bi.C3050403;
                } else if (bi.C3050501.isFocused()) {
                    day   = bi.C3050501;
                    month = bi.C3050502;
                    year  = bi.C3050503;
                } else if (bi.C3050601.isFocused()) {
                    day   = bi.C3050601;
                    month = bi.C3050602;
                    year  = bi.C3050603;
                } else if (bi.C3050701.isFocused()) {
                    day   = bi.C3050701;
                    month = bi.C3050702;
                    year  = bi.C3050703;
                } else if (bi.C3050801.isFocused()) {
                    day   = bi.C3050801;
                    month = bi.C3050802;
                    year  = bi.C3050803;
                } else if (bi.C3050901.isFocused()) {
                    day   = bi.C3050901;
                    month = bi.C3050902;
                    year  = bi.C3050903;
                } else if (bi.C3051001.isFocused()) {
                    day   = bi.C3051001;
                    month = bi.C3051002;
                    year  = bi.C3051003;
                } else if (bi.C3051101.isFocused()) {
                    day   = bi.C3051101;
                    month = bi.C3051102;
                    year  = bi.C3051103;
                } else if (bi.C3051201.isFocused()) {
                    day   = bi.C3051201;
                    month = bi.C3051202;
                    year  = bi.C3051203;
                } else if (bi.C3051301.isFocused()) {
                    day   = bi.C3051301;
                    month = bi.C3051302;
                    year  = bi.C3051303;
                } else if (bi.C3051401.isFocused()) {
                    day   = bi.C3051401;
                    month = bi.C3051402;
                    year  = bi.C3051403;
                } else if (bi.C3051501.isFocused()) {
                    day   = bi.C3051501;
                    month = bi.C3051502;
                    year  = bi.C3051503;
                } else if (bi.C3051601.isFocused()) {
                    day   = bi.C3051601;
                    month = bi.C3051602;
                    year  = bi.C3051603;
                } else {
                    day   = null;
                    month = null;
                    year  = null;
                }

                AndroidUtilityKt.chkValues(day, new Double[]{44.0, 66.0, 88.0, 97.0});
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 2) {

                    if (day != null) {
                        month.setText(null);
                        year.setText(null);
                        month.setEnabled(false);
                        year.setEnabled(false);
                    } else {
                        month.setEnabled(true);
                        year.setEnabled(true);
                    }

                } else if (s.length() == 0) {

                    month.setEnabled(true);
                    year.setEnabled(true);
                } else {

                    return;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };*/

        /*bi.C3050101.addTextChangedListener(textwatcher);
        bi.C3050201.addTextChangedListener(textwatcher);
        bi.C3050301.addTextChangedListener(textwatcher);
        bi.C3050401.addTextChangedListener(textwatcher);
        bi.C3050501.addTextChangedListener(textwatcher);
        bi.C3050601.addTextChangedListener(textwatcher);
        bi.C3050701.addTextChangedListener(textwatcher);
        bi.C3050801.addTextChangedListener(textwatcher);
        bi.C3050901.addTextChangedListener(textwatcher);
        bi.C3051001.addTextChangedListener(textwatcher);
        bi.C3051101.addTextChangedListener(textwatcher);
        bi.C3051201.addTextChangedListener(textwatcher);
        bi.C3051301.addTextChangedListener(textwatcher);
        bi.C3051401.addTextChangedListener(textwatcher);
        bi.C3051501.addTextChangedListener(textwatcher);
        bi.C3051601.addTextChangedListener(textwatcher);*/

        //AndroidUtilityKt.chkValues(bi.C3050101, new Double[]{44.0, 66.0}, this);

        //C306
        bi.C306.setOnCheckedChangeListener((group, idChecked) -> {

            if (idChecked == bi.C30601.getId()) {

                Clear.clearAllFields(bi.fldGrpCVC307);
                bi.fldGrpCVC307.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC308);
                bi.fldGrpCVC308.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC309);
                bi.fldGrpCVC309.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC310);
                bi.fldGrpCVC310.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC311);
                bi.fldGrpCVC311.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC312);
                bi.fldGrpCVC312.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC313);
                bi.fldGrpCVC313.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC314);
                bi.fldGrpCVC314.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC315);
                bi.fldGrpCVC315.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC316);
                bi.fldGrpCVC316.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC317);
                bi.fldGrpCVC317.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC318);
                bi.fldGrpCVC318.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC319);
                bi.fldGrpCVC319.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC320);
                bi.fldGrpCVC320.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVC307.setVisibility(View.VISIBLE);
                bi.fldGrpCVC308.setVisibility(View.VISIBLE);
                bi.fldGrpCVC309.setVisibility(View.VISIBLE);
                bi.fldGrpCVC310.setVisibility(View.VISIBLE);
                bi.fldGrpCVC311.setVisibility(View.VISIBLE);
                bi.fldGrpCVC312.setVisibility(View.VISIBLE);
                bi.fldGrpCVC313.setVisibility(View.VISIBLE);
                bi.fldGrpCVC314.setVisibility(View.VISIBLE);
                bi.fldGrpCVC315.setVisibility(View.VISIBLE);
                bi.fldGrpCVC316.setVisibility(View.VISIBLE);
                bi.fldGrpCVC317.setVisibility(View.VISIBLE);
                bi.fldGrpCVC318.setVisibility(View.VISIBLE);
                bi.fldGrpCVC319.setVisibility(View.VISIBLE);
                bi.fldGrpCVC320.setVisibility(View.VISIBLE);
            }
        });

        //C307
        bi.C307.setOnCheckedChangeListener((group, idChecked) -> {

            if (idChecked == bi.C30702.getId()) {

                Clear.clearAllFields(bi.fldGrpCVC308);
                bi.fldGrpCVC308.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC309);
                bi.fldGrpCVC309.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC310);
                bi.fldGrpCVC310.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC311);
                bi.fldGrpCVC311.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC312);
                bi.fldGrpCVC312.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC313);
                bi.fldGrpCVC313.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC314);
                bi.fldGrpCVC314.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC315);
                bi.fldGrpCVC315.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC316);
                bi.fldGrpCVC316.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC317);
                bi.fldGrpCVC317.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC318);
                bi.fldGrpCVC318.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC319);
                bi.fldGrpCVC319.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC320);
                bi.fldGrpCVC320.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC321);
                bi.fldGrpCVC321.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC321A);
                bi.fldGrpCVC321A.setVisibility(View.GONE);

            } else {

                bi.fldGrpCVC308.setVisibility(View.VISIBLE);
                bi.fldGrpCVC309.setVisibility(View.VISIBLE);
                bi.fldGrpCVC310.setVisibility(View.VISIBLE);
                bi.fldGrpCVC311.setVisibility(View.VISIBLE);
                bi.fldGrpCVC312.setVisibility(View.VISIBLE);
                bi.fldGrpCVC313.setVisibility(View.VISIBLE);
                bi.fldGrpCVC314.setVisibility(View.VISIBLE);
                bi.fldGrpCVC315.setVisibility(View.VISIBLE);
                bi.fldGrpCVC316.setVisibility(View.VISIBLE);
                bi.fldGrpCVC317.setVisibility(View.VISIBLE);
                bi.fldGrpCVC318.setVisibility(View.VISIBLE);
                bi.fldGrpCVC319.setVisibility(View.VISIBLE);
                bi.fldGrpCVC320.setVisibility(View.VISIBLE);
                bi.fldGrpCVC321.setVisibility(View.VISIBLE);
                bi.fldGrpCVC321A.setVisibility(View.VISIBLE);
            }
        });

        //C309
        bi.C309.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C30902.getId() || idChecked == bi.C30998.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC310);
                bi.fldGrpCVC310.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVC311);
                bi.fldGrpCVC311.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC310.setVisibility(View.VISIBLE);
                bi.fldGrpCVC311.setVisibility(View.VISIBLE);
            }
        });

        //C312
        bi.C312.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C31202.getId() || idChecked == bi.C31298.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC313);
                bi.fldGrpCVC313.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC313.setVisibility(View.VISIBLE);
            }
        });

        //C314
        bi.C314.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C31402.getId() || idChecked == bi.C31498.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC315);
                bi.fldGrpCVC315.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC315.setVisibility(View.VISIBLE);
            }
        });

        //C316
        bi.C316.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C31602.getId() || idChecked == bi.C31698.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC317);
                bi.fldGrpCVC317.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC317.setVisibility(View.VISIBLE);
            }
        });

        //C319
        bi.C319.setOnCheckedChangeListener((group, idChecked) -> {
            if (idChecked == bi.C31902.getId() || idChecked == bi.C31998.getId()) {
                Clear.clearAllFields(bi.fldGrpCVC320);
                bi.fldGrpCVC320.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVC320.setVisibility(View.VISIBLE);
            }
        });
    }

    public void setEdxValue(CharSequence s, int start, int before, int count) {

        if (s != null) {

            if (bi.C3050101.isFocused()) {
                multiValuesSet(bi.C3050101, bi.C3050102, bi.C3050103);
            } else if (bi.C3050201.isFocused()) {
                multiValuesSet(bi.C3050201, bi.C3050202, bi.C3050203);
            } else if (bi.C3050301.isFocused()) {
                multiValuesSet(bi.C3050301, bi.C3050302, bi.C3050303);
            } else if (bi.C3050401.isFocused()) {
                multiValuesSet(bi.C3050401, bi.C3050402, bi.C3050403);
            } else if (bi.C3050501.isFocused()) {
                multiValuesSet(bi.C3050501, bi.C3050502, bi.C3050503);
            } else if (bi.C3050601.isFocused()) {
                multiValuesSet(bi.C3050601, bi.C3050602, bi.C3050603);
            } else if (bi.C3050701.isFocused()) {
                multiValuesSet(bi.C3050701, bi.C3050702, bi.C3050703);
            } else if (bi.C3050801.isFocused()) {
                multiValuesSet(bi.C3050801, bi.C3050802, bi.C3050803);
            } else if (bi.C3050901.isFocused()) {
                multiValuesSet(bi.C3050901, bi.C3050902, bi.C3050903);
            } else if (bi.C3051001.isFocused()) {
                multiValuesSet(bi.C3051001, bi.C3051002, bi.C3051003);
            } else if (bi.C3051101.isFocused()) {
                multiValuesSet(bi.C3051101, bi.C3051102, bi.C3051103);
            } else if (bi.C3051201.isFocused()) {
                multiValuesSet(bi.C3051201, bi.C3051202, bi.C3051203);
            } else if (bi.C3051301.isFocused()) {
                multiValuesSet(bi.C3051301, bi.C3051302, bi.C3051303);
            } else if (bi.C3051401.isFocused()) {
                multiValuesSet(bi.C3051401, bi.C3051402, bi.C3051403);
            } else if (bi.C3051501.isFocused()) {
                multiValuesSet(bi.C3051501, bi.C3051502, bi.C3051503);
            } else if (bi.C3051601.isFocused()) {
                multiValuesSet(bi.C3051601, bi.C3051602, bi.C3051603);
            }
        }
    }

    public void multiValuesSet(EditTextPicker edx1, EditTextPicker edx2, EditTextPicker edx3) {
        if (TextUtils.isEmpty(edx1.getText())) return;
        edx1.setRangedefaultvalue(Integer.parseInt(edx1.getText().toString()) == 44 ? 44f
                : Integer.parseInt(edx1.getText().toString()) == 66 ? 66f
                : Integer.parseInt(edx1.getText().toString()) == 88 ? 88f
                : Integer.parseInt(edx1.getText().toString()) == 97 ? 97f
                : 0f);

        if (edx1.getRangedefaultvalue() == 44f ||
                edx1.getRangedefaultvalue() == 66f ||
                edx1.getRangedefaultvalue() == 88f ||
                edx1.getRangedefaultvalue() == 97f) {

            edx2.setText(null);
            edx3.setText(null);
            edx2.setEnabled(false);
            edx3.setEnabled(false);

        } else {
            edx2.setEnabled(true);
            edx3.setEnabled(true);
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
            startActivity(new Intent(this, C4.class).putExtra("id", id).putExtra("uid", uid));
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

        json.put("C300", bi.C30001.isChecked() ? "1"
                : bi.C30002.isChecked() ? "2"
                : bi.C30098.isChecked() ? "98"
                : "-1");

        json.put("C301", bi.C30101.isChecked() ? "1"
                : bi.C30102.isChecked() ? "2"
                : "-1");

        json.put("C302", bi.C30201.isChecked() ? "1"
                : bi.C30202.isChecked() ? "2"
                : "-1");

        json.put("C302A", bi.C302A01.isChecked() ? "1"
                : bi.C302A02.isChecked() ? "2"
                : bi.C302A03.isChecked() ? "3"
                : bi.C302A96.isChecked() ? "96"
                : "-1");
        json.put("C302A96x", bi.C302A96x.getText().toString().trim().isEmpty() ? "-1" : bi.C302A96x.getText().toString().trim());

        json.put("C303", bi.C30301.isChecked() ? "1"
                : bi.C30302.isChecked() ? "2"
                : bi.C30303.isChecked() ? "3"
                : bi.C30304.isChecked() ? "4"
                : bi.C30305.isChecked() ? "5"
                : bi.C30396.isChecked() ? "96"
                : "-1");
        json.put("C30396x", bi.C30396x.getText().toString().trim().isEmpty() ? "-1" : bi.C30396x.getText().toString().trim());

        json.put("C304", bi.C304.getText().toString().trim().isEmpty() ? "-1" : bi.C304.getText().toString().trim());

        json.put("C3050101", bi.C3050101.getText().toString().trim().isEmpty() ? "-1" : bi.C3050101.getText().toString().trim());
        json.put("C3050102", bi.C3050102.getText().toString().trim().isEmpty() ? "-1" : bi.C3050102.getText().toString().trim());
        json.put("C3050103", bi.C3050103.getText().toString().trim().isEmpty() ? "-1" : bi.C3050103.getText().toString().trim());

        json.put("C3050201", bi.C3050201.getText().toString().trim().isEmpty() ? "-1" : bi.C3050201.getText().toString().trim());
        json.put("C3050202", bi.C3050202.getText().toString().trim().isEmpty() ? "-1" : bi.C3050202.getText().toString().trim());
        json.put("C3050203", bi.C3050203.getText().toString().trim().isEmpty() ? "-1" : bi.C3050203.getText().toString().trim());

        json.put("C3050301", bi.C3050301.getText().toString().trim().isEmpty() ? "-1" : bi.C3050301.getText().toString().trim());
        json.put("C3050302", bi.C3050302.getText().toString().trim().isEmpty() ? "-1" : bi.C3050302.getText().toString().trim());
        json.put("C3050303", bi.C3050303.getText().toString().trim().isEmpty() ? "-1" : bi.C3050303.getText().toString().trim());

        json.put("C3050401", bi.C3050401.getText().toString().trim().isEmpty() ? "-1" : bi.C3050401.getText().toString().trim());
        json.put("C3050402", bi.C3050402.getText().toString().trim().isEmpty() ? "-1" : bi.C3050402.getText().toString().trim());
        json.put("C3050403", bi.C3050403.getText().toString().trim().isEmpty() ? "-1" : bi.C3050403.getText().toString().trim());

        json.put("C3050501", bi.C3050501.getText().toString().trim().isEmpty() ? "-1" : bi.C3050501.getText().toString().trim());
        json.put("C3050502", bi.C3050502.getText().toString().trim().isEmpty() ? "-1" : bi.C3050502.getText().toString().trim());
        json.put("C3050503", bi.C3050503.getText().toString().trim().isEmpty() ? "-1" : bi.C3050503.getText().toString().trim());

        json.put("C3050601", bi.C3050601.getText().toString().trim().isEmpty() ? "-1" : bi.C3050601.getText().toString().trim());
        json.put("C3050602", bi.C3050602.getText().toString().trim().isEmpty() ? "-1" : bi.C3050602.getText().toString().trim());
        json.put("C3050603", bi.C3050603.getText().toString().trim().isEmpty() ? "-1" : bi.C3050603.getText().toString().trim());

        json.put("C3050701", bi.C3050701.getText().toString().trim().isEmpty() ? "-1" : bi.C3050701.getText().toString().trim());
        json.put("C3050702", bi.C3050702.getText().toString().trim().isEmpty() ? "-1" : bi.C3050702.getText().toString().trim());
        json.put("C3050703", bi.C3050703.getText().toString().trim().isEmpty() ? "-1" : bi.C3050703.getText().toString().trim());

        json.put("C3050801", bi.C3050801.getText().toString().trim().isEmpty() ? "-1" : bi.C3050801.getText().toString().trim());
        json.put("C3050802", bi.C3050802.getText().toString().trim().isEmpty() ? "-1" : bi.C3050802.getText().toString().trim());
        json.put("C3050803", bi.C3050803.getText().toString().trim().isEmpty() ? "-1" : bi.C3050803.getText().toString().trim());

        json.put("C3050901", bi.C3050901.getText().toString().trim().isEmpty() ? "-1" : bi.C3050901.getText().toString().trim());
        json.put("C3050902", bi.C3050902.getText().toString().trim().isEmpty() ? "-1" : bi.C3050902.getText().toString().trim());
        json.put("C3050903", bi.C3050903.getText().toString().trim().isEmpty() ? "-1" : bi.C3050903.getText().toString().trim());

        json.put("C3051001", bi.C3051001.getText().toString().trim().isEmpty() ? "-1" : bi.C3051001.getText().toString().trim());
        json.put("C3051002", bi.C3051002.getText().toString().trim().isEmpty() ? "-1" : bi.C3051002.getText().toString().trim());
        json.put("C3051003", bi.C3051003.getText().toString().trim().isEmpty() ? "-1" : bi.C3051003.getText().toString().trim());

        json.put("C3051101", bi.C3051101.getText().toString().trim().isEmpty() ? "-1" : bi.C3051101.getText().toString().trim());
        json.put("C3051102", bi.C3051102.getText().toString().trim().isEmpty() ? "-1" : bi.C3051102.getText().toString().trim());
        json.put("C3051103", bi.C3051103.getText().toString().trim().isEmpty() ? "-1" : bi.C3051103.getText().toString().trim());

        json.put("C3051201", bi.C3051201.getText().toString().trim().isEmpty() ? "-1" : bi.C3051201.getText().toString().trim());
        json.put("C3051202", bi.C3051202.getText().toString().trim().isEmpty() ? "-1" : bi.C3051202.getText().toString().trim());
        json.put("C3051203", bi.C3051203.getText().toString().trim().isEmpty() ? "-1" : bi.C3051203.getText().toString().trim());

        json.put("C3051301", bi.C3051301.getText().toString().trim().isEmpty() ? "-1" : bi.C3051301.getText().toString().trim());
        json.put("C3051302", bi.C3051302.getText().toString().trim().isEmpty() ? "-1" : bi.C3051302.getText().toString().trim());
        json.put("C3051303", bi.C3051303.getText().toString().trim().isEmpty() ? "-1" : bi.C3051303.getText().toString().trim());

        json.put("C3051401", bi.C3051401.getText().toString().trim().isEmpty() ? "-1" : bi.C3051401.getText().toString().trim());
        json.put("C3051402", bi.C3051402.getText().toString().trim().isEmpty() ? "-1" : bi.C3051402.getText().toString().trim());
        json.put("C3051403", bi.C3051403.getText().toString().trim().isEmpty() ? "-1" : bi.C3051403.getText().toString().trim());

        json.put("C3051501", bi.C3051501.getText().toString().trim().isEmpty() ? "-1" : bi.C3051501.getText().toString().trim());
        json.put("C3051502", bi.C3051502.getText().toString().trim().isEmpty() ? "-1" : bi.C3051502.getText().toString().trim());
        json.put("C3051503", bi.C3051503.getText().toString().trim().isEmpty() ? "-1" : bi.C3051503.getText().toString().trim());

        json.put("C3051601", bi.C3051601.getText().toString().trim().isEmpty() ? "-1" : bi.C3051601.getText().toString().trim());
        json.put("C3051602", bi.C3051602.getText().toString().trim().isEmpty() ? "-1" : bi.C3051602.getText().toString().trim());
        json.put("C3051603", bi.C3051603.getText().toString().trim().isEmpty() ? "-1" : bi.C3051603.getText().toString().trim());

        json.put("C306", bi.C30601.isChecked() ? "1"
                : bi.C30602.isChecked() ? "2"
                : "-1");

        json.put("C307", bi.C30701.isChecked() ? "1"
                : bi.C30702.isChecked() ? "2"
                : bi.C30798.isChecked() ? "98"
                : "-1");

        json.put("C308", bi.C30801.isChecked() ? "1"
                : bi.C30802.isChecked() ? "2"
                : bi.C30898.isChecked() ? "98"
                : "-1");

        json.put("C309", bi.C30901.isChecked() ? "1"
                : bi.C30902.isChecked() ? "2"
                : bi.C30998.isChecked() ? "98"
                : "-1");

        json.put("C310", bi.C31001.isChecked() ? "1"
                : bi.C31002.isChecked() ? "2"
                : bi.C31098.isChecked() ? "98"
                : "-1");

        json.put("C311", bi.C311.getText().toString().trim().isEmpty() ? "-1" : bi.C311.getText().toString().trim());
        json.put("C31198", bi.C31198.isChecked() ? "98" : "-1");

        json.put("C312", bi.C31201.isChecked() ? "1"
                : bi.C31202.isChecked() ? "2"
                : bi.C31298.isChecked() ? "98"
                : "-1");

        json.put("C313", bi.C313.getText().toString().trim().isEmpty() ? "-1" : bi.C313.getText().toString().trim());
        json.put("C31398", bi.C31398.isChecked() ? "98" : "-1");

        json.put("C314", bi.C31401.isChecked() ? "1"
                : bi.C31402.isChecked() ? "2"
                : bi.C31498.isChecked() ? "98"
                : "-1");

        json.put("C315", bi.C315.getText().toString().trim().isEmpty() ? "-1" : bi.C315.getText().toString().trim());
        json.put("C31598", bi.C31598.isChecked() ? "98" : "-1");

        json.put("C316", bi.C31601.isChecked() ? "1"
                : bi.C31602.isChecked() ? "2"
                : bi.C31698.isChecked() ? "98"
                : "-1");

        json.put("C317", bi.C317.getText().toString().trim().isEmpty() ? "-1" : bi.C317.getText().toString().trim());
        json.put("C31798", bi.C31798.isChecked() ? "98" : "-1");

        json.put("C318", bi.C31801.isChecked() ? "1"
                : bi.C31802.isChecked() ? "2"
                : bi.C31898.isChecked() ? "98"
                : "-1");

        json.put("C319", bi.C31901.isChecked() ? "1"
                : bi.C31902.isChecked() ? "2"
                : bi.C31998.isChecked() ? "98"
                : "-1");

        json.put("C320", bi.C320.getText().toString().trim().isEmpty() ? "-1" : bi.C320.getText().toString().trim());
        json.put("C32098", bi.C32098.isChecked() ? "98" : "-1");

        json.put("C321", bi.C32101.isChecked() ? "1"
                : bi.C32102.isChecked() ? "2"
                : bi.C32103.isChecked() ? "3"
                : bi.C32196.isChecked() ? "96"
                : "-1");
        json.put("C32196x", bi.C32196x.getText().toString().trim().isEmpty() ? "-1" : bi.C32196x.getText().toString().trim());

        json.put("C321A", bi.C321A01.isChecked() ? "1"
                : bi.C321A02.isChecked() ? "2"
                : bi.C321A03.isChecked() ? "3"
                : bi.C321A96.isChecked() ? "96"
                : "-1");
        json.put("C321A96x", bi.C321A96x.getText().toString().trim().isEmpty() ? "-1" : bi.C321A96x.getText().toString().trim());

        json.put("C322", bi.C32201.isChecked() ? "1"
                : bi.C32202.isChecked() ? "2"
                : bi.C32203.isChecked() ? "3"
                : bi.C32204.isChecked() ? "4"
                : bi.C32205.isChecked() ? "5"
                : bi.C32206.isChecked() ? "6"
                : bi.C32207.isChecked() ? "7"
                : bi.C32208.isChecked() ? "8"
                : bi.C32209.isChecked() ? "9"
                : bi.C32210.isChecked() ? "10"
                : bi.C32211.isChecked() ? "11"
                : bi.C32212.isChecked() ? "12"
                : bi.C32213.isChecked() ? "13"
                : bi.C32214.isChecked() ? "14"
                : bi.C32215.isChecked() ? "15"
                : bi.C32216.isChecked() ? "16"
                : bi.C32298.isChecked() ? "98"
                : bi.C32296.isChecked() ? "96"
                : "-1");
        json.put("C32296x", bi.C32296x.getText().toString().trim().isEmpty() ? "-1" : bi.C32296x.getText().toString().trim());

        json.put("C322A", bi.C322A01.isChecked() ? "1"
                : bi.C322A02.isChecked() ? "2"
                : bi.C322A98.isChecked() ? "98"
                : "-1");

        json.put("C322B", bi.C322B.getText().toString().trim().isEmpty() ? "-1" : bi.C322B.getText().toString().trim());
        json.put("C322B98", bi.C322B98.isChecked() ? "98" : "-1");

        json.put("C322C", bi.C322C01.isChecked() ? "1"
                : bi.C322C02.isChecked() ? "2"
                : bi.C322C98.isChecked() ? "98"
                : "-1");

        json.put("C322D", bi.C322D01.isChecked() ? "1"
                : bi.C322D02.isChecked() ? "2"
                : bi.C322D98.isChecked() ? "98"
                : "-1");

        json.put("C323", bi.C32301.isChecked() ? "1"
                : bi.C32302.isChecked() ? "2"
                : bi.C32303.isChecked() ? "3"
                : bi.C32304.isChecked() ? "4"
                : "-1");

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


/*
class MyTextWatcher implements TextWatcher {

    private View view;

    private MyTextWatcher(View view) {
        this.view = view;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //access view
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //access view
    }

    @Override
    public void afterTextChanged(Editable s) {
        //access view
    }
}*/
