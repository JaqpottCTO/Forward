public class Objective {
    private String id;
    private String title;
    private String description;
    private boolean isMandatory;

    public Objective() {
        // Default constructor required for calls to DataSnapshot.getValue(Objective.class)
    }

    public Objective(String id, String title, String description, boolean isMandatory) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isMandatory = isMandatory;
    }

    // Getters and setters
}
