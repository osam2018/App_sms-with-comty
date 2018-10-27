package com.smswc.osam2018.osam2018_final_edition.adapters;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.smswc.osam2018.osam2018_final_edition.R;
import com.smswc.osam2018.osam2018_final_edition.data.ArticleTypes;
import com.smswc.osam2018.osam2018_final_edition.lib.Requester;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ArticleTypesAdapter extends RecyclerView.Adapter<ArticleTypesAdapter.ItemVH> {
    private ArrayList<ArticleTypes.ArticleType> types;
    private ArticlesAdapter articlesAdapter;

    public ArticleTypesAdapter(ArrayList<ArticleTypes.ArticleType> types, ArticlesAdapter articlesAdapter) {
        this.types = types;
        this.articlesAdapter = articlesAdapter;
    }

    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_article_types, viewGroup, false);

        return new ItemVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemVH itemVH, final int i) {
        itemVH.tvType.setText(types.get(i).getTypeName());
        itemVH.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(itemVH.v.getContext());
                String token = sp.getString("token", "null");
                try {
                    token = URLEncoder.encode(token, "UTF-8");
                    String params = "token=" + token + "&articletype=" + i;
                    JsonElement jsonElement = Requester.sendRequest("get", "/store", params);
                    articlesAdapter.update(jsonElement.getAsJsonArray());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    class ItemVH extends RecyclerView.ViewHolder {
        TextView tvType;
        View v;
        public ItemVH(@NonNull View v) {
            super(v);
            this.v = v;
            tvType = v.findViewById(R.id.tv_type);
        }
    }
}
