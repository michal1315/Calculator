package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.main_toolbar))


        val dataProcessing = DataProcessing()
        val tvInput = findViewById<TextView>(R.id.tvInput)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val clearButton = findViewById<Button>(R.id.clearButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)

        val oneButton = findViewById<Button>(R.id.oneButton)
        val twoButton = findViewById<Button>(R.id.twoButton)
        val threeButton = findViewById<Button>(R.id.threeButton)
        val fourButton = findViewById<Button>(R.id.fourButton)
        val fiveButton = findViewById<Button>(R.id.fiveButton)
        val sixButton = findViewById<Button>(R.id.sixButton)
        val sevenButton = findViewById<Button>(R.id.sevenButton)
        val eightButton = findViewById<Button>(R.id.eightButton)
        val nineButton = findViewById<Button>(R.id.nineButton)
        val zeroButton = findViewById<Button>(R.id.zeroButton)
        val dotButton = findViewById<Button>(R.id.dotButton)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val dividerButton = findViewById<Button>(R.id.dividerButton)
        val multiButton = findViewById<Button>(R.id.multiButton)
        val equateButton = findViewById<Button>(R.id.equateButton)


        fun tvInputRefresh(newTextToShow: String) {
            tvInput.text = newTextToShow

        }

        fun tvResultRefresh(newTextToShow: String) {
            tvResult.text = newTextToShow

        }

        fun userInput(char: String) {
            dataProcessing.inputSanitizer(char)
            tvInputRefresh(dataProcessing.tvInputString)
            tvResultRefresh(dataProcessing.tvResultString)
        }

        oneButton.setOnClickListener { userInput("1") }
        twoButton.setOnClickListener { userInput("2") }
        threeButton.setOnClickListener { userInput("3") }
        fourButton.setOnClickListener { userInput("4") }
        fiveButton.setOnClickListener { userInput("5") }
        sixButton.setOnClickListener { userInput("6") }
        sevenButton.setOnClickListener { userInput("7") }
        eightButton.setOnClickListener { userInput("8") }
        nineButton.setOnClickListener { userInput("9") }
        zeroButton.setOnClickListener { userInput("0") }

        clearButton.setOnClickListener { userInput("C") }
        deleteButton.setOnClickListener { userInput("DEL") }

        dotButton.setOnClickListener { userInput(".") }

        dividerButton.setOnClickListener { userInput("/") }
        multiButton.setOnClickListener { userInput("*") }
        subtractButton.setOnClickListener { userInput("-") }
        addButton.setOnClickListener { userInput("+") }

        equateButton.setOnClickListener { userInput("=") }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {

                val settingsActivity = Intent(this, SettingsActivity::class.java)
                startActivity(settingsActivity)

                true
            }

            R.id.about -> {

                val aboutActivity = Intent(this, AboutActivity::class.java)
                startActivity(aboutActivity)

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}


