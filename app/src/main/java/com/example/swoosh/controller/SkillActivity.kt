package com.example.swoosh.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R

class SkillActivity : AppCompatActivity() {
    var league = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }
}
