package com.k7.mealapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.k7.mealapp.mainscreen.ExploreFragment
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ExploreFragment.newInstance())
                    .commitNow()
        }
    }
}