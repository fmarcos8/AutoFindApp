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
import com.example.franciscommarcos.autofind.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.io.IOException
import com.google.android.gms.maps.model.LatLng



class MapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    override fun onMarkerClick(p0: Marker?) = false

    private val local1 = LatLng(-23.65019,-46.7206887)
    private val local2 = LatLng(-23.636369, -46.687558)
    private val local3 = LatLng(-23.680189, -46.695673)

    private lateinit var map: GoogleMap
    private lateinit var map1: GoogleMap
    private lateinit var map2: GoogleMap
    private lateinit var map3: GoogleMap
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
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        /*val myStreet = LatLng(-23.68849, -46.6718463)
        map.addMarker(MarkerOptions().position(myStreet).title("Rua onde eu moro"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(myStreet, 15.0f))*/


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

    private fun placeMarkerOnMap(location: LatLng){
        val markerOptions = MarkerOptions().position(location).snippet("Population: 4,137,400")
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))

        val titleAndress : String = getAddress(location)
        markerOptions.title(titleAndress)

        map.addMarker(MarkerOptions()
                .position(local1)
                .title("TESTE"))

        map.addMarker(MarkerOptions()
                .position(local2)
                .title("Perth"))

        map.addMarker(MarkerOptions()
                .position(local3)
                .title("Perth"))

        map.addMarker(markerOptions)

        val circle : Circle = map.addCircle(
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
                /*for (i in 1 until address.maxAddressLineIndex) {
                    addressText += if (i == 0) address.getAddressLine(i) else "\n" + address.getAddressLine(i)
                }*/
            }
        } catch (e: IOException) {
            Log.e("MapsActivity", e.localizedMessage)
        }
        return addressText
    }

}
