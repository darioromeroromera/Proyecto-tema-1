package com.pmdm

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var btnGotoCall : ImageButton
    private lateinit var btnAlarm : ImageButton
    private lateinit var btnWeb : ImageButton
    private lateinit var btnMail : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initEvent()
    }

    private fun initEvent() {
        btnGotoCall = findViewById(R.id.btn_goto_call)
        btnAlarm = findViewById(R.id.btn_alarm)
        btnWeb = findViewById(R.id.btn_web)
        btnMail = findViewById(R.id.btn_mail)

        btnGotoCall.setOnClickListener { view ->
            val intent = Intent(this, Second::class.java)

            startActivity(intent)
        }

        btnAlarm.setOnClickListener { view ->
            // NO PONER UN DELAY MAYOR A 60
            val DELAY = 2
            var hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            var minutos = Calendar.getInstance().get(Calendar.MINUTE) + DELAY

            if (minutos >= 60) {
                minutos -= 60
                if (hora != 23)
                    hora += 1
                else
                    hora = 0
            }

            var intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_HOUR, hora)
                putExtra(AlarmClock.EXTRA_MINUTES, minutos)
                putExtra(AlarmClock.EXTRA_MESSAGE, "Alarma creada por AppBotones")
            }


            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }

        btnWeb.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.w3schools.com")
            }

            startActivity(intent)
        }



        btnMail.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_SEND).apply {
                type="*/*"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("dromrom0206@g.educaand.es"))
                putExtra(Intent.EXTRA_SUBJECT, "Correo desde AppBotones")
                putExtra(Intent.EXTRA_TEXT, "Este es el mensaje del correo")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}