package lotto

object LotteryUtil {
    fun isValidLottoNumber(input: Int?): Boolean = input in 1..45
    fun isValidLottoSize(input: List<Int?>): Boolean = input.size == 6
}