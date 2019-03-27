package com.example.practicemvvm.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.practicemvvm.R
import com.example.practicemvvm.view.fragment.MainFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainFragment: MainFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fragmentの情報がなければフラグメントをreplaceで開始
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.screen_container, mainFragment)
                .commit()
        }
    }
}
