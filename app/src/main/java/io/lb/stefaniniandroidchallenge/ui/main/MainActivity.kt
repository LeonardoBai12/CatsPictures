package io.lb.stefaniniandroidchallenge.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import io.lb.stefaniniandroidchallenge.R
import javax.inject.Inject

class MainActivity: AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PostViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_StefaniniAndroidChallenge)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}