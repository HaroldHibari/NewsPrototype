package com.intheloop.intheloop;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gbrett on 19/03/2016.
 */
public class ChatMessage {

    @SerializedName("body")
    private String mMessage;
    private String mDate;
    @SerializedName("user_id")
    private String mUser;

    public ChatMessage(String message, String date, String user) {
        mMessage = message;
        mDate = date;
        mUser = user;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String user) {
        mUser = user;
    }
}
