package com.example.practicemvvm

import android.app.Application
import android.content.Context
import com.example.practicemvvm.data.VocabularyData
import com.example.practicemvvm.di.appModule
import com.example.practicemvvm.util.VocabularyId
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        vocabularyList = setVocabularyData()
        startKoin(this, listOf(appModule))
    }

    private fun setVocabularyData(): ArrayList<VocabularyData> {
        return arrayListOf(
            VocabularyData(VocabularyId.NINETH, getString(R.string.vocabulary_nineth)),
            VocabularyData(VocabularyId.TENTH, getString(R.string.vocabulary_tenth)),
            VocabularyData(VocabularyId.ELEVENTH, getString(R.string.vocabulary_eleventh))
        )
    }

    companion object {
        lateinit var appContext: Context
        lateinit var vocabularyList: ArrayList<VocabularyData>
    }
}