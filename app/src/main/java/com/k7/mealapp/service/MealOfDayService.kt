package com.k7.mealapp.service

import android.app.PendingIntent
import android.app.Service
import android.content.ContentValues
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.k7.mealapp.MainActivity
import com.k7.mealapp.R
import com.k7.mealapp.model.api.MealAPI
import com.k7.mealapp.network.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MealOfDayService: Service() {

    val binder = MealOfDayServiceBinder()


    fun showNotification(){
        Log.i(ContentValues.TAG, "Уведомление!")

        CoroutineScope(Dispatchers.Main).launch {
            var net = Network()
            var randomMeal = net.searchFoodRandom()
            var meal=randomMeal.meals[0]
            sendNotification(meal)

        }
    }
    suspend fun sendNotification(meal: MealAPI)= withContext(Dispatchers.Main){
        var intent = Intent(applicationContext, MainActivity::class.java)
            .setAction(Intent.ACTION_VIEW)
            .putExtra("mealId", meal.idMeal)
        val pendingIntent =  PendingIntent.getActivity(applicationContext, 1, intent,
            PendingIntent.FLAG_UPDATE_CURRENT)
        val notification = NotificationCompat.Builder(applicationContext, "MealOfDay")
            .setContentTitle("MealApp")
            .setContentText("Блюдо дня: "+meal.meal)
            .setSmallIcon(R.drawable.ic_message)
            .setContentIntent(pendingIntent)
        Log.i(ContentValues.TAG, "создалось notification!")
        try {
            with(NotificationManagerCompat.from(applicationContext)) {
                // notificationId is a unique int for each notification that you must define
                notify(1, notification.build())
            }
        }  catch (e: Exception) {
            Log.i(ContentValues.TAG, "error"+e.toString())
        }
    }


    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }
    inner class MealOfDayServiceBinder : Binder() {
        fun getService(): MealOfDayService {
            return this@MealOfDayService
        }
    }

}