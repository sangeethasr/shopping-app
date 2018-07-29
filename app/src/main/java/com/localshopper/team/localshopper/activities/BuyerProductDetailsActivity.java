package com.localshopper.team.localshopper.activities;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.localshopper.team.localshopper.R;

public class BuyerProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView productTitleTxtView;
    TextView productDescTxtView;
    FloatingActionButton addToCartFab;
    BottomSheetDialog dialog;
    Button okButton;

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

    private void addCartBottomSheet() {


        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View cartView = inflater.inflate(R.layout.cart_add, null, false);
        dialog = new BottomSheetDialog(BuyerProductDetailsActivity.this);
        dialog.setContentView(cartView);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();

        ImageView addImgBt = cartView.findViewById(R.id.add_bt_cart);
        ImageView minImgBt = cartView.findViewById(R.id.mini_bt_cart);
        TextView increaseTxt = cartView.findViewById(R.id.increase_txt_cart);
        TextView totalTxt = cartView.findViewById(R.id.increase_txt_cart);
        okButton = cartView.findViewById(R.id.ok_bt_cart);
        okButton.setOnClickListener(BuyerProductDetailsActivity.this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == okButton.getId()) {
            dialog.cancel();
        }
    }
}
