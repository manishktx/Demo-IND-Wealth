package com.demo.assignment.data.db

import androidx.room.TypeConverter
import com.demo.assignment.data.model.list.License
import com.demo.assignment.data.model.list.Owner
import com.demo.assignment.data.model.list.Permissions
import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class AppConverters {

    @TypeConverter
    fun licenseToString(source: License?): String? = Gson().toJson(source)

    @TypeConverter
    fun stringToLicense(source: String?): License? = Gson().fromJson(
        source,
        License::class.java
    )

    @TypeConverter
    fun ownerToString(data: Owner): String? = Gson().toJson(data)

    @TypeConverter
    fun stringToOwner(str: String?): Owner? = Gson().fromJson(
        str,
        Owner::class.java
    )

    @TypeConverter
    fun permissionsToString(data: Permissions): String? = Gson().toJson(data)

    @TypeConverter
    fun stringToPermissions(str: String?): Permissions? = Gson().fromJson(
        str,
        Permissions::class.java
    )


}