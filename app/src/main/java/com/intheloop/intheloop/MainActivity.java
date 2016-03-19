package com.intheloop.intheloop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pusher pusher = new Pusher("740d0f36323febd6a8c3");

        Log.d("GB", "starting up...");

        Channel channel = pusher.subscribe("test_channel");

        channel.bind("my_event", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, final String data) {
                showMessage(data);

            }
        });

        pusher.connect();
    }

    public void showMessage(final String strMessage) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(), strMessage, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}
