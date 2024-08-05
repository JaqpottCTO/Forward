package com.blerdU.rootworkapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DoorFragment extends AppCompatActivity {

    private TextView tvTitle, tvDescription;
    private RecyclerView rvObjectives;
    private Button btnNext, btnPrev;
    private List<Door> doorList;
    private int currentDoorIndex;

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

        // Load doors data
        doorList = getDoors();
        currentDoorIndex = 0; // Start with the first door

        // Set up initial UI with the first door data
        setupUI(doorList.get(currentDoorIndex));

        // Set up button listeners
        btnNext.setOnClickListener(v -> navigateToNextDoor());
        btnPrev.setOnClickListener(v -> navigateToPreviousDoor());
    }

    private void setupUI(Door door) {
        tvTitle.setText(door.getTitle());
        tvDescription.setText(door.getDescription());
        
        // Set up RecyclerView with objectives
        ObjectiveAdapter adapter = new ObjectiveAdapter(door.getObjectives());
        rvObjectives.setLayoutManager(new LinearLayoutManager(this));
        rvObjectives.setAdapter(adapter);
    }

    private List<Door> getDoors() {
        // Example doors with objectives
        List<Door> doors = new ArrayList<>();
        
        // Door 1: Fundamental Progress: Tech Makes Better Faster
        List<Objective> objectivesDoor1 = new ArrayList<>();
        objectivesDoor1.add(new Objective("Complete the Digital Literacy course", 
                                          "Demonstrate proficiency in essential software applications.", 
                                          false, "door1"));
        doors.add(new Door("Fundamental Progress: Tech Makes Better Faster",
                           "Equip participants with essential digital literacy and basic technical skills.",
                           objectivesDoor1, true));

        // Door 2: Tools as Force Multipliers
        List<Objective> objectivesDoor2 = new ArrayList<>();
        objectivesDoor2.add(new Objective("Create a professional portfolio using Canva",
                                          "Demonstrate skills by creating a portfolio and presenting it.",
                                          false, "door2"));
        objectivesDoor2.add(new Objective("Participate in a team communication exercise using Slack",
                                          "Engage in a collaborative task using Slack.",
                                          false, "door2"));
        doors.add(new Door("Tools as Force Multipliers",
                           "Introduce and train participants in using powerful digital tools like Canva, ChatGPT, Slack, and LinkedIn.",
                           objectivesDoor2, false));

        // Door 3: Unlocking Personal Development
        List<Objective> objectivesDoor3 = new ArrayList<>();
        objectivesDoor3.add(new Objective("Complete a comprehensive self-assessment",
                                          "Identify personal strengths and areas for growth.",
                                          false, "door3"));
        objectivesDoor3.add(new Objective("Set personal development goals with a customized action plan",
                                          "Develop a personalized plan to achieve growth objectives.",
                                          false, "door3"));
        doors.add(new Door("Unlocking Personal Development",
                           "Foster personal growth through self-assessment and tailored development plans.",
                           objectivesDoor3, false));

        // Door 4: Building Professional Skills
        List<Objective> objectivesDoor4 = new ArrayList<>();
        objectivesDoor4.add(new Objective("Participate in a job interview workshop",
                                          "Learn and practice essential interview skills.",
                                          false, "door4"));
        objectivesDoor4.add(new Objective("Develop a resume",
                                          "Create a professional resume highlighting skills and experiences.",
                                          false, "door4"));
        objectivesDoor4.add(new Objective("Complete a project demonstrating professional competencies",
                                          "Work on a project that showcases acquired professional skills.",
                                          false, "door4"));
        doors.add(new Door("Building Professional Skills",
                           "Develop job-ready skills and professional etiquette.",
                           objectivesDoor4, false));

        // Door 5: Community Engagement and Contribution
        List<Objective> objectivesDoor5 = new ArrayList<>();
        objectivesDoor5.add(new Objective("Organize or participate in a community service project",
                                          "Engage in activities that benefit the community.",
                                          false, "door5"));
        objectivesDoor5.add(new Objective("Document the experience and its impact",
                                          "Reflect on the contribution made and its significance.",
                                          false, "door5"));
        doors.add(new Door("Community Engagement and Contribution",
                           "Encourage community involvement and contribution.",
                           objectivesDoor5, false));

        return doors;
    }

    private void navigateToNextDoor() {
        if (currentDoorIndex < doorList.size() - 1) {
            currentDoorIndex++;
            setupUI(doorList.get(currentDoorIndex));
        }
    }

    private void navigateToPreviousDoor() {
        if (currentDoorIndex > 0) {
            currentDoorIndex--;
            setupUI(doorList.get(currentDoorIndex));
        }
    }
}
