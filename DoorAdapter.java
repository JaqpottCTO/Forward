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

    public DoorAdapter(List<Door> doorList) {
        this.doorList = doorList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_door, parent, false);
        return new ViewHolder(view);
    }

    @
