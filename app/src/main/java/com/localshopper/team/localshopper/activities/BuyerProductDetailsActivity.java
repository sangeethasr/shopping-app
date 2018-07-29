package com.localshopper.team.localshopper.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.localshopper.team.localshopper.R;

public class BuyerProductDetailsActivity extends AppCompatActivity {

    TextView productTitleTxtView;
    TextView productDescTxtView;
    FloatingActionButton addToCartFab;

    String productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_product_details);
        initViews();
        addToCart();
    }

    private void addToCart() {

    }

    private void initViews() {
        productTitleTxtView = findViewById(R.id.title_txtview_act_buyprodes);
        productDescTxtView = findViewById(R.id.desc_txtview_act_buyprodes);
        addToCartFab = findViewById(R.id.add_to_cart_fab_act_buyprodes);
    }
}
