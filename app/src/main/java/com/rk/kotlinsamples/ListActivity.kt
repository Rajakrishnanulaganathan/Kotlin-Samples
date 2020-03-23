package com.rk.kotlinsamples

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showToast(this, Utilities.users.get(position))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, Utilities.users
        )
        list_view.adapter = arrayAdapter
        list_view.onItemClickListener = this
    }


}
