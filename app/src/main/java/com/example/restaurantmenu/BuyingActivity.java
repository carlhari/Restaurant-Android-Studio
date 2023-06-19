package com.example.restaurantmenu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class BuyingActivity extends AppCompatActivity {
    String data = "";
    String sushiName = "";
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying);

        ImageView img = findViewById(R.id.imgBuy);
        TextView txtBuyname = findViewById(R.id.txtBuyName);
        Intent intent = getIntent();
        data = intent.getStringExtra("image_pick");

        switch (data) {
            case "Aimage_1":
                img.setImageResource(R.drawable.californiamaki);

                price = 350;
                sushiName = "California Maki";

                break;
            case "Aimage_2":
                img.setImageResource(R.drawable.kimbapsushi);
                price = 450;
                sushiName = "Kimbap Sushi";
                break;
            case "Aimage_3":
                img.setImageResource(R.drawable.seedsushi);
                price = 250;
                sushiName = "Seed Sushi";
                break;
            //-------------------------------------------------
            case "Bimage_1":
                img.setImageResource(R.drawable.salmonsushi);
                price = 255;
                sushiName = "Salmon Sushi";
                break;
            case "Bimage_2":
                img.setImageResource(R.drawable.cookedsalmon);
                price = 275;
                sushiName = "Cooked Salmon";
                break;
            case "Bimage_3":
                img.setImageResource(R.drawable.yinsushi);
                price = 355;
                sushiName = "Yin Sushi";
                break;
            //-------------------------------------------------
            case "Cimage_1":
                img.setImageResource(R.drawable.onigiri);
                price = 305;
                sushiName = "Onigiri";
                break;
            case "Cimage_2":
                img.setImageResource(R.drawable.shrimp);
                price = 215;
                sushiName = "Shrimp";
                break;
            case "Cimage_3":
                img.setImageResource(R.drawable.curry);
                price = 405;
                sushiName = "Curry";
                break;
            default:
                break;
        }
        txtBuyname.setText(sushiName);
        TextInputEditText input = findViewById(R.id.input);

        TextView txtBuyPrice = findViewById(R.id.txtBuyPrice);
        txtBuyPrice.setText(String.valueOf(price));

        if (NameListHolder.nameList == null) {
            NameListHolder.nameList = new ArrayList<>();
        }

        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {
            String quantityString = input.getText().toString().trim();
            if (quantityString.isEmpty()) {
                Toast.makeText(BuyingActivity.this, "Error: Empty Quantity", Toast.LENGTH_SHORT).show();
            } else {
                int quantity = Integer.parseInt(quantityString);
                if (quantity == 0) {
                    Toast.makeText(BuyingActivity.this, "Error: Zero Not allowed", Toast.LENGTH_SHORT).show();
                } else {
                    NameListHolder.nameList.add(sushiName);
                    PriceListHolder.priceList.add(String.valueOf(price * quantity));
                    QuantityListHolder.quantityList.add(quantityString);

                    Intent resultIntent = new Intent(BuyingActivity.this, CartActivity.class);
                    startActivity(resultIntent);
                }
            }
        });

        Button btnBack = findViewById(R.id.btnBackBuy);
        btnBack.setOnClickListener(view -> {
            Intent intentBack = new Intent(BuyingActivity.this, MenuActivity.class);
            startActivity(intentBack);
        });
    }
}
