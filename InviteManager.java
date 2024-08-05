import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InviteManager {
    private DatabaseReference databaseRef;

    public InviteManager() {
        databaseRef = FirebaseDatabase.getInstance().getReference("invitations");
    }

    public void sendInvite(String email, String role, String doorId) {
        String inviteId = databaseRef.push().getKey();
        Invite invite = new Invite(inviteId, email, role, doorId);
        databaseRef.child(inviteId).setValue(invite);
    }

    public void trackInviteResponse(String inviteId, DataCallback<String> callback) {
        databaseRef.child(inviteId).child("responseStatus").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String status = dataSnapshot.getValue(String.class);
                callback.onSuccess(status);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onFailure(databaseError.toException());
            }
        });
    }

    public void manageInviteRoles(String inviteId, String newRole) {
        databaseRef.child(inviteId).child("role").setValue(newRole);
    }
}
