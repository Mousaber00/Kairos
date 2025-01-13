package com.kairos.data.remote.util

import android.app.LocaleManager
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import com.kairos.R
import com.kairos.data.remote.ApiError
import org.intellij.lang.annotations.Language
import retrofit2.HttpException
import java.util.Locale

fun Context.getLocalizedResources(language: String): Resources {
    var conf: Configuration = resources.configuration
    conf = Configuration(conf)
    conf.setLocale(Locale(language))
    val localizedContext = createConfigurationContext(conf)
    return localizedContext.resources
}


fun Context.getCurrentLocale(): String =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        var language: String? =
            getSystemService(LocaleManager::class.java).applicationLocales.get(0)?.language
        if (language == null) {
            language = resources.configuration.locales.get(0).language
        }
        language ?: com.kairos.data.remote.util.Language.ENGLISH.value
    } else {
        var language = AppCompatDelegate.getApplicationLocales().get(0)?.language
        if (language == null) {
            language = resources.configuration.locales.get(0).language
        }
        language ?: com.kairos.data.remote.util.Language.ENGLISH.value
    }

