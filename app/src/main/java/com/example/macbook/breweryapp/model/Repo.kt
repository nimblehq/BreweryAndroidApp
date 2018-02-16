package com.example.macbook.breweryapp.model

import com.google.gson.annotations.SerializedName

data class Repo(
        @SerializedName("id")
        val id: String,
        @SerializedName("full_name")
        val fullname: String)