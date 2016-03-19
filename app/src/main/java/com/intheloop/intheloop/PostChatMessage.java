package com.intheloop.intheloop;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gbrett on 19/03/2016.
 */
public class PostChatMessage {

    @SerializedName("message")
    ChatMessage mChatMessageMap;

    public PostChatMessage(ChatMessage chatMessageMap) {
        mChatMessageMap = chatMessageMap;
    }

    public ChatMessage getChatMessageMap() {
        return mChatMessageMap;
    }

    public void setChatMessageMap(ChatMessage chatMessageMap) {
        mChatMessageMap = chatMessageMap;
    }
}
