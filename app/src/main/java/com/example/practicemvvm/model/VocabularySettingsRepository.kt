package com.example.practicemvvm.model

import android.content.Context
import com.example.practicemvvm.MyApplication
import com.example.practicemvvm.data.VocabularyData

class VocabularySettingsRepository {

    private val context = MyApplication.appContext
    private val pref = context.getSharedPreferences(
        VocabularySettings.PREF_VOCABULARY_SETTINGS_NAME, Context.MODE_PRIVATE
    )
    private val editor = pref.edit()

    fun loadVocabularySettings(): VocabularySettings {
        return VocabularySettings(
            vocabulary = pref.getString(VocabularySettingsPrefKey.VOCABULARY.name, null)
        )
    }

    fun setVocabulary(vocabularyData: VocabularyData) {
        editor.putString(VocabularySettingsPrefKey.VOCABULARY.name, vocabularyData.vocabulary).commit()
    }
}