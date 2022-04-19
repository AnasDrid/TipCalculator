package com.lonelywiz.tipcalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import com.lonelywiz.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val buttonCalculate =binding.Calculate
        val costOfService = binding.costofservice
        val roundtip=binding.roundtip
        val radioGroup =binding.radioGroup
        val result = binding.Result
        buttonCalculate.setOnClickListener {
            if(TextUtils.isEmpty(costOfService.text)){
                Toast.makeText(this, "No Cost entered",Toast.LENGTH_SHORT).show()
                print(true)
                Log.e("error","no cost")

            }
            else{
                if(radioGroup.checkedRadioButtonId==-1){
                    Toast.makeText(this, "Choose An Option",Toast.LENGTH_SHORT).show()
                }
                else {
                    var pourcentage:Double=0.1
                    val radiobuttonid = radioGroup.checkedRadioButtonId
                    val radioButton: RadioButton = findViewById(radiobuttonid)
                    when(radioButton.text.toString()){
                        "Amazing! (20%)" -> pourcentage = 0.2
                        "Good (15%)" -> pourcentage = 0.15
                        "Okay (10%)" -> pourcentage = 0.1
                    }
                    if (!roundtip.isChecked) {
                        var cal = costOfService.text.toString().toDouble()*pourcentage
                        result.text = cal.toString()


                    }
                    else{
                        var cal = costOfService.text.toString().toDouble()*pourcentage
                        result.text= Math.round(cal).toString()
                    }


                }
            }

        }


    }
}