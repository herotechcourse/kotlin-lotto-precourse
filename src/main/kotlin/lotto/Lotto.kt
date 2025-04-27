package lotto

import utils.NumberGenerator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == numbers.size){"[ERROR] Lotto must contain unique numbers."}
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    // TODO: Implement additional functions
    companion object{
        fun generate():Lotto{
            var numbers = NumberGenerator.generate()
            return Lotto(numbers)
        }
        fun generateWinningLotto(numbers : String):Lotto{
            val numList = numbers.split(",").map { it.trim().toInt() }
            return Lotto(numList)
        }

    }
    fun displayLotto():String{
        var ticket = numbers.joinToString(", ")
        return ticket
    }
    fun getNumber():List<Int>{
        return numbers
    }

}
