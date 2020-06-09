package com.kolliadit.recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<MyUser> usersList;

    public UsersAdapter(List<MyUser> ul) {
        this.usersList = ul;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final MyUser user = usersList.get(position);
        holder.textViewName.setText( user.name );
        holder.textViewAge.setText( String.valueOf(user.pos) );
        final String name=user.name;
        holder.votes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                user.vote();
                SharedPreferences sh = v.getContext().getSharedPreferences("votes", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sh.edit();
                int votes = sh.getInt(name, 0);
                votes += 1;
                editor.putInt(name, votes);
                editor.apply();
                holder.votes.setText(String.valueOf(user.getVote()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName, textViewAge;
        public String name;
        public Button votes;
        public MyViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.tv_name);
            textViewAge = view.findViewById(R.id.tv_age);
            name=textViewName.getText().toString();
            votes=view.findViewById(R.id.votes);
//            SharedPreferences sh = getActivity().getSharedPreferences("master2", Context.MODE_PRIVATE);
//            votes.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    SharedPreferences sh=getActivity();
//                }
//            });
        }
    }
}
