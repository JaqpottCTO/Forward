package com.blerdU.rootworkapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExpertFeedbackManager {
    private DatabaseReference databaseRef;

    public ExpertFeedbackManager() {
        databaseRef = FirebaseDatabase.getInstance().getReference("feedback");
    }

    public void submitFeedback(String expertId, String feedbackContent) {
        String feedbackId = databaseRef.push().getKey();
        Feedback feedback = new Feedback(feedbackId, expertId, feedbackContent);
        databaseRef.child(feedbackId).setValue(feedback);
    }

    public void getFeedbackForDoor(String doorId, DataCallback<List<Feedback>> callback) {
        databaseRef.orderByChild("doorId").equalTo(doorId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Feedback> feedbackList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Feedback feedback = snapshot.getValue(Feedback.class);
                    feedbackList.add(feedback);
                }
                callback.onSuccess(feedbackList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onFailure(databaseError.toException());
            }
        });
    }

    public void implementFeedback(String feedbackId) {
        databaseRef.child(feedbackId).child("status").setValue("Implemented");
    }
}
