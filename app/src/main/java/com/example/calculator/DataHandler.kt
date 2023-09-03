package com.example.calculator



class DataHandler {
    private var calculationList: ArrayList<String> = arrayListOf()



    fun dataSplitter(data: String) {
        var index: Int = 0
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



}