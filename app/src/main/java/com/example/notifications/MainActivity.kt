package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  nm= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            nm.createNotificationChannel(
                NotificationChannel(
                    "first",
                    "demo",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )

        }
            val simpleNotification =NotificationCompat.Builder(this,"first")
                .setContentText("Simple Notification")
                .setContentText("Sample discription for the notification")
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText("jwjjjdjkjdkdkhkjhhoiuiouklakusisousossklklklopoioipasaouiusowkslsuioilklklsjsiudoiuasoiudhkjsdhjsdhfjsdhfj,shfj,hfkjshfkshfkhksjhfsusiu;auljdskhfjkfhjkhkfhffjkljfkljlskdjflsufoi"))
                .setSmallIcon(R.drawable.ic_launcher_foreground)

        btn.setOnClickListener {
            val notification = simpleNotification.build()
            nm.notify(System.currentTimeMillis().toInt(), notification)
        }
        btn2.setOnClickListener {
            val i=Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("http://www.google.com")
            val pi = PendingIntent.getActivity(this,1234,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val notification = simpleNotification.apply {
                setContentIntent(pi)
                setAutoCancel(true)
            }.build()
            nm.notify(System.currentTimeMillis().toInt(), notification)
        }
        btn3.setOnClickListener {
            val i=Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("http://www.google.com")
            val pi = PendingIntent.getActivity(this,1234,i,PendingIntent.FLAG_UPDATE_CURRENT)
            val notification = simpleNotification.apply {
                setContentIntent(pi)
                addAction(R.drawable.ic_launcher_foreground,"Click me",pi)//add btn in notification
                
            }.build()
            nm.notify(System.currentTimeMillis().toInt(), notification)
        }
        }
    }
