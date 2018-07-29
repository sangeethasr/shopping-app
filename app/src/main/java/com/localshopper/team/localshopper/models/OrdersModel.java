package com.localshopper.team.localshopper.models;

import java.util.ArrayList;

public class OrdersModel {
    private String orderId;
    private String buyerUsername;
    private String sellerUsername;
    private String date;
    private int orderStatus;
    private ArrayList<OrderItemModel> items;

    public OrdersModel() {
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrdersModel(ArrayList<OrderItemModel> items) {
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public void setBuyerUsername(String buyerUsername) {
        this.buyerUsername = buyerUsername;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ArrayList<OrderItemModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItemModel> items) {
        this.items = items;
    }
}
