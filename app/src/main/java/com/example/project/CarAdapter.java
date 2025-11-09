package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<CarModel> carList;

    public CarAdapter(List<CarModel> carList) {
        this.carList = carList;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item_layout, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        CarModel car = carList.get(position);
        holder.carImage.setImageResource(car.getImage());
        holder.carName.setText(car.getName());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carName;

        public CarViewHolder(View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.carImage);
            carName = itemView.findViewById(R.id.carName);
        }
    }
}
