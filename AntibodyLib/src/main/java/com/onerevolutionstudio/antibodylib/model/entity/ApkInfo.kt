package com.onerevolutionstudio.antibodylib.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apk_info")
data class ApkInfo(
    @PrimaryKey
    @ColumnInfo(name = "packageName")
    val packageName: String,
    @ColumnInfo(name = "company")
    val company: String,
    @ColumnInfo(name = "appName")
    val appName: String,
    @ColumnInfo(name = "rating")
    val rating: Short,
    @ColumnInfo(name = "size")
    val size: Int,
    @ColumnInfo(name = "stored")
    val stored: Boolean,
    @ColumnInfo(name = "analyzed")
    val analyzed: Boolean,
    @ColumnInfo(name = "is_apk")
    val isApk: Boolean,
    @ColumnInfo(name = "trusted")
    val trusted: Boolean,
    @ColumnInfo(name = "detected")
    val detected: Boolean,
    @ColumnInfo(name = "corrupted")
    val corrupted: Boolean,
    @ColumnInfo(name = "displayed_version")
    val displayedVersion: Boolean
)