package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dataProcessing = DataProcessing()
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


        fun refreshText(newTextToShow: String) {
            calText.text = newTextToShow
        }

        fun sendToProcessing(char: String) {
            dataProcessing.charSanitizer(char)
            refreshText(dataProcessing.textViewString)
        }



        oneButton.setOnClickListener { sendToProcessing("1") }
        twoButton.setOnClickListener { sendToProcessing("2") }
        threeButton.setOnClickListener { sendToProcessing("3") }
        fourButton.setOnClickListener { sendToProcessing("4") }
        fiveButton.setOnClickListener { sendToProcessing("5") }
        sixButton.setOnClickListener { sendToProcessing("6") }
        sevenButton.setOnClickListener { sendToProcessing("7") }
        eightButton.setOnClickListener { sendToProcessing("8") }
        nineButton.setOnClickListener { sendToProcessing("9") }
        zeroButton.setOnClickListener { sendToProcessing("0") }

        clearButton.setOnClickListener {
            dataProcessing.clearData()
            refreshText(dataProcessing.textViewString)
        }
        deleteButton.setOnClickListener { dataProcessing.deleteChar() }

        dotButton.setOnClickListener { sendToProcessing(".") }

        dividerButton.setOnClickListener { sendToProcessing("/") }
        multiButton.setOnClickListener { sendToProcessing("*") }
        subtractButton.setOnClickListener { sendToProcessing("-") }
        addButton.setOnClickListener { sendToProcessing("+") }

        equateButton.setOnClickListener {
            dataProcessing.makeCalculations(
                dataProcessing.firstPartString,
                dataProcessing.algebraSign,
                dataProcessing.secondPartString
            )
            refreshText(dataProcessing.textViewString)
        }
    }
}