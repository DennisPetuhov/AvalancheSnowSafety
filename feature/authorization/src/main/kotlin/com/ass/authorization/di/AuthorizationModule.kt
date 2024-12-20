package com.ass.authorization.di

import com.ass.authorization.ui.screens.login.LogInViewModel
import com.ass.authorization.ui.screens.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

fun authorizationModule() = module {
    viewModelOf(::LogInViewModel)
    viewModelOf(::SplashScreenViewModel)
    includes(authorizationDataModule())
}