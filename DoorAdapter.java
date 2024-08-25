package com.evertisky.rootworkv1.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evertisky.rootworkv1.R;

import java.util.List;

public class DoorAdapter extends RecyclerView.Adapter<DoorAdapter.ViewHolder> {

    private List<Door> doorList;

    // Constructor
    public DoorAdapter(List<Door> doorList) {
        this.doorList = doorList;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item_door layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_door, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the current Door object
        Door door = doorList.get(position);

        // Bind the Door object data to the view elements
        holder.doorTitle.setText(door.getTitle());
        holder.doorDescription.setText(door.getDescription());

        // You can add more functionality here, like setting up click listeners
        holder.itemView.setOnClickListener(v -> {
            // Handle click events here
            // For example, you can start a new activity or show a Toast message
            // Toast.makeText(v.getContext(), "Clicked on " + door.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return doorList.size();
    }

    // Provide a reference to the type of views that you are using (custom ViewHolder)
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView doorTitle;
        public TextView doorDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            // Define the view elements
            doorTitle = itemView.findViewById(R.id.door_title);
            doorDescription = itemView.findViewById(R.id.door_description);
        }
    }
}
