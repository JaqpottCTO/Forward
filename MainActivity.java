public class MainActivity extends AppCompatActivity {

    private QoLUserProfileViewModel userProfileViewModel;
    private QoLAssessmentEngine assessmentEngine;
    private ResourceMatcher resourceMatcher;
    private QoLProgressTracker progressTracker;
    private ShowManager showManager;
    private Button btnAssess;
    private TextView tvRecommendations;
    private Button btnShowVoting;

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

        // Setup UI components
        btnAssess = findViewById(R.id.btnAssess);
        tvRecommendations = findViewById(R.id.tvRecommendations);
        btnShowVoting = findViewById(R.id.btnShowVoting);

        // Set up button click listeners
        btnAssess.setOnClickListener(v -> handleAssessButtonClick());
        btnShowVoting.setOnClickListener(v -> handleShowVotingClick());
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

    private void displayRecommendations(List<Suggestion> suggestions) {
        StringBuilder recommendationText = new StringBuilder();
        for (Suggestion suggestion : suggestions) {
            recommendationText.append(suggestion.getSuggestionText()).append("\n");
        }
        tvRecommendations.setText(recommendationText.toString());
    }
}
