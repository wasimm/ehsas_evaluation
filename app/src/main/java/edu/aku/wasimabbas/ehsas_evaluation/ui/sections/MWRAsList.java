package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.adapter.MWRAsAdapter;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.core.MainApp;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityMwrasListviewBinding;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.MWRAs;


public class MWRAsList extends AppCompatActivity {

    public int counter;
    ActivityMwrasListviewBinding bi;
    Intent oF = null;
    MWRAsAdapter MWRAsAdapter;
    RecyclerView rvMWRAs;
    RecyclerView.LayoutManager layoutManager;
    List<MWRAs> MWRAsList = new ArrayList<>();
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_mwras_listview);
        bi.setCallback(this);

        db = new DatabaseHelper(this);
        MWRAsList = db.getAllMWRAs(MainApp.form.getUid());

        if (MWRAsList.size() == 0) {
            startActivity(new Intent(this, ChildrenList.class));
        }

        rvMWRAs = bi.MWRAs;
        rvMWRAs.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvMWRAs.setLayoutManager(layoutManager);
        MWRAsAdapter = new MWRAsAdapter(MWRAsList.this, MWRAsList, rvMWRAs);
        rvMWRAs.setAdapter(MWRAsAdapter);
    }

    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }

}