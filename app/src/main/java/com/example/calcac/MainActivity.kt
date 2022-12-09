package com.example.calcac

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var calorieStorage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val restBtn = findViewById<ImageView>(R.id.resetBtn)
        val plusBtn = findViewById<ImageView>(R.id.plusBtn)
        val equalBtn = findViewById<ImageView>(R.id.equalBtn)
        var foodStorage = arrayOf<Int>()
        var calorieCounter = 0
        var plusChecker = 0
        val ans = findViewById<TextView>(R.id.ans)
        val myDialoug = Dialog(this)
        //val dialougBox = layoutInflater.inflate(R.layout.custom_dialoug, null)
        myDialoug.setContentView(R.layout.custom_dialoug)
        myDialoug.setCancelable(true)
        myDialoug.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialoug.show()
        burgerBtn.setOnClickListener {
            foodStorage += 1
            selection("Burger")
        }
        friesBtn.setOnClickListener {
            foodStorage += 2
            selection("French Fries")
        }
        sushiBtn.setOnClickListener {
            foodStorage += 3
            selection("Sushi")
        }
        chipsBtn.setOnClickListener {
            foodStorage += 4
            selection("Potato Chips")
        }
        toffeeBtn.setOnClickListener {
            foodStorage += 5
            selection("Toffee")
        }
        chocolateBtn.setOnClickListener {
            foodStorage += 6
            selection("Chocolate")
        }
        cakeBtn.setOnClickListener {
            foodStorage += 7
            selection("Cheese Cake")
        }
        saladBtn.setOnClickListener {
            foodStorage += 8
            selection("Fruit Salad")
        }
        muffinsBtn.setOnClickListener {
            foodStorage += 9
            selection("Muffins")
        }
        waterBtn.setOnClickListener {
            foodStorage += 10
            selection("Water")
        }
        colaBtn.setOnClickListener {
            foodStorage += 11
            selection("Soft Drink")
        }
        ojBtn.setOnClickListener {
            foodStorage += 12
            selection("Orange Juice")
        }
        restBtn.setOnClickListener{
            val intent = Intent(this@MainActivity,MainActivity::class.java)
            startActivity(intent)
        }
        equalBtn.setOnClickListener{
            if(plusChecker == 0){
                Toast.makeText(this, "Click on the plus button first", Toast.LENGTH_SHORT).show()
            }
            else if (plusChecker > 1){
                Toast.makeText(this, "Click on the reset button to get restart", Toast.LENGTH_SHORT).show()
            }
            else{
            ans.text = "$calorieCounter Calories"
                plusChecker++
            }
        }
        plusBtn.setOnClickListener{
            if (plusChecker == 0){
                plusChecker++
                for (i in foodStorage.indices){
                    if (foodStorage[i] == 1){
                        calorieCounter += 295
                    }
                    else if (foodStorage[i] == 2){
                        calorieCounter += 312
                    }
                    else if (foodStorage[i] == 3){
                        calorieCounter += 100
                    }
                    else if (foodStorage[i] == 4){
                        calorieCounter += 536
                    }
                    else if (foodStorage[i] == 5){
                        calorieCounter += 50
                    }
                    else if (foodStorage[i] == 6){
                        calorieCounter += 535
                    }
                    else if (foodStorage[i] == 7){
                        calorieCounter += 321
                    }
                    else if (foodStorage[i] == 8){
                        calorieCounter += 50
                    }
                    else if (foodStorage[i] == 9){
                        calorieCounter += 364
                    }
                    else if (foodStorage[i] == 10){
                        calorieCounter += 0
                    }
                    else if (foodStorage[i] == 11){
                        calorieCounter += 210
                    }
                    else if (foodStorage[i] == 12){
                        calorieCounter += 45
                    }
                }
            }
            else if (plusChecker == 2){
                Toast.makeText(this, "Click on the reset button to get restart", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Click on the equal button to get the results", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun selection(counter: String){
        when (calorieStorage) {
            0 -> {
                ele1.text = counter
                calorieStorage++
            }
            1 -> {
                ele2.text = " + \n$counter"
                calorieStorage++
            }
            2 -> {
                ele3.text = " + \n$counter"
                calorieStorage++
            }
            3 -> {
                ele4.text = " + \n$counter"
                calorieStorage++
                burgerBtn.isEnabled = false
                friesBtn.isEnabled = false
                sushiBtn.isEnabled = false
                chipsBtn.isEnabled = false
                toffeeBtn.isEnabled = false
                chocolateBtn.isEnabled = false
                cakeBtn.isEnabled = false
                saladBtn.isEnabled = false
                muffinsBtn.isEnabled = false
                waterBtn.isEnabled = false
                colaBtn.isEnabled = false
                ojBtn.isEnabled = false
            }
        }
    }
}
