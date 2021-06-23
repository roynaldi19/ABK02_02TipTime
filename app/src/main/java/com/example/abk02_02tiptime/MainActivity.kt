package com.example.abk02_02tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.abk02_02tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    fun calculateTip() {
        val cost = activityMainBinding.costOfService.text.toString().toDouble()

        val selectedId = activityMainBinding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost

        val roundUp = activityMainBinding.roundUpSwitch.isChecked
        if(roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        activityMainBinding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

}