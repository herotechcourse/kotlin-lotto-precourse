package utils

import model.Prize

class Accountant {
    companion object{
        fun analyse(input : Map<Prize,Int>, ticketCount:Int):Double{
            val sum = input.entries.sumOf{ (prize, count) -> prize.value* count }
            val payment = ticketCount*1000
            val rate = (sum.toDouble() / payment) * 100
            return rate.roundTo(1)
        }
        private fun Double.roundTo(decimals: Int): Double {
            return "%.${decimals}f".format(this).toDouble()
        }
    }
}