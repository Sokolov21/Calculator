package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         button_clear.setOnClickListener {
             input.text = ""
             output.text = ""
         }

        button_left.setOnClickListener {
            input.text = addToInputText( "(")
        }
        button_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }

        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }

        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }

        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }

        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }

        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }

        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }

        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }

        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }

        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }

        button_zap.setOnClickListener {
            input.text = addToInputText(".")
        }

        button_delenie.setOnClickListener {
            input.text = addToInputText("÷")
        }

        button_ymnoz.setOnClickListener {
            input.text = addToInputText("×")
        }

        button_minus.setOnClickListener {
            input.text = addToInputText("-")
        }

        button_plus.setOnClickListener {
            input.text = addToInputText("+")
        }


        button_ravno.setOnClickListener {
            showResult()
        }

    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return  expression
    }

    private  fun showResult() {
        try {
            val expression = getInputExpression()
            val  result = Expression(expression).calculate()
            if (result.isNaN()) {
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor( this, R.color.cardview_dark_background))
            } else {
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor( this, R.color.cardview_light_background))
            }
        } catch (e: Exception) {
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.cardview_shadow_end_color))

        }
    }
}