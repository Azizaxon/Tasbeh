package uz.aziza.tasbex_keshxotira

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("tasbex_count", Context.MODE_PRIVATE)

        count = sharedPreferences.getInt("keyCount", 0)
        tv_display.text = count.toString()

        val editor = sharedPreferences.edit()
        btn_add.setOnClickListener {
            count++
            editor.putInt("keyCount", count)
            editor.apply()
            tv_display.text = count.toString()

        }

        btn_reset.setOnClickListener {
            count = 0
            editor.putInt("keyCount", count)
            editor.apply()
            tv_display.text = count.toString()

        }
    }
}