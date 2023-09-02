package com.example.calculator

class DataHandler {

    private var textToShow = ""
    fun addToTextView(textToAdd: String): String {
        textToShow += textToAdd
        return textToShow
    }



}