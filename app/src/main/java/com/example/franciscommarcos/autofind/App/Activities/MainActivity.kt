package com.example.franciscommarcos.autofind.App.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.franciscommarcos.autofind.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val edit_plate = edit_plate

        btn_search.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        /*btn_search.setOnClickListener{
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
        }*/
    }
}
