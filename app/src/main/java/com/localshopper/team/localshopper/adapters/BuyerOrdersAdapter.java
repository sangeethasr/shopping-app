package com.localshopper.team.localshopper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.models.OrdersModel;

import java.util.ArrayList;

public class BuyerOrdersAdapter extends RecyclerView.Adapter<BuyerOrdersAdapter.BuyerViewHolder> implements View.OnClickListener {

    private ArrayList<OrdersModel> ordersModelsArrayList;

    public void setOrdersModelsArrayList(ArrayList<OrdersModel> ordersModelsArrayList) {
        this.ordersModelsArrayList = ordersModelsArrayList;
    }

    @NonNull
    @Override
    public BuyerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buyer_orders_list_item, parent, false);
        return new BuyerOrdersAdapter.BuyerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyerViewHolder holder, int position) {
        OrdersModel ordersModel = ordersModelsArrayList.get(position);

        holder.item.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return ordersModelsArrayList.size();
    }

    @Override
    public void onClick(View view) {
        Log.d("OrdersListITem", "Clicked");
//        TODO: intent to new activity
    }

    public class BuyerViewHolder extends RecyclerView.ViewHolder {

        LinearLayout item;

        public BuyerViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.buyer_orders_list_item);
        }
    }
}
