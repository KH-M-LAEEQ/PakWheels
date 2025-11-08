package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class top_nav extends Fragment {

    public top_nav() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_nav, container, false);

        // Load usedCars fragment by default inside childFragmentContainer
        loadChildFragment(new usedCars());

        // Find top buttons
        Button used = view.findViewById(R.id.tabUsedCars);
        Button newbtn = view.findViewById(R.id.tabNewCars);
        Button bikes = view.findViewById(R.id.tabBikes);
        Button autostore = view.findViewById(R.id.tabAutostore);

        // Set click listeners to load corresponding child fragments
        used.setOnClickListener(v -> loadChildFragment(new usedCars()));
        newbtn.setOnClickListener(v -> loadChildFragment(new newCars()));
        bikes.setOnClickListener(v -> loadChildFragment(new BikesFragment()));
        autostore.setOnClickListener(v -> loadChildFragment(new autostore()));

        return view;
    }

    // Helper to replace child fragment inside top_nav
    public void loadChildFragment(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.childFragmentContainer, fragment);
        transaction.commit();
    }
}
