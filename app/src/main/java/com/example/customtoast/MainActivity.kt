package com.example.customtoast

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoast.Utils.Companion.dpToPx

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.show_toast).setOnClickListener {
            val toast = Toast.makeText(this, "", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.BOTTOM or Gravity.LEFT, dpToPx(16), dpToPx(16))
            toast.setText("This is a toast")
            toast.show()
        }
    }


}
