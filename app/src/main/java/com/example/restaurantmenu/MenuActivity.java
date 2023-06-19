package com.example.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;
import app.num.numandroidpagecurleffect.PageCurlView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        PageCurlView pageCurl1;
        PageCurlView pageCurl2;
        PageCurlView pageCurl3;
        pageCurl1 = findViewById(R.id.pagecurl_view1);
        pageCurl2 = findViewById(R.id.pagecurl_view2);
        pageCurl3 = findViewById(R.id.pagecurl_view3);
        Button btnC1 = findViewById(R.id.btnC1);
        Button btnC2 = findViewById(R.id.btnC2);
        Button btnC3 = findViewById(R.id.btnC3);
        Button back = findViewById(R.id.btnBack);


        //BUTTON 2
        ArrayList img1 = new ArrayList<>();

        img1.add(R.drawable.salmonsushi);
        img1.add(R.drawable.cookedsalmon);
        img1.add(R.drawable.yinsushi);


        pageCurl1.setCurlView(img1);
        pageCurl1.setCurlSpeed(1500);

        btnC1.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, CategoryActivity.class);
            intent.putExtra("category", "p1");
            startActivity(intent);
        });

    //BUTTON 3
        ArrayList img2 = new ArrayList<>();

        img2.add(R.drawable.onigiri);
        img2.add(R.drawable.shrimp);
        img2.add(R.drawable.curry);


        pageCurl2.setCurlView(img2);
        pageCurl2.setCurlSpeed(1500);

        btnC2.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, CategoryActivity.class);
            intent.putExtra("category", "p2");
            startActivity(intent);
        });


    //BUTTON 1
        ArrayList img3 = new ArrayList<>();

        img3.add(R.drawable.californiamaki);
        img3.add(R.drawable.kimbapsushi);
        img3.add(R.drawable.seedsushi);


        pageCurl3.setCurlView(img3);
        pageCurl3.setCurlSpeed(1500);

        btnC3.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, CategoryActivity.class);
            intent.putExtra("category", "p3");
            startActivity(intent);
        });


        back.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
            startActivity(intent);
        });


    }
}