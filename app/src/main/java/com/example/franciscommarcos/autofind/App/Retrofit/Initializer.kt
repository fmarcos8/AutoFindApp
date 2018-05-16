package com.example.franciscommarcos.autofind.App.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by francisco.mmarcos on 08/05/2018.
 */
 class Initializer {
    val retrofit = Retrofit.Builder()
            .baseUrl("http://temporadabrasil.com.br/autofind/web/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun autoListService() : AutoListService = retrofit.create(AutoListService::class.java)
}
