package com.smswc.osam2018.osam2018_final_edition.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smswc.osam2018.osam2018_final_edition.R;

public class ArticleTypesAdapter extends RecyclerView.Adapter<ArticleTypesAdapter.ItemVH> {
    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_article_types, viewGroup, false);
        return new ItemVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVH itemVH, int i) {
        itemVH.tvType.setText("메뉴");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ItemVH extends RecyclerView.ViewHolder {
        TextView tvType;
        public ItemVH(@NonNull View v) {
            super(v);
            tvType = v.findViewById(R.id.tv_type);
        }
    }
}
