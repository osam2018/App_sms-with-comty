package com.smswc.osam2018.osam2018_final_edition.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smswc.osam2018.osam2018_final_edition.R;
import com.smswc.osam2018.osam2018_final_edition.activities.IntroActivity;
import com.smswc.osam2018.osam2018_final_edition.lib.Requester;

public class MyPageFragment extends Fragment {
    private View v;
    private Button btnLogout;
    private TextView tvId, tvNickname;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my_page, container, false);

        btnLogout = v.findViewById(R.id.btn_logout);
        tvId = v.findViewById(R.id.tv_id_value);
        tvNickname = v.findViewById(R.id.tv_nickname_value);

        SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        /*
        String token = sp.getString("token", "null");
        Requester.sendRequest("get", "/user/info", token);
        */
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(v.getContext(), IntroActivity.class));
                getActivity().finish();
            }
        });
        return v;
    }
}
