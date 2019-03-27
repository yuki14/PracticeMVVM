package com.example.practicemvvm.model

data class VocabularySettings(
    var vocabulary: String?
) {
    companion object {
        const val PREF_VOCABULARY_SETTINGS_NAME = "com.example.practicemvvm.vocabulary_settings"
    }
}

enum class VocabularySettingsPrefKey {
    VOCABULARY
}