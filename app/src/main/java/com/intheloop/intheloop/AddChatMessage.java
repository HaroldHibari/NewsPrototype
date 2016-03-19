package com.intheloop.intheloop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddChatMessage extends AppCompatActivity implements Callback<HttpBinResponse> {

    private EditText mMessageBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Add New Message");

        mMessageBody = (EditText)findViewById(R.id.new_message_text);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postMessage();
            }
        });
    }

    private void postMessage(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://46.101.2.116:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChatMessage message = new ChatMessage(mMessageBody.getText().toString(), "today", "Trump");

        PostChatMessage postMessage = new PostChatMessage(message);

        ChatMessagesService  service = retrofit.create(ChatMessagesService.class);
        Call<HttpBinResponse> call = service.postMessage(postMessage);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<HttpBinResponse> call, Response<HttpBinResponse> response) {
        Toast.makeText(this, "Message posted!", Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(AddChatMessage.this, ChatActivity.class);
//        startActivity(i);
        finish();
    }

    @Override
    public void onFailure(Call<HttpBinResponse> call, Throwable t) {

        finish();
        //Toast.makeText(this, "Error :-(", Toast.LENGTH_SHORT).show();
    }
}
