package com.pe5ha.homework

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val profileFragment = ProfileFragment.newInstance(1) // какой из моков показать на вью
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_main, profileFragment, null)
                .commit()
        }
    }
}