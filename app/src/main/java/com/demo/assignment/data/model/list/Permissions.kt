package com.demo.assignment.data.model.list


import com.google.gson.annotations.SerializedName

data class Permissions(
    @SerializedName("admin")
    val admin: Boolean = false,
    @SerializedName("push")
    val push: Boolean = false,
    @SerializedName("pull")
    val pull: Boolean = false
)