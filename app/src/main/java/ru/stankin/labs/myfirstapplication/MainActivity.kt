package ru.stankin.labs.laba2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Инициализация переменных, достаём из активити хмл
        val sqrt: TextView = findViewById(R.id.b_sqrt)
        val log2: TextView = findViewById(R.id.b_log2)
        val ln: TextView = findViewById(R.id.b_ln)
        val leftB: TextView = findViewById(R.id.b_leftb)
        val rightB: TextView = findViewById(R.id.b_rightb)
        val xy: TextView = findViewById(R.id.b_xy)
        val ac: TextView = findViewById(R.id.b_AC)
        val back: TextView = findViewById(R.id.b_back)
        val mod: TextView = findViewById(R.id.b_mod)
        val devide: TextView = findViewById(R.id.b_devide)
        val sin: TextView = findViewById(R.id.b_sin)
        val seven: TextView = findViewById(R.id.b_7)
        val eight: TextView = findViewById(R.id.b_8)
        val nine: TextView = findViewById(R.id.b_9)
        val multiply: TextView = findViewById(R.id.b_multiply)
        val cos: TextView = findViewById(R.id.b_cos)
        val four: TextView = findViewById(R.id.b_4)
        val five: TextView = findViewById(R.id.b_5)
        val six: TextView = findViewById(R.id.b_6)
        val minus: TextView = findViewById(R.id.b_minus)
        val pi: TextView = findViewById(R.id.b_pi)
        val one: TextView = findViewById(R.id.b_1)
        val two: TextView = findViewById(R.id.b_2)
        val three: TextView = findViewById(R.id.b_3)
        val plus: TextView = findViewById(R.id.b_plus)
        val e: TextView = findViewById(R.id.b_e)
        val zeroZeroZero: TextView = findViewById(R.id.b_000)
        val dot: TextView = findViewById(R.id.b_dot)
        val zero: TextView = findViewById(R.id.b_0)
        val equal: TextView = findViewById(R.id.b_equal)
        val operation: TextView = findViewById(R.id.operation)
        val result: TextView = findViewById(R.id.result)

        //Обработчики, сначала обычные, потом особые
        sqrt.setOnClickListener{ operation.append("sqrt(") }
        log2.setOnClickListener{ operation.append("log2(") }
        ln.setOnClickListener{ operation.append("ln(") }
        leftB.setOnClickListener{ operation.append("(") }
        rightB.setOnClickListener{ operation.append(")") }
        xy.setOnClickListener{ operation.append("x^y") }
        mod.setOnClickListener{ operation.append("%") }
        devide.setOnClickListener{ operation.append("/") }
        sin.setOnClickListener{ operation.append("sin(") }
        seven.setOnClickListener{ operation.append("7") }
        eight.setOnClickListener{ operation.append("8") }
        nine.setOnClickListener{ operation.append("9") }
        multiply.setOnClickListener{ operation.append("*") }
        cos.setOnClickListener{ operation.append("cos(") }
        four.setOnClickListener{ operation.append("4") }
        five.setOnClickListener{ operation.append("5") }
        six.setOnClickListener{ operation.append("6") }
        minus.setOnClickListener{ operation.append("-") }
        pi.setOnClickListener{ operation.append("pi") }
        one.setOnClickListener{ operation.append("1") }
        two.setOnClickListener{ operation.append("2") }
        three.setOnClickListener{ operation.append("3") }
        plus.setOnClickListener{ operation.append("+") }
        e.setOnClickListener{ operation.append("e") }
        zeroZeroZero.setOnClickListener{ operation.append("000") }
        dot.setOnClickListener{ operation.append(".") }
        zero.setOnClickListener{ operation.append("0") }

        //Удаление символа
        back.setOnClickListener {
            val s = operation.text.toString()
            if (s != "") {
                operation.text = s.substring(0, s.length - 1)
            }
        }

        //Очистка
        ac.setOnClickListener {
            operation.text = ""
            result.text = ""
        }

        //вывод результата
        result.setOnClickListener {
            val resText = result.text.toString()
            if (resText != "Error" && resText != ""){
                operation.text = resText
                result.text = ""
            }
        }

        equal.setOnClickListener{
            val optext = operation.text.toString()
            if (optext != "") {
                try {
                    val expr = ExpressionBuilder(operation.text.toString()).build()
                    val res = expr.evaluate()
                    val longres = res.toLong()
                    if (longres.toDouble() == res) {
                        result.text = longres.toString()
                    } else {
                        result.text = res.toString()
                    }
                } catch (e: Exception) {
                    result.text = "Error"
                }
            }
        }

    }
}