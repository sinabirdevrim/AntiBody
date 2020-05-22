package com.onerevolutionstudio.antibodylib

data class AntiBodyConfig constructor(
    val isDeepScan: Boolean = false
) {

    data class Builder(var isDeepScan: Boolean) {

        fun isDeepScan(isDeepScan: Boolean) = apply { this.isDeepScan = isDeepScan }
    }

}



