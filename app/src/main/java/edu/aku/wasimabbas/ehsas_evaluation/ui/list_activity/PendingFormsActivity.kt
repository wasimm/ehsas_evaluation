package edu.aku.wasimabbas.ehsas_evaluation.ui.list_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import edu.aku.wasimabbas.ehsas_evaluation.R
import edu.aku.wasimabbas.ehsas_evaluation.adapter.PendingListAdapter
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityPendingFormsBinding
import edu.aku.wasimabbas.ehsas_evaluation.models.Form


class PendingFormsActivity : AppCompatActivity() {

    lateinit var bi: ActivityPendingFormsBinding
    lateinit var adapter: PendingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_pending_forms)
        bi.callback = this

        //val unclosedForms = MainApp.appInfo.dbHelper.unclosedForms
        //setupRecyclerView(unclosedForms)
    }

    private fun setupRecyclerView(forms_lst: MutableList<Form>) {
        adapter = PendingListAdapter(this, forms_lst)
        bi.recyclerView.layoutManager = LinearLayoutManager(this)
        bi.recyclerView.adapter = adapter
    }
}
