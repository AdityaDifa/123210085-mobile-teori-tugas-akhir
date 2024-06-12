package adityadifa.tugasmobile.difanotes.data.retrofit
import adityadifa.tugasmobile.difanotes.data.response.LocationResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET("cuaca/501187.json")
    fun getWeather(
//        @Query("q") login: String
    ): Call<List<LocationResponseItem>>

//    @GET("users/{username}/following")
//    fun getFollowing(
//        @Path("username") username: String
//    ): Call<List<ItemsItem>>
}