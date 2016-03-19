package com.intheloop.intheloop;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by gbrett on 19/03/2016.
 */
public class ChatMessages {

    @SerializedName("messages")
    ArrayList<ChatMessage> mChatMessages;

    public ChatMessages(ArrayList<ChatMessage> chatMessages) {
        mChatMessages = chatMessages;
    }

    public ArrayList<ChatMessage> getChatMessages() {
        return mChatMessages;
    }

    public void setChatMessages(ArrayList<ChatMessage> chatMessages) {
        mChatMessages = chatMessages;
    }
}
