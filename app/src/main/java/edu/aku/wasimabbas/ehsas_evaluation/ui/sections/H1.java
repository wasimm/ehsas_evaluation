package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import static edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.form;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityH1Binding;
import edu.aku.wasimabbas.ehsas_evaluation.models.Form;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.EndingActivity;


public class H1 extends AppCompatActivity {

    /*private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };
    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};
    */

    ActivityH1Binding bi;
    Intent oF = null;
    String SectionBActivity;
    private DatabaseHelper db;
    private List<String> schools;
    private String semisCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_h1);
        bi.setCallback(this);
        setupSkip();

        //populateSpinner(this);

        /*TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String selectedValue = charSequence.toString();

                Toast.makeText(getApplicationContext(), "" + selectedValue, Toast.LENGTH_LONG).show();

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };
        bi.B4.addTextChangedListener(textWatcher);*/

        /*bi.B1.setEnabled(false);
        bi.B3.setEnabled(false);

        TextWatcher textwatcher2 = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 0 && s.length() < 9) {
                    bi.B1.setText(null);
                    bi.B2.setText(null);
                    bi.B3.setText(null);
                    bi.submitBtns.setVisibility(View.GONE);
                    //Toast.makeText(getApplicationContext(), "either 0 or greater than 9 length", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "length is 0", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        bi.B4.addTextChangedListener(textwatcher2);*/
    }

    /*private void populateSpinner(final Context context) {

        db = MainApp.appInfo.getDbHelper();
        Cursor schoolsList = db.getRecords();
        if (schoolsList.getCount() > 0) {
            schoolsList.moveToFirst();
            schools = new ArrayList<>();
            schools.add("....");
            for (int i = 0; i < schoolsList.getCount(); i++) {
                schools.add(schoolsList.getString(schoolsList.getColumnIndex("semisCode")));
                schoolsList.moveToNext();
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, schools);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView activity = findViewById(R.id.B4);
        activity.setThreshold(1);//will start working from first character
        activity.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        activity.setTextColor(Color.parseColor("#16A085"));
    }*/

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
            startActivity(new Intent(this, H301.class));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        oF = new Intent(this, EndingActivity.class);
        startActivity(oF);
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addForm(form);
        form.setId(String.valueOf(updcount));
        if (updcount > 0) {
            form.setUid(form.getDeviceid() + form.getId());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.getUid());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        /*assessment = new Assessment();
        assessment.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        assessment.setFormtype(CONSTANTS.FORM_MA);
        assessment.setUsername(MainApp.userName);
        assessment.setDeviceid(MainApp.appInfo.getDeviceID());
        assessment.setMa104(bi.ma10401.isChecked() ? "1"
                : bi.ma10402.isChecked() ? "2"
                : "-1");
        assessment.setMa105(bi.ma105.getText().toString().trim().isEmpty() ? "-1" : bi.ma105.getText().toString());*/


        MainApp.form = new Form();
        MainApp.form.setSysdate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()));
        MainApp.form.setUsername(MainApp.userName);
        MainApp.form.setDeviceid(MainApp.appInfo.getDeviceID());

        JSONObject json = new JSONObject();

        json.put("H101", bi.H101.getText().toString().trim().isEmpty() ? "-1" : bi.H101.getText().toString().trim());
        json.put("H102", bi.H102.getText().toString().trim().isEmpty() ? "-1" : bi.H102.getText().toString().trim());
        json.put("H103", bi.H103.getText().toString().trim().isEmpty() ? "-1" : bi.H103.getText().toString().trim());
        json.put("H104", bi.H104.getText().toString().trim().isEmpty() ? "-1" : bi.H104.getText().toString().trim());
        json.put("H105", bi.H105.getText().toString().trim().isEmpty() ? "-1" : bi.H105.getText().toString().trim());
        json.put("H106", bi.H106.getText().toString().trim().isEmpty() ? "-1" : bi.H106.getText().toString().trim());
        json.put("H107", bi.H107.getText().toString().trim().isEmpty() ? "-1" : bi.H107.getText().toString().trim());
        json.put("H108", bi.H108.getText().toString().trim().isEmpty() ? "-1" : bi.H108.getText().toString().trim());
        json.put("H109", bi.H109.getText().toString().trim().isEmpty() ? "-1" : bi.H109.getText().toString().trim());
        json.put("H110", bi.H110.getText().toString().trim().isEmpty() ? "-1" : bi.H110.getText().toString().trim());
        json.put("H111", bi.H111.getText().toString().trim().isEmpty() ? "-1" : bi.H111.getText().toString().trim());
        json.put("H112", bi.H112.getText().toString().trim().isEmpty() ? "-1" : bi.H112.getText().toString().trim());
        json.put("H113", bi.H113.getText().toString().trim().isEmpty() ? "-1" : bi.H113.getText().toString().trim());
        json.put("H114", bi.H114.getText().toString().trim().isEmpty() ? "-1" : bi.H114.getText().toString().trim());

        json.put("H115", bi.H11501.isChecked() ? "1"
                : bi.H11502.isChecked() ? "2"
                : "-1");

        json.put("H116", bi.H11601.isChecked() ? "1"
                : bi.H11602.isChecked() ? "2"
                : "-1");

        MainApp.form.setJSON(String.valueOf(json));
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }

}