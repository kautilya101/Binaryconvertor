package com.example.binaryconvertor

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() ,AdapterView.OnItemSelectedListener {


    lateinit var num:String
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinner: Spinner = findViewById(R.id.options)
        ArrayAdapter.createFromResource(this,
                R.array.convertor,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
        }

        btn.setOnClickListener {
            if (etname.text.toString().isNotEmpty()) {
                num = etname.text.toString()


            }
            when(spinner.selectedItemPosition){
                0->{
                    if (etname.text.toString().isNotEmpty()) {
                        Log.i("values","$num")
                        if (num.isDigitsOnly() and isBinary(num)) {

                            etname2.text = Integer.parseInt(num, 2).toString()

                        }
                    }

                }

                1->{
                    if (etname.text.toString().isNotEmpty()) {
                        if (num.isDigitsOnly() and isBinary(num)) {

                            etname2.text = Integer.toOctalString(Integer.parseInt(num, 2)).toString()
                        }
                    }
                }

                2->{
                    if (etname.text.toString().isNotEmpty()) {

                        if (num.isDigitsOnly() and isBinary(num)) {

                            etname2.text = Integer.toHexString(Integer.parseInt(num, 2)).toString().capitalize()
                        }
                    }
                }


                3->{
                    if (etname.text.toString().isNotEmpty()) {

                        if (num.isDigitsOnly()) {

                            etname2.text = Integer.toBinaryString(num.toInt()).toString()

                        }
                    }

                }

                4->{
                    if (etname.text.toString().isNotEmpty()) {
                        if (num.isDigitsOnly()) {

                            etname2.text = Integer.toOctalString(num.toInt()).toString()
                        }
                    }
                }

                5->{
                    if (etname.text.toString().isNotEmpty()) {

                        if (num.isDigitsOnly()) {

                            etname2.text = Integer.toHexString(num.toInt()).toString().capitalize()
                        }
                    }
                }

                6->{
                    if (etname.text.toString().isNotEmpty()) {

                        if (num.isDigitsOnly()) {

                            etname2.text = Integer.toBinaryString(Integer.parseInt(num, 8)).toString()

                        }
                    }

                }

                7->{
                    if (etname.text.toString().isNotEmpty()) {
                        if (num.isDigitsOnly()) {

                            etname2.text = Integer.parseInt(num, 8).toString()
                        }
                    }
                }

                8->{
                    if (etname.text.toString().isNotEmpty()) {

                        if (num.isDigitsOnly()) {

                            etname2.text = Integer.toHexString(Integer.parseInt(num, 8)).toString().capitalize(Locale.getDefault())
                        }
                    }
                }

                9->{
                    if (etname.text.toString().isNotEmpty()) {

                        if (num.isDigitsOnly() || isLetters(num)) {

                            etname2.text = Integer.toBinaryString(Integer.parseInt(num, 16)).toString()

                        }
                    }

                }

                10->{
                    if (etname.text.toString().isNotEmpty()) {
                        if (num.isDigitsOnly() || isLetters(num)) {

                            etname2.text = Integer.parseInt(num, 16).toString()
                        }
                    }
                }

                11->{
                    if (etname.text.toString().isNotEmpty()) {

                        if (num.isDigitsOnly() || isLetters(num)) {

                            etname2.text = Integer.toOctalString(Integer.parseInt(num, 16)).toString()
                        }
                    }
                }


            }


        }
    }
        private fun isLetters(string: String): Boolean {
            return string.all { it.isLetter() }
        }



        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {


            num = ""
            val tview: TextView = findViewById(R.id.heading)
            tview.text = parent!!.getItemAtPosition(position).toString()
            var stn = tview.text.split("to")

            etname.hint = stn[0]

            etname2.text = stn[1]

        }


        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("Not yet implemented")
        }


    private fun isBinary(num:String):Boolean{
        var flag = 0
        for (i in num){
            if (i == '0' || i == '1'){
                flag = 0
            }
            else{
                flag = 1
            }
        }
        return flag == 0
    }

    
}


