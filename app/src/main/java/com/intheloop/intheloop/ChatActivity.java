package com.intheloop.intheloop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatActivity extends AppCompatActivity implements Callback<ChatMessages> {

    private RecyclerView mRecyclerView;
    private ChatAdapter mAdapter;
    private ArrayList<ChatMessage> mMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(ChatActivity.this);
        mRecyclerView.setLayoutManager(llm);

        ChatMessage cm = new ChatMessage("This is a test messagesage. enter some meaningful text here", "16:50 - 19 March 2016", "Hungry Cat");

        mMessages = new ArrayList<ChatMessage>();
        mMessages.add(cm);

        mAdapter = new ChatAdapter(mMessages);

        mRecyclerView.setAdapter(mAdapter);

        getMessages();


    }

    private void getMessages(){

        Log.d("GB", "trying to get messages");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://46.101.2.116:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChatMessagesService  service = retrofit.create(ChatMessagesService.class);

        Call<ChatMessages> call = service.getMessages();

        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ChatMessages> call, Response<ChatMessages> response) {

        Log.d("GB", "received messages");

        ChatMessages messages = response.body();

        mAdapter = new ChatAdapter(messages.getChatMessages());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onFailure(Call<ChatMessages> call, Throwable t) {
        Toast.makeText(this, "Fail!!", Toast.LENGTH_SHORT);
    }
}
