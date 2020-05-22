package com.onerevolutionstudio.antibodylib.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onerevolutionstudio.antibodylib.db.dao.ApkInfoDao
import com.onerevolutionstudio.antibodylib.model.entity.ApkInfo

@Database(entities = [ApkInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun apkInfoDao(): ApkInfoDao

}