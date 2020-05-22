package com.onerevolutionstudio.antibodylib.helper

import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

object FileUtil {


    fun getPermissions(packageManager: PackageManager, applicationInfo: ApplicationInfo)
            : Array<String> {
        var packageInfo: PackageInfo?
        try {
            packageInfo = packageManager.getPackageInfo(
                applicationInfo.packageName,
                PackageManager.GET_PERMISSIONS
            )
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            return arrayOf()
        }
        return packageInfo?.let {
            it.requestedPermissions
        } ?: run {
            return arrayOf()
        }
    }
}