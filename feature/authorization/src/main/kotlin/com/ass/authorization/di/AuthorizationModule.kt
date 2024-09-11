package com.ass.authorization.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.ass.authorization.ui.LogInViewModel

fun authorizationModule() = module {
    viewModelOf(::LogInViewModel)
}