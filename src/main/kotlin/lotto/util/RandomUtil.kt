package lotto.util

object RandomUtil {

    fun generateRandomNumbers(): List<Int> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < 6) {
            numbers.add((1..45).random())
        }
        return numbers.toList()
    }
}
