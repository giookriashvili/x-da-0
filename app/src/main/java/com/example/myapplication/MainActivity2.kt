package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class MainActivity2 : AppCompatActivity(), View.OnClickListener{

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var reset: Button
    private lateinit var p1Name: TextView
    private lateinit var p2Name: TextView
    private lateinit var p1Score: TextView
    private lateinit var p2Score: TextView

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var score1 = 0
    private var score2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        reset = findViewById(R.id.reset)
        p1Name = findViewById(R.id.p1Name)
        p2Name = findViewById(R.id.p2Name)
        p1Score = findViewById(R.id.p1Score)
        p2Score = findViewById(R.id.p2Score)
        p1Name.text = intent?.extras?.getString("player1", "")
        p2Name.text = intent?.extras?.getString("player2", "")


        reset.setOnClickListener{
            reset()
        }

        init()
    }
    private fun init(){
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }

    var buttonNumber = 0
    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            when(clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0 ) {
                playGame(clickedView, buttonNumber)
            }

        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.CYAN)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()

    }

    private fun check(){

        var winnerPlayer = 0
        if (firstPlayer.contains(1)&&firstPlayer.contains(2)&&firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1)&&secondPlayer.contains(2)&&secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4)&&firstPlayer.contains(5)&&firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4)&&secondPlayer.contains(5)&&secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7)&&firstPlayer.contains(8)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7)&&secondPlayer.contains(8)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1)&&firstPlayer.contains(4)&&firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1)&&secondPlayer.contains(4)&&secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2)&&firstPlayer.contains(5)&&firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2)&&secondPlayer.contains(5)&&secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3)&&firstPlayer.contains(6)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3)&&secondPlayer.contains(6)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1)&&firstPlayer.contains(5)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1)&&secondPlayer.contains(5)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3)&&firstPlayer.contains(5)&&firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3)&&secondPlayer.contains(5)&&secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.size + secondPlayer.size == 9){
            Toast.makeText(this, "tie", Toast.LENGTH_SHORT).show()
            activePlayer = 1
            firstPlayer.clear()
            secondPlayer.clear()
            reset()
        }
        if(winnerPlayer == 1){
            Toast.makeText(this, "player 1 wins", Toast.LENGTH_SHORT).show()
            activePlayer = 1
            firstPlayer.clear()
            secondPlayer.clear()
            reset()
            score1 ++
            p1Score.text = score1.toString()

        } else if(winnerPlayer == 2){
            Toast.makeText(this, "player 2 wins", Toast.LENGTH_SHORT).show()
            activePlayer = 1
            firstPlayer.clear()
            secondPlayer.clear()
            reset()
            score2 ++
            p2Score.text = score2.toString()
        }
    }
    private fun reset(){

        activePlayer = 1
        firstPlayer.clear()
        secondPlayer.clear()

        button1.text = ""
        button1.setBackgroundColor(Color.rgb(98, 0, 238))
        button1.isEnabled = true
        button2.text = ""
        button2.setBackgroundColor(Color.rgb(98, 0, 238))
        button2.isEnabled = true
        button3.text = ""
        button3.setBackgroundColor(Color.rgb(98, 0, 238))
        button3.isEnabled = true
        button4.text = ""
        button4.setBackgroundColor(Color.rgb(98, 0, 238))
        button4.isEnabled = true
        button5.text = ""
        button5.setBackgroundColor(Color.rgb(98, 0, 238))
        button5.isEnabled = true
        button6.text = ""
        button6.setBackgroundColor(Color.rgb(98, 0, 238))
        button6.isEnabled = true
        button7.text = ""
        button7.setBackgroundColor(Color.rgb(98, 0, 238))
        button7.isEnabled = true
        button8.text = ""
        button8.setBackgroundColor(Color.rgb(98, 0, 238))
        button8.isEnabled = true
        button9.text = ""
        button9.setBackgroundColor(Color.rgb(98, 0, 238))
        button9.isEnabled = true
        p1Score.text = "0"
        p2Score.text = "0"
        score1 = 0
        score2 = 0
    }
}