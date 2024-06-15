package com.blerdU.rootworkapp;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private PoolingSystem poolingSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        // Initialize PoolingSystem
        poolingSystem = new PoolingSystem();
        poolingSystem.addMember(new Member("user1", 5000, 3, MemberType.PROJECT));
        poolingSystem.addMember(new Member("user2", 4500, 2, MemberType.MENTOR));
        poolingSystem.addMember(new Member("user3", 6000, 4, MemberType.FINANCE));
        poolingSystem.addMember(new Member("user4", 5500, 5, MemberType.OPERATIONS));
        poolingSystem.addMember(new Member("user5", 4800, 1, MemberType.DIGITAL));
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        switch (item.getItemId()) {
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                break;
            case R.id.nav_entrepreneurship:
                selectedFragment = new EntrepreneurshipFragment();
                break;
            case R.id.nav_quality_of_life:
                selectedFragment = new QualityOfLifeFragment();
                break;
            case R.id.nav_artistic_works:
                selectedFragment = new ArtisticWorksFragment();
                break;
            case R.id.nav_environmental_awareness:
                selectedFragment = new EnvironmentalAwarenessFragment();
                break;
            case R.id.nav_health_wellness:
                selectedFragment = new HealthWellnessFragment();
                break;
            case R.id.nav_social_justice:
                selectedFragment = new SocialJusticeFragment();
                break;
            case R.id.nav_pooling:
                selectedFragment = new PoolingFragment();
                break;
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public PoolingSystem getPoolingSystem() {
        return poolingSystem;
    }
}
