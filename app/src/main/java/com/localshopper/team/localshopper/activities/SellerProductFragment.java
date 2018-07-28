package com.localshopper.team.localshopper.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localshopper.team.localshopper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SellerProductFragment extends Fragment {


    public SellerProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sellerProductView = inflater.inflate(R.layout.fragment_seller_product, container, false);
        return sellerProductView;
    }

}
