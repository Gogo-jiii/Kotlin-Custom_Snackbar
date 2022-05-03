package com.example.customsnackbar

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_layout.*

class MainActivity : AppCompatActivity() {

    var customView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customView = layoutInflater.inflate(
            R.layout.custom_layout,
            findViewById<View>(R.id.rootLayout) as ViewGroup
        )

        btnShowCustomSnackBar.setOnClickListener { view ->
            val snackbar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE)
            snackbar.view.setBackgroundColor(Color.TRANSPARENT)
            val snackbarLayout = snackbar.view as SnackbarLayout

            button.setOnClickListener {
                Toast.makeText(this@MainActivity, "Dismiss.", Toast.LENGTH_SHORT).show()
                snackbar.dismiss()
            }
            snackbarLayout.addView(customView, 0)
            snackbar.show()
        }
    }
}