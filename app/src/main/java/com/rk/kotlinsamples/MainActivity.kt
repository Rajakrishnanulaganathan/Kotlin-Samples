package com.rk.kotlinsamples

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        val item_id = v?.id

        when (item_id) {

            R.id.btn_kotlin_views ->
                startActivity(Intent(this, KotlinViewsActivity::class.java))

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_kotlin_views.setOnClickListener(this)

    }
}
