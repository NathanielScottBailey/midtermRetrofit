package com.example.midtermretrofit.reposervice;

import retrofit2.Call;
import retrofit2.http.GET;
import com.example.midtermretrofit.models.breedList;
public interface ApiService {

    @GET("breeds/list/all")
    Call <breedList> getBreeds();

    @GET("breed/hound/images")
    Call <breedList> getDogs();
}
