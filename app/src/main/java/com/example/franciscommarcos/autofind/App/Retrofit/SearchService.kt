package com.example.franciscommarcos.autofind.App.Retrofit

import com.example.franciscommarcos.autofind.App.Models.RequestSearch
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by franc on 24/05/2018.
 */
interface SearchService {
    @Headers(
        "X-Api-Key: TOKEN_RATO_MORTO"
    )
    @FormUrlEncoded
    @POST("products/search")
    fun search(
            @Field("latitude")  latitude : String,
            @Field("longitude") longitude : String,
            @Field("range")     range : String,
            @Field("keyword")   keyword : String,
            @Field("model")     model : String,
            @Field("brand")     brand : String
    ) : Call<RequestSearch>

}