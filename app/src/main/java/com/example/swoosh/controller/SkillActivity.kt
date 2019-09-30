package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.swoosh.utilities.EXTRA_PLAYER
import com.example.swoosh.R
import com.example.swoosh.model.Player
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
        var league = player.league
        var changeString = ""
        //display selected value from previous screen

        if(league != null && league.contentEquals("mens")){
            changeString = "Man"
        }else if(league != null && league.contentEquals("womens")){
            changeString = "Woman"
        }

        beginnerBtn.setOnClickListener{
            ballerBtn.isChecked = false
            player.skill = "beginner"
        }

        ballerBtn.setOnClickListener {
         beginnerBtn.isChecked = false
            player.skill = "baller"
        }

        var selected = findViewById(R.id.selected_button) as TextView
        selected.text = "Iam a: "+changeString

        finishBtn.setOnClickListener {
            if(player.skill != null){
                val finishIntent = Intent(this, FinishActivity::class.java)
                finishIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(finishIntent)
            }else{
                Toast.makeText(this, "Please select your skill level", Toast.LENGTH_SHORT).show()
            }

        }

    }
}
