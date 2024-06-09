package com.example.rootworkapp;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

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
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_entrepreneurship:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EntrepreneurshipFragment()).commit();
                break;
            case R.id.nav_quality_of_life:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QualityOfLifeFragment()).commit();
                break;
            case R.id.nav_artistic_works:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ArtisticWorksFragment()).commit();
                break;
            case R.id.nav_environmental_awareness:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EnvironmentalAwarenessFragment()).commit();
                break;
            case R.id.nav_health_wellness:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HealthWellnessFragment()).commit();
                break;
            case R.id.nav_social_justice:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SocialJusticeFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
