package com.localshopper.team.localshopper.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.localshopper.team.localshopper.R;
import com.localshopper.team.localshopper.constants.Constants;
import com.localshopper.team.localshopper.fragments.BuyerCartFragment;
import com.localshopper.team.localshopper.fragments.BuyerOrdersFragment;
import com.localshopper.team.localshopper.fragments.NearbyItemsFragment;
import com.localshopper.team.localshopper.fragments.SettingsActivity;

public class BuyerHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        setTitle("Store");
        fragmentTransaction = fragmentManager.beginTransaction();
        NearbyItemsFragment nearbyItemsFragment = new NearbyItemsFragment();
        fragmentTransaction.replace(R.id.frag_holder_act_buyhome, nearbyItemsFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment fragment = this.fragmentManager.findFragmentById(R.id.frag_holder_act_buyhome);

            if (!(fragment instanceof NearbyItemsFragment)) {
                setTitle("Store");
                NearbyItemsFragment nearbyItemsFragment = new NearbyItemsFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_holder_act_buyhome, nearbyItemsFragment);
                fragmentTransaction.commit();
                navigationView.setCheckedItem(R.id.nav_buyer_home);
            } else {
                super.onBackPressed();
            }
        }
    }


    public boolean checkFragmentType(int fragmentNumber) {
        Fragment fragment = this.getSupportFragmentManager().findFragmentById(R.id.frag_holder_act_buyhome);
        switch (fragmentNumber) {
            case 0:
                if (fragment instanceof NearbyItemsFragment) {
                    return true;
                }
                break;
            case 1:
                if (fragment instanceof BuyerOrdersFragment) {
                    return true;
                }
                break;
            case 2:
                if (fragment instanceof BuyerCartFragment) {
                    return true;
                }
            default:
                return false;
        }
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_buyer_home:
                if (checkFragmentType(0)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    setTitle("Store");
                    fragmentTransaction = fragmentManager.beginTransaction();
                    NearbyItemsFragment nearbyItemsFragment = new NearbyItemsFragment();
                    fragmentTransaction.replace(R.id.frag_holder_act_buyhome, nearbyItemsFragment);
                    fragmentTransaction.commit();
                }
                break;
            case R.id.nav_buyer_orders:
                if (checkFragmentType(1)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    setTitle("Orders");
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BuyerOrdersFragment buyerOrdersFragment = new BuyerOrdersFragment();
                    fragmentTransaction.replace(R.id.frag_holder_act_buyhome, buyerOrdersFragment);
                    fragmentTransaction.commit();
                }
                break;
            case R.id.nav_buyer_cart:
                if (checkFragmentType(2)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    setTitle("Cart");
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BuyerCartFragment buyerCartFragment = new BuyerCartFragment();
                    fragmentTransaction.replace(R.id.frag_holder_act_buyhome, buyerCartFragment);
                    fragmentTransaction.commit();
                }
                break;
            case R.id.nav_buyer_contact_us:
                startActivity(new Intent(BuyerHomeActivity.this, ContactUsActivity.class));
                break;
            case R.id.nav_buyer_feedback:
                startActivity(new Intent(BuyerHomeActivity.this, FeedbackActivity.class));
                break;
            case R.id.nav_buyer_settings:
                startActivity(new Intent(BuyerHomeActivity.this, SettingsActivity.class));
                break;
            case R.id.nav_buyer_sell:
                startActivity(new Intent(BuyerHomeActivity.this, SellerHomeActivity.class));
                finish();
                break;
            case R.id.nav_buyer_logout:
                SharedPreferences sharedPreferences;
                SharedPreferences.Editor editor;
                sharedPreferences = getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt(Constants.LOGIN_STATUS_PREF_VAR, Constants.LOGGED_OUT);
                editor.putString(Constants.USER_NAME, "");
                editor.apply();
                startActivity(new Intent(BuyerHomeActivity.this, LoginActivity.class));
                finish();
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
