package com.example.customtoast

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.show_toast).setOnClickListener {
            CustomToast.create(this, "This is an important heading", "Some irrelevant detail", Gravity.BOTTOM or Gravity.CENTER)
        }
    }


}
