package lotto.utils

fun validateNotBlank(input: String) {
    if (input.isBlank()) {
        throw IllegalArgumentException("[ERROR] Input field cannot be empty.")
    }
}

fun validateDivisibleByThousand(number: Int) {
    if (number % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
    }
}

fun validateNumberSeparatedWithCommas(input: String) {
    if (!input.contains(",")) {
        throw IllegalArgumentException("[ERROR] Winning numbers must be separated by commas \",\".")
    }
}

fun validateNumberCount(numbers: List<Int>, limit: Int) {
    if (numbers.size != limit) {
        throw IllegalArgumentException("[ERROR] Only $limit number(s) is(are) allowed.")
    }
}

fun validateNumberRange(numbers: List<Int>) {
    numbers.forEach { number ->
        if (number !in 1..45) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }
}

fun validateUniqueNumbers(numbers: List<Int>) {
    if (numbers.size != numbers.toSet().size) {
        throw IllegalArgumentException("[ERROR] Lotto numbers must be unique.")
    }
}

fun validateBonusNotDuplicate(winningNumbers: List<Int>, bonusNumber: Int) {
    if (bonusNumber in winningNumbers) {
        throw IllegalArgumentException("[ERROR] Bonus number must be unique from winning numbers.")
    }
}
