package com.example.hp.chatapp.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.chatapp.activity.ChatActivity;
import com.example.hp.chatapp.R;
import com.example.hp.chatapp.fragments.DescriptionFragment;
import com.example.hp.chatapp.models.MessageModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<MessageModel> messages;
    private final String userImageUrl;

    public ChatAdapter(Context context, List<MessageModel> messages, String userImageUrl) {
        this.context = context;
        this.messages = messages;
        this.userImageUrl = userImageUrl;
    }

    @Override
    public int getItemViewType(int position) {
        final MessageModel message = messages.get(position);
        if (message.isMine()) {
            return 0;
        }
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        if (0 == viewType) {
            view = inflater.inflate(R.layout.send_message_item, parent, false);
            return new SendViewHolder(view);
        }
        view = inflater.inflate(R.layout.receive_message_item, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MessageModel model = messages.get(position);
        if (model.isMine()) {
            ((SendViewHolder) holder).bind(model);
        } else {
            ((ReceiveViewHolder) holder).bind(model);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class SendViewHolder extends RecyclerView.ViewHolder {

        TextView sendText;

        SendViewHolder(View itemView) {
            super(itemView);
            sendText = itemView.findViewById(R.id.myMessageID);
        }

        void bind(MessageModel message) {
            sendText.setText(message.getText());
        }
    }

    class ReceiveViewHolder extends RecyclerView.ViewHolder {

        TextView receiveText;
        CircleImageView userImage;

        ReceiveViewHolder(View itemView) {
            super(itemView);
            receiveText = itemView.findViewById(R.id.receiveMessageID);
            userImage = itemView.findViewById(R.id.chatReceiveImageID);
            final int position = ((ChatActivity) context)
                    .getIntent().getIntExtra(UserAdapter.POSITION_KEY, 0);
            userImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DescriptionFragment dp = new DescriptionFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("dep", position);
                    dp.setArguments(bundle);
                    ((ChatActivity) context).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fr_containerID, dp)
                            .commit();
                }
            });
        }

        void bind(MessageModel message) {
            receiveText.setText(message.getText());
            Picasso.get().load(userImageUrl).placeholder(R.drawable.smile).error(R.mipmap.ic_launcher).into(userImage);
        }
    }
}


