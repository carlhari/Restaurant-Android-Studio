package com.example.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.NameList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String sum = intent.getStringExtra("sum");


        TextView txtFinalPrice = findViewById(R.id.txtfinalPrice);
        txtFinalPrice.setText(sum);

        Button btnOrderAgain = findViewById(R.id.btnOrderAgain);

        btnOrderAgain.setOnClickListener(v->{
            Intent intentOrderAgain = new Intent(ResultActivity.this, MainActivity.class);
            NameListHolder.nameList.removeAll(NameListHolder.nameList);
            PriceListHolder.priceList.removeAll(PriceListHolder.priceList);
            QuantityListHolder.quantityList.removeAll(QuantityListHolder.quantityList);

            startActivity(intentOrderAgain);
            finish();
        });



    }
}