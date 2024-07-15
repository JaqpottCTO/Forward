public class TaskManager {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "TaskManager";

    public void assignTask(String teamId, Task task) {
        DocumentReference teamRef = db.collection("teams").document(teamId);
        teamRef.update("tasks", FieldValue.arrayUnion(task))
            .addOnSuccessListener(aVoid -> Log.d(TAG, "Task assigned successfully"))
            .addOnFailureListener(e -> Log.w(TAG, "Error assigning task", e));
    }

    public void trackTaskProgress(String taskId, Callback callback) {
        DocumentReference taskRef = db.collection("tasks").document(taskId);
        taskRef.addSnapshotListener((snapshot, e) -> {
            if (e != null) {
                Log.w(TAG, "Listen failed.", e);
                return;
            }

            if (snapshot != null && snapshot.exists()) {
                Task task = snapshot.toObject(Task.class);
                callback.onSuccess(task);
            } else {
                callback.onFailure(new Exception("Task not found"));
            }
        });
    }
}
