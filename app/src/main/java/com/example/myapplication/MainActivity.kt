package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var saxeli: EditText
    private lateinit var meoresaxeli: EditText
    private lateinit var dawyeba: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dawyeba= findViewById(R.id.dawyeba)
        saxeli = findViewById(R.id.saxeli)
        meoresaxeli = findViewById(R.id.meoresaxeli)

        dawyeba.setOnClickListener{
            var playerOne = saxeli.text.toString()
            var playerSecond = meoresaxeli.text.toString()
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("player1", playerOne)
            intent.putExtra("player2", playerSecond)
            startActivity(intent)
        }
    }
}