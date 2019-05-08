package com.example.kotlinlearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //通过引入kotlin-android-extensions 可以直接使用view的id

        mToolbar.subtitle = "Kotlin Learning";
        textHello.setText(R.string.app_name);

        textHello.setOnClickListener {

            val result = addNum(1, 2);

            toastView(result.toString());

            toastView("2", 0);

            intentOtherView();
        }
    }

    /***
     * 返回一个Int蕾西类型
     */
    private fun addNum(number1: Int, number2: Int): Int {

        return number1 + number2;
    }

    /***
     * 显示Toast,showTime这个地方的默认值为 LENGTH_LONG,调用此方法时候如果不传递 就取默认值
     */
    private fun toastView(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show();
    }

    private fun intentOtherView() {

        val intent = Intent();

        intent.setClass(this, Main2Activity().javaClass)

        startActivity(intent)
    }

}
