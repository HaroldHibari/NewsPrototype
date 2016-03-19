package com.intheloop.intheloop;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gbrett on 19/03/2016.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{

    private ArrayList<ChatMessage> mMessages;

    public ChatAdapter(ArrayList<ChatMessage> messages){
        mMessages = messages;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item, viewGroup, false);

        v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        ChatViewHolder cvh = new ChatViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        holder.message.setText(mMessages.get(position).getMessage());
        holder.timestamp.setText(mMessages.get(position).getDate());
        holder.user.setText(mMessages.get(position).getUser());
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView message;
        TextView timestamp;
        TextView user;

        ChatViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.message_cv);
            message = (TextView)itemView.findViewById(R.id.message_text);
            timestamp = (TextView)itemView.findViewById(R.id.message_timestamp);
            user = (TextView)itemView.findViewById(R.id.message_user);
        }
    }

}


