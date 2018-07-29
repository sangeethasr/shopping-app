package com.localshopper.team.localshopper.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.constants.Constants;
import com.localshopper.team.localshopper.models.ItemsModel;

import es.dmoral.toasty.Toasty;

public class AddProductActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AddProductActivity";

    TextInputEditText itemTitleEdtTxt;
    TextInputEditText itemDescEdtTxt;
    TextInputEditText itemRateEdtTxt;
    TextInputEditText itemPreferredUnitEdtTxt;
    TextView submitBtn;

    ItemsModel itemModel;

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        db = FirebaseFirestore.getInstance();
        initViews();

        submitBtn.setOnClickListener(this);
    }

    private void initViews() {
        itemTitleEdtTxt = findViewById(R.id.title_edtxt_act_addpro);
        itemDescEdtTxt = findViewById(R.id.desc_edtxt_act_addpro);
        itemPreferredUnitEdtTxt = findViewById(R.id.pref_unit_edtxt_act_addpro);
        itemRateEdtTxt = findViewById(R.id.rate_edtxt_act_addpro);
        submitBtn = findViewById(R.id.submit_btn_act_addpro);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit_btn_act_addpro) {
            itemModel = new ItemsModel();
            itemModel.setTitle(itemTitleEdtTxt.getText().toString());
            itemModel.setDescription(itemDescEdtTxt.getText().toString());
            itemModel.setRate(Float.parseFloat(itemRateEdtTxt.getText().toString()));
            itemModel.setUnit(itemPreferredUnitEdtTxt.getText().toString());
            addItemToFirestore(itemModel);
        }
    }

    private void addItemToFirestore(ItemsModel itemModel) {

        DocumentReference productDocumentRef = db.collection("users").document(Constants.SELLER).collection("products").document();
        productDocumentRef.set(itemModel)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toasty.success(AddProductActivity.this, "Item added successfully.", Toast.LENGTH_SHORT).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toasty.error(AddProductActivity.this, "Adding item failed.", Toast.LENGTH_SHORT).show();
                        Log.w(TAG, "FirestoreError", e);
                    }
                });

    }

}
