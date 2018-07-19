package com.example.hp.chatapp.models;

import java.util.List;

public class UserModel {
    private String name;
    private String imageUri;
    private String phoneNumber;
    private String email;
    private String description;
    private List<MessageModel> messageList;

    public UserModel(String name, String imageUri, String phoneNumber, String email, String description, List<MessageModel> messageList) {
        this.name = name;
        this.imageUri = imageUri;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.messageList = messageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MessageModel> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageModel> messageList) {
        this.messageList = messageList;
    }
}
