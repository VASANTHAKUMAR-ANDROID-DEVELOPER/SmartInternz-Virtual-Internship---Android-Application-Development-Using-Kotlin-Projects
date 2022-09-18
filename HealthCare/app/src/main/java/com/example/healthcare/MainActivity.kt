package com.example.healthcare

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val h = findViewById<EditText>(R.id.editTextNumber)
        val w = findViewById<EditText>(R.id.editTextNumber2)
        val test = findViewById<Button>(R.id.button)
        val cle=findViewById<Button>(R.id.clear)
        cle.setOnClickListener{
            h.setText(" ")
            w.setText(" ")
        }
        h.setOnClickListener{
            h.append("  ")
        }
        w.setOnClickListener{
            w.append("  ")
        }

        test.setOnClickListener {
           if(h.equals("  ") || w.equals("  ")){
               Toast.makeText(this, "Enter Height or Weight!!", Toast.LENGTH_SHORT).show()
           }
           else{

               val a:Float=h.text.toString().toFloat()
               val b:Float=w.text.toString().toFloat()
               val c:Float=(b/(a*a))*10000
               if(c<18.5) {
                   Toast.makeText(this, "Under Weight::$c", Toast.LENGTH_SHORT).show()
               }
               else if(18.5<c && c<24.9){ Toast.makeText(this, "Healthy Weight::$c", Toast.LENGTH_SHORT).show()
               }

               else if(25.0<c && c<39.9){
                   Toast.makeText(this, "Over Weight::$c", Toast.LENGTH_SHORT).show()
               }
               else{
                   Toast.makeText(this, "Obese::$c", Toast.LENGTH_SHORT).show()
               }
           }
        }
    }
}


