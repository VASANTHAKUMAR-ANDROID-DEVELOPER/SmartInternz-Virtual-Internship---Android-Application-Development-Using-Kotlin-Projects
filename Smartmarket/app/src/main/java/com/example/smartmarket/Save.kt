package com.example.smartmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.smartmarket.databinding.ActivitySaveBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Save : AppCompatActivity() {
    private lateinit var binding: ActivitySaveBinding

   private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivitySaveBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_save2)
       database = FirebaseDatabase.getInstance().getReference("Users")
        findViewById<Button>(R.id.button7).setOnClickListener {
            val intent= Intent(this,Register::class.java)
            startActivity(intent)
            finish()
         val name = findViewById<EditText>(R.id.editText4).text.toString()
      val phone = findViewById<EditText>(R.id.editText2).text.toString()
       val email = findViewById<EditText>(R.id.editText3).text.toString()
        val user = Userdata(email,name,phone)
         database.child(findViewById<EditText>(R.id.editText4).text.toString()).setValue(user).addOnSuccessListener {
             Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show()
          }.addOnFailureListener {
             Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()
           }
         }
       }
        }

