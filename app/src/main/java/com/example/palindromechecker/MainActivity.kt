package com.example.palindromechecker

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.example.palindromechecker.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            button.setOnClickListener {
                val word = wordInput.text.toString()
                val isPalindrome = word.reversed() == word

                val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                if (isPalindrome) {
                    builder.setTitle("Result").setMessage("$word is a palindrome!").setPositiveButton("Cancel") { dialog, _ -> dialog.dismiss() }
                } else {
                    builder.setTitle("Result").setMessage("$word is not a palindrome!").setPositiveButton("Cancel") { dialog, _ -> dialog.dismiss() }
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
    }
}