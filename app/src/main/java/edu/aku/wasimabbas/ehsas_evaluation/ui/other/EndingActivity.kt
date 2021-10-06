package edu.aku.wasimabbas.ehsas_evaluation.ui.other

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.wasimabbas.ehsas_evaluation.CONSTANTS
import edu.aku.wasimabbas.ehsas_evaluation.R
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.appInfo
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.form
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityEndingBinding
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class EndingActivity : AppCompatActivity() {
    lateinit var bi: ActivityEndingBinding
    var flag = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending)
        bi.callback = this

        val check = intent.getBooleanExtra("complete", false)
        if (check) {
            bi.H11801.isEnabled = true
            bi.H11802.isEnabled = false
            bi.H11803.isEnabled = false
            bi.H11804.isEnabled = false
            bi.H11805.isEnabled = false
            bi.H11806.isEnabled = false
            bi.H11896.isEnabled = false
        } else {
            bi.H11801.isEnabled = false
            bi.H11802.isEnabled = true
            bi.H11803.isEnabled = true
            bi.H11804.isEnabled = true
            bi.H11805.isEnabled = true
            bi.H11806.isEnabled = true
            bi.H11896.isEnabled = true
        }

        flag = intent.getStringExtra(CONSTANTS.SELECTED_MODEL).toString()
    }

    fun BtnEnd() {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveDraft() {

        val statusValue = if (bi.H11801.isChecked) "1"
        else if (bi.H11802.isChecked) "2"
        else if (bi.H11803.isChecked) "3"
        else if (bi.H11804.isChecked) "4"
        else if (bi.H11805.isChecked) "5"
        else if (bi.H11806.isChecked) "6"
        else if (bi.H11896.isChecked) "96"
        else "-1"


        form.istatus = statusValue
        form.istatus96x =
            if (bi.H11896x.text.toString().trim().isEmpty()) "-1" else bi.H11896x.text.toString()
        form.endingdatetime =
            SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH).format(Date().time)

        val json = JSONObject()
        json.put(
            "H118",
            if (bi.H11801.isChecked) "1" else if (bi.H11802.isChecked) "2" else if (bi.H11803.isChecked) "3" else if (bi.H11804.isChecked) "4" else if (bi.H11805.isChecked) "5" else if (bi.H11806.isChecked) "6" else if (bi.H11896.isChecked) "96" else "-1"
        )
        json.put(
            "H11896x",
            if (bi.H11896x.text.toString().trim().isEmpty()) "-1" else bi.H11896x.text
                .toString().trim()
        )

        try {
            val json_merged = JSONUtils.mergeJSONObjects(JSONObject(form.json), json)
            form.json = json_merged.toString()
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        /*when (flag) {
            CONSTANTS.FORM_MP -> {
                form.istatus = statusValue
                form.istatus96x = if (bi.istatus96x.text.toString().trim().isEmpty()) "-1" else bi.istatus96x.text.toString()
                form.endingdatetime = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH).format(Date().time)
            }
            else -> {
                assessment.istatus = statusValue
                assessment.istatus96x = if (bi.istatus96x.text.toString().trim().isEmpty()) "-1" else bi.istatus96x.text.toString()
                assessment.endingdatetime = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH).format(Date().time)
            }
        }*/

    }

    private fun updateDB(): Boolean {
        val db = appInfo.dbHelper
        val updcount = db.updateEnding()
        return if (updcount == 1) {
            true
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.fldGrpEnd)
    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext, "You Can't go back", Toast.LENGTH_LONG).show()
    }
}