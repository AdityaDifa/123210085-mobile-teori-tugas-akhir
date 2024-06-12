package adityadifa.tugasmobile.difanotes.LoginPage

import adityadifa.tugasmobile.difanotes.HalamanReviewNote.ReviewHalamanActivity
import adityadifa.tugasmobile.difanotes.HalamanUtama.MainActivity
import adityadifa.tugasmobile.difanotes.HalamanUtama.TambahFile
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import adityadifa.tugasmobile.difanotes.R
import adityadifa.tugasmobile.difanotes.data.Pref.UserModel
import adityadifa.tugasmobile.difanotes.data.akunRetrofit.ApiConfig
import adityadifa.tugasmobile.difanotes.data.response.LoginResponse
import adityadifa.tugasmobile.difanotes.databinding.ActivityLoginPageBinding
import adityadifa.tugasmobile.difanotes.databinding.ActivityMainBinding
import android.content.ContentValues
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginPage : AppCompatActivity() {

    private lateinit var binding: ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener{
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                showToast("Username and Password masih kosong")
                return@setOnClickListener
            }

            lifecycleScope.launch {
                try {
                    val apiService = ApiConfig.getApiService()
                    val loginData = UserModel(username, password)
                    val successResponse = apiService.getAccount(loginData)

                    if (successResponse.body()?.exists == true) {
                        val loginResponse = successResponse.body()
                        showToast("Login Successful")
                        val intent = Intent(it.context, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        val errorBody = successResponse.errorBody()?.string()
                        val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
                        showToast("Login Gagal")
                    }

                } catch (e: HttpException) {
                    Log.e("LoginPage", "HttpException: ${e.message()}")
                    showToast("Login Failed: ${e.message()}")
                } catch (e: Exception) {
                    Log.e("LoginPage", "Exception: ${e.message}")
                    showToast("An error occurred: ${e.message}")
                }
            }
        }

        binding.registerButton.setOnClickListener{
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                showToast("Username and Password masih kosong")
                return@setOnClickListener
            }

            lifecycleScope.launch {
                try {
                    val apiService = ApiConfig.getApiService()
                    val loginData = UserModel(username, password)
                    val successResponse = apiService.registerAccount(loginData)

                    if (successResponse.body()?.success == true) {
                        showToast("Register Berhasil")

                    }
                    else if(successResponse.body()?.message == "Username sudah ada"){
                        showToast("Akun sudah terdaftar")
                    }
                    else {
                        val errorBody = successResponse.errorBody()?.string()
                        val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
                        showToast("Akun sudah terdaftar")
                    }

                } catch (e: HttpException) {
                    Log.e("LoginPage", "HttpException: ${e.message()}")
                    showToast("Login Failed: ${e.message()}")
                } catch (e: Exception) {
                    Log.e("LoginPage", "Exception: ${e.message}")
                    showToast("An error occurred: ${e.message}")
                }
            }
        }
    }
    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}