package com.example.swoosh.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.swoosh.R
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.utilities.PASSED_VALUE

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        var league = intent.getStringExtra(EXTRA_LEAGUE)
        var level =  intent.getStringExtra(PASSED_VALUE)
        var display: String = "Looking for a " + league + " " + level + "s league near you ..."

        var field = findViewById(R.id.searchLeaguesText) as TextView
        field.text = display
    }
}
