package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {
    var selectedLeague = ""

    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        mensLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            player.league = "mens"
        }

        womensLeagueBtn.setOnClickListener {
            mensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            player.league = "womens"
        }

        coedLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false
            mensLeagueBtn.isChecked = false
            player.league = "co-ed"
        }


        next_btn.setOnClickListener {
            if(player.league != ""){
                val skillIntent = Intent(this, SkillActivity::class.java)
                skillIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(skillIntent)
            }else{
                Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
