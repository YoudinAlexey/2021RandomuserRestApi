package ua.youdin.randomuserrestapi.data.randomuserApi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class RandomUserResponse(
    @field:SerializedName("results") val items: List<Data> = emptyList(),
)
@Parcelize
data class Data(
    @field:SerializedName("email") val email: String = "",
    @field:SerializedName("gender") val gender: String = "",
    @field:SerializedName("login") val login: Login?,
    @field:SerializedName("name") val name: Name?,
    @field:SerializedName("phone") val phone: String = "",
    @field:SerializedName("picture") val picture: Picture?,
) : Parcelable

@Parcelize
data class Login(
    @field:SerializedName("password") var password: String?,
    @field:SerializedName("username") var username: String?,

    ) : Parcelable

@Parcelize
data class Name(
    @field:SerializedName("first") var first: String?,
    @field:SerializedName("last") var last: String?,
    @field:SerializedName("title") var title: String?
) : Parcelable

@Parcelize
data class Picture(
    @field:SerializedName("large") var large: String?,
    @field:SerializedName("medium") var medium: String?,
    @field:SerializedName("thumbnail") var thumbnail: String?
) : Parcelable


//data class Result(
//    var info: Info?,
//    var results: List<ResultX>?
//)
//
//data class Info(
//    var page: Int?,
//    var results: Int?,
//    var seed: String?,
//    var version: String?
//)
//
//data class ResultX(
//    var cell: String?,
//    var dob: Dob?,
//    var email: String?,
//    var gender: String?,
//    var id: Id?,
//    var location: Location?,
//    var login: Login?,
//    var name: Name?,
//    var nat: String?,
//    var phone: String?,
//    var picture: Picture?,
//    var registered: Registered?
//)
//
//data class Dob(
//    var age: Int?,
//    var date: String?
//)
//
//data class Id(
//    var name: String?,
//    var value: Any?
//)
//
//data class Location(
//    var city: String?,
//    var coordinates: Coordinates?,
//    var country: String?,
//    var postcode: Any?,
//    var state: String?,
//    var street: Street?,
//    var timezone: Timezone?
//)
//
//data class Login(
//    var md5: String?,
//    var password: String?,
//    var salt: String?,
//    var sha1: String?,
//    var sha256: String?,
//    var username: String?,
//    var uuid: String?
//)
//
//data class Name(
//    var first: String?,
//    var last: String?,
//    var title: String?
//)
//
//data class Picture(
//    var large: String?,
//    var medium: String?,
//    var thumbnail: String?
//)
//
//data class Registered(
//    var age: Int?,
//    var date: String?
//)
//
//data class Coordinates(
//    var latitude: String?,
//    var longitude: String?
//)
//
//data class Street(
//    var name: String?,
//    var number: Int?
//)
//
//data class Timezone(
//    var description: String?,
//    var offset: String?
//)