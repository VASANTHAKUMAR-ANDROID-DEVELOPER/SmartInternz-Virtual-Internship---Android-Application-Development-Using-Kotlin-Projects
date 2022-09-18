package com.example.lunchtray

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val s=findViewById<Button>(R.id.button)
        s.setOnClickListener{
           val intent=Intent(this,order::class.java)
            startActivity(intent)
        }
    }
}