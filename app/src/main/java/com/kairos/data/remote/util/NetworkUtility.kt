package com.kairos.data.remote.util

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kairos.R
import com.kairos.data.remote.ApiError
import com.kairos.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import retrofit2.HttpException
import javax.inject.Inject

/*
class NetworkUtility @Inject constructor(

    private val applicationContext: Context,
) {

    fun isOnline(): Boolean {

        val connectivityManager: ConnectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) != null
    }


    fun <T : Any> safeApiCall(
        isHandleUnAuthorized: Boolean = true,
        apiToBeCalled: suspend () -> T
    ): Flow<com.kairos.presentation.common.Result<T>> = flow {
        try {
            if (!isOnline()) {
                emit(
                    com.kairos.presentation.common.Result.Error(
                        ApiError(
                            NetworkError.NO_INTERNET.code,
                            applicationContext.getLocalizedResources(applicationContext.getCurrentLocale())
                                .getString(R.string.msg_no_network)
                        )
                    )
                )
            } else {
                emit(com.kairos.presentation.common.Result.Loading())
                val response = apiToBeCalled.invoke()
                emit(Result.Success(response))
            }
        } catch (ex: Exception) {
            handleNetworkException(ex, isHandleUnAuthorized)?.let {
                emit(com.kairos.presentation.common.Result.Error(it))
            }
        }
    }


    private fun handleNetworkException(ex: Exception, isHandleUnAuthorized: Boolean): ApiError? {
        if (ex is HttpException) {
            return when (ex.code()) {
                NetworkError.UNAUTHORIZED.code -> {
                    if (isHandleUnAuthorized) {
                        GeneralUtility.handleUnauthorized(applicationContext)
                    }
                    null
                }

                else -> {
                    ApiError(ex.code(), getErrorMessage(ex.code(), ex.response()?.errorBody()))
                }
            }
        } else {
            return ApiError(
                NetworkError.UNKNOWN_ERROR.code,
                applicationContext.getLocalizedResources(applicationContext.getCurrentLocale())
                    .getString(
                        R.string.msg_can_not_get_data
                    )
            )
        }


}

    private fun getErrorMessage(responseCode: Int, responseBody: ResponseBody?): String {
        val resources =
            applicationContext.getLocalizedResources(applicationContext.getCurrentLocale())
        when (responseCode) {

            NetworkError.BAD_REQUEST.code -> return getBackendErrorMessage(responseBody)
                ?: resources.getString(R.string.msg_bad_request)

            NetworkError.UNAUTHORIZED.code -> return resources.getString(R.string.msg_unauthorized_user)

            NetworkError.FORBIDDEN.code -> return resources.getString(R.string.msg_forbidden_user)

            NetworkError.NOT_FOUND.code -> return resources.getString(R.string.msg_no_data)

            NetworkError.TIMEOUT.code -> return resources.getString(R.string.msg_timeout)

            NetworkError.TOO_MANY_REQUESTS.code -> return getBackendErrorMessage(responseBody)
                ?: resources.getString(R.string.msg_too_many_requests)

            NetworkError.CONFLICT.code -> return resources.getString(R.string.msg_conflict)

            NetworkError.INTERNAL_SERVER_ERROR.code -> return resources.getString(
                R.string.msg_internal_service_error
            )

            else -> return resources.getString(R.string.msg_can_not_get_data)

        }
    }
}

private fun getBackendErrorMessage(responseBody: ResponseBody?): String? {
    val gson = Gson()
    val type = object : TypeToken<ErrorBodyResponse>() {}.type
    val errorResponse: ErrorBodyResponse? = gson.fromJson(responseBody?.charStream(), type)

    return errorResponse?.message
}
*/


enum class NetworkError(val code: Int) {
    NO_INTERNET(1000),
    UNKNOWN_ERROR(3000),
    DATA_ERROR(4000),

    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    TIMEOUT(408),
    CONFLICT(409),
    TOO_MANY_REQUESTS(429),
    INTERNAL_SERVER_ERROR(500),
}
