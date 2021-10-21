package com.fr1x3.foodjournal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fr1x3.foodjournal.models.Food
import com.fr1x3.foodjournal.utils.Constants
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database( entities = [Food::class], version = Constants.DB_VERSION)
abstract class FoodRoomDatabase: RoomDatabase() {

    abstract fun FoodDao() : FoodDAO

    companion object{

        private var INSTANCE : FoodRoomDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context) : FoodRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    FoodRoomDatabase::class.java,
                    "food_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }

    }
}