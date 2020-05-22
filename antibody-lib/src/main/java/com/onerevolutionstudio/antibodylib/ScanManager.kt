package com.onerevolutionstudio.antibodylib

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.onerevolutionstudio.antibodylib.helper.FileUtil
import com.onerevolutionstudio.antibodylib.helper.ResultState
import com.onerevolutionstudio.antibodylib.model.ScanResult
import io.reactivex.Observable


class ScanManager constructor(
    private val context: Context,
    private val antiBodyConfig: AntiBodyConfig
) {

    private lateinit var installedApplicationList: List<ApplicationInfo>
    private val installedApplicationMap: HashMap<ApplicationInfo, Array<String>> = hashMapOf()


    fun onScan(): Observable<ResultState<ScanResult>> {
        return Observable.create { emitter ->
            emitter.onNext(ResultState.loading())

            val packageManager: PackageManager =
                context.getApplicationContext().getPackageManager()
            installedApplicationList =
                packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
            installedApplicationList.forEach { applicationValue ->
                if ((applicationValue.flags and ApplicationInfo.FLAG_SYSTEM) == 0) {
                    installedPermissionList(packageManager, applicationValue)
                }
            }

//

            emitter.onComplete()
        }

    }


    private fun installedPermissionList(packageManager: PackageManager, application: ApplicationInfo) {
        val permissionList: Array<String> =
            FileUtil.getPermissions(packageManager, application)
        if (antiBodyConfig.isDeepScan) {
            installedApplicationMap[application] = permissionList
        } else {
            installedApplicationMap[application] = arrayOf()
        }
    }


}