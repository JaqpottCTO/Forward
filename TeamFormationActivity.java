package com.blerdU.rootworkapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TeamFormationActivity extends AppCompatActivity {

    private EditText teamNameInput;
    private EditText teamDescriptionInput;
    private Button createTeamButton;
    private RecyclerView teamListView;

    private TeamAdapter teamAdapter;
    private TeamManager teamManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_formation);

        // Initialize UI components
        teamNameInput = findViewById(R.id.teamNameInput);
        teamDescriptionInput = findViewById(R.id.teamDescriptionInput);
        createTeamButton = findViewById(R.id.createTeamButton);
        teamListView = findViewById(R.id.teamListView);

        // Setup RecyclerView
        teamAdapter = new TeamAdapter(new ArrayList<>());
        teamListView.setLayoutManager(new LinearLayoutManager(this));
        teamListView.setAdapter(teamAdapter);

        // Initialize TeamManager
        teamManager = new TeamManager();

        // Set up button click listeners
        createTeamButton.setOnClickListener(v -> handleCreateTeam());
        loadTeams();
    }

    private void handleCreateTeam() {
        String teamName = teamNameInput.getText().toString();
        String teamDescription = teamDescriptionInput.getText().toString();

        if (!teamName.isEmpty() && !teamDescription.isEmpty()) {
            Team newTeam = new Team(teamName, teamDescription);
            teamManager.createTeam(newTeam);
            loadTeams(); // Refresh the list of teams
        }
    }

    private void loadTeams() {
        List<Team> teams = teamManager.getAllTeams();
        teamAdapter.updateTeams(teams);
    }
}

