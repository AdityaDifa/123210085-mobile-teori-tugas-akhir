package adityadifa.tugasmobile.difanotes.data.response
import com.google.gson.annotations.SerializedName

data class LocationResponse(

    @field:SerializedName("LocationResponse")
    val locationResponse: List<LocationResponseItem?>? = null
)

data class LocationResponseItem(

    @field:SerializedName("tempF")
    val tempF: String? = null,

    @field:SerializedName("kodeCuaca")
    val kodeCuaca: String? = null,

    @field:SerializedName("cuaca")
    val cuaca: String? = null,

    @field:SerializedName("jamCuaca")
    val jamCuaca: String? = null,

    @field:SerializedName("humidity")
    val humidity: String? = null,

    @field:SerializedName("tempC")
    val tempC: String? = null
)