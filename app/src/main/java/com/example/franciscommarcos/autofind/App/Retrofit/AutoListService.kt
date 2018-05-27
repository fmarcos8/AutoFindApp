package com.example.franciscommarcos.autofind.App.Retrofit

import com.example.franciscommarcos.autofind.App.Models.RequestPlate
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by francisco.mmarcos on 08/05/2018.
 */
interface AutoListService {
    @Headers(
        "X-Api-Key: TOKEN_RATO_MORTO"
    )
    @FormUrlEncoded
    @POST("cars/plate")
    fun get(
        @Field("plate") plate : String
    ) : Call<RequestPlate>
}