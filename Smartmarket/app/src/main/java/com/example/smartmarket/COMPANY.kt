package com.example.smartmarket

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class COMPANY : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)
            val profile1 = findViewById<ImageView>(R.id.imageView14)
            profile1.setOnClickListener {
                val intent = Intent(this, PROFILE::class.java)
                startActivity(intent)

            }
            val business = findViewById<ImageView>(R.id.imageView15)
            business.setOnClickListener {
                val intent = Intent(this,BUSINESS::class.java)
                startActivity(intent)

            }
            val search = findViewById<ImageView>(R.id.imageView16)
            search.setOnClickListener {
                val intent = Intent(this,SEARCH::class.java)
                startActivity(intent)

            }
            val favourite = findViewById<ImageView>(R.id.imageView17)
            favourite.setOnClickListener {
                val intent = Intent(this,FAVOURITE::class.java)
                startActivity(intent)

            }
        val home = findViewById<ImageView>(R.id.imageView9)
        home.setOnClickListener {
            val intent = Intent(this, COMPANY::class.java)
            startActivity(intent)

        }

        }
    }