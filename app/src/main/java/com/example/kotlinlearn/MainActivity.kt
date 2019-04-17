package com.example.kotlinlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //通过引入kotlin-android-extensions 可以直接使用view的id
        textHello.setText(R.string.app_name);

        textHello.setOnClickListener{
           Toast.makeText(this,"Click",Toast.LENGTH_LONG).show();
        }
    }
}
