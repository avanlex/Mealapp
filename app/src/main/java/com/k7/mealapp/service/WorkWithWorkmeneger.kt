package com.k7.mealapp.service

import androidx.work.*
import kotlinx.coroutines.withContext

import java.util.concurrent.TimeUnit
class WorkWithWorkmeneger {

    private val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

    //рабочая версия
    //val delayedRequest = PeriodicWorkRequest.Builder(WorkMeneger::class.java,24,TimeUnit.HOURS,18,TimeUnit.HOURS)
    //   .setConstraints(constraints)

    //версия для тестирования
    val delayedRequest = PeriodicWorkRequest.Builder(WorkMeneger::class.java,18,TimeUnit.HOURS)
        .setConstraints(constraints)

    fun startService(){

        val startServiceOfDay: PeriodicWorkRequest = delayedRequest.build()
        WorkManager.getInstance().enqueue(startServiceOfDay)
    }

}