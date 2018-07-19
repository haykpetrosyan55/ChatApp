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

import com.example.hp.chatapp.R;
import com.example.hp.chatapp.models.UserModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {
    private Context context;
    private List<UserModel> usersList;

    public EmailAdapter(Context context, List<UserModel> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public EmailAdapter.EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.email_item, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailAdapter.EmailViewHolder holder, int position) {
        final UserModel user = usersList.get(position);
        holder.userEmailName.setText(user.getName());
        Picasso.get().load(user.getImageUri()).error(R.mipmap.ic_launcher).into(holder.userEmailImage);
        holder.userEmail.setText(user.getEmail());
        holder.emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + user.getEmail()));
                context.startActivity(Intent.createChooser(intent, "send email"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView userEmailName;
        CircleImageView userEmailImage;
        TextView userEmail;
        Button emailButton;

        public EmailViewHolder(View itemView) {
            super(itemView);
            userEmailName = itemView.findViewById(R.id.userEmailNameID);
            userEmailImage = itemView.findViewById(R.id.userEmailImageID);
            userEmail = itemView.findViewById(R.id.userEmailID);
            emailButton = itemView.findViewById(R.id.userEmailButtonID);
        }
    }
}
