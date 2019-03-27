package com.example.practicemvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.practicemvvm.data.VocabularyData
import com.example.practicemvvm.model.VocabularySettings
import com.example.practicemvvm.model.VocabularySettingsRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MainViewModel(val context: Application) : AndroidViewModel(context), KoinComponent {
    var vocabulary = MutableLiveData<String>()
    private val vocabularySettingsRepository: VocabularySettingsRepository by inject()
    private lateinit var vocabularySettings: VocabularySettings

    fun initParameter() {
        vocabularySettings = vocabularySettingsRepository.loadVocabularySettings()
        vocabulary.value = vocabularySettings.vocabulary
    }

    fun setVocabulary(vocabularyData: VocabularyData) {
        vocabularySettingsRepository.setVocabulary(vocabularyData)
        vocabulary.value = vocabularyData.vocabulary
    }
}
