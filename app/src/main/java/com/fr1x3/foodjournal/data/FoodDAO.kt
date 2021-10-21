package com.fr1x3.foodjournal.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.fr1x3.foodjournal.models.Food

@Dao
interface FoodDAO {

    /* add food item to db*/
    @Insert( onConflict = OnConflictStrategy.REPLACE )
    fun insert( food: Food)

    /* update food item*/


    /* get food item list */

    /*  delete food item */
}