package com.example.tictactoe.DB_files

import android.content.ContentValues.TAG
import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "db_Games")
data class Game_info(
    @PrimaryKey(autoGenerate = true) val Game_id:Int?,
    @ColumnInfo(name ="playerx") val playerx:String,
    @ColumnInfo(name ="playero") val playero:String,
    @ColumnInfo(name = "socre_x") val score_X:Int,
    @ColumnInfo(name = "socre_o") val score_O:Int,
    @ColumnInfo(name = "LastWoned") val WhoWonedLast:String,
    @ColumnInfo(name="Date") var date:String?,


) {

    constructor(playerx: String,playero: String,score_X: Int,score_O: Int,WhoWonedLast: String):this(null,playerx,playero,score_X,score_O,WhoWonedLast,Date().toString());
}