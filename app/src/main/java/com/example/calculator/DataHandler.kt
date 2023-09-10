package com.example.calculator


class DataHandler {
    var result = 0.0
    private var calculationList: ArrayList<String> = arrayListOf()

    private fun dataSplitter(data: String) {
        var index = 0
        var numToCal = ""

        while (index <= data.length - 1) {
            when (data[index]) {
                in "1234567890" -> {
                    numToCal += data[index]
                }

                in "-+*/" -> {
                    calculationList.add(numToCal)
                    calculationList.add(data[index].toString())
                    numToCal = ""
                }

            }
            index += 1
        }
        calculationList.add(numToCal)
        //println(calculationList)
    }

    private fun makeCalculations() {
        var index = 0
        while (index <= calculationList.size - 1) {

            when (calculationList[index]) {
                in "-" -> {
                   result = (calculationList[index - 1].toDouble() - calculationList[index + 1].toDouble())
                }
                in "+" -> {
                    result = (calculationList[index - 1].toDouble() + calculationList[index + 1].toDouble())
                }
                in "*" -> {
                    result = (calculationList[index - 1].toDouble() * calculationList[index + 1].toDouble())
                }
                in "/" -> {
                    result = (calculationList[index - 1].toDouble() / calculationList[index + 1].toDouble())
                }
            }
            index += 1
        }
        //println(result)

    }

    fun calculateResult(data:String){
        dataSplitter(data)
        makeCalculations()


    }


}