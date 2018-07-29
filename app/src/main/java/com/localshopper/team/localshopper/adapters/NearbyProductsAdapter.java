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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NearbyProductsAdapter extends RecyclerView.Adapter<NearbyProductsAdapter.NearbyProductsViewHolder> {
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
        Picasso.get()
                .load(itemsModel.getImageUrl())
                .placeholder(R.drawable.item_placeholder)
                .resize(50, 50)
                .centerCrop()
                .into(holder.productImageView);
        String description = itemsModel.getDescription();
        if (description.length() > 22) {
            description = description.substring(0, 22);
            description = description + "...";
        }

        holder.descTxtView.setText(description);
    }

    @Override
    public int getItemCount() {
        return itemsModelsArrayList.size();
    }


    public class NearbyProductsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout item;
        ImageView productImageView;
        TextView titleTxtView;
        TextView descTxtView;
        TextView priceTxtView;
        TextView ratingTxtView;

        public NearbyProductsViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.nearby_prod_list_item);
            titleTxtView = itemView.findViewById(R.id.pro_title_txtview_list_nearby);
            priceTxtView = itemView.findViewById(R.id.pro_rate_txtview_list_nearby);
            descTxtView = itemView.findViewById(R.id.pro_desc_txtview_list_nearby);
            ratingTxtView = itemView.findViewById(R.id.pro_rating_txtview_list_nearby);
            productImageView = itemView.findViewById(R.id.itemimage_imgview_list_nearby);
            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (view.getId() == R.id.nearby_prod_list_item) {
                Intent intent = new Intent(view.getContext(), BuyerProductDetailsActivity.class);
                intent.putExtra("data", itemsModelsArrayList.get(position));
                view.getContext().startActivity(intent);
            }
        }
    }

}
