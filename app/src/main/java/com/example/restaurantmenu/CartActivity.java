package com.example.restaurantmenu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.restaurantmenu.NameListHolder;
import com.example.restaurantmenu.PriceListHolder;
import com.example.restaurantmenu.QuantityListHolder;

public class CartActivity extends AppCompatActivity {

    public int sumOfPrice = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Button addMore = findViewById(R.id.addmore);



        LinearLayout verticalLayout = findViewById(R.id.linear);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);

        // Create header row
        LinearLayout headerLayout = new LinearLayout(this);
        headerLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView nameHeaderTextView = new TextView(this);
        nameHeaderTextView.setWidth(400);
        nameHeaderTextView.setText("Name");
        nameHeaderTextView.setTextColor(Color.WHITE);
        nameHeaderTextView.setTextSize(18);
        nameHeaderTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerLayout.addView(nameHeaderTextView);

        TextView quantityHeaderTextView = new TextView(this);
        quantityHeaderTextView.setText("Quantity");
        quantityHeaderTextView.setTextColor(Color.WHITE);
        quantityHeaderTextView.setTextSize(18);
        quantityHeaderTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerLayout.addView(quantityHeaderTextView);

        TextView priceHeaderTextView = new TextView(this);
        priceHeaderTextView.setText("Price");
        priceHeaderTextView.setTextColor(Color.WHITE);
        priceHeaderTextView.setTextSize(18);
        priceHeaderTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerLayout.addView(priceHeaderTextView);



        nameHeaderTextView.setPadding(40,0,60,0);
        priceHeaderTextView.setPadding(40,0,50,0);
        quantityHeaderTextView.setPadding(40,0,60,0);
        verticalLayout.addView(headerLayout);


        for (String newPrice : PriceListHolder.priceList) {
            int convert = Integer.parseInt(newPrice);
            sumOfPrice += convert;
        }


        TextView txtTotalPrice = findViewById(R.id.txtTotalPrice);
        txtTotalPrice.setText(String.valueOf(sumOfPrice));

        if (NameListHolder.nameList != null) {
            for (int i = 0; i < QuantityListHolder.quantityList.size(); i++) {
                LinearLayout rowLayout = new LinearLayout(this);
                rowLayout.setOrientation(LinearLayout.HORIZONTAL);
                int rowMargin = getResources().getDimensionPixelSize(R.dimen.row_margin);
                rowLayout.setPadding(8, rowMargin, 0, rowMargin);

                TextView nameTextView = new TextView(this);
                nameTextView.setText(NameListHolder.nameList.get(i));
                rowLayout.addView(nameTextView);

                TextView quantityTextView = new TextView(this);
                quantityTextView.setText(QuantityListHolder.quantityList.get(i));
                rowLayout.addView(quantityTextView);

                TextView priceTextView = new TextView(this);
                priceTextView.setText(PriceListHolder.priceList.get(i));
                rowLayout.addView(priceTextView);

                nameTextView.setPadding(50,0,60,0);
                priceTextView.setPadding(50, 0,50,0);
                quantityTextView.setPadding(50,0,60,0);
                verticalLayout.addView(rowLayout);


                nameTextView.setWidth(400);

                nameTextView.setTextSize(16);
                nameTextView.setTextColor(Color.WHITE);
                nameTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                priceTextView.setWidth(400);

                priceTextView.setTextSize(16);
                priceTextView.setTextColor(Color.WHITE);
                priceTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                quantityTextView.setTextSize(16);
                quantityTextView.setTextColor(Color.WHITE);
                quantityTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            }
        }

        Button btnClear = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(v->{
            NameListHolder.nameList.removeAll(NameListHolder.nameList);
            PriceListHolder.priceList.removeAll(PriceListHolder.priceList);
            QuantityListHolder.quantityList.removeAll(QuantityListHolder.quantityList);

            Intent intentClear = new Intent(CartActivity.this, MenuActivity.class);
            startActivity(intentClear);
        });


        Button btnConfirm = findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(v->{
            Intent intentConfirm = new Intent(CartActivity.this, ResultActivity.class);
            intentConfirm.putExtra("sum", String.valueOf(sumOfPrice));
            startActivity(intentConfirm);

        });


        addMore.setOnClickListener(v -> {
            Intent addmore = new Intent(CartActivity.this, MenuActivity.class);
            addmore.putExtra("category", getIntent().getStringExtra("category"));
            startActivity(addmore);
        });
    }
}
