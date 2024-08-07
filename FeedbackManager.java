package com.blerdU.rootworkapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackManager {
    private DatabaseReference databaseRef;

    public FeedbackManager() {
        databaseRef = FirebaseDatabase.getInstance().getReference("generalFeedback");
    }

    public void submitFeedback(String userId, String content) {
        String feedbackId = databaseRef.push().getKey();
        Feedback feedback = new Feedback(feedbackId, userId, content);
        databaseRef.child(feedbackId).setValue(feedback);
    }

    public void getFeedbackForUser(String userId, DataCallback<List<Feedback>> callback) {
        databaseRef.orderByChild("userId").equalTo(userId).addListenerForSingleValueEvent(new ValueEventListener() {
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

    public void updateFeedbackStatus(String feedbackId, String status) {
        databaseRef.child(feedbackId).child("status").setValue(status);
    }
}
