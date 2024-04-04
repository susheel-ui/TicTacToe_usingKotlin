package com.example.tictactoe.DB_files

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Game_info::class], version = 1)
abstract class SaveGameDatabase:RoomDatabase(){
    abstract fun game_Dao():Game_Dao
}