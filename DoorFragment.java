package com.blerdU.rootworkapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class DoorFragment extends AppCompatActivity {

    private TextView tvTitle, tvDescription;
    private RecyclerView rvObjectives;
    private Button btnNext, btnPrev;
    private Door currentDoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        // Initialize UI components
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        rvObjectives = findViewById(R.id.rvObjectives);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        // Load current door data (Example with hardcoded door)
        currentDoor = new Door("Fundamental Progress: Tech Makes Better Faster", 
                               "Equip participants with essential digital literacy and basic technical skills.",
                               getObjectivesForDoor1(), true);

        // Set up UI with door data
        setupUI(currentDoor);

        // Set up button listeners
        btnNext.setOnClickListener(v -> navigateToNextDoor());
        btnPrev.setOnClickListener(v -> navigateToPreviousDoor());
    }

    private void setupUI(Door door) {
        tvTitle.setText(door.getTitle());
        tvDescription.setText(door.getDescription());
        // Set up RecyclerView with objectives
        ObjectiveAdapter adapter = new ObjectiveAdapter(door.getObjectives());
        rvObjectives.setAdapter(adapter);
    }

    private List<Objective> getObjectivesForDoor1() {
        // Example objectives for Door 1
        List<Objective> objectives = new ArrayList<>();
        objectives.add(new Objective("Complete the Digital Literacy course", 
                                     "Demonstrate proficiency in essential software applications.", 
                                     false, "door1"));
        // Add more objectives as needed
        return objectives;
    }

    private void navigateToNextDoor() {
        // Logic to navigate to the next door's interstitial page
    }

    private void navigateToPreviousDoor() {
        // Logic to navigate to the previous door's interstitial page
    }
}
