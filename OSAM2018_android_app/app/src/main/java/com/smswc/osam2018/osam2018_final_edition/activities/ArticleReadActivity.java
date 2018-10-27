package com.smswc.osam2018.osam2018_final_edition.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.smswc.osam2018.osam2018_final_edition.R;

public class ArticleReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_read);

        ImageView imgvBack = findViewById(R.id.imgv_back_arrow);

        imgvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
