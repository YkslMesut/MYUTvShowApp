package com.myu.myutvshowapp.api

import com.myu.myutvshowapp.helper.Constants
import com.myu.myutvshowapp.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows() : Response<TvShowResponse>
}