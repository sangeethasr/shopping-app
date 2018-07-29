package com.localshopper.team.localshopper.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.activities.AddProductActivity;
import com.localshopper.team.localshopper.adapters.SellerProductAdapter;
import com.localshopper.team.localshopper.models.ItemsModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SellerProductFragment extends Fragment implements View.OnClickListener {
    RecyclerView sellerProductReView;
    ArrayList<ItemsModel> iteModelArrayList;
    FloatingActionButton floatingActionButton;

    public SellerProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sellerProductView = inflater.inflate(R.layout.fragment_seller_product, container, false);
        sellerProductReView = sellerProductView.findViewById(R.id.seller_prodt_Recycle_frag);
        floatingActionButton = sellerProductView.findViewById(R.id.add_prod_fab_frg_sellpro);
        iteModelArrayList = new ArrayList<>();
        SellerProductAdapter sellerProductAdapter = new SellerProductAdapter();
        sellerProductAdapter.setItemModelsArray(iteModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(sellerProductView.getContext(),
                LinearLayoutManager.VERTICAL, false);
        sellerProductReView.setLayoutManager(linearLayoutManager);
        sellerProductReView.setAdapter(sellerProductAdapter);
        floatingActionButton.setOnClickListener(this);
        return sellerProductView;

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_prod_fab_frg_sellpro) {
            startActivity(new Intent(getContext(), AddProductActivity.class));
        }
    }
}
