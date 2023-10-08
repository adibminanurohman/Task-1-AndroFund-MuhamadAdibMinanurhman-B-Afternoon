package com.example.projectlatihan1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectlatihan1.fragment.FirstFragment

class SecondActivity : AppCompatActivity() {
    private val dataString: String = "Hello ini adalah data  string"

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val transaction = supportFragmentManager.beginTransaction()
        val firstFragment = FirstFragment.sendData(dataString)

        transaction.replace(R.id.fragment_container, firstFragment)
        transaction.commit()
    }
}