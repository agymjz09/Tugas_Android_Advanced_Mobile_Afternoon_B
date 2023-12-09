package com.example.tugasandroidadvancefinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnshowhide: Button
    private lateinit var etpassword: EditText
    private lateinit var btnlogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnshowhide = findViewById(R.id.btnshowhide)
        etpassword = findViewById(R.id.etpasswordlogin)
        btnlogin = findViewById(R.id.btnlogin)
        btnlogin.setOnClickListener(this)

        btnshowhide.setOnClickListener {
            if (btnshowhide.text.toString().equals("S")) {
                etpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                btnshowhide.text = "H"
            } else {
                etpassword.transformationMethod = PasswordTransformationMethod.getInstance()
                btnshowhide.text = "S"
            }
        }
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnlogin -> {
                val intent = Intent(this@LoginActivity, MainActivity1::class.java)
                startActivity(intent)
            }
        }
    }
}