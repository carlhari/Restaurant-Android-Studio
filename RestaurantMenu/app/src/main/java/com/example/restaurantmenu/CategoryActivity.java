package com.example.restaurantmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ImageView img1 = findViewById(R.id.img1);
        ImageView img2 = findViewById(R.id.img2);
        ImageView img3 = findViewById(R.id.img3);
        TextView txt = findViewById(R.id.categorytxt);
        Button btnBack = findViewById(R.id.btnBackCategory);

        Intent intent = getIntent();
        String data = intent.getStringExtra("category");

        if (data != null) {
            switch (data) {
                case "p1":
                    txt.setText("Nigiri");
                    img1.setImageResource(R.drawable.californiamaki);
                    img2.setImageResource(R.drawable.kimbapsushi);
                    img3.setImageResource(R.drawable.seedsushi);
                    break;
                case "p2":
                    txt.setText("Raw");
                    img1.setImageResource(R.drawable.salmonsushi);
                    img2.setImageResource(R.drawable.cookedsalmon);
                    img3.setImageResource(R.drawable.yinsushi);
                    break;
                case "p3":
                    txt.setText("Secret Menu");
                    img1.setImageResource(R.drawable.onigiri);
                    img2.setImageResource(R.drawable.shrimp);
                    img3.setImageResource(R.drawable.curry);
                    break;
                default:
                    break;
            }
        }

        Intent intentCategory = new Intent(CategoryActivity.this, BuyingActivity.class);

        img1.setOnClickListener(view -> {
            if (data != null) {
                switch (data) {
                    case "p1":
                        intentCategory.putExtra("image_pick", "Aimage_1");
                        startActivity(intentCategory);
                        break;
                    case "p2":
                        intentCategory.putExtra("image_pick", "Bimage_1");
                        startActivity(intentCategory);
                        break;
                    case "p3":
                        intentCategory.putExtra("image_pick", "Cimage_1");
                        startActivity(intentCategory);
                        break;
                }
            }
        });

        img2.setOnClickListener(view -> {
            if (data != null) {
                switch (data) {
                    case "p1":
                        intentCategory.putExtra("image_pick", "Aimage_2");
                        startActivity(intentCategory);
                        break;
                    case "p2":
                        intentCategory.putExtra("image_pick", "Bimage_2");
                        startActivity(intentCategory);
                        break;
                    case "p3":
                        intentCategory.putExtra("image_pick", "Cimage_2");
                        startActivity(intentCategory);
                        break;
                }
            }
        });

        img3.setOnClickListener(view -> {
            if (data != null) {
                switch (data) {
                    case "p1":
                        intentCategory.putExtra("image_pick", "Aimage_3");
                        startActivity(intentCategory);
                        break;
                    case "p2":
                        intentCategory.putExtra("image_pick", "Bimage_3");
                        startActivity(intentCategory);
                        break;
                    case "p3":
                        intentCategory.putExtra("image_pick", "Cimage_3");
                        startActivity(intentCategory);
                        break;
                }
            }
        });

        btnBack.setOnClickListener(view -> {
            Intent intentBack = new Intent(CategoryActivity.this, MenuActivity.class);
            startActivity(intentBack);
        });
    }
}
