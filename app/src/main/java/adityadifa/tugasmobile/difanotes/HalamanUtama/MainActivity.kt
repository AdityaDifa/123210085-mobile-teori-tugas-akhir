package adityadifa.tugasmobile.difanotes.HalamanUtama

import adityadifa.tugasmobile.difanotes.databinding.ActivityMainBinding
import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NoteAdapter

    private lateinit var binding: ActivityMainBinding

    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.tombolTambah.setOnClickListener{
            Log.d(ContentValues.TAG, "onCreate: tombol tambah clicked")
            val dialogFragment = TambahFile()
            dialogFragment.show(supportFragmentManager, "my_dialog_fragment_tag")
        }

        val mainViewModel = obtainViewModel(this@MainActivity)
        mainViewModel.getAllNotes().observe(this) { noteList ->
            if (noteList != null) {
                adapter.setListNotes(noteList)
            }
        }

        mainViewModel.weather.observe(this){
            val listWeather = it.first()
            binding.textWeather.text = "cuaca : ${listWeather.cuaca.toString()}"
        }


        adapter = NoteAdapter()
        binding?.rvNotes?.layoutManager = GridLayoutManager(this, 3)
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter

        // Inisialisasi locationManager
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        // Buat locationListener
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                // Lokasi telah berubah, update tampilan teks lokasi
                updateLocationText(location)
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }

        // Cek izin lokasi
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Jika izin tidak diberikan, minta izin
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                1001
            )
            return
        }

        // Mulai permintaan pembaruan lokasi
        try {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                5000,
                10f,
                locationListener
            )
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }


    private fun obtainViewModel(activity: AppCompatActivity): MainViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(MainViewModel::class.java)
    }
    private fun updateLocationText(location: Location) {
        //-6.175403,106.824584 monas
        //31.5017125,34.4565447 gaza
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses: List<Address>? = geocoder.getFromLocation(location.latitude, location.longitude, 1)
        val cityName: String? = addresses?.get(0)?.locality
        binding.textLocation.text = cityName // Gantilah 'textView' dengan id tampilan teks Anda
    }


}