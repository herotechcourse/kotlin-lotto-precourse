package lotto.validator


fun validatePurchaseAmount (input: String): Int {
    val amount = input.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Purchase amount must be a number.")
    require(amount > 0 && amount % 1000 == 0){
        "[ERROR] Purchase amount must be a positive multiple of 1000."
    }
    return amount

}

fun validateWinningNumbers (input: String): List<Int> {
    val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numbers") }

    require(numbers.size == 6 && numbers.distinct().size == 6){
        "[ERROR] Winning numbers must be 6 unique numbers."
    }
    require(numbers.all { it in 1..45 }){
        "[ERROR] Lotto numbers must be between 1 and 45."
    }
    return numbers

}
fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int{
    val bonus = input.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number")
    require(bonus in 1..45 && bonus !in winningNumbers){
        "[ERROR] Bonus number must be between 1-45 and must be other than the winning numbers"
    }
    return bonus
}

