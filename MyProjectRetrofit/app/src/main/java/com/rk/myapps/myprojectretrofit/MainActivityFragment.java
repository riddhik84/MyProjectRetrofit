package com.rk.myapps.myprojectretrofit;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rk.myapps.myprojectretrofit.API.GitAPI;
import com.rk.myapps.myprojectretrofit.Model.GitModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    String base_url = "https://api.github.com";

    TextView login;
    TextView avatar_url;
    TextView url;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        login = (TextView) rootView.findViewById(R.id.login);
        avatar_url = (TextView) rootView.findViewById(R.id.avatar_url);
        url = (TextView) rootView.findViewById(R.id.url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitAPI service = retrofit.create(GitAPI.class);

        Call<GitModel> call = service.getGitProfileInfo();

        call.enqueue(new Callback<GitModel>() {

            @Override
            public void onResponse(Call<GitModel> call, Response<GitModel> response) {
                try {

                    String login__ = response.body().getLogin().toString();

                    String avatar_url__ = response.body().getAvatarUrl().toString();

                    String url__ = response.body().getUrl().toString();

                    login.setText(login__);
                    avatar_url.setText(avatar_url__);
                    url.setText(url__);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GitModel> call, Throwable t) {
                    Log.e(LOG_TAG, "Error in retrofit");
            }
        });

        return rootView;
    }
}
