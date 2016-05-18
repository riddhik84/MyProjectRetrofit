package com.rk.myapps.myprojectretrofit.API;

import com.rk.myapps.myprojectretrofit.Model.GitModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rkakadia on 4/18/2016.
 */
public interface GitAPI {

//    @GET("/users/{user}")
//    Call<List<Repo>> listRepos(@Path("riddhik84") String user);
//
////    @GET("/users/riddhik84")
////    void getUser(Callback<GitModel>uscb);

    //Retrofit 2.0
    @GET("/users/riddhik84")
    Call<GitModel> getGitProfileInfo();
}
