package com.localshopper.team.localshopper.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.models.OrdersModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    RecyclerView orderRecycleView;
    ArrayList<OrdersModel> orderModelArray;
    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View orderView = inflater.inflate(R.layout.fragment_order, container, false);

       /* orderModelArray = new ArrayList<>();
        orderRecycleView = orderView.findViewById(R.id.order_recycle_frag);
        OrderProductAdapter orderProductAdapter = new OrderProductAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext(),
                LinearLayoutManager.VERTICAL, false);
        orderRecycleView.setAdapter(orderProductAdapter);
        orderRecycleView.setLayoutManager(linearLayoutManager);*/
        return orderView;
    }

}
