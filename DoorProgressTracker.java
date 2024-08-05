package com.blerdU.rootworkapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoorProgressTracker {
    private DatabaseReference databaseRef;

    public DoorProgressTracker() {
        databaseRef = FirebaseDatabase.getInstance().getReference("userProgress");
    }

    public void trackProgress(String userId, String doorId, String objectiveId) {
        databaseRef.child(userId).child(doorId).child("completedObjectives").child(objectiveId).setValue(true);
    }

    public void updateDoorStatus(String userId, String doorId, boolean isUnlocked) {
        databaseRef.child(userId).child(doorId).child("status").setValue(isUnlocked ? "unlocked" : "locked");
    }

    public void getUserProgressForDoor(String userId, String doorId, DataCallback<UserProgress> callback) {
        databaseRef.child(userId).child(doorId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProgress progress = dataSnapshot.getValue(UserProgress.class);
                callback.onSuccess(progress);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onFailure(databaseError.toException());
            }
        });
    }
}
