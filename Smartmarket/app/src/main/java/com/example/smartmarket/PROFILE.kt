package com.example.smartmarket

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.smartmarket.databinding.ActivityProfileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PROFILE : AppCompatActivity() {
    private var backPressedTime=0L
    private lateinit var username:TextView
    private lateinit var password:TextView
    private lateinit var binding: ActivityProfileBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProfileBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_profile)
        username=findViewById<EditText>(R.id.name)
        password=findViewById<EditText>(R.id.password)
        val pass=intent.getStringExtra("pass")
        val logout=findViewById<Button>(R.id.button6)
        val profile1 = findViewById<ImageView>(R.id.imageView14)
        profile1.setOnClickListener {
            val intent = Intent(this, PROFILE::class.java)
            startActivity(intent)
        }
            val home = findViewById<ImageView>(R.id.imageView9)
            home.setOnClickListener {
                val intent = Intent(this,PROFILE::class.java)
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
        database= FirebaseDatabase.getInstance().getReference("Users")

            database.child(pass.toString()).get().addOnSuccessListener {
                if(it.exists()){
                    val emaila=it.child("email").value
                    val passs=it.child("password").value
                    username.text=emaila.toString()
                    password.text=passs.toString()
                }else{
                    Toast.makeText(this,"User Dosn't text",Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener{
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
         logout.setOnClickListener{
             val intent= Intent(this,MainActivity::class.java)
             startActivity(intent)
             finish()
         }

    }
   override fun onBackPressed() {
       if(backPressedTime+2000>System.currentTimeMillis()){
        super.onBackPressed()
    }else{
        Toast.makeText(applicationContext,"Press Back again to exit", Toast.LENGTH_SHORT).show()
       }
       backPressedTime=System.currentTimeMillis()
}
}
