package com.onerevolutionstudio.antibodylib

import android.content.Context
import com.onerevolutionstudio.antibodylib.db.AppDatabase
import com.onerevolutionstudio.antibodylib.db.DatabaseManager
import com.onerevolutionstudio.antibodylib.model.entity.ApkInfo
import java.util.*


object AntiBodyMain {

    private lateinit var context: Context
    private lateinit var appDatabase: AppDatabase

    fun init(context: Context) {
        this.context = context
        this.appDatabase = DatabaseManager.getInstance(context)
    }

    fun initList(blackList: List<ApkInfo>) {
        val uuid: UUID = UUID.randomUUID()
        val randomUUIDString: String = uuid.toString()
        updateList(blackList, randomUUIDString)
    }

    /**
     *@param hash parameter decides whether the library needs to be updated
     */
    fun initList(blackList: List<ApkInfo>, hash: String) {
        updateList(blackList, hash)
    }

    private fun updateList(blackList: List<ApkInfo>, hash: String) {

    }

    fun onScan() {

    }
}