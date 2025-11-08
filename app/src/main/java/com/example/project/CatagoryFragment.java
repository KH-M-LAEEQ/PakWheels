package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CatagoryFragment extends Fragment {

    public CatagoryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catagory, container, false);

        int[] images = {
                R.mipmap.c,
                R.mipmap.imported_foreground,
                R.mipmap.automatic,
                R.mipmap.jeep_foreground,
                R.mipmap.driving_wheel_foreground,
                R.mipmap.hybird_foreground,
                R.mipmap.driving_wheel_foreground,
                R.mipmap.disel



        };

        String[] titles = {
                "Cars",
                "Imported",
                "Automatic",
                "Jeep",
                "Family",
                "Hybird",
                "Commmercial",
                "disel"
        };

        GridLayout grid = view.findViewById(R.id.catagoryGrid);

        int count = Math.min(grid.getChildCount(), images.length);

        for (int i = 0; i < count; i++) {

            View card = grid.getChildAt(i);
            ImageView img = card.findViewById(R.id.catagory_cardIcon);
            TextView txt = card.findViewById(R.id.cata_cardText);

            img.setImageResource(images[i]);
            txt.setText(titles[i]);

            int index = i;
            card.setOnClickListener(v -> {

                if (index == 0) {
                    startActivity(new Intent(getActivity(), CarsActivity.class));
                } else if (index == 1) {
                    startActivity(new Intent(getActivity(), ImportedActivity.class));
                }
                else if (index == 2) {
                    startActivity(new Intent(getActivity(), AutomaticActivity.class));
                }
                else if (index == 3) {
                    startActivity(new Intent(getActivity(), JeepActivity.class));
                }
                else if (index == 4) {
                    startActivity(new Intent(getActivity(), FamilyActivity.class));
                }
                else if (index == 5) {
                    startActivity(new Intent(getActivity(), HybirdActivity.class));
                }
                else if (index == 6) {
                    startActivity(new Intent(getActivity(), CommercialActivity.class));
                }
                else  {
                    startActivity(new Intent(getActivity(), DieselActivity.class));
                }


            });
        }

        return view;
    }
}
