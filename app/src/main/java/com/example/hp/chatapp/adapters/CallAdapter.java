package com.example.hp.chatapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp.chatapp.activity.ChatActivity;
import com.example.hp.chatapp.R;
import com.example.hp.chatapp.models.UserModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.CallViewHolder> {

    public static final String KEY_P = "key_p";
    public static final String CHECK = "check";
    private Context context;
    private List<UserModel> usersList;

    public CallAdapter(Context context, List<UserModel> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public CallAdapter.CallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.call_item, parent, false);
        return new CallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallAdapter.CallViewHolder holder, final int position) {
        final UserModel user = usersList.get(position);
        holder.userCallName.setText(user.getName());
        Picasso.get().load(user.getImageUri()).error(R.mipmap.ic_launcher).into(holder.userCallImage);
        holder.userCallNumber.setText(user.getPhoneNumber());
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + user.getPhoneNumber()));
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra(KEY_P, position);
                intent.putExtra(CHECK, "call");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class CallViewHolder extends RecyclerView.ViewHolder {
        TextView userCallName;
        CircleImageView userCallImage;
        TextView userCallNumber;
        Button callButton;

        public CallViewHolder(View itemView) {
            super(itemView);
            userCallName = itemView.findViewById(R.id.userCallNameID);
            userCallImage = itemView.findViewById(R.id.userCallImageID);
            userCallNumber = itemView.findViewById(R.id.userCallNumberID);
            callButton = itemView.findViewById(R.id.userCallButtonID);
        }
    }
}
