package com.kairos.data.remote.util

import android.content.Context
import android.content.pm.PackageManager
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import com.kairos.data.remote.ApiError

class GeneralUtility {
    companion object {
        private val handler = Handler(Looper.getMainLooper())

        val dataError = ApiError(
            NetworkError.DATA_ERROR.code,
            GenConstants.DATA_ERROR_MESSAGE
        )

        fun checkPermissionIsGranted(context: Context, permission: String): Boolean {
            return ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }


        fun handleUnauthorized(context: Context) {

            handler.post {
                //TODO
            }
        }


    }
}


