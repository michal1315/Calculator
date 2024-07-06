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
        val calText = findViewById<TextView>(R.id.tvInput)

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


        fun refreshText(newTextToShow: String) {
            calText.text = newTextToShow
        }

        fun toProcessing(char: String) {
            dataProcessing.inputSanitizer(char)
            refreshText(dataProcessing.tvString)
        }

        oneButton.setOnClickListener { toProcessing("1") }
        twoButton.setOnClickListener { toProcessing("2") }
        threeButton.setOnClickListener { toProcessing("3") }
        fourButton.setOnClickListener { toProcessing("4") }
        fiveButton.setOnClickListener { toProcessing("5") }
        sixButton.setOnClickListener { toProcessing("6") }
        sevenButton.setOnClickListener { toProcessing("7") }
        eightButton.setOnClickListener { toProcessing("8") }
        nineButton.setOnClickListener { toProcessing("9") }
        zeroButton.setOnClickListener { toProcessing("0") }

        clearButton.setOnClickListener {
            dataProcessing.clear()
            refreshText(dataProcessing.tvString)
        }
        deleteButton.setOnClickListener {
            dataProcessing.delete()
            refreshText(dataProcessing.tvString)
        }

        dotButton.setOnClickListener { toProcessing(".") }

        dividerButton.setOnClickListener { toProcessing("/") }
        multiButton.setOnClickListener { toProcessing("*") }
        subtractButton.setOnClickListener { toProcessing("-") }
        addButton.setOnClickListener { toProcessing("+") }

        equateButton.setOnClickListener {
            dataProcessing.calculate(
                dataProcessing.leftSide,
                dataProcessing.operationSing,
                dataProcessing.rightSide
            )
            refreshText(dataProcessing.tvString)
        }

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


