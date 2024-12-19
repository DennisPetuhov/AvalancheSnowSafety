package com.ass.observation.di

import com.ass.observation.ui.screens.main.ObservationMainScreenViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


fun observationModule() = module {
    single { Dispatchers.Default }
    viewModel { ObservationMainScreenViewModel(get()) }
}