package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.utilities.PASSED_VALUE
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    var league: String = ""
    var skill: String = ""
    var changeString: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)

        //display selected value from previous screen

        if(league.contentEquals("mens")){
            changeString = "Man"
        }else if(league.contentEquals("womens")){
            changeString = "Woman"
        }

        beginnerBtn.setOnClickListener{
            ballerBtn.isChecked = false
            skill = "beginner"
        }

        ballerBtn.setOnClickListener {
         beginnerBtn.isChecked = false
            skill = "baller"
        }

        var selected = findViewById(R.id.selected_button) as TextView
        selected.text = "Iam a: "+changeString

        finishBtn.setOnClickListener {
            if(skill != ""){
                val finishIntent = Intent(this, FinishActivity::class.java)
                finishIntent.putExtra(PASSED_VALUE, skill)
                finishIntent.putExtra(EXTRA_LEAGUE, league)
                startActivity(finishIntent)
            }else{
                Toast.makeText(this, "Please select your skill level", Toast.LENGTH_SHORT).show()
            }

        }

    }
}
