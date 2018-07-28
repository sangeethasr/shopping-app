package com.localshopper.team.localshopper.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localshopper.team.localshopper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearbySellerFragment extends Fragment {


    public NearbySellerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nearby_seller, container, false);
    }

}
