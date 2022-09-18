package com.example.smartmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smartmarket.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login: AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()
        binding.textView3.setOnClickListener{
            val intent= Intent(this,Register::class.java)
            startActivity(intent)
        }
        binding.Register.setOnClickListener{
            val email=binding.email.text.toString()
            val pass=binding.pass.text.toString()
            if(email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent=Intent(this,COMPANY::class.java)
                        startActivity(intent)
                        intent.putExtra("email",email)
                        intent.putExtra("pass",pass)
                        finish()
                        Toast.makeText(this,"Succesfully login",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            }else{
                Toast.makeText(this,"Empty feilds not Allowed", Toast.LENGTH_SHORT).show()

            }
        }
    }
}
