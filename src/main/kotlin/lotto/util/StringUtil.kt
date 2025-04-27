package lotto.util

object StringUtil {
    fun convertToList(input: String): List<String> =
        input.split(",").map { it.trim() }
}