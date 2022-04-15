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

        val dialogButton = findViewById<FloatingActionButton>(R.id.floatingDialogButton)
        dialogButton.setOnClickListener {
            Snackbar.make(it, "TODO", Snackbar.LENGTH_SHORT).show()
        }

        val achievements = findViewById<TextView>(R.id.achievements)
        achievements.setOnClickListener {
            if (achievements.maxLines == 2) {
                achievements.maxLines = 100
                achievements.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            } else {
                achievements.maxLines = 2
                achievements.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_keyboard_arrow_right_24,
                    0
                )
            }
        }

        val phoneNumber = findViewById<TextView>(R.id.phone_number)
        phoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + phoneNumber.text.toString())
            startActivity(intent)
        }

        val email = findViewById<TextView>(R.id.email)
        email.setOnClickListener {
            Snackbar.make(it, "TODO", Snackbar.LENGTH_SHORT).show()
        }

    }


}