package com.smswc.osam2018.osam2018_final_edition.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smswc.osam2018.osam2018_final_edition.R;

public class PastReturnsAdapter extends RecyclerView.Adapter<PastReturnsAdapter.ItemVH> {
    @NonNull
    @Override
    public PastReturnsAdapter.ItemVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_past_returns, viewGroup, false);
        return new ItemVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PastReturnsAdapter.ItemVH h, int i) {
        h.tvReturnTime.setText("test1");
        h.tvGetOutType.setText("test2");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ItemVH extends RecyclerView.ViewHolder {

        TextView tvGetOutType, tvReturnTime;

        public ItemVH(@NonNull View v) {
            super(v);
            tvGetOutType = v.findViewById(R.id.tv_getout_type);
            tvReturnTime = v.findViewById(R.id.tv_return_time);

        }
    }
}
