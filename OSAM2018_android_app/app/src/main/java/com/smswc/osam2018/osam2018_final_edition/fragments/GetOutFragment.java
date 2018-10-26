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
import com.smswc.osam2018.osam2018_final_edition.adapters.PastReturnsAdapter;

public class GetOutFragment extends Fragment {
    private RecyclerView rcvPastReturns;
    private PastReturnsAdapter pastReturnsAdapter;
    private RecyclerView.LayoutManager lm;
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_get_out, container, false);

        initialize();
        setRecyclerView();

        return v;
    }

    void initialize() {
        rcvPastReturns = v.findViewById(R.id.rcv_past_returns);
        pastReturnsAdapter = new PastReturnsAdapter();
        lm = new LinearLayoutManager(v.getContext());
    }

    void setRecyclerView() {
        rcvPastReturns.setAdapter(pastReturnsAdapter);
        rcvPastReturns.setLayoutManager(lm);
    }
}
