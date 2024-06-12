package adityadifa.tugasmobile.difanotes.data.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
//            val authInterceptor = Interceptor { chain ->
//                val req = chain.request()
//                val requestHeaders = req.newBuilder()
//                    .addHeader("Authorization", "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")
//                    .build()
//                chain.proceed(requestHeaders)
//            }
            val client = OkHttpClient.Builder()
//                .addInterceptor(authInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://ibnux.github.io/BMKG-importer/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}