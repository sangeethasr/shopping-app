package com.localshopper.team.localshopper.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.localshopper.team.localshopper.adapters.NearbyProductsAdapter;
import com.localshopper.team.localshopper.constants.Constants;
import com.localshopper.team.localshopper.models.ItemsModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearbyItemsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ItemsModel> itemsModelArrayList;
    FirebaseFirestore db;
    NearbyProductsAdapter nearbyProductsAdapter;

    public NearbyItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nearby_seller, container, false);
        recyclerView = view.findViewById(R.id.nearby_seller_recyc_frg_near);

        itemsModelArrayList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        nearbyProductsAdapter = new NearbyProductsAdapter();
        nearbyProductsAdapter.setItemsModelsArrayList(itemsModelArrayList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(nearbyProductsAdapter);
//        fetchData();
        return view;
    }

    public void fetchData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(Constants.USER_NAME, "");

        db.collection("users")
                .document(username)
                .collection("outgoing_orders")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d("hello", document.getId());
                                itemsModelArrayList.add(document.toObject(ItemsModel.class));
                                nearbyProductsAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.d("Hello", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }


}
