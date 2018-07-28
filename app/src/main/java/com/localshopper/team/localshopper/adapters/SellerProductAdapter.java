package com.localshopper.team.localshopper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.localshopper.team.localshopper.R;
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
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seller_product_item, parent, false);
        return new SellerProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerProductViewHolder holder, int position) {
        ItemsModel model = itemModelsArray.get(position);
        holder.nameTxt.setText(model.getName());
        holder.descriptionTxt.setText(model.getDescription());
        holder.priceTxt.setText(String.valueOf(model.getRate()));
    }

    @Override
    public int getItemCount() {
        return itemModelsArray.size();
    }

    public class SellerProductViewHolder extends RecyclerView.ViewHolder {

        ImageView cancelBt;
        ImageView contactPhotoImg;
        TextView nameTxt;
        TextView descriptionTxt;
        TextView priceTxt;
        Button reviewBt;
        Button ratingBt;
        Button editBt;
        public SellerProductViewHolder(View itemView) {
            super(itemView);
            cancelBt = itemView.findViewById(R.id.cancel_img_item_SPF);
            contactPhotoImg = itemView.findViewById(R.id.photo_img_item_SPF);
            nameTxt = itemView.findViewById(R.id.title_txt_item_SPF);
            descriptionTxt = itemView.findViewById(R.id.description_txt_item_SPF);
            priceTxt = itemView.findViewById(R.id.price_txt_item_SPF);
            reviewBt = itemView.findViewById(R.id.review_btn_item_SPF);
            ratingBt = itemView.findViewById(R.id.rating_btn_item_SPF);
            editBt = itemView.findViewById(R.id.edit_btn_item_SPF);
        }
    }
}
