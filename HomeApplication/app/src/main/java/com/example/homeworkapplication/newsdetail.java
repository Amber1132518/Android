package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class newsdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);

        Intent intent = getIntent();
        if (intent != null) {
            News news = intent.getParcelableExtra("news");
            if (news != null) {
                TextView titleView = findViewById(R.id.news_title);
                titleView.setText(news.getTitle());

                TextView dateView = findViewById(R.id.news_date);
                dateView.setText(news.getDate());

                TextView contentView=findViewById(R.id.news_content);
                contentView.setText(news.getContent());
            }
        }
    }
}
