package com.example.instalaw

import android.app.Application

class InstaLawApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitInstance.initialize(this)
    }
}