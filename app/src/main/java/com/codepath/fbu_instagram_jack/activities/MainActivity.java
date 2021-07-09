package com.codepath.fbu_instagram_jack.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.codepath.fbu_instagram_jack.R;
import com.codepath.fbu_instagram_jack.databinding.ActivityMainBinding;
import com.codepath.fbu_instagram_jack.fragments.HomeFragment;
import com.codepath.fbu_instagram_jack.fragments.PostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Context context;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = this;

        fragmentManager = getSupportFragmentManager();
        fragment = HomeFragment.newInstance(this);

        bottomNavigationView = binding.bottomNavigation;
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.miHome:
                                fragment = HomeFragment.newInstance(context);
                                break;
                            case R.id.miPost:
                                fragment = PostFragment.newInstance(context);
                                break;
                            //case R.id.action_music:
                            default:
                                //fragment = fragment3;
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                        return true;
                    }
                });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.miHome);
        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logoutItem:
                ParseUser.logOut();
                if(ParseUser.getCurrentUser() == null)
                    goToLoginActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
