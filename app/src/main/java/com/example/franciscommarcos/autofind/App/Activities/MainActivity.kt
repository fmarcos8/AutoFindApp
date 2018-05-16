package com.example.franciscommarcos.autofind.App.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.franciscommarcos.autofind.App.Models.Data
import com.example.franciscommarcos.autofind.App.Models.RequestPlate
import com.example.franciscommarcos.autofind.App.Retrofit.Initializer
import com.example.franciscommarcos.autofind.R

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    protected lateinit var car_data : Data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        /*btn_search.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }*/

        btn_search.setOnClickListener{
            val dialog = indeterminateProgressDialog(message = "Aguarde", title = "Buscando dados da placa!")
            dialog.show()
            val edit_plate = edit_plate.text
            val call = Initializer().autoListService().get(edit_plate.toString())
            call.enqueue(object : Callback<RequestPlate?> {
                override fun onResponse(call: Call<RequestPlate?>?, response: Response<RequestPlate?>?) {
                    response?.body()?.let{
                        car_data = it.data
                    }
                    dialog.hide()
                    alert("Placa: " + car_data.placa + "\n" +
                                   "Marca: " + car_data.marca + "\n" +
                                   "Modelo: "+ car_data.modelo + "\n" +
                                   "Cor: " + car_data.cor + "\n" +
                                   "Combutível: " + car_data.combustivel + "\n" +
                                   "Ano: " + car_data.anofabricacao +"/" + car_data.anomodelo + "\n",
                            "Esses dados são do seu carro ?") {
                        yesButton {
                            val intent = Intent(this@MainActivity, MapActivity::class.java)
                            startActivity(intent)
                        }
                        noButton {}
                    }.show()
                }
                override fun onFailure(call: Call<RequestPlate?>?, t: Throwable?) {
                }
            })
        }
    }
}
