package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

public class usedCars extends Fragment {

    public usedCars() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_used_cars, container, false);

        Button category = view.findViewById(R.id.btnCategory);
        Button model = view.findViewById(R.id.btnModel);
        Button brand = view.findViewById(R.id.btnBrand);
        Button budget = view.findViewById(R.id.btnBudget);

        category.setOnClickListener(v -> loadChildFragment(new CatagoryFragment()));
        model.setOnClickListener(v -> loadChildFragment(new ModelFragment()));
        brand.setOnClickListener(v -> loadChildFragment(new BrandFragment()));
        budget.setOnClickListener(v -> loadChildFragment(new BudgetFragment()));

        loadChildFragment(new CatagoryFragment());

        View card1 = view.findViewById(R.id.cardview1);
        View card2 = view.findViewById(R.id.cardview2);
        View card3 = view.findViewById(R.id.cardview3);
        View card4 = view.findViewById(R.id.cardview4);

        setCard(card1, R.mipmap.sellit_foreground, "Sell it for me");
        setCard(card2, R.mipmap.autostore_foreground, "Auto Store");
        setCard(card3, R.mipmap.paperverification_foreground, "Paper Verification");
        setCard(card4, R.mipmap.insurance_foreground, "Insurance");

        return view;
    }


    private void loadChildFragment(Fragment fragment) {
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.childFragmentContainer, fragment)
                .commit();
    }

    private void setCard(View card, int imageRes, String text) {
        ImageView icon = card.findViewById(R.id.cardIcon);
        TextView title = card.findViewById(R.id.cardText);
        icon.setImageResource(imageRes);
        title.setText(text);
    }
}
