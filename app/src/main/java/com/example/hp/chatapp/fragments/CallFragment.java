package com.example.hp.chatapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.chatapp.ChatProvider;
import com.example.hp.chatapp.R;
import com.example.hp.chatapp.adapters.CallAdapter;
import com.example.hp.chatapp.adapters.UserAdapter;

public class CallFragment extends Fragment {

    public CallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_call, container, false);
        final RecyclerView usersList = view.findViewById(R.id.users_list);
        usersList.setHasFixedSize(true);
        usersList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final CallAdapter adapter =
                new CallAdapter(getContext(), ChatProvider.getUserProvider());
        usersList.setAdapter(adapter);
        return view;
    }
}
