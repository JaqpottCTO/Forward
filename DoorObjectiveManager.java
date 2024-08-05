import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoorObjectiveManager {
    private DatabaseReference databaseRef;

    public DoorObjectiveManager() {
        databaseRef = FirebaseDatabase.getInstance().getReference("doors");
    }

    public void createObjective(String doorId, String title, String description, boolean isMandatory) {
        String objectiveId = databaseRef.child(doorId).child("objectives").push().getKey();
        Objective objective = new Objective(objectiveId, title, description, isMandatory);
        databaseRef.child(doorId).child("objectives").child(objectiveId).setValue(objective);
    }

    public void updateObjective(String doorId, String objectiveId, String newTitle, String newDescription, boolean newIsMandatory) {
        databaseRef.child(doorId).child("objectives").child(objectiveId).child("title").setValue(newTitle);
        databaseRef.child(doorId).child("objectives").child(objectiveId).child("description").setValue(newDescription);
        databaseRef.child(doorId).child("objectives").child(objectiveId).child("isMandatory").setValue(newIsMandatory);
    }

    public void getObjectivesForDoor(String doorId, DataCallback<List<Objective>> callback) {
        databaseRef.child(doorId).child("objectives").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Objective> objectives = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Objective objective = snapshot.getValue(Objective.class);
                    objectives.add(objective);
                }
                callback.onSuccess(objectives);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onFailure(databaseError.toException());
            }
        });
    }

    public void checkObjectiveCompletion(String doorId, String objectiveId, String userId, DataCallback<Boolean> callback) {
        databaseRef.child(doorId).child("objectives").child(objectiveId).child("completedUsers").child(userId)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        callback.onSuccess(dataSnapshot.exists());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        callback.onFailure(databaseError.toException());
                    }
                });
    }
}

