package com.example.tictactoe

import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tictactoe.databinding.ActivityNewGameFormBinding
import org.json.JSONObject

class newGameForm : AppCompatActivity() {
    private lateinit var binding:ActivityNewGameFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewGameFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
      binding.btnPlayGame.setOnClickListener {
         try{
             var playersDetails = JSONObject()
             var NamePlayerx = binding.playerX.text
             var NamePlayerO = binding.playerO.text
             playersDetails.put("playerX",NamePlayerx.toString().uppercase())
             playersDetails.put("playerO",NamePlayerO.toString().uppercase())
             Log.d(TAG, "onCreate: players Details $playersDetails")
             startActivity(Intent(applicationContext,GameBoard::class.java).putExtra("playersDetails",playersDetails.toString()))
         }catch (e:Exception){
             Log.e(TAG, "onCreate: error input in ${e.message}", )
         }
      }
    }
}