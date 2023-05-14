package com.github.fajaragungpramana.intent.ui.main

import android.os.Bundle
import com.github.fajaragungpramana.intent.common.app.AppActivity
import com.github.fajaragungpramana.intent.databinding.ActivityMainBinding

class MainActivity : AppActivity<ActivityMainBinding>() {

    override fun onViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}