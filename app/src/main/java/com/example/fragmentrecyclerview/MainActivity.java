package com.example.fragmentrecyclerview;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        ListFragment listFragment = new ListFragment();
        FoodDescFragment foodDescFragment = new FoodDescFragment();
        fragmentTransaction.add(R.id.frame_layout_recycler_fragment, listFragment);
        fragmentTransaction.add(R.id.frame_layout_desc_fragment, foodDescFragment);
        fragmentTransaction.commit();

        listFragment.setCommunicator(foodDescFragment);
    }
}
