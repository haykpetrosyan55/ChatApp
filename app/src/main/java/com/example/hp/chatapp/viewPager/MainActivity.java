package com.example.hp.chatapp.viewPager;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp.chatapp.activity.MessengerActivity;
import com.example.hp.chatapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.viewPagerID);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(this, getList());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        final Button skipButton = findViewById(R.id.skipID);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MessengerActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Hero> getList() {
        final List<Hero> list = new ArrayList<>();
        list.add(new Hero("IRON MAN", R.drawable.iron_man));
        list.add(new Hero("HALK", R.drawable.halk));
        list.add(new Hero("THOR", R.drawable.thor_end));
        return list;
    }
}
