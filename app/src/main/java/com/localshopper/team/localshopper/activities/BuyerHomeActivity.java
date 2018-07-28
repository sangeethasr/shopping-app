package com.localshopper.team.localshopper.activities;

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
import com.localshopper.team.localshopper.fragments.BuyerCartFragment;
import com.localshopper.team.localshopper.fragments.BuyerOrdersFragment;
import com.localshopper.team.localshopper.fragments.NearbySellerFragment;

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
        fragmentTransaction = fragmentManager.beginTransaction();
        NearbySellerFragment nearbySellerFragment = new NearbySellerFragment();
        fragmentTransaction.replace(R.id.frag_holder_act_buyhome, nearbySellerFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment fragment = this.fragmentManager.findFragmentById(R.id.frag_holder_act_buyhome);

            if (!(fragment instanceof NearbySellerFragment)) {
                setTitle("Store");
                NearbySellerFragment nearbySellerFragment = new NearbySellerFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_holder_act_buyhome, nearbySellerFragment);
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
                if (fragment instanceof NearbySellerFragment) {
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
                    NearbySellerFragment nearbySellerFragment = new NearbySellerFragment();
                    fragmentTransaction.replace(R.id.frag_holder_act_buyhome, nearbySellerFragment);
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
                break;
            case R.id.nav_buyer_feedback:
                break;
            case R.id.nav_buyer_settings:
                break;
            case R.id.nav_buyer_logout:
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
