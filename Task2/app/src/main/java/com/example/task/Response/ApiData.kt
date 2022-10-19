package com.example.task.Response

import com.google.gson.annotations.SerializedName

data class ApiData(
    @SerializedName("data") var data: Data,
    @SerializedName("support") var support: Support
)


data class Data(

    @SerializedName("id") var id: Int,
    @SerializedName("email") var email: String,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("avatar") var avatar: String

)

data class Support(

    @SerializedName("url") var url: String,
    @SerializedName("text") var text: String

)