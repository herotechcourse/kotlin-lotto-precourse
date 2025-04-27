package utils

import model.Prize

class OutputView {
    companion object{
        fun print(input : String){
            println(input)
        }
        fun displayResult(result : Map<Prize,Int>){
            println("Winning Statistics\n" +
                    "---")
            for(set in result){
                println("${set.key.displayPrize()}"+" – ${set.value} tickets")
            }
        }
        fun displayReturnRate(profit:Double){
            println("Total return rate is ${profit}%.")
        }
    }
}