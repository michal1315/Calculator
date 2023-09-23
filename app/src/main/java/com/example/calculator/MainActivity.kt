package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var firstPartOfEquation = true
        var secondPartOfEquation = false
        var numButtonsUnlock = true
        var algebraButtonsUnlock = false
        var dotButtonUnlock = false
        var dotsAmount = 0


        var calculationDataString = ""
        val dataHandler = DataHandler()
        val calText = findViewById<TextView>(R.id.currentCal)

        val clearButton = findViewById<Button>(R.id.clearButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val dividerButton = findViewById<Button>(R.id.dividerButton)
        val sevenButton = findViewById<Button>(R.id.sevenButton)
        val eightButton = findViewById<Button>(R.id.eightButton)
        val nineButton = findViewById<Button>(R.id.nineButton)
        val multiButton = findViewById<Button>(R.id.multiButton)
        val fourButton = findViewById<Button>(R.id.fourButton)
        val fiveButton = findViewById<Button>(R.id.fiveButton)
        val sixButton = findViewById<Button>(R.id.sixButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val oneButton = findViewById<Button>(R.id.oneButton)
        val twoButton = findViewById<Button>(R.id.twoButton)
        val threeButton = findViewById<Button>(R.id.threeButton)
        val addButton = findViewById<Button>(R.id.addButton)
        val zeroButton = findViewById<Button>(R.id.zeroButton)
        val dotButton = findViewById<Button>(R.id.dotButton)
        val equateButton = findViewById<Button>(R.id.equateButton)


        fun intLocksState() {
            firstPartOfEquation = true
            secondPartOfEquation = false
            numButtonsUnlock = true
            algebraButtonsUnlock = false
            dotsAmount = 0
            dotButtonUnlock = false
        }

        fun refreshText(newTextToShow: String) {
            calText.text = newTextToShow
        }

        fun clearCalculationData() {
            calculationDataString = ""
            refreshText(calculationDataString)
            intLocksState()
        }

        fun deleteCalculationData() {
            if (calculationDataString.isNotEmpty()) {
                when (calculationDataString.last()) {
                    in "1234567890" -> {
                        if (firstPartOfEquation) {
                            algebraButtonsUnlock = true
                        }
                        if (secondPartOfEquation) {
                            algebraButtonsUnlock = false
                        }
                    }

                    in "-+*/" -> {
                        algebraButtonsUnlock = true
                        firstPartOfEquation = true
                        secondPartOfEquation = false
                    }

                    in "." -> {
                        if (firstPartOfEquation) {
                            dotsAmount = 0
                            dotButtonUnlock = true
                        }
                        if (secondPartOfEquation) {
                            dotsAmount = 0
                            dotButtonUnlock = true
                        }
                    }
                }
            }
            calculationDataString = calculationDataString.dropLast(1)
            refreshText(calculationDataString)
        }

        fun addToCalculation(textToAdd: String) {
            when (textToAdd) {
                in "1234567890" -> {
                    algebraButtonsUnlock = true
                    dotButtonUnlock = true
                    if (secondPartOfEquation) {
                        algebraButtonsUnlock = false
                    }
                    calculationDataString += textToAdd
                    refreshText(calculationDataString)
                }

                in "-+*/" -> {
                    if (calculationDataString.last() != '.') {
                        if (algebraButtonsUnlock) {
                            dotsAmount = 0
                            dotButtonUnlock = false
                            firstPartOfEquation = false
                            secondPartOfEquation = true
                            calculationDataString += textToAdd
                            refreshText(calculationDataString)
                            algebraButtonsUnlock = false
                        }
                    }
                }

                in "." -> {
                    if (firstPartOfEquation && dotsAmount == 0 && dotButtonUnlock) {
                        calculationDataString += textToAdd
                        refreshText(calculationDataString)
                        dotsAmount++
                        algebraButtonsUnlock = false
                    }
                    if (secondPartOfEquation && dotsAmount == 0 && dotButtonUnlock) {
                        calculationDataString += textToAdd
                        refreshText(calculationDataString)
                        dotsAmount++
                        algebraButtonsUnlock = false
                    }
                }
            }
        }



        oneButton.setOnClickListener { addToCalculation("1") }
        twoButton.setOnClickListener { addToCalculation("2") }
        threeButton.setOnClickListener { addToCalculation("3") }
        fourButton.setOnClickListener { addToCalculation("4") }
        fiveButton.setOnClickListener { addToCalculation("5") }
        sixButton.setOnClickListener { addToCalculation("6") }
        sevenButton.setOnClickListener { addToCalculation("7") }
        eightButton.setOnClickListener { addToCalculation("8") }
        nineButton.setOnClickListener { addToCalculation("9") }
        zeroButton.setOnClickListener { addToCalculation("0") }

        clearButton.setOnClickListener { clearCalculationData() }
        deleteButton.setOnClickListener { deleteCalculationData() }

        dotButton.setOnClickListener { addToCalculation(".") }

        dividerButton.setOnClickListener { addToCalculation("/") }
        multiButton.setOnClickListener { addToCalculation("*") }
        subtractButton.setOnClickListener { addToCalculation("-") }
        addButton.setOnClickListener { addToCalculation("+") }

        equateButton.setOnClickListener {
            calculationDataString = dataHandler.calculateResult(calculationDataString)
            refreshText(calculationDataString)
        }

    }
}