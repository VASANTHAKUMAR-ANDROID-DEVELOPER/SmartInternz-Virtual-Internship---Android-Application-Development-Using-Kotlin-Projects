package com.example.dogglersapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vertical=findViewById<Button>(R.id.button7)
        vertical.setOnClickListener{
            val intent=Intent(this,Vertical::class.java)
            startActivity(intent)
        }
        val horizontal=findViewById<Button>(R.id.button8)
        horizontal.setOnClickListener{
            val intent=Intent(this,Horizontal::class.java)
            startActivity(intent)
        }
        val grid=findViewById<Button>(R.id.button9)
        grid.setOnClickListener{
            val intent=Intent(this,Grid::class.java)
            startActivity(intent)
        }
    }
}