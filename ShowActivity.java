public class ShowActivity extends AppCompatActivity {

    private ShowManager showManager;
    private RecyclerView recyclerView;
    private ShowAdapter showAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        showManager = new ShowManager();

        // Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showAdapter = new ShowAdapter(showManager.getShows());
        recyclerView.setAdapter(showAdapter);

        // Load shows
        loadShows();
    }

    private void loadShows() {
        // Add some demo shows for illustration
        showManager.addShow(new Show("Show 1", "Description for show 1"));
        showManager.addShow(new Show("Show 2", "Description for show 2"));

        // Notify adapter of data change
        showAdapter.notifyDataSetChanged();
    }
}
