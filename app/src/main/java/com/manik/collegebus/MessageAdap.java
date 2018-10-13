package com.manik.collegebus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MessageAdap extends RecyclerView.Adapter<MessageAdap.MessageHolder> {

    private Context context;
    private List<UMessage> messageList;
    private FirebaseAuth firebaseAuth;

    public MessageAdap(Context context, List<UMessage> messageList) {
        this.context = context;
        this.messageList = messageList;
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_msg, viewGroup, false);
        return new MessageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder messageHolder, int i) {
        UMessage uMessage = messageList.get(i);

        if (uMessage.getUsername().equals(firebaseAuth.getCurrentUser().getPhoneNumber())) {
            messageHolder.tv_inmsg.setVisibility(View.GONE);
            messageHolder.tv_outmsg.setVisibility(View.VISIBLE);
            messageHolder.tv_outmsg.setBackground(context.getResources().getDrawable(R.drawable.outgoing_msg));
            messageHolder.tv_outmsg.setText(uMessage.getMessage());
        } else {
            messageHolder.tv_outmsg.setVisibility(View.GONE);
            messageHolder.tv_inmsg.setVisibility(View.VISIBLE);

            messageHolder.tv_inmsg.setBackground(context.getResources().getDrawable(R.drawable.income_msg));
            messageHolder.tv_inmsg.setText(uMessage.getMessage());
        }
    }


    @Override
    public int getItemCount() {
        return messageList.size();
    }


    public class MessageHolder extends RecyclerView.ViewHolder {

        TextView tv_inmsg;
        TextView tv_outmsg;
        ConstraintLayout layout;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);

            tv_inmsg = itemView.findViewById(R.id.incomingmsg);
            tv_outmsg = itemView.findViewById(R.id.outgoingmsg);
            layout = itemView.findViewById(R.id.rl);

        }

    }


}
