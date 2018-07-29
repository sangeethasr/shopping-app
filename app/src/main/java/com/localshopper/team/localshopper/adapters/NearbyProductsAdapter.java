package com.localshopper.team.localshopper.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.activities.BuyerProductDetailsActivity;
import com.localshopper.team.localshopper.models.ItemsModel;

import java.util.ArrayList;

public class NearbyProductsAdapter extends RecyclerView.Adapter<NearbyProductsAdapter.NearbyProductsViewHolder> implements View.OnClickListener {
    ArrayList<ItemsModel> itemsModelsArrayList;

    public void setItemsModelsArrayList(ArrayList<ItemsModel> itemsModelsArrayList) {
        this.itemsModelsArrayList = itemsModelsArrayList;
    }

    @NonNull
    @Override
    public NearbyProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nearby_prod_list_item, parent, false);
        return new NearbyProductsAdapter.NearbyProductsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyProductsViewHolder holder, int position) {
        ItemsModel itemsModel = itemsModelsArrayList.get(position);
        holder.titleTxtView.setText(itemsModel.getTitle());
        holder.priceTxtView.setText(String.valueOf(itemsModel.getRate()));
        holder.ratingTxtView.setText(String.valueOf(itemsModel.getOverallRating()));

        holder.item.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return itemsModelsArrayList.size();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.nearby_prod_list_item) {
            view.getContext().startActivity(new Intent(view.getContext(), BuyerProductDetailsActivity.class));
        }
    }

    public class NearbyProductsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout item;
        ImageView productImageView;
        TextView titleTxtView;
        TextView priceTxtView;
        TextView ratingTxtView;

        public NearbyProductsViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.nearby_prod_list_item);
        }
    }

}
