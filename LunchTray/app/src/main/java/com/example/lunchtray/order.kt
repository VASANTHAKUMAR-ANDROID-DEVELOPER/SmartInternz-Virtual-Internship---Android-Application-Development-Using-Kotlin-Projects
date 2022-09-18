package com.example.lunchtray

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        var f=0
        val h=findViewById<Button>(R.id.button3)
        val s=findViewById<Button>(R.id.button2)
        val t=findViewById<TextView>(R.id.textView)
        val a=findViewById<RadioButton>(R.id.radioButton2)
        a.setOnClickListener{
            f+=4
            t.setText("Total=$f$")



        }
        val b=findViewById<RadioButton>(R.id.radioButton3)
        b.setOnClickListener{
            f+=6
            t.setText("Total=$f$")

        }
        val c=findViewById<RadioButton>(R.id.radioButton)
        c.setOnClickListener{
            f+=5
            t.setText("Total=$f$")
        }
        val d=findViewById<RadioButton>(R.id.radioButton4)
        d.setOnClickListener{
            f+=3
            t.setText("Total=$f$")
        }

            s.setOnClickListener{
                if(f>0){
                val intent= Intent(this,Succesful::class.java)
                startActivity(intent)
            }
        }
        h.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}