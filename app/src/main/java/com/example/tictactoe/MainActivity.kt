package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityMainBinding
import kotlin.random.Random



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun buClick(view:View){
        val buChoise=view as Button
        var cellID=0
        when(buChoise.id){
            R.id.bu1-> cellID=1
            R.id.bu2-> cellID=2
            R.id.bu3-> cellID=3
            R.id.bu4-> cellID=4
            R.id.bu5-> cellID=5
            R.id.bu6-> cellID=6
            R.id.bu7-> cellID=7
            R.id.bu8-> cellID=8
            R.id.bu9-> cellID=9
        }
        Log.d("cellID", cellID.toString())
        buChoise.setBackgroundResource(R.color.blue)
        playGame(cellID,buChoise)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1
    fun playGame(cellID:Int,buChoise:Button){
        if( activePlayer == 1 ){
            buChoise.text = "X"
            buChoise.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()


        }else{

            buChoise.text = "O"
            buChoise.setBackgroundResource(R.color.darkGreen)
            player2.add(cellID)
            activePlayer = 1

        }
        buChoise.isEnabled=false

        checkWinner()
    }

    private fun autoPlay() {
        var emptyCells = ArrayList<Int>()

        for( cellId in 1..9){

            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }
        val r = Random
        val randIndex = r.nextInt(emptyCells.size -0)+0
        val cellId = emptyCells[randIndex]

        var buSelected:Button?
        when(cellId){
            1->  buSelected=binding.bu1
            2->buSelected= binding.bu2
            3-> buSelected=binding.bu3
            4-> buSelected=binding.bu4
            5-> buSelected=binding.bu5
            6-> buSelected=binding.bu6
            7-> buSelected=binding.bu7
            8-> buSelected=binding.bu8
            9-> buSelected=binding.bu9
            else ->{ buSelected=binding.bu1}

        }
        playGame(cellId,buSelected)
    }

    private fun checkWinner() {
        var winer = -1


        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }
        if(winer!=-1) {
            if (winer == 1) {

                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()


            } else {

                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()

            }
        }
    }
}