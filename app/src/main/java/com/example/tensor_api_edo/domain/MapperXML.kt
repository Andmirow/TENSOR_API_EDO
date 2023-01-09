package com.example.tensor_api_edo.domain

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Base64;

class MapperXML {

    val encodedString = "fdfgdrg"





    @RequiresApi(Build.VERSION_CODES.O)
    val decodedBytes = Base64.getDecoder().decode(encodedString)

    @RequiresApi(Build.VERSION_CODES.O)
    val decodedString = String(decodedBytes)






}