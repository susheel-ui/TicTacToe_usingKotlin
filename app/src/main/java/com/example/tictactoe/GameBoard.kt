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
private var WinnerAnnounceOrNot = false
private var GameboardStates = arrayOf("2","2","2","2","2","2","2","2","2")
private var playersCount_X = 0
private var playersCount_O = 0
private var counter=0
class GameBoard : AppCompatActivity(),View.OnClickListener {
    private lateinit var bindingGameboard:ActivityGameBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingGameboard = ActivityGameBoardBinding.inflate(layoutInflater)
        setContentView(bindingGameboard.root)
        
       try {
           val playersDetailsString = intent.getStringExtra("playersDetails")
           val playerDetails = JSONObject(playersDetailsString)
           val playerX_name = playerDetails.get(playerx)
           val playerO_name = playerDetails.get(playero)
           Log.d(TAG, "onCreate: GameBoard $playersDetailsString $playerX_name $playerO_name")
           bindingGameboard.txtplayerx.text = playerX_name.toString().plus("[X]")
           bindingGameboard.txtplayerO.text = playerO_name.toString().plus("[O]")

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
        if (counter == 0){                                                                          // if counter is 0 then it will set the reset WinnerAnnounceOrNot for false then it will goes to normal behaviour
            WinnerAnnounceOrNot = false
        }
        if(btn.text.isEmpty()){
            if(XorY==true){
                        btn.setBackgroundResource(R.drawable.bkg_o)
                        btn.text = "O"
                        addFilledPositions(position,"O")
                if (WinnerAnnounceOrNot == false){
                    XorY= false
                }else{
                    XorY = true
                }


            }else{

                        btn.setBackgroundResource(R.drawable.bkg_x)
                        btn.text = "X"
                addFilledPositions(position,"X")
                if (WinnerAnnounceOrNot == false){
                    XorY = true
                }else{
                    XorY = false
                }

            }
        }


    }
    private fun addFilledPositions(place:Int,str:String){
        GameboardStates[place] = str
        counter++                                                                                   // counter for get the position of the game play

        if(counter>=4){                                                                             // if counter is in 4th number then it check otherwise it will not execute this section of code because there is no chance to win if there is only 3 input
            checkGame(str)
        }

    }
    private fun checkGame(str:String){
        //for testing purpose
        Log.d(TAG, "checkGame:------------------------new states ")
       for (i in 0..8){
           Log.d(TAG, "checkGame: "+ GameboardStates.get(i))
       }

        // check loggic to who is winner
//check horizontal element
        if(GameboardStates.get(0).equals(GameboardStates.get(1))&& GameboardStates.get(1).equals(
                GameboardStates.get(2))&& !GameboardStates.get(0).equals("2")){
            Toast.makeText(applicationContext, "Winner->"+str, Toast.LENGTH_SHORT).show()
            winnerAnnounced(str.uppercase());
        }
        else if (GameboardStates.get(3).equals(GameboardStates.get(4))&& GameboardStates.get(4).equals(
                GameboardStates.get(5))&& !GameboardStates.get(3).equals("2")){
            Toast.makeText(applicationContext, "Winner->"+str, Toast.LENGTH_SHORT).show()
            winnerAnnounced(str.uppercase());
        }
        else if (  GameboardStates.get(6).equals(GameboardStates.get(7))&& GameboardStates.get(7).equals(
                GameboardStates.get(8))&& !GameboardStates.get(6).equals("2")){
            Toast.makeText(applicationContext, "Winner->"+str, Toast.LENGTH_SHORT).show()
            winnerAnnounced(str.uppercase());
        }
        // for check vertical elements
        else if (  GameboardStates.get(0).equals(GameboardStates.get(3))&& GameboardStates.get(3).equals(
                GameboardStates.get(6))&& !GameboardStates.get(0).equals("2")){
            Toast.makeText(applicationContext, "Winner->"+str, Toast.LENGTH_SHORT).show()
            winnerAnnounced(str.uppercase());
        }

        else if (  GameboardStates.get(1).equals(GameboardStates.get(4))&& GameboardStates.get(4).equals(
                GameboardStates.get(7))&& !GameboardStates.get(1).equals("2")){
            Toast.makeText(applicationContext, "Winner->"+str, Toast.LENGTH_SHORT).show()
            winnerAnnounced(str.uppercase());
        }
        else if (  GameboardStates.get(2).equals(GameboardStates.get(5))&& GameboardStates.get(5).equals(
                GameboardStates.get(8))&& !GameboardStates.get(2).equals("2")){
            Toast.makeText(applicationContext, "Winner->"+str, Toast.LENGTH_SHORT).show()
            winnerAnnounced(str.uppercase());
        }
        // check diagonal elements
        else if (  GameboardStates.get(0).equals(GameboardStates.get(4))&& GameboardStates.get(4).equals(
                GameboardStates.get(8))&& !GameboardStates.get(0).equals("2")){
            Toast.makeText(applicationContext, "Winner->"+str, Toast.LENGTH_SHORT).show()
            winnerAnnounced(str.uppercase());
        }
        else if (  GameboardStates.get(2).equals(GameboardStates.get(4))&& GameboardStates.get(4).equals(
                GameboardStates.get(6))&& !GameboardStates.get(2).equals("2")){
            Toast.makeText(applicationContext, "Winner->"+str, Toast.LENGTH_SHORT).show()
            winnerAnnounced(str.uppercase());
        }else if(counter == 9){
            ResetPlayborad()
        }





    }
    private fun winnerAnnounced(winner:String){
        WinnerAnnounceOrNot = true

            if(winner.equals("X")){
                playersCount_X++
                bindingGameboard.scorX.text = playersCount_X.toString()
                ResetPlayborad()


            }else{
                playersCount_O++
                bindingGameboard.scorY.text = playersCount_O.toString()
                ResetPlayborad()
            }

    }
    private fun ResetPlayborad(){
        bindingGameboard.playboard.btn0.text = ""
        bindingGameboard.playboard.btn1.text = ""
        bindingGameboard.playboard.btn2.text = ""
        bindingGameboard.playboard.btn3.text = ""
        bindingGameboard.playboard.btn4.text = ""
        bindingGameboard.playboard.btn5.text = ""
        bindingGameboard.playboard.btn6.text = ""
        bindingGameboard.playboard.btn7.text = ""
        bindingGameboard.playboard.btn8.text = ""

        bindingGameboard.playboard.btn0.setBackgroundResource(R.drawable.playbtnbg)
        bindingGameboard.playboard.btn1.setBackgroundResource(R.drawable.playbtnbg)
        bindingGameboard.playboard.btn2.setBackgroundResource(R.drawable.playbtnbg)
        bindingGameboard.playboard.btn3.setBackgroundResource(R.drawable.playbtnbg)
        bindingGameboard.playboard.btn4.setBackgroundResource(R.drawable.playbtnbg)
        bindingGameboard.playboard.btn5.setBackgroundResource(R.drawable.playbtnbg)
        bindingGameboard.playboard.btn6.setBackgroundResource(R.drawable.playbtnbg)
        bindingGameboard.playboard.btn7.setBackgroundResource(R.drawable.playbtnbg)
        bindingGameboard.playboard.btn8.setBackgroundResource(R.drawable.playbtnbg)

        for (i in 0..8){
            GameboardStates[i] = "2"
        }
        counter=0;


    }
}