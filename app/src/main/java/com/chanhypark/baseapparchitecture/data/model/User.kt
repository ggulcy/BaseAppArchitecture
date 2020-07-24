package com.chanhypark.baseapparchitecture.data.model

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User : Serializable{
    //name
    @SerializedName("name")
    var name:Name = Name()

    //gender
    @SerializedName("gender")
    var gender:String = ""

    //email
    @NonNull
    @SerializedName("email")
    var email:String = ""

    //picture
    @SerializedName("picture")
    var picture:Picture = Picture()


    var like:Int = 0


    class Name : Serializable{
        @SerializedName("title")
        var title: String = ""
        @SerializedName("first")
        var first: String = ""
        @SerializedName("last")
        var last: String = ""
    }

    class Picture : Serializable{
        @SerializedName("large")
        var large:String = ""
        @SerializedName("medium")
        var medium:String = ""
        @SerializedName("thumbnail")
        var thumbnail:String = ""
    }

    override fun hashCode(): Int {
        return name.first.toInt()
    }
}