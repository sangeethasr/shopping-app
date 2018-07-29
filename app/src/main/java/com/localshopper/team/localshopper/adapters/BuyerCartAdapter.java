package com.localshopper.team.localshopper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.models.OrderItemModel;

import java.util.ArrayList;

public class BuyerCartAdapter extends RecyclerView.Adapter<BuyerCartAdapter.BuyerCartViewHolder> {

    private ArrayList<OrderItemModel> orderItemModelArrayList;

    public void setOrderItemModelArrayList(ArrayList<OrderItemModel> orderItemModelArrayList) {
        this.orderItemModelArrayList = orderItemModelArrayList;
    }

    @NonNull
    @Override
    public BuyerCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buyer_cart_list_item, parent, false);
        return new BuyerCartAdapter.BuyerCartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyerCartViewHolder holder, int position) {
        OrderItemModel orderItemModel = orderItemModelArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return orderItemModelArrayList.size();
    }

    public class BuyerCartViewHolder extends RecyclerView.ViewHolder {
        LinearLayout item;

        public BuyerCartViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.buyer_cart_list_item);
        }
    }
}
