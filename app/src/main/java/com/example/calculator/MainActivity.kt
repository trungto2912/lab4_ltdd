package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun butNumberEvent(view: View) {
        val ShowNumber: TextView = findViewById(R.id.etShowNumber)
        if (isNewOp){
            ShowNumber.setText("")
        }
        isNewOp = false
        val butSelect = view as Button
        var butClickValue:String = ShowNumber.text.toString()
        when(butSelect.id){
            R.id.but0 -> {
                butClickValue += "0"
            }
            R.id.but1 -> {
                butClickValue += "1"
            }
            R.id.but2 -> {
                butClickValue += "2"
            }
            R.id.but3 -> {
                butClickValue += "3"
            }
            R.id.but4 -> {
                butClickValue += "4"
            }
            R.id.but5 -> {
                butClickValue += "5"
            }
            R.id.but6 -> {
                butClickValue += "6"
            }
            R.id.but7 -> {
                butClickValue += "7"
            }
            R.id.but8 -> {
                butClickValue += "8"
            }
            R.id.but9 -> {
                butClickValue += "9"
            }
            R.id.butDot -> {
                butClickValue += "."
            }
            R.id.butPlusMins -> {
                butClickValue = "-"+ butClickValue
            }
        }
        ShowNumber.setText(butClickValue)


    }

    var Op = "*"
    var oldNumber = ""
    var isNewOp = true
    fun butOpEvent(view: View) {
        val ShowNumber: TextView = findViewById(R.id.etShowNumber)
        val butSelect = view as Button
        when(butSelect.id){
            R.id.butDiv -> {
                Op = "/"
            }
            R.id.butMul -> {
                Op = "*"
            }
            R.id.butSub -> {
                Op = "-"
            }
            R.id.butSum -> {
                Op = "+"
            }
        }
        oldNumber = ShowNumber.text.toString()
        isNewOp = true
    }

    fun butEqualEvent(view: View) {
        val ShowNumber: TextView = findViewById(R.id.etShowNumber)
        val newNumber = ShowNumber.text.toString()
        var finalNumber:Double? = null
        when(Op){
            "/" ->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*" ->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-" ->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" ->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        ShowNumber.setText(finalNumber.toString())
        isNewOp= true
    }
    fun butPercent(view: View) {
        val ShowNumber: TextView = findViewById(R.id.etShowNumber)
        val number:Double = ShowNumber.text.toString().toDouble()/100
        ShowNumber.setText(number.toString())
        isNewOp = true

    }
    fun butClear(view: View) {
        val ShowNumber: TextView = findViewById(R.id.etShowNumber)
        ShowNumber.setText("0")
        isNewOp = true
    }

}
