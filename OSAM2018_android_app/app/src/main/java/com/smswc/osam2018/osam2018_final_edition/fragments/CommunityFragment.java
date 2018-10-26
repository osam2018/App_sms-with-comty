package com.smswc.osam2018.osam2018_final_edition.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smswc.osam2018.osam2018_final_edition.R;
import com.smswc.osam2018.osam2018_final_edition.adapters.ArticleTypesAdapter;
import com.smswc.osam2018.osam2018_final_edition.adapters.ArticlesAdapter;

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
        rcvArticles = v.findViewById(R.id.rcv_articles);
        rcvArticleTypes = v.findViewById(R.id.rcv_article_types);
        articlesAdapter = new ArticlesAdapter();
        articleTypesAdapter = new ArticleTypesAdapter();
        lmArticles = new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false);
        lmArticleTypes = new LinearLayoutManager(v.getContext(), LinearLayoutManager.HORIZONTAL, false);
    }

    void setRecyclerView() {
        rcvArticles.setLayoutManager(lmArticles);
        rcvArticleTypes.setLayoutManager(lmArticleTypes);
        rcvArticles.setAdapter(articlesAdapter);
        rcvArticleTypes.setAdapter(articleTypesAdapter);
    }
}
