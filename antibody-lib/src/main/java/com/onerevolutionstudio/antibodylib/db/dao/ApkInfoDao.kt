package com.onerevolutionstudio.antibodylib.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.onerevolutionstudio.antibodylib.model.entity.ApkInfo
import io.reactivex.Completable

@Dao
interface ApkInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(apkList: ArrayList<ApkInfo>): Completable
}