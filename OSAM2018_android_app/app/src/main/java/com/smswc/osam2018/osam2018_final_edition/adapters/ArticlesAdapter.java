package com.smswc.osam2018.osam2018_final_edition.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smswc.osam2018.osam2018_final_edition.R;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ItemVH> {
    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_articles, viewGroup, false);
        return new ItemVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVH itemVH, int i) {
        itemVH.tvTitle.setText("제목입니다.");
        itemVH.tvContent.setText("긴 글 테스트트트틑트 긴 글 긴 글 테스트트트틑트 긴 글긴 글 테스트트트틑트 긴 글긴 글 테스트트트틑트 긴 글긴 글 테스트트트틑트 긴 글긴 글 테스트트트틑트 긴 글");
        itemVH.tvAuthor.setText("오시환");
        itemVH.tvCreatedTIme.setText("18.10.31 04:30PM");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ItemVH extends RecyclerView.ViewHolder {
        TextView tvTitle, tvContent, tvAuthor, tvCreatedTIme;
        public ItemVH(@NonNull View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_title);
            tvContent = v.findViewById(R.id.tv_content);
            tvAuthor = v.findViewById(R.id.tv_author);
            tvCreatedTIme = v.findViewById(R.id.tv_created_time);
        }
    }
}
