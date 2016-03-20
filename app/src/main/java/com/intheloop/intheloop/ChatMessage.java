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

    @SerializedName("article_id")
    private String mArticleId;

    public ChatMessage(String message, String date, String user) {
        mArticleId = "56eddbf18cc0a3e958f03ad1";
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
