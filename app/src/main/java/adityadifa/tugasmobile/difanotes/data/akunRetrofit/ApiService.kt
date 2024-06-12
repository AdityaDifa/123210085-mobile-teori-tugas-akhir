package adityadifa.tugasmobile.difanotes.data.akunRetrofit

import adityadifa.tugasmobile.difanotes.data.Pref.UserModel
import adityadifa.tugasmobile.difanotes.data.response.LocationResponseItem
import adityadifa.tugasmobile.difanotes.data.response.LoginResponse
import adityadifa.tugasmobile.difanotes.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
//    @GET("search/users")
//    fun getUser(
//        @Query("q") login: String
//    ): Call<UserResponse>
//
//    @GET("users/{username}")
//    fun getDetailUser(
//        @Path("username") username: String
//    ): Call<DetailUserResponse>

    @POST("api/account/check")
    suspend fun getAccount(
//        @Query("q") login: String
        @Body loginData: UserModel
    ): Response<LoginResponse>

    @POST("api/account/register")
    suspend fun registerAccount(
//        @Query("q") login: String
        @Body loginData: UserModel
    ): Response<RegisterResponse>

//    @GET("users/{username}/following")
//    fun getFollowing(
//        @Path("username") username: String
//    ): Call<List<ItemsItem>>
}