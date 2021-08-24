package com.example.androidassignment.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidassignment.R

class MapsFragment : Fragment() {

    companion object {
        fun newInstance() = MapsFragment()
    }

    private lateinit var viewModel: MapsViewModel

    private val callback = OnMapReadyCallback { googleMap ->

        val SnehaCare = LatLng(27.6518687, 85.2904712)
        googleMap.addMarker(MarkerOptions().position(SnehaCare).title("Mobile Shop"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SnehaCare, 15F), 4000, null )
        googleMap.uiSettings.isZoomControlsEnabled = true
//        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID;
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.maps_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }}






//    {
//        return inflater.inflate(R.layout.maps_fragment, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MapsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
//
//}