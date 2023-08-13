package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = "Click"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(this, text, duration) // in Activity


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

        clearButton.setOnClickListener {  }
        deleteButton.setOnClickListener {  }
        dividerButton.setOnClickListener {  }
        sevenButton.setOnClickListener {  }
        eightButton.setOnClickListener {  }
        nineButton.setOnClickListener {  }
        multiButton.setOnClickListener {  }
        fourButton.setOnClickListener {  }
        fiveButton.setOnClickListener {  }
        sixButton.setOnClickListener {  }
        subtractButton.setOnClickListener {  }
        oneButton.setOnClickListener {  }
        twoButton.setOnClickListener {  }
        threeButton.setOnClickListener {  }
        addButton.setOnClickListener {  }
        zeroButton.setOnClickListener {  }
        dotButton.setOnClickListener {  }
        equateButton.setOnClickListener {  }


    }
}