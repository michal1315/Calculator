package com.example.calculator


class DataProcessing {

    var tvInputString = ""
    var tvResultString = ""
    var leftSide = ""
    var rightSide = ""
    var operationSing = ""
    private var typingLeftSide = true
    private var typingRightSide = false
    private var toPreviousResult = false


    private fun tvInputRefresh() {
        tvInputString = leftSide + operationSing + rightSide
    }

    private fun clear() {
        tvInputString = ""
        tvResultString = ""
        leftSide = ""
        rightSide = ""
        operationSing = ""
        typingLeftSide = true
        typingRightSide = false
        toPreviousResult = false
    }

    fun toInitState() {
        toPreviousResult = true
        typingRightSide = false
        tvInputString = tvResultString
        this.leftSide = tvResultString
        this.rightSide = ""
        this.operationSing = ""

    }

    fun delete() {
        if (leftSide.isNotEmpty() && operationSing.isEmpty() && !toPreviousResult) {
            leftSide = leftSide.dropLast(1)
            tvInputRefresh()
        }
        if (operationSing.isNotEmpty() && rightSide.isEmpty()) {
            operationSing = operationSing.dropLast(1)
            typingLeftSide = true
            typingRightSide = false
            tvInputRefresh()
        }
        if (rightSide.isNotEmpty()) {
            rightSide = rightSide.dropLast(1)
            tvInputRefresh()
        }


    }

    fun inputSanitizer(char: String) {
        when (char) {
            in "-+*/" -> {
                if (operationSing.isEmpty() &&
                    leftSide.isNotEmpty() &&
                    !leftSide.endsWith(".")
                ) {
                    typingLeftSide = false
                    typingRightSide = true
                    operationSing += char
                }
            }

            in "1234567890" -> {
                if (typingLeftSide) {
                    leftSide += char
                }
                if (typingRightSide) {
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

            in "C" -> {
                clear()
            }

            in "DEL" -> {
                delete()
            }

            in "=" -> {
                clear()
            }
        }

        calculate(leftSide, operationSing, rightSide)


        //println("$firstPartString  $algebraSign  $secondPartString")

    }


    fun calculate(
        leftSide: String,
        operationSing: String,
        rightSide: String
    ) {
        if (this.leftSide.isNotEmpty() &&
            this.operationSing.isNotEmpty() &&
            this.rightSide.isNotEmpty() &&
            !this.rightSide.endsWith(".")
        ) {
            var result = 0.0
            when (operationSing) {
                in "-" -> {
                    result =
                        (leftSide.toDouble() - rightSide.toDouble())
                }

                in "+" -> {
                    result =
                        (leftSide.toDouble() + rightSide.toDouble())
                }

                in "*" -> {
                    result =
                        (leftSide.toDouble() * rightSide.toDouble())
                }

                in "/" -> {
                    result =
                        (leftSide.toDouble() / rightSide.toDouble())
                }


            }
            tvResultString = if (result % 1 != 0.0) {
                result.toString().take(12)
            } else {
                result.toInt().toString().take(12)
            }
        }
        tvInputRefresh()
    }


}