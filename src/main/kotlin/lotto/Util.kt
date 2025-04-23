package lotto

class Util {
    fun winningNumberSplitter(input: String) : List<Int> {
        val numbers = input.split(",")
            .map { it.toInt() }
        return numbers
    }
}