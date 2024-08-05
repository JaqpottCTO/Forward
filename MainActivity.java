package com.blerdU.rootworkapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QoLUserProfileViewModel userProfileViewModel;
    private QoLAssessmentEngine assessmentEngine;
    private ResourceMatcher resourceMatcher;
    private QoLProgressTracker progressTracker;
    private ShowManager showManager;
    private DoorObjectiveManager doorObjectiveManager;
    private ExpertFeedbackManager expertFeedbackManager;
    private FeedbackManager feedbackManager;
    private DoorProgressTracker doorProgressTracker;

    private Button btnAssess;
    private TextView tvRecommendations;
    private Button btnShowVoting;
    private Button btnViewDoors;
    private Button btnFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel and other components
        userProfileViewModel = new ViewModelProvider(this).get(QoLUserProfileViewModel.class);
        assessmentEngine = new QoLAssessmentEngine();
        resourceMatcher = new ResourceMatcher();
        progressTracker = new QoLProgressTracker();
        showManager = new ShowManager();
        doorObjectiveManager = new DoorObjectiveManager();
        expertFeedbackManager = new ExpertFeedbackManager();
        feedbackManager = new FeedbackManager();
        doorProgressTracker = new DoorProgressTracker();

        // Setup UI components
        btnAssess = findViewById(R.id.btnAssess);
        tvRecommendations = findViewById(R.id.tvRecommendations);
        btnShowVoting = findViewById(R.id.btnShowVoting);
        btnViewDoors = findViewById(R.id.btnViewDoors);
        btnFeedback = findViewById(R.id.btnFeedback);

        // Set up button click listeners
        btnAssess.setOnClickListener(v -> handleAssessButtonClick());
        btnShowVoting.setOnClickListener(v -> handleShowVotingClick());
        btnViewDoors.setOnClickListener(v -> handleViewDoorsClick());
        btnFeedback.setOnClickListener(v -> handleFeedbackClick());
    }

    private void handleAssessButtonClick() {
        QoLUserProfile userProfile = userProfileViewModel.getUserProfile();
        QoLAssessmentResult assessmentResult = assessmentEngine.assessUser(userProfile);
        List<Suggestion> suggestions = assessmentResult.getSuggestions();

        // Display recommendations
        displayRecommendations(suggestions);
    }

    private void handleShowVotingClick() {
        Intent intent = new Intent(this, ShowActivity.class);
        startActivity(intent);
    }

    private void handleViewDoorsClick() {
        Intent intent = new Intent(this, DoorActivity.class);
        startActivity(intent);
    }

    private void handleFeedbackClick() {
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }

    private void displayRecommendations(List<Suggestion> suggestions) {
        StringBuilder recommendationText = new StringBuilder();
        for (Suggestion suggestion : suggestions) {
            recommendationText.append(suggestion.getSuggestionText()).append("\n");
        }
        tvRecommendations.setText(recommendationText.toString());
    }
}
