package com.blerdU.rootworkapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PoolingFragment extends Fragment {

    private PoolingSystem poolingSystem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pooling, container, false);

        // Initialize poolingSystem
        poolingSystem = ((MainActivity) getActivity()).getPoolingSystem();

        // Example logic to collect contributions and distribute funds
        poolingSystem.collectContributions();
        Member winner = poolingSystem.distributeFunds();
        // Update UI with the winner information

        return view;
    }
}
