package com.example.franciscommarcos.autofind.App.Activities

import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.widget.Toast
import com.example.franciscommarcos.autofind.App.Models.RequestSearch
import com.example.franciscommarcos.autofind.App.Models.SearchModel
import com.example.franciscommarcos.autofind.App.Retrofit.Initializer
import com.example.franciscommarcos.autofind.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_maps.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import kotlin.collections.ArrayList

class MapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    override fun onMarkerClick(p0: Marker?) = false

    private var listSearchModel: ArrayList<SearchModel> = ArrayList()

    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        search("-23.670078", "-46.700142", "3000", "golf", "", "")

        fab.setOnClickListener{view ->
            Toast.makeText(this@MapActivity, "TESTE", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.getUiSettings().setZoomControlsEnabled(true)
        map.setOnMarkerClickListener(this)
        setUpMap()
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }

        map.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(currentLatLng)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }
        map.mapType = GoogleMap.MAP_TYPE_TERRAIN


    }

    private fun placeMarkerOnMap(location: LatLng) {
        val markerOptions = MarkerOptions().position(location).snippet("Population: 4,137,400")
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))

        val titleAndress: String = getAddress(location)
        markerOptions.title(titleAndress)

        map.addMarker(markerOptions)

        if(listSearchModel.size > 0) {
            for (latLng in listSearchModel) {
                map.addMarker(MarkerOptions()
                        .position(LatLng(latLng.latitude.toDouble(), latLng.longitude.toDouble()))
                        .title("teste"))

            }
        }
        map.addCircle(
            CircleOptions()
            .center(location)
            .radius(3000.toDouble())
            .strokeColor(Color.WHITE)
            .strokeWidth(1.toFloat())
            .fillColor(this@MapActivity.resources.getColor(R.color.transparence))
        )

    }

    private fun getAddress(latLng: LatLng): String {
        val geocoder = Geocoder(this)
        val addresses: List<Address>?
        val address: Address?
        var addressText = ""

        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)

            if (null != addresses && !addresses.isEmpty()) {
                addressText = addresses[0].getAddressLine(0)
            }
        } catch (e: IOException) {
            Log.e("MapsActivity", e.localizedMessage)
        }
        return addressText
    }

    private fun search(latitude : String, longitude : String, range : String, keyword : String, model : String, brand : String){
        val call = Initializer()
                .searchService()
                .search(
                    latitude,
                    longitude,
                    range,
                    keyword,
                    model,
                    brand
                )

        call.enqueue(object : Callback<RequestSearch>{
            override fun onFailure(call: Call<RequestSearch>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<RequestSearch>?, response: Response<RequestSearch>?) {
                response?.body()?.let{
                    //requestSearch = it
                    for(resultSearch in it.data){
                        listSearchModel.add(resultSearch)
                    }
                }
            }
        })
    }
}

