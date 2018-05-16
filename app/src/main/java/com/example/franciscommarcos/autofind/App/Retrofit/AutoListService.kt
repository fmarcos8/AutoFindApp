package com.example.franciscommarcos.autofind.App.Retrofit

import com.example.franciscommarcos.autofind.App.Models.Car
import com.example.franciscommarcos.autofind.App.Models.Data
import com.example.franciscommarcos.autofind.App.Models.RequestPlate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by francisco.mmarcos on 08/05/2018.
 */
interface AutoListService {
    @GET("cars/plate/{plate}")
    fun get(@Path("plate") plate : String ) : Call<RequestPlate>
}