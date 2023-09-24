package com.example.calculator


class DataProcessing {

    var textViewString = ""
    var firstPartString = ""
    var secondPartString = ""
    var algebraSign = ""
    private var firstPartEquation = true
    private var secondPartEquation = false
    private var toPreviousResult = false


    private fun textViewRefresh(){
        textViewString = firstPartString + algebraSign + secondPartString
    }
    fun charSanitizer(char: String) {
        when (char) {
            in "-+*/" -> {
                if (algebraSign.isEmpty() &&
                    firstPartString.isNotEmpty()
                ) {
                    firstPartEquation = false
                    secondPartEquation = true
                    algebraSign += char
                }
            }

            in "1234567890" -> {
                if (firstPartEquation) {
                    firstPartString += char
                }
                if (secondPartEquation) {
                    secondPartString += char
                }
            }

            in "." -> {
                if (!firstPartString.contains('.') &&
                    !firstPartString.endsWith('.') &&
                    firstPartString.isNotEmpty() &&
                    algebraSign.isEmpty()
                ) {
                    firstPartString += char
                }

                if (!secondPartString.contains('.') &&
                    !secondPartString.endsWith('.') &&
                    secondPartString.isNotEmpty()
                ) {
                    secondPartString += char
                }
            }
        }
        textViewRefresh()

        //println("$firstPartString  $algebraSign  $secondPartString")

    }


    fun makeCalculations(
        firstPart: String,
        algebraSing: String,
        secondPart: String
    ) {
        var result = 0.0
        when (algebraSing) {
            in "-" -> {
                result =
                    (firstPart.toDouble() - secondPart.toDouble())
            }

            in "+" -> {
                result =
                    (firstPart.toDouble() + secondPart.toDouble())
            }

            in "*" -> {
                result =
                    (firstPart.toDouble() * secondPart.toDouble())
            }

            in "/" -> {
                result =
                    (firstPart.toDouble() / secondPart.toDouble())
            }
        }
        val resultString: String = if (result % 1 != 0.0) {
            result.toString().take(12)
        } else {
            result.toInt().toString().take(12)
        }

        toPreviousResult = true
        secondPartEquation = false
        textViewString =  resultString
        firstPartString = resultString
        secondPartString = ""
        algebraSign = ""


    }



    fun deleteChar(){
        if(firstPartString.isNotEmpty() && algebraSign.isEmpty() && !toPreviousResult){
            firstPartString = firstPartString.dropLast(1)
            textViewRefresh()
        }
        if(algebraSign.isNotEmpty() && secondPartString.isEmpty()){
            algebraSign = algebraSign.dropLast(1)
            firstPartEquation = true
            secondPartEquation = false
            textViewRefresh()
        }
        if(secondPartString.isNotEmpty()){
            secondPartString = secondPartString.dropLast(1)
            textViewRefresh()
        }


    }

    fun clearData(){
        textViewString = ""
        firstPartString = ""
        secondPartString = ""
        algebraSign = ""
        firstPartEquation = true
        secondPartEquation = false
    }
}