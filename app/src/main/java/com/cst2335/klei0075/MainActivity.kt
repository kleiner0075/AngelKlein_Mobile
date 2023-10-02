package com.cst2335.klei0075

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity1 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val toastMessage = getString(R.string.hello_message)
            Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_LONG).show()
        }

        val switchButton = findViewById<Switch>(R.id.SwitchButton)
        switchButton.setOnCheckedChangeListener { buttonView, isChecked ->
            val switchState = if (isChecked) "on" else "off"
            val message = "The switch is now $switchState"

            val snackbar = Snackbar.make(findViewById(R.id.linear), message, Snackbar.LENGTH_LONG)
            snackbar.setAction("Undo") {
                switchButton.isChecked = !isChecked
            }
            snackbar.show()
        }
    }
}
