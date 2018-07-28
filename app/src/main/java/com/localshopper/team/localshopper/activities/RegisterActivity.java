package com.localshopper.team.localshopper.activities;

import android.content.Intent;
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
import com.localshopper.team.localshopper.models.UserModel;

import es.dmoral.toasty.Toasty;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "RegisterActivity";

    TextInputEditText usernameEdtTxt;
    TextInputEditText passwordEdtTxt;
    TextInputEditText fnameEdtTxt;
    TextInputEditText lnameEdtTxt;
    TextInputEditText addressEdtTxt;
    TextInputEditText phoneNoEdttxt;
    TextInputEditText emailEdtTxt;
    TextView registerBtn;

    UserModel userModel;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

        db = FirebaseFirestore.getInstance();

        registerBtn.setOnClickListener(this);
    }


    private void initViews() {
        usernameEdtTxt = findViewById(R.id.username_edtxt_act_reg);
        passwordEdtTxt = findViewById(R.id.password_edtxt_act_reg);
        fnameEdtTxt = findViewById(R.id.fname_edtxt_act_reg);
        lnameEdtTxt = findViewById(R.id.lname_edtxt_act_reg);
        addressEdtTxt = findViewById(R.id.address_edtxt_act_reg);
        phoneNoEdttxt = findViewById(R.id.phoneno_edtxt_act_reg);
        emailEdtTxt = findViewById(R.id.email_edtxt_act_reg);
        registerBtn = findViewById(R.id.register_txt_act_reg);
    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.register_txt_act_reg){
            userModel = new UserModel();
            userModel.setUsername(usernameEdtTxt.getText().toString());
            userModel.setEmail(emailEdtTxt.getText().toString());
            userModel.setPassword(passwordEdtTxt.getText().toString());
            userModel.setAddress(addressEdtTxt.getText().toString());
            userModel.setFirstName(fnameEdtTxt.getText().toString());
            userModel.setLastName(lnameEdtTxt.getText().toString());
            userModel.setPhone(Integer.parseInt(phoneNoEdttxt.getText().toString()));
            registerUser();
        }

    }

    private void registerUser() {
        DocumentReference userDocumentRef = db.collection("users").document(userModel.getUsername());
        userDocumentRef.set(userModel)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        Toasty.success(RegisterActivity.this, "Registerd successfully.", Toast.LENGTH_SHORT).show();

                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toasty.error(RegisterActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                        Log.w(TAG, "Error writing document", e);
                    }
                });

    }
}

