package com.rk.kotlinsamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        recyclerview.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = RecyclerViewAdapter(applicationContext, Utilities.users)
        }
    }
}
