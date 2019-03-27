package com.example.practicemvvm.di

import android.app.Application
import com.example.practicemvvm.model.VocabularySettingsRepository
import com.example.practicemvvm.view.fragment.MainFragment
import com.example.practicemvvm.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    factory { MainFragment() }
    factory { VocabularySettingsRepository() }

    viewModel { MainViewModel(androidContext() as Application) }
}