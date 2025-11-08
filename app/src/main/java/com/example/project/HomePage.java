package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private static final String DEFAULT_FRAGMENT_TAG = "usedCars";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNav = findViewById(R.id.bottom_nav);

        // Load Home fragment (usedCars) by default only if no saved state
        if (savedInstanceState == null) {
            loadFragment(new top_nav(), DEFAULT_FRAGMENT_TAG);
            bottomNav.setSelectedItemId(R.id.nav_home);
        }

        // Handle tab selection
        bottomNav.setOnItemSelectedListener(item -> {
            navigateToFragment(item.getItemId());
            return true;
        });

        // Handle reselect (clicking same tab) - optional
        bottomNav.setOnItemReselectedListener(item -> {
            // You might want to add scroll to top or refresh behavior here
            navigateToFragment(item.getItemId());
        });
    }

    private void navigateToFragment(int id) {
        Fragment fragment = null;
        String tag = null;

        if (id == R.id.nav_home) {
            fragment = new top_nav();
            tag = "top_nav";
        } else if (id == R.id.nav_add) {
            fragment = new Add();
            tag = "add";
        } else if (id == R.id.nav_settings) {
            fragment = new settings();
            tag = "settings";
        }

        if (fragment != null) {
            loadFragment(fragment, tag);
        }
    }

    private void loadFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment, tag);

        // Use commit() instead of commitAllowingStateLoss() for normal operation
        // commitAllowingStateLoss() should only be used in special cases
        transaction.commit();
    }
}