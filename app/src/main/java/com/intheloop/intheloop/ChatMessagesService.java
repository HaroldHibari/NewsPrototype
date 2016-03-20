package com.intheloop.intheloop;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by gbrett on 19/03/2016.
 */
public interface ChatMessagesService {

    @GET("messages/56eddbf18cc0a3e958f03ad1")
    Call<ChatMessages> getMessages();

    @POST("messages/create")
    Call<HttpBinResponse> postMessage(@Body PostChatMessage chatMessage);

}
