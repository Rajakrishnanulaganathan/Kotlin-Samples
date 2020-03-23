package com.rk.kotlinsamples

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin_views.*


class KotlinViewsActivity : AppCompatActivity(), View.OnClickListener,
    SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener,
    AdapterView.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_views)
        kotlin_apply.setOnClickListener(this)
        kotlin_get_selected_item.setOnClickListener(this)
        kotlin_click_toast.setOnClickListener(this)
        checked_text.setOnClickListener(this)
        kotlin_recycler_view.setOnClickListener(this)
        kotlin_list_view.setOnClickListener(this)
        get_rating.setOnClickListener(this)
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, Utilities.users
        )
        setAdapter(arrayAdapter)
        seekbar.setOnSeekBarChangeListener(this)
        switch_item.setOnCheckedChangeListener(this)
        addspinnerAdapter()
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                showToast(applicationContext, Utilities.users[position])

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun addspinnerAdapter() {
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, Utilities.users
        )
        spinner.adapter = arrayAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.kotlin_apply -> kotlin_apply_text.text = kotlin_edittext.text.toString()
            R.id.kotlin_click_toast -> showToast(applicationContext, "Toast Clicked")
            R.id.kotlin_get_selected_item -> showToast(
                applicationContext,
                autocomplete_textview.text.toString()
            )
            R.id.checked_text -> {
                checked_text.isChecked = !checked_text.isChecked
                checked_text.setCheckMarkDrawable(
                    if (checked_text.isChecked)
                        android.R.drawable.checkbox_on_background
                    else
                        android.R.drawable.checkbox_off_background
                )
                showToast(
                    applicationContext,
                    getString(if (checked_text.isChecked) R.string.checked else R.string.unchecked)
                )

            }
            R.id.get_rating -> showToast(applicationContext, ratingbar.rating.toString())

            R.id.kotlin_list_view -> startActivity(Intent(this, ListActivity::class.java))
            R.id.kotlin_recycler_view -> startActivity(
                Intent(
                    this,
                    RecyclerviewActivity::class.java
                )
            )
        }
    }

    fun setAdapter(arrayAdapter: ArrayAdapter<String>): Unit {
        autocomplete_textview.setAdapter(arrayAdapter)
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        showToast(applicationContext, "stopped")

    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        showToast(applicationContext, "started")

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        showToast(applicationContext, "Progress is: " + seekBar?.progress + "%")
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        showToast(
            applicationContext,
            getString(if (isChecked) R.string.checked else R.string.unchecked)
        )
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showToast(applicationContext, Utilities.users[position])
    }
}
