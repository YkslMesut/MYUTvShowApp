package com.myu.myutvshowapp.repository

import com.myu.myutvshowapp.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val api : ApiService) {

    suspend fun getTvShows ()  = api.getTvShows()
}