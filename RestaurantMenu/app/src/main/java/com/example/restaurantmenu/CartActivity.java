package com.example.restaurantmenu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Button addMore = findViewById(R.id.addmore);

        Intent intent = getIntent();
        int price = intent.getIntExtra("price", 0);
        String quantity = intent.getStringExtra("quantity");
        int newQuantity = Integer.parseInt(quantity);

        LinearLayout linear = findViewById(R.id.linear);

        if (NameListHolder.nameList != null) {
            for (String newNames : NameListHolder.nameList) {
                TextView textView = new TextView(this);
                textView.setText(newNames);
                textView.setTextColor(Color.WHITE);
                linear.addView(textView);
            }
        }

        addMore.setOnClickListener(v -> {
            Intent addmore = new Intent(CartActivity.this, MenuActivity.class);
            addmore.putExtra("category", getIntent().getStringExtra("category"));
            startActivity(addmore);
        });
    }
}
