package br.com.cambuy.uai.wars.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UaiWarsApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}