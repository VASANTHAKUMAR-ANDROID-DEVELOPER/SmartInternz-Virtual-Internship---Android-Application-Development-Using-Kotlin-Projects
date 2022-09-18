package com.example.smartmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smartmarket.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("Users")
        binding.textView.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }
        binding.Register.setOnClickListener {

            val gmail = binding.email.text.toString()
            val pass = binding.pass.text.toString()
            val confipass = binding.cpass.text.toString()
            if (gmail.isNotEmpty() && pass.isNotEmpty() && confipass.isNotEmpty()) {
                if (pass == confipass) {
                    firebaseAuth.createUserWithEmailAndPassword(gmail, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
//                            val intent = Intent(this, PROFILE::class.java)
//                            startActivity(intent)
//                            var email=it.child("email").value
                            val user = User(gmail,pass)
//                            val key = database.push().key!!
                            database.child(pass).setValue(user).addOnSuccessListener {
                                val i=Intent(this,COMPANY::class.java)
                                i.putExtra("email",gmail)
                                i.putExtra("pass",pass)
                                startActivity(i)
                                finish()
                                Toast.makeText(this, "Register Successfull!!!", Toast.LENGTH_SHORT)
                                    .show()
                            }.addOnFailureListener {

                            }
                        }
                            else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
               } else {
                    Toast.makeText(this, "Confirm password not match!!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty feilds not Allowed", Toast.LENGTH_SHORT).show()
         }
        }
    }
}



//     private lateinit var database: DatabaseReference
//database = FirebaseDatabase.getInstance().getReference("Users")
//val user = userdata(email, pass)
//
//database.child(email).setValue(user).addOnSuccessListener {
//    binding.email.text.clear()
//    binding.pass.text.clear()
//    binding.cpass.text.clear()
//    Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show()
//}.addOnFailureListener {
//    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
//}