package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.MembersContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH2Binding;
import edu.aku.wasimabbas.ehsas_evaluation.models.Member;


public class H2 extends AppCompatActivity {

    public int counter;
    public String fuid;
    ActivityH2Binding bi;
    Intent oF = null;
    private DatabaseHelper db;

    public static boolean isValidDate(String inDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static int MonthsToDays(int tMonth, int tYear) {

        if (tMonth == 1 || tMonth == 3 || tMonth == 5 || tMonth == 7
                || tMonth == 8 || tMonth == 10 || tMonth == 12) {
            return 31;
        } else if (tMonth == 2) {
            if (tYear % 4 == 0) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 30;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h2);
        bi.setCallback(this);

        fuid = MainApp.form.getUid();

        Intent intent = getIntent();
        counter = intent.getIntExtra("counter", 0);
        counter = counter + 1;

        bi.H201.setText(String.valueOf(counter));

        setupSkip();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        /*TextWatcher textwatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 0) {
                    Toast.makeText(getApplication(), "S: " + s, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplication(), "Length is 0", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };*/
        //H20603
        //bi.H20603.addTextChangedListener(textwatcher);

        Toast.makeText(this, "H2: " + fuid, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupSkip() {

        //H204
        bi.H204.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.H20402.getId()) {
                bi.fldGrpCVH210.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVH210);
                bi.fldGrpCVH210.setVisibility(View.GONE);
            }
        });

        bi.H20503.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Toast.makeText(H2.this, "Length: " + s.length(), Toast.LENGTH_SHORT).show();

                if (s.length() == 4) {

                    if (!bi.H20501.getText().toString().equals("98") && !bi.H20502.getText().toString().equals("98") && !bi.H20503.getText().toString().equals("9998")) {

                        String dob = bi.H20501.getText().toString() + "/" + bi.H20502.getText().toString() + "/" + bi.H20503.getText().toString();

                        if (!isValidDate(dob)) {

                            bi.H20501.setError("Kindly enter a valid Date of Birth");
                            bi.H20501.requestFocus();

                        } else {

                            int[] Age = calculateAge(dob, MainApp.interviewDate);
                            int days = Age[0];
                            int months = Age[1];
                            int years = Age[2];
                            bi.H20601.setText(String.valueOf(days));
                            bi.H20602.setText(String.valueOf(months));
                            bi.H20603.setText(String.valueOf(years));
                        }

                    } else {

                        if (bi.H20503.getText().toString().equals("9998")) {

                            bi.H20601.setEnabled(true);
                            bi.H20601.setText(null);

                            bi.H20602.setEnabled(true);
                            bi.H20602.setText(null);

                            bi.H20603.setEnabled(true);
                            bi.H20603.setText(null);

                        } else {

                            String dob = bi.H20501.getText().toString() + "/" + bi.H20502.getText().toString() + "/" + bi.H20503.getText().toString();

                            int[] Age = calculateAge(dob, MainApp.interviewDate);
                            int days = Age[0];
                            int months = Age[1];
                            int years = Age[2];
                            bi.H20601.setText(String.valueOf(days));
                            bi.H20602.setText(String.valueOf(months));
                            bi.H20603.setText(String.valueOf(years));
                        }
                    }

                } else {

                    bi.H20601.setEnabled(false);
                    bi.H20601.setText(null);

                    bi.H20602.setEnabled(false);
                    bi.H20602.setText(null);

                    bi.H20603.setEnabled(false);
                    bi.H20603.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        bi.H20603.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 0) {

                    if (Integer.parseInt(s.toString()) < 3) {
                        Clear.clearAllFields(bi.fldGrpCVH211);
                        bi.fldGrpCVH211.setVisibility(View.GONE);
                        Clear.clearAllFields(bi.fldGrpCVH212);
                        bi.fldGrpCVH212.setVisibility(View.GONE);
                    } else {
                        bi.fldGrpCVH211.setVisibility(View.VISIBLE);
                        bi.fldGrpCVH212.setVisibility(View.VISIBLE);
                    }

                    if (Integer.parseInt(s.toString()) < 10) {
                        Clear.clearAllFields(bi.fldGrpCVH209);
                        bi.fldGrpCVH209.setVisibility(View.GONE);
                    } else {
                        bi.fldGrpCVH209.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        //H20704
        bi.H20704.setOnCheckedChangeListener((group, isChecked) -> {
            if (isChecked) {
                Clear.clearAllFields(bi.fldGrpCVH208);
                bi.fldGrpCVH208.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH208.setVisibility(View.VISIBLE);
            }
        });

        //H20796
        bi.H20796.setOnCheckedChangeListener((group, isChecked) -> {
            if (isChecked) {
                Clear.clearAllFields(bi.fldGrpCVH208);
                bi.fldGrpCVH208.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVH208.setVisibility(View.VISIBLE);
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
            startActivity(new Intent(this, MemberList.class).putExtra("counter", counter));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        MainApp.openEndActivity(this);
    }

    private boolean UpdateDB() {

        db = new DatabaseHelper(this);
        long inserted = db.addFamilyMember(MainApp.mc);
        MainApp.mc.setId(String.valueOf(inserted));
        if (inserted > 0) {
            MainApp.mc.setUid(MainApp.deviceId + MainApp.mc.getId());
            db.updatesFamilyMemberColumn(MembersContract.MembersTable.COLUMN_UID, MainApp.mc.getUid(), MainApp.mc.getId());
            db.updateH214ToH216(MainApp.mc.getFuid(), MainApp.mc.getH204(), MainApp.mc.getH20603());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        MainApp.mc = new Member();

        MainApp.mc.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        MainApp.mc.setUsername(MainApp.userName);
        MainApp.mc.setDeviceid(MainApp.appInfo.getDeviceID());
        MainApp.mc.setDevicetagid(MainApp.appInfo.getDeviceID());
        MainApp.mc.setAppversion(MainApp.appInfo.getAppVersion());
        MainApp.mc.setFuid(fuid);

        MainApp.mc.setH201(String.valueOf(counter));

        MainApp.mc.setH202(bi.H202.getText().toString().trim().isEmpty() ? "-1" : bi.H202.getText().toString().trim());

        MainApp.mc.setH203(bi.H20301.isChecked() ? "1"
                : bi.H20302.isChecked() ? "2"
                : bi.H20303.isChecked() ? "3"
                : bi.H20304.isChecked() ? "4"
                : bi.H20305.isChecked() ? "5"
                : bi.H20306.isChecked() ? "6"
                : bi.H20307.isChecked() ? "7"
                : bi.H20308.isChecked() ? "8"
                : bi.H20309.isChecked() ? "9"
                : bi.H20310.isChecked() ? "10"
                : bi.H20311.isChecked() ? "11"
                : bi.H20312.isChecked() ? "12"
                : bi.H20313.isChecked() ? "13"
                : bi.H20314.isChecked() ? "14"
                : bi.H20315.isChecked() ? "15"
                : bi.H20396.isChecked() ? "96"
                : bi.H20398.isChecked() ? "98"
                : "-1");

        MainApp.mc.setH204(bi.H20401.isChecked() ? "1"
                : bi.H20402.isChecked() ? "2"
                : bi.H20403.isChecked() ? "3"
                : "-1");

        MainApp.mc.setH20501(bi.H20501.getText().toString().trim().isEmpty() ? "-1" : bi.H20501.getText().toString().trim());
        MainApp.mc.setH20502(bi.H20502.getText().toString().trim().isEmpty() ? "-1" : bi.H20502.getText().toString().trim());
        MainApp.mc.setH20503(bi.H20503.getText().toString().trim().isEmpty() ? "-1" : bi.H20503.getText().toString().trim());

        MainApp.mc.setH20601(bi.H20601.getText().toString().trim().isEmpty() ? "-1" : bi.H20601.getText().toString().trim());
        MainApp.mc.setH20602(bi.H20602.getText().toString().trim().isEmpty() ? "-1" : bi.H20602.getText().toString().trim());
        MainApp.mc.setH20603(bi.H20603.getText().toString().trim().isEmpty() ? "-1" : bi.H20603.getText().toString().trim());

        MainApp.mc.setH20701(bi.H20701.isChecked() ? "1" : "-1");
        MainApp.mc.setH20702(bi.H20702.isChecked() ? "2" : "-1");
        MainApp.mc.setH20703(bi.H20703.isChecked() ? "3" : "-1");
        MainApp.mc.setH20704(bi.H20704.isChecked() ? "4" : "-1");
        MainApp.mc.setH20796(bi.H20796.isChecked() ? "96" : "-1");
        MainApp.mc.setH20796x(bi.H20796x.getText().toString().trim().isEmpty() ? "-1" : bi.H20796x.getText().toString().trim());

        MainApp.mc.setH208(bi.H208.getText().toString().trim().isEmpty() ? "-1" : bi.H208.getText().toString().trim());

        MainApp.mc.setH209(bi.H20901.isChecked() ? "1"
                : bi.H20902.isChecked() ? "2"
                : bi.H20903.isChecked() ? "3"
                : bi.H20904.isChecked() ? "4"
                : bi.H20905.isChecked() ? "5"
                : "-1");

        MainApp.mc.setH210(bi.H21001.isChecked() ? "1"
                : bi.H21002.isChecked() ? "2"
                : bi.H21003.isChecked() ? "3"
                : bi.H21004.isChecked() ? "4"
                : "-1");

        MainApp.mc.setH211(bi.H21101.isChecked() ? "1"
                : bi.H21102.isChecked() ? "2"
                : bi.H21103.isChecked() ? "3"
                : bi.H21104.isChecked() ? "4"
                : bi.H21105.isChecked() ? "5"
                : bi.H21106.isChecked() ? "6"
                : bi.H21107.isChecked() ? "7"
                : bi.H21108.isChecked() ? "8"
                : bi.H21109.isChecked() ? "9"
                : bi.H21198.isChecked() ? "98"
                : "-1");

        MainApp.mc.setH212(bi.H21201.isChecked() ? "1"
                : bi.H21202.isChecked() ? "2"
                : bi.H21203.isChecked() ? "3"
                : bi.H21204.isChecked() ? "4"
                : bi.H21205.isChecked() ? "5"
                : bi.H21206.isChecked() ? "6"
                : bi.H21207.isChecked() ? "7"
                : bi.H21208.isChecked() ? "8"
                : bi.H21209.isChecked() ? "9"
                : bi.H21210.isChecked() ? "10"
                : bi.H21296.isChecked() ? "96"
                : "-1");
        MainApp.mc.setH21296x(bi.H21296x.getText().toString().trim().isEmpty() ? "-1" : bi.H21296x.getText().toString().trim());

        MainApp.mc.setE101("-1");
        MainApp.mc.setE102("-1");
        MainApp.mc.setE103("-1");
        MainApp.mc.setE104("-1");
        MainApp.mc.setE105("-1");
        MainApp.mc.setE106("-1");
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);

        /*String dob = "";
        if (bi.H20501.getText().toString() == "98" && bi.H20502.getText().toString() == "98" && bi.H20503.getText().toString() == "9998") {
            dob = bi.H20501.getText().toString() + "-" + bi.H20502.getText().toString() + "-" + bi.H20503.getText().toString();
        }

        if (!isValidDate(dob)) {
            bi.H20501.setError("Kindly enter a valid Date of Birth");
            bi.H20501.requestFocus();
            return false;
        }*/
    }

    public int[] calculateAge(String dob, String curd) {

        String[] dob_sep = dob.split("/");
        String[] curd_sep = curd.split("/");

        String dob_day = dob_sep[0];
        String dob_month = dob_sep[1];
        String dob_year = dob_sep[2];
        String curd_day = curd_sep[0];
        String curd_month = curd_sep[1];
        String curd_year = curd_sep[2];

        int mYearDiff, mMonDiff, mDayDiff;

        if (parseInt(dob_year) == 9998 || parseInt(curd_year) == 9998) {

            mYearDiff = 0;

        } else {

            mYearDiff = parseInt(curd_year) - parseInt(dob_year);
        }

        if (parseInt(dob_month) == 98 || parseInt(curd_month) == 98) {

            mMonDiff = 0;

        } else {

            mMonDiff = parseInt(curd_month) - parseInt(dob_month);

            if (mMonDiff < 0) {
                mYearDiff = mYearDiff - 1;
                mMonDiff = mMonDiff + 12;
            }
        }

        if (parseInt(dob_day) == 98 || parseInt(curd_day) == 98) {

            mDayDiff = 0;

        } else {

            mDayDiff = parseInt(curd_day) - parseInt(dob_day);
        }

        if (mDayDiff < 0) {
            if (mMonDiff > 0) {
                mMonDiff = mMonDiff - 1;
                mDayDiff = mDayDiff + MonthsToDays(parseInt(curd_month) - 1, parseInt(curd_year));

            } else {
                mYearDiff = mYearDiff - 1;
                mMonDiff = 11;
                mDayDiff = mDayDiff + MonthsToDays(parseInt(curd_month) - 1, parseInt(curd_year));
            }

        }

        int[] Age = new int[]{mDayDiff, mMonDiff, mYearDiff};

        return Age;
    }
}