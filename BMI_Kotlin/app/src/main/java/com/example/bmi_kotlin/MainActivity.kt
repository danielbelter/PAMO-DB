package com.example.bmi_kotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var gender: Int = 0

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    homeLayout.visibility = View.VISIBLE
                    bmi_calculaltor_layout.visibility = View.INVISIBLE
                    recomendation_layout.visibility = View.INVISIBLE
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    homeLayout.visibility = View.INVISIBLE
                    bmi_calculaltor_layout.visibility = View.VISIBLE
                    recomendation_layout.visibility = View.INVISIBLE
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    homeLayout.visibility = View.INVISIBLE
                    bmi_calculaltor_layout.visibility = View.INVISIBLE
                    recomendation_layout.visibility = View.VISIBLE
                    scrollview.visibility = View.INVISIBLE
                    radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->

                        val radioButton = radioGroup.findViewById<View>(i)
                        val index = radioGroup.indexOfChild(radioButton)
                        when (index) {
                            0 -> {
                                gender = 0
                                recipe4.visibility = View.INVISIBLE
                                imageView4.visibility = View.INVISIBLE
                            }
                            1 -> {
                                gender = 1
                                recipe4.visibility = View.VISIBLE
                                imageView4.visibility = View.VISIBLE

                            }
                        }
                    })
                    recom_calc_button.setOnClickListener(View.OnClickListener {
                        var weightVal = weightText4.getText().toString().toDouble()
                        var heightVal = heightText4.getText().toString().toDouble()
                        val ageVal = heightText5.getText().toString().toDouble()
                        val resultVal: Double = calculate(weightVal, heightVal, ageVal)
                        recom_result.setText(resultVal.toString() + "Kcal")
                        scrollview.visibility = View.VISIBLE
                    })
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        homeLayout.visibility = View.VISIBLE
        bmi_calculaltor_layout.visibility = View.INVISIBLE
        recomendation_layout.visibility = View.INVISIBLE
        caluculateButton.setOnClickListener(View.OnClickListener {
            var h = heightText.getText().toString().toDouble()
            h = h / 100
            var w = weightText.getText().toString().toDouble()
            val b = w / (h * h)
            bmiText.setText((Math.round(b * 100.0) / 100.0).toString())
            if (b >= 25.0) {
                scaleText.setText("Nadwaga")
            } else if (b > 18.5) {
                scaleText.setText("W normie")
            } else {
                scaleText.setText("Niedowaga")
            }
        })
        bt_activity_changer.setOnClickListener(View.OnClickListener {
            lanuchActvity()
        })

        bt_quiz.setOnClickListener(View.OnClickListener {
            startQuiz()
        })

    }

    private fun calculate(weight: Double, height: Double, age: Double): Double {
        var value: Double = 0.00;
        if (gender == 0) {
            value = (10 * weight + height * 6.25 - 5 * age - 161)
        } else if (gender == 1) {
            value = ((10 * weight) + (height * 6.25) - (5 * age) + 5)
        }
        return value
    }

    private fun lanuchActvity() {
        val intent = Intent(this, ChartActivity::class.java)
        intent.putExtra("q1", styczen_text_id.getText().toString())
        intent.putExtra("q2", luty_text_id.getText().toString())
        intent.putExtra("q3", marzec_text_id.getText().toString())
        intent.putExtra("q4", kwiecien_text_id.getText().toString())
        startActivity(intent)
    }

    private fun startQuiz() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)

    }
}
