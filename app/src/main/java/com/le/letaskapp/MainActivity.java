package com.le.letaskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.le.letaskapp.model.UserDetails;
import com.le.letaskapp.network.ApiInterface;
import com.le.letaskapp.network.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    private ArrayList<UserDetails> userDetailsArrayList;
    private RecyclerView recyclerView;
    private UserDetailsAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        getUserData();

    }

    private void getUserData () {
        apiInterface = ApiService.getClient().create(ApiInterface.class);

        Call<ArrayList<UserDetails>>  call = apiInterface.doGetUserList();
        call.enqueue(new Callback<ArrayList<UserDetails>>() {
            @Override
            public void onResponse (Call<ArrayList<UserDetails>> call, Response<ArrayList<UserDetails>> response) {
                userDetailsArrayList = response.body();
                adapter = new UserDetailsAdapter(userDetailsArrayList, MainActivity.this);
                recyclerView.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure (Call<ArrayList<UserDetails>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void initialize () {
        progressBar = findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = findViewById(R.id.rv_list);
    }
}