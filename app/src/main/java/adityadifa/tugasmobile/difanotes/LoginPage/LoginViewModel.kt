package adityadifa.tugasmobile.difanotes.LoginPage

import adityadifa.tugasmobile.difanotes.Repository.NoteRepository
import adityadifa.tugasmobile.difanotes.data.response.LocationResponseItem
import adityadifa.tugasmobile.difanotes.data.response.LoginResponse
import adityadifa.tugasmobile.difanotes.data.akunRetrofit.ApiConfig
import adityadifa.tugasmobile.difanotes.database.Note
import android.app.Application
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel (application: Application) : ViewModel() {



    private val _account = MutableLiveData<LoginResponse>()
    val account: LiveData<LoginResponse> = _account

    init {
//        cekAccount()
    }

    suspend fun cekAccount() {
//        _isLoading.value = true
//        val client = ApiConfig.getApiService().getAccount()
//        client.enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(
//                call: Call<LoginResponse>,
//                response: Response<LoginResponse>
//            ) {
////                _weather.value = response.body()
//
////                _isLoading.value = false
//                if (response.isSuccessful) {
//                    _account.value = response.body()
//                } else {
//                    Log.e(ContentValues.TAG, "onFailure: cek failure")
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
////                _isLoading.value = false
//                Log.e(ContentValues.TAG, "onFailure: cek failure 2")
//            }
//        })
    }
}