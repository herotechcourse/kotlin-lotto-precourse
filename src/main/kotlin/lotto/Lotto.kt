package lotto

import utils.NumberGenerator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    // TODO: Implement additional functions
    companion object{
        fun generate():Lotto{
            var numbers = NumberGenerator.generate()
            return Lotto(numbers)
        }

    }
    fun displayLotto():String{
        var ticket = numbers.joinToString(", ")
        return ticket
    }

}
