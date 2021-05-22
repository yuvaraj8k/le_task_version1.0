package com.le.letaskapp.network;

import com.le.letaskapp.model.UserDetails;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/users")
    Call<ArrayList<UserDetails>> doGetUserList();
}
