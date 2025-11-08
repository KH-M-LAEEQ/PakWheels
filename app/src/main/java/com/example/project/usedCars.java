package com.example.project;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class usedCars extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public usedCars() {}

    public static usedCars newInstance(String param1, String param2) {
        usedCars fragment = new usedCars();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_used_cars, container, false);

        Button used = view.findViewById(R.id.tabUsedCars);
        Button newbtn = view.findViewById(R.id.tabNewCars);
        Button bikes = view.findViewById(R.id.tabBikes);
        Button autostore = view.findViewById(R.id.tabAutostore);

        loadFragment(new CatagoryFragment());

        used.setOnClickListener(v -> loadFragment(new usedCars()));
        newbtn.setOnClickListener(v -> loadFragment(new newCars()));
        bikes.setOnClickListener(v -> loadFragment(new BikesFragment()));
        autostore.setOnClickListener(v -> loadFragment(new autostore()));

        View card1 = view.findViewById(R.id.cardview1);
        View card2 = view.findViewById(R.id.cardview2);
        View card3 = view.findViewById(R.id.cardview3);
        View card4 = view.findViewById(R.id.cardview4);

        setCard(card1, R.mipmap.sellit_foreground, "Sell it for me");
        setCard(card2, R.mipmap.autostore_foreground, "Auto Store");
        setCard(card3, R.mipmap.paperverification_foreground, "Paper Verification");
        setCard(card4, R.mipmap.insurance_foreground, "Insurance");

        Button category = view.findViewById(R.id.btnCategory);
        Button model = view.findViewById(R.id.btnModel);
        Button brand = view.findViewById(R.id.btnBrand);
        Button budget = view.findViewById(R.id.btnBudget);

        category.setOnClickListener(v -> loadFragment(new CatagoryFragment()));
        model.setOnClickListener(v -> loadFragment(new ModelFragment()));
        brand.setOnClickListener(v -> loadFragment(new BrandFragment()));
        budget.setOnClickListener(v -> loadFragment(new BudgetFragment()));

        return view;
    }

    private void setCard(View card, int imageRes, String text) {
        ImageView icon = card.findViewById(R.id.cardIcon);
        TextView title = card.findViewById(R.id.cardText);
        icon.setImageResource(imageRes);
        title.setText(text);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.childFragmentContainer, fragment);
        transaction.commit();
    }
}
