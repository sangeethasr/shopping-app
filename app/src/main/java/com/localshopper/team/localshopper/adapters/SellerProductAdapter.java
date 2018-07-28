package com.localshopper.team.localshopper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.localshopper.team.localshopper.models.ItemsModel;

import java.util.ArrayList;

public class SellerProductAdapter extends RecyclerView.Adapter<SellerProductAdapter.SellerProductViewHolder> {

    ArrayList<ItemsModel> itemModelsArray;

    public void setItemModelsArray(ArrayList<ItemsModel> itemModelsArray) {
        this.itemModelsArray = itemModelsArray;
    }


    @NonNull
    @Override
    public SellerProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SellerProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemModelsArray.size();
    }

    public class SellerProductViewHolder extends RecyclerView.ViewHolder {
        public SellerProductViewHolder(View itemView) {
            super(itemView);
        }
    }
}
