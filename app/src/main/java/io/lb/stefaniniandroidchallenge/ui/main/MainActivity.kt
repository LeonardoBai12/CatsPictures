package io.lb.stefaniniandroidchallenge.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewTreeObserver
import io.lb.stefaniniandroidchallenge.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_StefaniniAndroidChallenge)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}