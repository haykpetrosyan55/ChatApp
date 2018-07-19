package com.example.hp.chatapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.hp.chatapp.R;
import com.example.hp.chatapp.adapters.FragmentAdapter;
import com.example.hp.chatapp.fragments.CallFragment;
import com.example.hp.chatapp.fragments.EmailFragment;
import com.example.hp.chatapp.fragments.UserFragment;

import java.util.Objects;

public class MessengerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messanger);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tabs);

        final FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new UserFragment(), "Users");
        adapter.addFragment(new CallFragment(), "Call");
        adapter.addFragment(new EmailFragment(), "Email");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_users);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_call);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.ic_email);
    }

}
