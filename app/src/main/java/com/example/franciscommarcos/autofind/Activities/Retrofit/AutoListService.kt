package com.example.franciscommarcos.autofind.Activities.Retrofit

import com.example.franciscommarcos.autofind.Activities.Models.Plate
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by francisco.mmarcos on 08/05/2018.
 */
interface AutoListService {
    @GET("V0009/{plate}")
    fun get() : Call<Plate>
}