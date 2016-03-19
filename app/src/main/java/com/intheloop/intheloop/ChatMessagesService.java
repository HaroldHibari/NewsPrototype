package com.intheloop.intheloop;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gbrett on 19/03/2016.
 */
public interface ChatMessagesService {

    @GET("messages")
    Call<ChatMessages> getMessages();
}
