package edu.aku.wasimabbas.ehsas_evaluation.ui.sections;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.core.DatabaseHelper;
import edu.aku.wasimabbas.ehsas_evaluation.databinding.ActivityMembersListviewBinding;


public class MemberList extends AppCompatActivity {

    public int counter;
    public String fuid;
    ActivityMembersListviewBinding bi;
    Intent oF = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_members_listview);
        bi.setCallback(this);

        //fuid = MainApp.form.getUid();
        fuid = "fb47bf5763adfcbf1";

        Intent intent = getIntent();
        counter = intent.getIntExtra("counter", 0);

        db = new DatabaseHelper(this);
        final SimpleCursorAdapter simpleCursorAdapter = db.populateListView(fuid);
        bi.familyMembers.setAdapter(simpleCursorAdapter);

        bi.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberList.this, H2.class).putExtra("counter", counter));
            }
        });

        bi.btnNextSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MemberList.this);
                builder.setCancelable(true);
                builder.setTitle("Go to Next Section");
                builder.setMessage("Are you sure you want to go to next section");
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (bi.familyMembers.getCount() < 1) {
                                    Toast.makeText(MemberList.this, "Minimum two family members must be added", Toast.LENGTH_LONG).show();
                                } else {
                                    startActivity(new Intent(MemberList.this, H301.class));
                                }
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }

    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }

}