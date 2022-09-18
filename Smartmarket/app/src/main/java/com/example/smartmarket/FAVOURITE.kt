package com.example.smartmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class FAVOURITE : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        val home = findViewById<ImageView>(R.id.imageView9)
        home.setOnClickListener {
            val intent = Intent(this, PROFILE::class.java)
            startActivity(intent)

        }
        val profile1 = findViewById<ImageView>(R.id.imageView20)
        profile1.setOnClickListener {
            val intent = Intent(this, PROFILE::class.java)
            startActivity(intent)

        }
        val business = findViewById<ImageView>(R.id.imageView19)
        business.setOnClickListener {
            val intent = Intent(this,BUSINESS::class.java)
            startActivity(intent)

        }
        val search = findViewById<ImageView>(R.id.imageView10)
        search.setOnClickListener {
            val intent = Intent(this,SEARCH::class.java)
            startActivity(intent)

        }
        val favourite = findViewById<ImageView>(R.id.imageView8)
        favourite.setOnClickListener {
            val intent = Intent(this,FAVOURITE::class.java)
            startActivity(intent)

        }
    }
}