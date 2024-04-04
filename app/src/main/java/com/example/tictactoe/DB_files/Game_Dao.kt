package com.example.tictactoe.DB_files

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Game_Dao {
    @Query("Select * from DB_GAMES")
    fun getAllGames():List<Game_info>

    @Insert
    fun insertnewEntity(vararg Game:Game_info)

    @Delete
    fun deleteEntity(Game:Game_info)


}