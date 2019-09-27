package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    var league: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)

        //display selected value from previous screen

        if(league.contentEquals("mens")){
            league = "Man"
        }else if(league.contentEquals("womens")){
            league = "Woman"
        }

        beginnerBtn.setOnClickListener{
            ballerBtn.isChecked = false
        }

        ballerBtn.setOnClickListener {
         beginnerBtn.isChecked = false
        }

        var selected = findViewById(R.id.selected_button) as TextView
        selected.text = "Iam a: "+league

        finishBtn.setOnClickListener {
            val finishIntent = Intent(this, FinishActivity::class.java)
            startActivity(finishIntent)
        }

    }
}
