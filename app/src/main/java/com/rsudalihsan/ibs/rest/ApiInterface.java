package com.rsudalihsan.ibs.rest;

import com.rsudalihsan.ibs.model.IbsResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
//    @Headers({
//            "Accept: application/json",
//            "Content-Type: application/json",
//            "x-username: ibs",
//            "x-token: c01e30fc608bec4fe5a9d8f415cd344c",
//    })
    @GET("v1/ibs")
    Call<IbsResponse> getIbs();
}