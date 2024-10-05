package com.ass

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ass.core.foundation.lifecycle.BaseActivity
import com.ass.ui.app.AvalancheSnowSafetyApp

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckingCoarsePermission()
            AvalancheSnowSafetyApp()
        }
    }
}
