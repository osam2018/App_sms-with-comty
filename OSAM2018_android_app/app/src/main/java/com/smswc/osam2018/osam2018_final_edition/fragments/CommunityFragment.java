package com.smswc.osam2018.osam2018_final_edition.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonElement;
import com.smswc.osam2018.osam2018_final_edition.R;
import com.smswc.osam2018.osam2018_final_edition.adapters.ArticleTypesAdapter;
import com.smswc.osam2018.osam2018_final_edition.adapters.ArticlesAdapter;
import com.smswc.osam2018.osam2018_final_edition.data.ArticleTypes;
import com.smswc.osam2018.osam2018_final_edition.lib.Requester;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

public class CommunityFragment extends Fragment {

    private View v;
    private RecyclerView rcvArticles, rcvArticleTypes;
    private ArticlesAdapter articlesAdapter;
    private ArticleTypesAdapter articleTypesAdapter;
    private RecyclerView.LayoutManager lmArticles, lmArticleTypes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_community, container, false);

        initialize();
        setRecyclerView();
        return v;
    }

    void initialize() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(v.getContext());
        String token = sp.getString("token", "null");
        try {
            token = URLEncoder.encode(token, "UTF-8");
            String params = "token=" + token + "&articletype=" + 0;
            JsonElement jsonElement = Requester.sendRequest("get", "/store", params);
            rcvArticles = v.findViewById(R.id.rcv_articles);
            rcvArticleTypes = v.findViewById(R.id.rcv_article_types);
            articlesAdapter = new ArticlesAdapter(jsonElement.getAsJsonArray());
            articleTypesAdapter = new ArticleTypesAdapter(ArticleTypes.getList(), articlesAdapter);
            lmArticles = new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false);
            lmArticleTypes = new LinearLayoutManager(v.getContext(), LinearLayoutManager.HORIZONTAL, false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    void setRecyclerView() {
        rcvArticles.setLayoutManager(lmArticles);
        rcvArticleTypes.setLayoutManager(lmArticleTypes);
        rcvArticles.setAdapter(articlesAdapter);
        rcvArticleTypes.setAdapter(articleTypesAdapter);
    }
}
