package com.github.fajaragungpramana.intent.ui.detail

import android.os.Bundle
import com.github.fajaragungpramana.intent.common.app.AppActivity
import com.github.fajaragungpramana.intent.databinding.ActivityDetailBinding

class DetailActivity : AppActivity<ActivityDetailBinding>() {

    override fun onViewBinding(): ActivityDetailBinding =
        ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}