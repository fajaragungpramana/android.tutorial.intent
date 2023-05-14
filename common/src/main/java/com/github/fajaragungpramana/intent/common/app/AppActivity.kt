package com.github.fajaragungpramana.intent.common.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class AppActivity<out T: ViewBinding> : AppCompatActivity() {

    private lateinit var mViewBinding: T
    protected val viewBinding: T
        get() = mViewBinding

    protected abstract fun onViewBinding(): T

    protected abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!::mViewBinding.isInitialized) mViewBinding = onViewBinding()
        setContentView(viewBinding.root)

        onCreated(savedInstanceState)
    }

}