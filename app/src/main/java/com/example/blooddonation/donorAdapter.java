package com.example.blooddonation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class donorAdapter extends RecyclerView.Adapter<donorAdapter.DonorViewHolder> {
    private List<Donor> donorList;

    public donorAdapter(List<Donor> donorList) {
        this.donorList = donorList;
    }

    @NonNull
    @Override
    public DonorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_donor, parent, false);
        return new DonorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonorViewHolder holder, int position) {
        Donor donor = donorList.get(position);
        holder.nameTextView.setText(donor.getName());
        holder.bloodTypeTextView.setText(donor.getBloodType());
        holder.contactTextView.setText(donor.getContact());
    }

    @Override
    public int getItemCount() {
        return donorList.size();
    }

    // New method to update the list
    public void updateList(List<Donor> newList) {
        donorList = newList;
        notifyDataSetChanged(); // Notify the RecyclerView that the data has changed
    }

    static class DonorViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, bloodTypeTextView, contactTextView;

        public DonorViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            bloodTypeTextView = itemView.findViewById(R.id.bloodTypeTextView);
            contactTextView = itemView.findViewById(R.id.contactTextView);
        }
    }
}