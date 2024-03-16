package com.example.tictactoe

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityGameBoardBinding
import org.json.JSONObject


//globel veriable
private val playerx = "playerX"
private val playero = "playerO"
private var XorY = true
private var GameboardStates = arrayOf("2","2","2","2","2","2","2","2","2")
class GameBoard : AppCompatActivity(),View.OnClickListener {
    private lateinit var bindingGameboard:ActivityGameBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingGameboard = ActivityGameBoardBinding.inflate(layoutInflater)
        setContentView(bindingGameboard.root)
        
       try {
           var playersDetailsString = intent.getStringExtra("playersDetails")
           var playerDetails = JSONObject(playersDetailsString)
           var playerX_name = playerDetails.get(playerx)
           var playerO_name = playerDetails.get(playero)
           Log.d(TAG, "onCreate: GameBoard $playersDetailsString $playerX_name $playerO_name")

       }catch (e:Exception){
           Log.e(TAG, "onCreate: in intentGetting ${e.message}")
       }

        
        // code for button click
        bindingGameboard.playboard.btn0.setOnClickListener(this)
        bindingGameboard.playboard.btn1.setOnClickListener(this)
        bindingGameboard.playboard.btn2.setOnClickListener(this)
        bindingGameboard.playboard.btn3.setOnClickListener(this)
        bindingGameboard.playboard.btn4.setOnClickListener(this)
        bindingGameboard.playboard.btn5.setOnClickListener(this)
        bindingGameboard.playboard.btn6.setOnClickListener(this)
        bindingGameboard.playboard.btn7.setOnClickListener(this)
        bindingGameboard.playboard.btn8.setOnClickListener(this)



    }

    override fun onStart() {
        super.onStart()
        for (i in 1..8){
            GameboardStates[i] = "2"
        }
    }

    override fun onClick(view: View?) {
            if (view != null) {
                when (view.id) {
                    R.id.btn0 -> {
                        GameBottomClick(0, view)
                    }

                    R.id.btn1 -> {
                        GameBottomClick(1, view)
                    }

                    R.id.btn2 -> {
//
                        GameBottomClick(2, view)
                    }

                    R.id.btn3 -> {
                        GameBottomClick(3, view)

                    }

                    R.id.btn4 -> {
                        GameBottomClick(4, view)

                    }

                    R.id.btn5 -> {
                        GameBottomClick(5, view)

                    }

                    R.id.btn6 -> {
                        GameBottomClick(6, view)

                    }

                    R.id.btn7 -> {
                        GameBottomClick(7, view)

                    }

                    R.id.btn8 -> {
                        GameBottomClick(8, view)
                    }

                }
            }

       }
    private fun GameBottomClick(position:Int, view: View){
        var btn:Button = findViewById(view.id);
        if(btn.text.isEmpty()){
            if(XorY==true){
                        btn.setBackgroundResource(R.drawable.bkg_o)
                        btn.text = "O"
                addFilledPositions(position,"O")
                        XorY= false

            }else{

                        btn.setBackgroundResource(R.drawable.bkg_x)
                        btn.text = "X"
                addFilledPositions(position,"X")
                        XorY = true

            }
        }


    }
    private fun addFilledPositions(place:Int,str:String){
        GameboardStates[place] = str
        checkGame()
    }
    private fun checkGame(){
        //for testing purpose
        Log.d(TAG, "checkGame:------------------------new states ")
       for (i in 0..8){
           Log.d(TAG, "checkGame: "+ GameboardStates.get(i))
       }

        // check loggic to who is winner


    }
}