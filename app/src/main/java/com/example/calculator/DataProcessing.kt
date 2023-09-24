package com.example.calculator


class DataProcessing {

    var textViewString = ""
    var firstPartString = ""
    var secondPartString = ""
    var algebraSign = ""
    private var firstPartEquation = true
    private var secondPartEquation = false
    private var toPreviousResult = false


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
        textViewString = firstPartString + algebraSign + secondPartString

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