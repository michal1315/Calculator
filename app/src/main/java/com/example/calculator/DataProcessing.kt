package com.example.calculator


class DataProcessing {

    private var result = 0.0
    var tvInputString = ""
    var tvResultString = ""
    private var leftSide = ""
    private var rightSide = ""
    private var operationSign = ""
    private var typingLeftSide = true
    private var typingRightSide = false
    private var toPreviousResult = false

    private fun tvInputRefresh() {
        tvInputString = leftSide + operationSign + rightSide
    }

    private fun tvResultRefresh() {
        if (leftSide.isEmpty() && rightSide.isEmpty()) {
            tvResultString = ""
        } else if (leftSide.isNotEmpty() && rightSide.isEmpty()) {
            tvResultString = "= $leftSide"
        } else {
            tvResultString = "= ${resultConverter()}"
        }
    }

    private fun resultConverter(): String {
        tvResultString = if (result % 1 != 0.0) {
            result.toString().take(12)
        } else {
            result.toInt().toString().take(12)
        }
        return tvResultString
    }

    private fun clear() {
        result = 0.0
        tvInputString = ""
        tvResultString = ""
        leftSide = ""
        operationSign = ""
        rightSide = ""
        typingLeftSide = true
        typingRightSide = false
        toPreviousResult = false
    }

    private fun delete() {
        if (leftSide.isNotEmpty() &&
            operationSign.isEmpty() &&
            !toPreviousResult
        ) {
            leftSide = leftSide.dropLast(1)
            tvInputRefresh()
        }

        if (operationSign.isNotEmpty() && rightSide.isEmpty()) {
            operationSign = operationSign.dropLast(1)
            typingLeftSide = true
            typingRightSide = false
            tvInputRefresh()
        }
        if (rightSide.isNotEmpty()) {
            rightSide = rightSide.dropLast(1)
            tvInputRefresh()
        }
        calculate(leftSide, operationSign, rightSide)
    }

    fun equals() {
        tvInputString = ""
        tvResultString = ""
        leftSide = resultConverter()
        operationSign = ""
        rightSide = ""
        typingLeftSide = false
        typingRightSide = false
        toPreviousResult = true
    }

    fun inputSanitizer(char: String) {
        when (char) {
            in "-+*/" -> {
                if (operationSign.isEmpty() &&
                    leftSide.isNotEmpty() &&
                    !leftSide.endsWith(".")
                ) {
                    typingLeftSide = false
                    typingRightSide = true
                    operationSign += char
                }
            }

            in "1234567890" -> {
                if (typingLeftSide &&
                    !toPreviousResult
                ) {
                    leftSide += char
                }
                if (typingRightSide) {
                    rightSide += char
                }
            }

            in "." -> {
                if (!leftSide.contains('.') &&
                    !leftSide.endsWith('.') &&
                    leftSide.isNotEmpty() &&
                    typingLeftSide &&
                    !toPreviousResult
                ) {
                    leftSide += char
                }

                if (!rightSide.contains('.') &&
                    !rightSide.endsWith('.') &&
                    rightSide.isNotEmpty() &&
                    typingRightSide
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
                if (rightSide.isNotEmpty()) {
                    equals()
                }
            }
        }

        calculate(leftSide, operationSign, rightSide)
    }

    private fun calculate(
        leftSide: String,
        operationSign: String,
        rightSide: String
    ) {
        if (this.leftSide.isNotEmpty() &&
            this.operationSign.isNotEmpty() &&
            this.rightSide.isNotEmpty()
        ) {
            //https://ambinate.bandcamp.com/track/ellipsis
            when (operationSign) {
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
        }
        tvInputRefresh()
        tvResultRefresh()
    }
}