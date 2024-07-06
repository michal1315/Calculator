package com.example.calculator


class DataProcessing {

    var tvString = ""
    var leftSide = ""
    var rightSide = ""
    var operationSing = ""
    private var leftSideStart = true
    private var rightSideStart = false
    private var toPreviousResult = false


    private fun tvRefresh() {
        tvString = leftSide + operationSing + rightSide
    }

    fun inputSanitizer(char: String) {
        when (char) {
            in "-+*/" -> {
                if (operationSing.isEmpty() &&
                    leftSide.isNotEmpty() &&
                    !leftSide.endsWith(".")
                ) {
                    leftSideStart = false
                    rightSideStart = true
                    operationSing += char
                }
            }

            in "1234567890" -> {
                if (leftSideStart) {
                    leftSide += char
                }
                if (rightSideStart) {
                    rightSide += char
                }
            }

            in "." -> {
                if (!leftSide.contains('.') &&
                    !leftSide.endsWith('.') &&
                    leftSide.isNotEmpty()
                ) {
                    leftSide += char
                }

                if (!rightSide.contains('.') &&
                    !rightSide.endsWith('.') &&
                    rightSide.isNotEmpty()
                ) {
                    rightSide += char
                }
            }
        }
        tvRefresh()

        //println("$firstPartString  $algebraSign  $secondPartString")

    }


    fun calculate(
        firstPart: String,
        algebraSing: String,
        secondPart: String
    ) {
        if (leftSide.isNotEmpty() &&
            operationSing.isNotEmpty() &&
            rightSide.isNotEmpty() &&
            !rightSide.endsWith(".")
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
            rightSideStart = false
            tvString = resultString
            leftSide = resultString
            rightSide = ""
            operationSing = ""


        }
    }


    fun delete() {
        if (leftSide.isNotEmpty() && operationSing.isEmpty() && !toPreviousResult) {
            leftSide = leftSide.dropLast(1)
            tvRefresh()
        }
        if (operationSing.isNotEmpty() && rightSide.isEmpty()) {
            operationSing = operationSing.dropLast(1)
            leftSideStart = true
            rightSideStart = false
            tvRefresh()
        }
        if (rightSide.isNotEmpty()) {
            rightSide = rightSide.dropLast(1)
            tvRefresh()
        }


    }

    fun clear() {
        tvString = ""
        leftSide = ""
        rightSide = ""
        operationSing = ""
        leftSideStart = true
        rightSideStart = false
        toPreviousResult = false
    }
}