package com.blerdU.rootworkapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ObjectivePageActivity extends AppCompatActivity {
    private DatabaseReference databaseRef;
    private ListView objectivesListView;
    private ObjectiveAdapter objectiveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective_page);

        databaseRef = FirebaseDatabase.getInstance().getReference("doors");
        objectivesListView = findViewById(R.id.objectivesListView);
        objectiveAdapter = new ObjectiveAdapter(this, new ArrayList<>());
        objectivesListView.setAdapter(objectiveAdapter);

        String doorId = getIntent().getStringExtra("doorId");
        loadObjectives(doorId);
    }

    private void loadObjectives(String doorId) {
        databaseRef.child(doorId).child("objectives").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Objective> objectives = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Objective objective = snapshot.getValue(Objective.class);
                    objectives.add(objective);
                }
                objectiveAdapter.updateObjectives(objectives);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }

    private void handleObjectiveClick(String objectiveId) {
        // Handle click on objective, e.g., mark as completed or show details
    }
}
