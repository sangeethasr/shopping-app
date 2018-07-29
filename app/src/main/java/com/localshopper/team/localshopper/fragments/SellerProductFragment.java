package com.localshopper.team.localshopper.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.activities.AddProductActivity;
import com.localshopper.team.localshopper.adapters.SellerProductAdapter;
import com.localshopper.team.localshopper.constants.Constants;
import com.localshopper.team.localshopper.models.ItemsModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SellerProductFragment extends Fragment implements View.OnClickListener {
    RecyclerView sellerProductReView;
    ArrayList<ItemsModel> iteModelArrayList;
    FloatingActionButton floatingActionButton;
    FirebaseFirestore db;
    SellerProductAdapter sellerProductAdapter;

    public SellerProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sellerProductView = inflater.inflate(R.layout.fragment_seller_product, container, false);
        sellerProductReView = sellerProductView.findViewById(R.id.seller_prodt_Recycle_frag);
        floatingActionButton = sellerProductView.findViewById(R.id.add_prod_fab_frg_sellpro);
        iteModelArrayList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        sellerProductAdapter = new SellerProductAdapter();
        sellerProductAdapter.setItemModelsArray(iteModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(sellerProductView.getContext(),
                LinearLayoutManager.VERTICAL, false);
        sellerProductReView.setLayoutManager(linearLayoutManager);
        sellerProductReView.setAdapter(sellerProductAdapter);
        floatingActionButton.setOnClickListener(this);
        fetchData();
        return sellerProductView;

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_prod_fab_frg_sellpro) {
            startActivity(new Intent(getContext(), AddProductActivity.class));
        }
    }

    public void fetchData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(Constants.USER_NAME, "");

        db.collection("users")
                .document(username)
                .collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d("hello", document.getId());
                                iteModelArrayList.add(document.toObject(ItemsModel.class));
                                sellerProductAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.d("Hello", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }
}
