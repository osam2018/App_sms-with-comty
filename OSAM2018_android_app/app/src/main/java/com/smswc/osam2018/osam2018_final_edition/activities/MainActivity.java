package com.smswc.osam2018.osam2018_final_edition.activities;

import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.smswc.osam2018.osam2018_final_edition.R;
import com.smswc.osam2018.osam2018_final_edition.fragments.CommunityFragment;
import com.smswc.osam2018.osam2018_final_edition.fragments.GetOutFragment;
import com.smswc.osam2018.osam2018_final_edition.fragments.MyPageFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentManager fm;
    private FragmentTransaction ft;

    private TextView tvTabMyPage, tvTabGetOut, tvTabCommunity;
    private TextView tabs[];
    private final int TAB_SIZE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setOnClickListener();
    }

    void initialize() {
        tvTabMyPage = findViewById(R.id.tv_my_page);
        tvTabGetOut = findViewById(R.id.tv_get_out);
        tvTabCommunity = findViewById(R.id.tv_community);
        tabs = new TextView[TAB_SIZE];

        tabs[0] = tvTabMyPage;
        tabs[1] = tvTabGetOut;
        tabs[2] = tvTabCommunity;

        fm = getSupportFragmentManager();

        changeTabUI(1);
        ft = fm.beginTransaction();
        ft.replace(R.id.container, new GetOutFragment());
        ft.commit();
    }

    void setOnClickListener() {
        for(int i = 0; i < TAB_SIZE; i++) tabs[i].setOnClickListener(this);
    }

    void changeTabUI(int position) {
        for(int i = 0; i < TAB_SIZE; i++) tabs[i].setSelected(false);
        for(int i = 0; i < TAB_SIZE; i++) tabs[i].setTypeface(null, Typeface.NORMAL);
        tabs[position].setSelected(true);
        tabs[position].setTypeface(null, Typeface.BOLD);
    }

    @Override
    public void onClick(View v) {
        ft = fm.beginTransaction();
        switch(v.getId()) {
            case R.id.tv_my_page:
                changeTabUI(0);
                ft.replace(R.id.container, new MyPageFragment());
                break;
            case R.id.tv_get_out:
                changeTabUI(1);
                ft.replace(R.id.container, new GetOutFragment());
                break;
            case R.id.tv_community:
                changeTabUI(2);
                ft.replace(R.id.container, new CommunityFragment());
                break;
        }
        ft.commit();
    }


}
