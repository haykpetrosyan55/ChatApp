package com.example.hp.chatapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.chatapp.activity.ChatActivity;
import com.example.hp.chatapp.ChatProvider;
import com.example.hp.chatapp.R;
import com.example.hp.chatapp.models.UserModel;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DescriptionFragment extends Fragment {

    public DescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        if (getArguments() != null) {
            final int userPosition = getArguments().getInt(ChatActivity.DEP_KEY);
            final UserModel user = ChatProvider.getUserPosition(userPosition);
            TextView userName = view.findViewById(R.id.descriptionUserNameID);
            TextView phone = view.findViewById(R.id.userPhoneDescription);
            TextView email = view.findViewById(R.id.emailID);
            TextView description = view.findViewById(R.id.descriptionTextID);
            CircleImageView imageView = view.findViewById(R.id.descriptionImageID);
            userName.setText(user.getName());
            description.setText(user.getDescription());
            phone.setText(user.getPhoneNumber());
            email.setText(user.getEmail());
            Picasso.get().load(user.getImageUri()).placeholder(R.drawable.smile).into(imageView);
        }

        return view;
    }
}