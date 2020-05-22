package com.onerevolutionstudio.antibodylib.db

import android.content.Context
import androidx.room.Room

class DatabaseManager {

    companion object {

        @Volatile private var mInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            mInstance ?: synchronized(this) {
                mInstance ?: buildDatabase(context).also { mInstance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "AntiBody.db")
                .build()
    }
}