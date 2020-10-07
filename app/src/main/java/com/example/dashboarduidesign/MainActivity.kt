package com.example.dashboarduidesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fingrePrintCard = findViewById<CardView>(R.id.fingrePrintCard);
        fingrePrintCard.setOnClickListener {
            val intent = Intent(this, fingureActivity::class.java)
            startActivity(intent)
        }
        var CustomNotificationCard = findViewById<CardView>(R.id.CustomNotificationCard);
        CustomNotificationCard.setOnClickListener {
            val intent = Intent(this, CustomNotificationActivity::class.java)
            startActivity(intent)
        }

        var CollapsingCard = findViewById<CardView>(R.id.CollapsingCard);
        CollapsingCard.setOnClickListener {
            val intent = Intent(this, CollapsingActivity::class.java)
            startActivity(intent)
        }
        var SigninCard = findViewById<CardView>(R.id.SigninCard);
        SigninCard.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


    }
}