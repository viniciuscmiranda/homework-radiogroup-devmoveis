package com.example.revistacarrapicho;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView title = findViewById(R.id.title);
        TextView content = findViewById(R.id.content);
        ImageView image = findViewById(R.id.image);

        int total = getIntent().getExtras().getInt("total");
        int set = (int) Math.floor((total - 1) / 10);

        String[] titles = getResources().getStringArray(R.array.titles);
        String[] contents = getResources().getStringArray(R.array.contents);
        Drawable[] images = new Drawable[]{
                getDrawable(R.drawable.image01),
                getDrawable(R.drawable.image02),
                getDrawable(R.drawable.image03),
                getDrawable(R.drawable.image04)
        };


        title.setText(titles[set]);
        content.setText(contents[set]);
        image.setImageDrawable(images[set]);
    }
}
