package com.localshopper.team.localshopper.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.adapters.SellerProductAdapter;
import com.localshopper.team.localshopper.models.ItemsModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SellerProductFragment extends Fragment {
    RecyclerView sellerProductReView;
    ArrayList<ItemsModel> iteModelArrayList;

    public SellerProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sellerProductView = inflater.inflate(R.layout.fragment_seller_product, container, false);
        sellerProductReView = sellerProductView.findViewById(R.id.seller_prodt_Recycle_frag);
        iteModelArrayList = new ArrayList<>();
        SellerProductAdapter sellerProductAdapter = new SellerProductAdapter();
        sellerProductAdapter.setItemModelsArray(iteModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(sellerProductView.getContext(),
                LinearLayoutManager.VERTICAL, false);
        sellerProductReView.setLayoutManager(linearLayoutManager);
        sellerProductReView.setAdapter(sellerProductAdapter);
        return sellerProductView;

    }

}
