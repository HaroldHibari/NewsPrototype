package com.intheloop.intheloop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;

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
        setContentView(R.layout.activity_chat_coord);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Messages");

        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(ChatActivity.this);
        mRecyclerView.setLayoutManager(llm);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_message_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChatActivity.this, AddChatMessage.class);
                ChatActivity.this.startActivity(i);
            }
        });

        setupPusher();

        mMessages = new ArrayList<ChatMessage>();
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

    private void setupPusher(){
        Pusher pusher = new Pusher("740d0f36323febd6a8c3");

        Channel channel = pusher.subscribe("chat");

        channel.bind("new_comment", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, final String data) {
                getMessages();
            }
        });

        pusher.connect();
    }

    @Override
    public void onResponse(Call<ChatMessages> call, Response<ChatMessages> response) {

        ChatMessages messages = response.body();

        mAdapter = new ChatAdapter(messages.getChatMessages());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onFailure(Call<ChatMessages> call, Throwable t) {
        Toast.makeText(this, "Fail!!", Toast.LENGTH_SHORT);
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
    }
}
