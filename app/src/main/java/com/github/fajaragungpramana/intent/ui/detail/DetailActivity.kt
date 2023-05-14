package com.github.fajaragungpramana.intent.ui.detail

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.github.fajaragungpramana.intent.R
import com.github.fajaragungpramana.intent.common.app.AppActivity
import com.github.fajaragungpramana.intent.databinding.ActivityDetailBinding

class DetailActivity : AppActivity<ActivityDetailBinding>() {

    private val mLaunchIntentGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }

    private val mRequestPermissionGallery =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted)
                openGalleryWithChooser()
            else
                Toast.makeText(
                    this@DetailActivity,
                    getString(R.string.something_went_wrong),
                    Toast.LENGTH_SHORT
                ).show()
        }

    override fun onViewBinding(): ActivityDetailBinding =
        ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {

        viewBinding.mbBack.setOnClickListener { finish() }

        viewBinding.mbGallery.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this@DetailActivity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            )
                openGalleryWithChooser()
            else
                mRequestPermissionGallery.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

    }

    private fun openGalleryWithChooser() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        mLaunchIntentGallery.launch(
            Intent.createChooser(
                intent,
                getString(R.string.choose_a_picture)
            )
        )
    }

}