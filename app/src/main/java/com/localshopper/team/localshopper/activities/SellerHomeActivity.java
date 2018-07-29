package com.localshopper.team.localshopper.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.constants.Constants;
import com.localshopper.team.localshopper.fragments.OrderFragment;
import com.localshopper.team.localshopper.fragments.SellerProductFragment;

public class SellerHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    android.support.v4.app.FragmentTransaction fragmentTransaction;
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);

        if (findViewById(R.id.seller_prodt_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            SellerProductFragment sellerFragment = new SellerProductFragment();

            fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.seller_prodt_container, sellerFragment, null);
            fragmentTransaction.commit();

        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean checkFragmentType(int fragmentNumber) {
        Fragment fragment = this.getSupportFragmentManager().findFragmentById(R.id.seller_prodt_container);
        switch (fragmentNumber) {
            case 0:
                if (fragment instanceof SellerProductFragment) {
                    return true;
                }
                break;
            case 1:
                if (fragment instanceof OrderFragment) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_seller_home:
                if (checkFragmentType(0)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    setTitle("Orders");
                    OrderFragment orderFragment = new OrderFragment();
                    fragmentTransaction = getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.seller_prodt_container, orderFragment, null);
                    fragmentTransaction.commit();
                }
                break;
            case R.id.nav_buyer_contact_us:
                break;
            case R.id.nav_buyer_feedback:
                break;
            case R.id.nav_seller_buy:
                startActivity(new Intent(SellerHomeActivity.this, BuyerHomeActivity.class));
                finish();
            case R.id.nav_buyer_settings:
                break;
            case R.id.nav_buyer_logout:
                SharedPreferences sharedPreferences;
                SharedPreferences.Editor editor;
                sharedPreferences = getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt(Constants.LOGIN_STATUS_PREF_VAR, Constants.LOGGED_OUT);
                editor.putString(Constants.USER_NAME, "");
                editor.apply();
                startActivity(new Intent(SellerHomeActivity.this, LoginActivity.class));
                finish();
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
