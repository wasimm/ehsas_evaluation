package edu.aku.wasimabbas.ehsas_evaluation.ui.sections

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.wasimabbas.ehsas_evaluation.CONSTANTS
import edu.aku.wasimabbas.ehsas_evaluation.R
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.appInfo
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp.mwra
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityMwraEndingBinding
import edu.aku.wasimabbas.ehsas_evaluation.utils.JSONUtils
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class EndingMWRA : AppCompatActivity() {
    lateinit var bi: ActivityMwraEndingBinding
    var flag = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_mwra_ending)
        bi.callback = this

        val check = intent.getBooleanExtra("complete", false)
        if (check) {
            bi.W10401.isEnabled = true
            bi.W10402.isEnabled = false
            bi.W10403.isEnabled = false
            bi.W10404.isEnabled = false
            bi.W10405.isEnabled = false
            bi.W10496.isEnabled = false
        } else {
            bi.W10401.isEnabled = false
            bi.W10402.isEnabled = true
            bi.W10403.isEnabled = true
            bi.W10404.isEnabled = true
            bi.W10405.isEnabled = true
            bi.W10496.isEnabled = true
        }

        flag = intent.getStringExtra(CONSTANTS.SELECTED_MODEL).toString()

        Toast.makeText(this, "EndingMWRA: " + mwra.uid, Toast.LENGTH_SHORT).show()
    }

    fun BtnEnd() {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            finish()
            startActivity(Intent(this, MWRAsList::class.java))
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveDraft() {

        val statusValue = if (bi.W10401.isChecked) "1"
        else if (bi.W10402.isChecked) "2"
        else if (bi.W10403.isChecked) "3"
        else if (bi.W10404.isChecked) "4"
        else if (bi.W10405.isChecked) "5"
        else if (bi.W10496.isChecked) "96"
        else "-1"

        mwra.istatus = statusValue
        mwra.istatus96x =
            if (bi.W10496x.text.toString().trim().isEmpty()) "-1" else bi.W10496x.text.toString()
        mwra.endingdatetime =
            SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH).format(Date().time)

        val json = JSONObject()
        json.put(
            "W104",
            if (bi.W10401.isChecked) "1" else if (bi.W10402.isChecked) "2" else if (bi.W10403.isChecked) "3" else if (bi.W10404.isChecked) "4" else if (bi.W10405.isChecked) "5" else if (bi.W10496.isChecked) "96" else "-1"
        )
        json.put(
            "W10496x",
            if (bi.W10496x.text.toString().trim().isEmpty()) "-1" else bi.W10496x.text
                .toString().trim()
        )

        try {
            val json_merged = JSONUtils.mergeJSONObjects(JSONObject(mwra.json), json)
            mwra.json = json_merged.toString()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


    private fun updateDB(): Boolean {
        val db = appInfo.dbHelper
        val updcount = db.updateMWRAEnding()
        return if (updcount == 1) {
            true
        } else {
            Toast.makeText(
                this,
                "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)",
                Toast.LENGTH_SHORT
            ).show()
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