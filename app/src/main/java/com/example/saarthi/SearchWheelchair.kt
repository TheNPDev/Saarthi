package com.example.saarthi

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.saarthi.databinding.ActivitySearchWheelchairBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class SearchWheelchair : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mapView: MapView
    private lateinit var binding: ActivitySearchWheelchairBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchWheelchairBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)

        mapView = findViewById(R.id.map)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        val allWheelchair = arrayOf("Wheelchair 1","Wheelchair 2","Wheelchair 3")
        val chairs = findViewById<Spinner>(R.id.allWheelchair)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            applicationContext,
            android.R.layout.simple_spinner_dropdown_item,
            allWheelchair
        )
        chairs.setAdapter(adapter)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val its = LatLng(28.677559718503982, 77.38883555178325)
        val its1 = LatLng(28.677079718503982,77.38826555178325)
        val its2 = LatLng(28.677929718503982,77.38801555178325)
        mMap.addMarker(MarkerOptions().position(its).title("Wheelchair 1"))
        mMap.addMarker(MarkerOptions().position(its1).title("Wheelchair 2"))
        mMap.addMarker(MarkerOptions().position(its2).title("Wheelchair 3"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(its))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(its, 15f))
    }
}