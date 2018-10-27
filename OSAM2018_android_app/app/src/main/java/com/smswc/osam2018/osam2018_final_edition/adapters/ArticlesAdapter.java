package com.smswc.osam2018.osam2018_final_edition.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.smswc.osam2018.osam2018_final_edition.R;
import com.smswc.osam2018.osam2018_final_edition.activities.ArticleReadActivity;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ItemVH> {
    private JsonArray jsonElements;

    public ArticlesAdapter(JsonArray jsonElements) {
        this.jsonElements = jsonElements;
    }

    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_articles, viewGroup, false);
        return new ItemVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemVH itemVH, int i) {
        final JsonObject jsonObject = jsonElements.get(i).getAsJsonObject();
        itemVH.tvTitle.setText(jsonObject.get("title").getAsString());
        itemVH.tvContent.setText(jsonObject.get("content").getAsString());
        itemVH.tvAuthor.setText(jsonObject.get("creator").getAsString());
        itemVH.tvCreatedTIme.setText(jsonObject.get("created_time").getAsString());

        itemVH.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemVH.v.getContext(), ArticleReadActivity.class);
                intent.putExtra("article_no", jsonObject.get("article_no").getAsInt());
                itemVH.v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jsonElements.size();
    }

    class ItemVH extends RecyclerView.ViewHolder {
        View v;
        TextView tvTitle, tvContent, tvAuthor, tvCreatedTIme;
        public ItemVH(@NonNull View v) {
            super(v);
            this.v = v;
            tvTitle = v.findViewById(R.id.tv_title);
            tvContent = v.findViewById(R.id.tv_content);
            tvAuthor = v.findViewById(R.id.tv_author);
            tvCreatedTIme = v.findViewById(R.id.tv_created_time);
        }
    }

    public void update(JsonArray jsonElements) {
        this.jsonElements = jsonElements;

        notifyDataSetChanged();
    }
}
