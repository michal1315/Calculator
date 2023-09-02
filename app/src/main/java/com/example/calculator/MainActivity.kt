package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        fun addToCalText(text: String){
            calText.text = dataHandler.addToTextView(text)
        }

        oneButton.setOnClickListener { addToCalText(oneButton.text.toString()) }
        twoButton.setOnClickListener { addToCalText(twoButton.text.toString()) }
        threeButton.setOnClickListener { }
        fourButton.setOnClickListener { }
        fiveButton.setOnClickListener { }
        sixButton.setOnClickListener { }
        sevenButton.setOnClickListener { }
        eightButton.setOnClickListener { }
        nineButton.setOnClickListener { }
        zeroButton.setOnClickListener { }

        dotButton.setOnClickListener { }

        clearButton.setOnClickListener { }

        deleteButton.setOnClickListener { }

        dividerButton.setOnClickListener { }

        multiButton.setOnClickListener { }

        subtractButton.setOnClickListener { }

        addButton.setOnClickListener { }

        equateButton.setOnClickListener { }
    }
}