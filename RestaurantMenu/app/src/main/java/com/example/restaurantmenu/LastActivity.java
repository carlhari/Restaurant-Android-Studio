package com.example.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(LastActivity.this, MainActivity.class);
            startActivity(intent);

        }, 3000);
    }
}
