package com.localshopper.team.localshopper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.localshopper.team.localshopper.R;

public class OrderProductAdapter extends RecyclerView.Adapter<OrderProductAdapter.OrderProductViewHolder> {


    @NonNull
    @Override
    public OrderProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OrderProductViewHolder extends RecyclerView.ViewHolder {

        TextView dateTxt;
        ImageView photoImg;
        TextView nameTxt;
        TextView addressTxt;
        TextView phoneNoTxt;
        TextView emailTxt;

        public OrderProductViewHolder(View itemView) {
            super(itemView);

            dateTxt = itemView.findViewById(R.id.date_txt_order_item);
            photoImg = itemView.findViewById(R.id.photo_img_order_item);
            nameTxt = itemView.findViewById(R.id.name_txt_order_item);
            addressTxt = itemView.findViewById(R.id.address_txt_order_item);
            phoneNoTxt = itemView.findViewById(R.id.phone_txt_order_item);
            emailTxt = itemView.findViewById(R.id.email_txt_order_item);
        }
    }
}
