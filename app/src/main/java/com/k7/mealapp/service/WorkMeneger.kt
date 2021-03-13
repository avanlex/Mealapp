package com.k7.mealapp.service

import android.content.*
import android.os.IBinder
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkMeneger(context: Context, params: WorkerParameters): Worker(context, params) {
    override fun doWork(): Result {
        val intent = Intent(applicationContext,MealOfDayService::class.java)
        applicationContext.bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE)

        Log.i(ContentValues.TAG, "Запуск работы сервиса")
        return Result.success()
    }
    private var isBound = false
    private var service: MealOfDayService? = null
    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            isBound = true

            service = (binder as? MealOfDayService.MealOfDayServiceBinder)?.getService()
            service?.showNotification()

            Log.i(ContentValues.TAG, "Запуск работы сервиса")

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.i(ContentValues.TAG, "Прекращение работы сервиса")
            isBound = false
            service = null
        }
    }

}