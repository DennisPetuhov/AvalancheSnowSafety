package com.avalanche_snow_safety.di

import com.avalanche_snow_safety.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// Main Koin Module
val avalancheSnowSafetyModule = module {
    includes()
    viewModel<MainActivityViewModel> { MainActivityViewModel() }
}