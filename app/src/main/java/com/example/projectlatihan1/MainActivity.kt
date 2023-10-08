package com.example.projectlatihan1

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClick: Button = findViewById(R.id.btn_click)
        val btnSecond: Button = findViewById(R.id.btn_second)

        btnClick.setOnClickListener(){
            //Explisit Intent
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", "ini adalah data text saya")

            startActivity(intent)
        }
        btnSecond.setOnClickListener{
            //Implicit Intent
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://trisnasejati.com"))
//            if (intent.resolveActivity(packageManager) != null){
//                startActivity(intent)
//            }else{
//                Toast.makeText(applicationContext, "Tidak ada aplikasi yang support", Toast.LENGTH_SHORT).show()
//            }

            val intent =Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
            }
            intent.putExtra(Intent.EXTRA_TEXT, "Hai, ini adalah kiriman")
            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext, "Tidak ada aplikasi yang support", Toast.LENGTH_SHORT).show()
            }
        }
    }
}