package com.localshopper.team.localshopper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.models.OrdersModel;

import java.util.ArrayList;

public class OrderProductAdapter extends RecyclerView.Adapter<OrderProductAdapter.OrderProductViewHolder> {

    ArrayList<OrdersModel> orderModelArray;

    public void setOrderModelArray(ArrayList<OrdersModel> orderModelArray) {
        this.orderModelArray = orderModelArray;
    }

    @NonNull
    @Override
    public OrderProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_order_item, parent, false);
        return new OrderProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderProductViewHolder holder, int position) {
        OrdersModel model = orderModelArray.get(position);
        holder.dateTxt.setText(model.getDate());
        holder.buyerUsernameTxt.setText(model.getBuyerUsername());
        holder.sellerUsernameTxt.setText(model.getSellerUsername());
        holder.orderStatusTxt.setText(model.getOrderStatus());
    }

    @Override
    public int getItemCount() {
        return orderModelArray.size();
    }

    public class OrderProductViewHolder extends RecyclerView.ViewHolder {

        TextView dateTxt;
        ImageView photoImg;
        TextView buyerUsernameTxt;
        TextView sellerUsernameTxt;
        TextView orderStatusTxt;


        public OrderProductViewHolder(View itemView) {
            super(itemView);

            dateTxt = itemView.findViewById(R.id.date_txt_order_item);
            photoImg = itemView.findViewById(R.id.photo_img_order_item);
            buyerUsernameTxt = itemView.findViewById(R.id.buyerUsername_txt_order_item);
            sellerUsernameTxt = itemView.findViewById(R.id.sellerUsername_txt_order_item);
            orderStatusTxt = itemView.findViewById(R.id.orderStatus_txt_order_item);
        }
    }
}
