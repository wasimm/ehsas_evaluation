package edu.aku.wasimabbas.ehsas_evaluation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aku.wasimabbas.ehsas_evaluation.R;
import edu.aku.wasimabbas.ehsas_evaluation.ui.other.MWRAs;
import edu.aku.wasimabbas.ehsas_evaluation.ui.sections.C1;
import edu.aku.wasimabbas.ehsas_evaluation.ui.sections.W101;

public class MWRAsAdapter extends RecyclerView.Adapter<MWRAsAdapter.ViewHolder> {

    final View.OnClickListener onClickListener = new myOnClickListener();
    private final int selected_position = -1;
    public String fuid;
    Context context;
    List<MWRAs> MWRAsList;
    RecyclerView rvMWRAs;

    public MWRAsAdapter(Context context, List<MWRAs> MWRAsList, RecyclerView rvMWRAs) {
        this.context = context;
        this.MWRAsList = MWRAsList;
        this.rvMWRAs = rvMWRAs;
    }

    @NonNull
    @Override
    public MWRAsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        View view = inflater.inflate(R.layout.single_item2, ViewGroup, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MWRAsAdapter.ViewHolder viewHolder, int i) {
        MWRAs MWRA = MWRAsList.get(i);
        viewHolder.rowId.setText("" + MWRA.getId());
        viewHolder.rowSerialNo.setText("" + MWRA.getSerial());
        viewHolder.rowName.setText(MWRA.getName());
        viewHolder.rowUID.setText(MWRA.getUid());
    }

    @Override
    public int getItemCount() {
        return MWRAsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView rowId;
        TextView rowSerialNo;
        TextView rowName;
        TextView rowUID;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowId = itemView.findViewById(R.id.item_id);
            rowSerialNo = itemView.findViewById(R.id.item_serial);
            rowName = itemView.findViewById(R.id.item_name);
            rowUID = itemView.findViewById(R.id.item_uid);
        }
    }

    private class myOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            int itemPosition = rvMWRAs.getChildLayoutPosition(v);
            long id = MWRAsList.get(itemPosition).getId();
            int serial = MWRAsList.get(itemPosition).getSerial();
            String name = MWRAsList.get(itemPosition).getName();
            String uid = MWRAsList.get(itemPosition).getUid();
            String age = MWRAsList.get(itemPosition).getAge();


            Toast.makeText(context, "" + id, Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "" + serial, Toast.LENGTH_SHORT).show();
            Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
            Toast.makeText(context, uid, Toast.LENGTH_SHORT).show();
            /*v.setBackgroundResource(R.color.green_overlay);
            v.setOnClickListener(null);*/

            /*if (context instanceof edu.aku.wasimabbas.ehsas_evaluation.ui.sections.MWRAsList) {

                Toast.makeText(context, "Context: " + context, Toast.LENGTH_SHORT).show();
            }*/

            Intent intent;

            if (Integer.parseInt(age) > 1) {
                intent = new Intent(context, W101.class);
            } else {
                intent = new Intent(context, C1.class);
            }

            intent.putExtra("id", id);
            intent.putExtra("uid", uid);
            intent.putExtra("serialNo", serial);
            intent.putExtra("name", name);
            context.startActivity(intent);
        }
    }
}
