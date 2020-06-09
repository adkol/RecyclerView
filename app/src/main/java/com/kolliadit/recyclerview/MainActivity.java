package com.kolliadit.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MyUser> mUsersList;
    private RecyclerView mRecyclerView;
    private UsersAdapter mUsersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new GsonBuilder().create();
        MyUser[] myUsers = gson.fromJson( getString(R.string.my_users), MyUser[].class );
        mUsersList = new ArrayList<>(Arrays.asList(myUsers));

        mRecyclerView = findViewById(R.id.recycler_view);
        mUsersAdapter = new UsersAdapter(mUsersList);
        mUsersAdapter.notifyDataSetChanged();

        RecyclerView.LayoutManager rvlManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(rvlManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mUsersAdapter);


    }
}


