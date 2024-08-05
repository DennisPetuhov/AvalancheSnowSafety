package com.ass.bulletin.di

import com.ass.bulletin.ui.BulletinViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

fun bulletinFeatureModule()= module {
    viewModelOf(::BulletinViewModel)
}