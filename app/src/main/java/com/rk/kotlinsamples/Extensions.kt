package com.rk.kotlinsamples

import android.content.Context
import android.widget.Toast

fun Context.showToast(context: Context,msg:String,duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(context,msg,duration).show()
}
fun showToast(context: Context,msg:String,duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(context,msg,duration).show()
}
