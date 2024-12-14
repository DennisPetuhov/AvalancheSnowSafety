package com.ass.authorization.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.ass.authorization.ui.screens.login.LogInViewModel
import com.ass.authorization.ui.screens.splash.SplashScreenViewModel

fun authorizationModule() = module {
    viewModelOf(::LogInViewModel)
    viewModelOf(::SplashScreenViewModel)
}