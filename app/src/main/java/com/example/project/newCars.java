package com.example.project;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class newCars extends Fragment {

    private RecyclerView popularCarsRecycler, newlyLaunchedRecycler, upcomingCarsRecycler;
    private CarAdapter popularAdapter, newlyLaunchedAdapter, upcomingAdapter;
    private List<CarModel> popularCarsList, newlyLaunchedList, upcomingCarsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_cars, container, false);

        // Find RecyclerViews
        popularCarsRecycler = view.findViewById(R.id.popularCarsRecycler);
        newlyLaunchedRecycler = view.findViewById(R.id.newly_launched_cars_recycler);
        upcomingCarsRecycler = view.findViewById(R.id.up_comming_cars);

        // ---------- Popular Cars (Horizontal) ----------
        LinearLayoutManager horizontalLayout1 =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        popularCarsRecycler.setLayoutManager(horizontalLayout1);
        popularCarsRecycler.addItemDecoration(new HorizontalSpaceItemDecoration(16));

        popularCarsList = new ArrayList<>();
        popularCarsList.add(new CarModel(R.mipmap.hybird_foreground, "Swift"));
        popularCarsList.add(new CarModel(R.mipmap.alto_foreground, "Alto"));
        popularCarsList.add(new CarModel(R.mipmap.civic_foreground, "Civic"));
        popularCarsList.add(new CarModel(R.mipmap.fortuner_foreground, "Fortuner"));
        popularCarsList.add(new CarModel(R.mipmap.city_foreground, "City"));
        popularCarsList.add(new CarModel(R.mipmap.corolla_foreground, "Corolla"));

        popularAdapter = new CarAdapter(popularCarsList);
        popularCarsRecycler.setAdapter(popularAdapter);

        // ---------- Newly Launched Cars (Horizontal) ----------
        LinearLayoutManager horizontalLayout2 =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        newlyLaunchedRecycler.setLayoutManager(horizontalLayout2);
        newlyLaunchedRecycler.addItemDecoration(new HorizontalSpaceItemDecoration(16));

        newlyLaunchedList = new ArrayList<>();
        newlyLaunchedList.add(new CarModel(R.mipmap.alto_foreground, "Alto 2025"));
        newlyLaunchedList.add(new CarModel(R.mipmap.civic_foreground, "Civic 2025"));
        newlyLaunchedList.add(new CarModel(R.mipmap.city_foreground, "City 2025"));

        newlyLaunchedAdapter = new CarAdapter(newlyLaunchedList);
        newlyLaunchedRecycler.setAdapter(newlyLaunchedAdapter);

        // ---------- Upcoming Cars (Horizontal) ----------
        LinearLayoutManager horizontalLayout3 =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        upcomingCarsRecycler.setLayoutManager(horizontalLayout3);
        upcomingCarsRecycler.addItemDecoration(new HorizontalSpaceItemDecoration(16));

        upcomingCarsList = new ArrayList<>();
        upcomingCarsList.add(new CarModel(R.mipmap.fortuner_foreground, "Fortuner 2026"));
        upcomingCarsList.add(new CarModel(R.mipmap.corolla_foreground, "Corolla 2026"));

        upcomingAdapter = new CarAdapter(upcomingCarsList);
        upcomingCarsRecycler.setAdapter(upcomingAdapter);

        return view;
    }

    // Custom ItemDecoration for horizontal spacing
    public static class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {
        private final int horizontalSpace;

        public HorizontalSpaceItemDecoration(int horizontalSpace) {
            this.horizontalSpace = horizontalSpace;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                                   @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            outRect.right = horizontalSpace;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.left = horizontalSpace; // first item offset
            }
        }
    }
}
