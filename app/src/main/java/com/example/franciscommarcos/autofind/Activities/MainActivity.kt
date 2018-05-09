package com.example.franciscommarcos.autofind.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.franciscommarcos.autofind.Activities.Models.Plate
import com.example.franciscommarcos.autofind.Activities.Retrofit.Initializer
import com.example.franciscommarcos.autofind.R

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit_plate = edit_plate
        val btn_search = btn_search

        btn_search.setOnClickListener{
            val call = Initializer().autoListService().get()
            call.enqueue(object : Callback<Plate?>{
                override fun onResponse(call: Call<Plate?>?, response: Response<Plate?>?) {
                    response?.body()?.let{
                        val data_plate = it
                    }
                }
                override fun onFailure(call: Call<Plate?>?, t: Throwable?) {
                }
            })
        }
    }
}
