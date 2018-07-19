package com.example.hp.chatapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hp.chatapp.R;
import com.example.hp.chatapp.adapters.CallAdapter;
import com.example.hp.chatapp.adapters.UserAdapter;
import com.example.hp.chatapp.fragments.ChatFragment;
import com.example.hp.chatapp.fragments.DescriptionFragment;

public class ChatActivity extends AppCompatActivity {

    public static final String FRAGMENT_KEY = "fragment_key";
    public static final String DEP_KEY = "dep";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        if (getIntent().getExtras().get(UserAdapter.CHECK).equals("user")) {
            final int position = getIntent().getIntExtra(UserAdapter.POSITION_KEY, 0);
            ChatFragment chatFragment = new ChatFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(FRAGMENT_KEY, position);
            chatFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fr_containerID, chatFragment).commit();
        } else if (getIntent().getExtras().get(CallAdapter.CHECK).equals("call")) {
            final int position = getIntent().getIntExtra(CallAdapter.KEY_P, 0);
            DescriptionFragment dp = new DescriptionFragment();
            final Bundle descBundle = new Bundle();
            descBundle.putInt(DEP_KEY, position);
            dp.setArguments(descBundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fr_containerID, dp)
                    .commit();
        }
    }
}
