package adityadifa.tugasmobile.difanotes.HalamanUtama

import adityadifa.tugasmobile.difanotes.Repository.NoteRepository
import adityadifa.tugasmobile.difanotes.data.response.LocationResponseItem
import adityadifa.tugasmobile.difanotes.data.retrofit.ApiConfig
import adityadifa.tugasmobile.difanotes.database.Note
import android.app.Application
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class MainViewModel (application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()

    private val _weather = MutableLiveData<List<LocationResponseItem>>()
    val weather: LiveData<List<LocationResponseItem>> = _weather

    init {
        searchWeather()
    }

    fun searchWeather() {
//        _isLoading.value = true
        val client = ApiConfig.getApiService().getWeather()
        client.enqueue(object : Callback<List<LocationResponseItem>> {
            override fun onResponse(
                call: Call<List<LocationResponseItem>>,
                response: Response<List<LocationResponseItem>>
            ) {
//                _weather.value = response.body()

//                _isLoading.value = false
                if (response.isSuccessful) {
                    _weather.value = response.body()
                } else {
                    Log.e(ContentValues.TAG, "onFailure: cek failure")
                }
            }

            override fun onFailure(call: Call<List<LocationResponseItem>>, t: Throwable) {
//                _isLoading.value = false
                Log.e(ContentValues.TAG, "onFailure: cek failure 2")
            }
        })
    }
}