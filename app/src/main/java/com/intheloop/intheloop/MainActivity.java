package com.intheloop.intheloop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity implements Callback<Articles> {
    private RecyclerView mRecyclerView;
    private ArticleAdapter mAdapter;
    private ArrayList<Article> mArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.arv);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(llm);

        setupPusher();

        mArticles = new ArrayList<Article>();
        mAdapter = new ArticleAdapter(mArticles, this.getBaseContext());
        mRecyclerView.setAdapter(mAdapter);

        getArticles();


    }

    private void getArticles() {

        Log.d("GB", "trying to get articles");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://46.101.2.116:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArticleService service = retrofit.create(ArticleService.class);
        Call<Articles> call = service.getArticles();
        call.enqueue(this);
    }

    private void setupPusher() {
        Pusher pusher = new Pusher("740d0f36323febd6a8c3");

        Channel channel = pusher.subscribe("chat");

        channel.bind("new_chat", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, final String data) {
                getArticles();
            }
        });

        pusher.connect();
    }

    @Override
    public void onResponse(Call<Articles> call, Response<Articles> response) {

        Articles articles = response.body();

        mAdapter = new ArticleAdapter(articles.getArticles(), this.getBaseContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onFailure(Call<Articles> call, Throwable t) {
        Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT);
    }
}
