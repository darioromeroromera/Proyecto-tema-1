package com.pmdm

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import android.Manifest

class Second : AppCompatActivity() {
    private lateinit var btnCall : ImageButton
    private lateinit var btnBack : Button
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted)
            call()
        else
            Toast.makeText(this, "Error: permisos denegados", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initEvent()
    }

    private fun initEvent() {
        btnCall = findViewById(R.id.btn_call)
        btnBack = findViewById(R.id.btn_back)

        btnCall.setOnClickListener { view ->
            requestPermission()
        }

        btnBack.setOnClickListener { view ->
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (hasPermission())
                call()
            else
                requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
        } else
            call()
    }

    private fun call() {
        var intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:603779410")
        }
        startActivity(intent)
    }

    private fun hasPermission() : Boolean = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
}