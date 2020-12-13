package com.example.hopeitworks.Fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hopeitworks.R

class calculatorFragment : Fragment(R.layout.fragment_calculator) {
    class MainActivity : AppCompatActivity() {

        private lateinit var resultTextView: TextView

        private var operand: Double = 0.0
        private var operation: String = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            resultTextView = findViewById(R.id.resultTextView)


        }

        fun numberClick(view: View) {

            if (view is TextView) {

                val number: String = view.text.toString()
                var result: String = resultTextView.text.toString()

                if (result == "0") {
                    result = ""
                }

                resultTextView.text = result + number

            }

        }

        fun operationClick(view: View) {

            if (view is TextView) {

                if (!TextUtils.isEmpty(resultTextView.text)) {
                    operand = resultTextView.text.toString().toDouble()
                }

                this.operation = view.text.toString()

                resultTextView.text = ""

            }

        }

        fun equalsClick(view: View) {

            val secOperandText: String = resultTextView.text.toString()
            var secOperand: Double = 0.0

            if (!TextUtils.isEmpty(secOperandText)) {
                secOperand = secOperandText.toDouble()
            }

            when (operation) {
                "+" -> resultTextView.text = (operand + secOperand).toString()
                "-" -> resultTextView.text = (operand - secOperand).toString()
                "*" -> resultTextView.text = (operand * secOperand).toString()
                "/" -> resultTextView.text = (operand / secOperand).toString()
            }

        }
        fun dota(view: View){

            resultTextView.text = resultTextView.text.toString() + "."

        }
        fun deletelastdota(view: View){
            resultTextView.text = resultTextView.text.toString().dropLast(1)

        }
        fun cleardota(view: View){
            resultTextView.text = ""
        }
    }







}
