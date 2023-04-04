package com.example.mymood;

import static com.example.mymood.R.id.emailUserTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mymood.fragments.AffirmationFragment;
import com.example.mymood.fragments.BreathingPracticesFragment;
import com.example.mymood.fragments.MeditationFragment;
import com.example.mymood.fragments.NoteFragment;
import com.example.mymood.fragments.ProfileFragment;
import com.example.mymood.fragments.StatisticFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar materialToolbar;
    private DrawerLayout drawerLayout;
    private TextView email;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialToolbar = findViewById(R.id.topAppLayout);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        email = (TextView) navigationView.findViewById(emailUserTextView);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        materialToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id) {
                    case R.id.nav_note:
                        replaceFragment(new NoteFragment());
                        break;
                    case R.id.nav_profile:
                        replaceFragment(new ProfileFragment());
                        break;
                    case R.id.nav_statistic:
                        replaceFragment(new StatisticFragment());
                        break;
                    case R.id.nav_settings:
                        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_affirmation:
                        replaceFragment(new AffirmationFragment());
                        break;
                    case R.id.nav_meditation:
                        replaceFragment(new MeditationFragment());
                        break;
                    case R.id.nav_breathing_practices:
                        replaceFragment(new BreathingPracticesFragment());
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NoteFragment noteFragment = new NoteFragment();
        fragmentTransaction.replace(R.id.fragmentLayout, noteFragment, "NoteFragment");
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, fragment);
        fragmentTransaction.commit();
    }
}