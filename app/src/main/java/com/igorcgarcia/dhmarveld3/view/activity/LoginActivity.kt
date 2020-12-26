package com.igorcgarcia.dhmarveld3.view.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.igorcgarcia.dhmarveld3.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("dhmarvekd3-ic", MODE_PRIVATE)
        initComponents()
        setupObservables()
    }

    private fun initComponents(){
        val remember = sharedPreferences.getBoolean("remember",false)
//        Log.i("LoginActivity", remember.toString())
        if (remember) {
            binding.edloginEmail.setText(sharedPreferences.getString("email", ""))
            binding.edPwd.setText(sharedPreferences.getString("pwd", ""))
            binding.cbRemenber.isChecked = remember
        }
    }

    private fun setupObservables(){
        binding.btLogin.setOnClickListener{
            var valid = true
            val email = binding.edloginEmail.text.toString()
            val pwd = binding.edPwd.text.toString()

            if (email == "") {
                valid = false
                binding.edloginEmail.error = "E-mail inválido!"
            }

            if (pwd == ""){
                valid = false
                binding.edPwd.error = "Password inválido!"
            }

            if (valid) {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }

        binding.btCreateAccount.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.cbRemenber.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                sharedPreferences.edit {
                    putString("email",binding.edloginEmail.text.toString())
                    putString("pwd",binding.edPwd.text.toString())
                    putBoolean("remember",true)
                }
            } else {
                sharedPreferences.edit {
                    putBoolean("remember",false)
                }
                binding.edloginEmail.setText("")
                binding.edPwd.setText("")
            }
        }
    }
}