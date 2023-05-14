package com.github.fajaragungpramana.intent.ui.main

import android.content.Intent
import android.os.Bundle
import com.github.fajaragungpramana.intent.common.app.AppActivity
import com.github.fajaragungpramana.intent.databinding.ActivityMainBinding
import com.github.fajaragungpramana.intent.ui.detail.DetailActivity

class MainActivity : AppActivity<ActivityMainBinding>() {

    override fun onViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {

        viewBinding.mbDetail.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            startActivity(intent)
        }

    }

}