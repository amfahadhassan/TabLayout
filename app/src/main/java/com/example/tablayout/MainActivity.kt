package com.example.tablayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginLeft
import androidx.core.view.marginStart
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var versions = ArrayList<String>()
    var versionNames = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateData()
        initVersionListUI()

        btn_add.setOnClickListener{
            if (versions.contains(edt_version.text.toString()) || versionNames.contains(edt_name.text.toString()))
                return@setOnClickListener

            if (edt_version.text.toString() != "" && edt_name.text.toString() != "" ){
                updateVersionListUI(edt_version.text.toString(),edt_name.text.toString())
                Toast.makeText(this, "Successfully added!!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Please, fulfill the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateVersionListUI(version:String, versionName:String) {
        val tbrow = TableRow(this)
        val t1v = TextView(this)
        t1v.text = "" + version
        t1v.setTextColor(Color.WHITE)
        t1v.gravity = Gravity.LEFT
        tbrow.addView(t1v)
        val t2v = TextView(this)
        t2v.text = ""+versionName
        t2v.setTextColor(Color.WHITE)
        t2v.gravity = Gravity.LEFT
        tbrow.addView(t2v)

        table_main.addView(tbrow)
    }

    private fun populateData() {
        versions.add("Android 7.0")
        versions.add("Android 4.4")
        versions.add("Android 4.3")
        versionNames.add("Nougat")
        versionNames.add("KitKat")
        versionNames.add("Jelly Bean")
    }

    fun initVersionListUI() {
        val tbrow0 = TableRow(this)
        val tv0 = TextView(this)
        tv0.text = " Version "
        tv0.setTextColor(Color.WHITE)
        tbrow0.addView(tv0)
        val tv1 = TextView(this)
        tv1.text = " Name "
        tv1.setTextColor(Color.WHITE)
        tbrow0.addView(tv1)

        table_main.addView(tbrow0)
        for (i in 0..(versions.size-1)) {
            val tbrow = TableRow(this)
            val t1v = TextView(this)
            t1v.text = "" + versions.get(i)
            t1v.setTextColor(Color.WHITE)
            t1v.gravity = Gravity.LEFT
            tbrow.addView(t1v)
            val t2v = TextView(this)
            t2v.text = ""+versionNames.get(i)
            t2v.setTextColor(Color.WHITE)
            t2v.gravity = Gravity.LEFT
            tbrow.addView(t2v)
            table_main.addView(tbrow)
        }
    }
}