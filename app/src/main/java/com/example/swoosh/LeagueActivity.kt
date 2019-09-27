package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {
    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        mensLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            selectedLeague = "mens"
        }

        womensLeagueBtn.setOnClickListener {
            mensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            selectedLeague = "womens"
        }

        coedLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false
            mensLeagueBtn.isChecked = false
            selectedLeague = "co-ed"
        }


        next_btn.setOnClickListener {
            if(selectedLeague != ""){
                val skillIntent = Intent(this, SkillActivity::class.java)
                startActivity(skillIntent)
            }else{
                Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
