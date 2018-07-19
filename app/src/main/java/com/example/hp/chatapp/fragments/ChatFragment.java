package com.example.hp.chatapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hp.chatapp.activity.ChatActivity;
import com.example.hp.chatapp.ChatProvider;
import com.example.hp.chatapp.R;
import com.example.hp.chatapp.adapters.ChatAdapter;
import com.example.hp.chatapp.models.MessageModel;
import com.example.hp.chatapp.models.UserModel;

import java.util.List;

public class ChatFragment extends Fragment {

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        if (getArguments() != null) {
            final int position = getArguments().getInt(ChatActivity.FRAGMENT_KEY);
            UserModel userModel = ChatProvider.getUserPosition(position);
            final TextView textView = view.findViewById(R.id.userNameChatID);
            textView.setText(userModel.getName());
            initializeMessagesList(view, userModel);
        }
        return view;
    }

    private void initializeMessagesList(View view, UserModel user) {
        final RecyclerView messagesList = view.findViewById(R.id.chat_listID);
        messagesList.setHasFixedSize(true);

        final LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        manager.setReverseLayout(false);
        messagesList.setLayoutManager(manager);
        final List<MessageModel> messages = user.getMessageList();
        final ChatAdapter adapter = new ChatAdapter(getContext(), messages, user.getImageUri());
        messagesList.setAdapter(adapter);

        final EditText editText = view.findViewById(R.id.edit_textID);
        final Button send = view.findViewById(R.id.sendButtonID);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages.add(new MessageModel(editText.getText().toString(), true));
                messages.add(new MessageModel("A Barlus Dzez!!!", false));
                editText.setText("");
                manager.scrollToPosition(messages.size() - 1);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
