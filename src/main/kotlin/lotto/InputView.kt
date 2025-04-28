package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    // 구입 금액 입력 받기
    fun readAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine()
                val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] The amount must be entered as a number.")

                if (amount % 1000 != 0) {
                    throw IllegalArgumentException("[ERROR] The amount must be in multiples of 1,000.")
                }

                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // 당첨 번호 입력 받기
    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                val input = Console.readLine()
                val numbers = input.split(",").map {
                    it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Only numbers are allowed.")
                }

                // 유효성 검사: 6개의 고유 번호인지, 1~45 범위인지
                if (numbers.size != 6 || numbers.toSet().size != 6 || numbers.any { it !in 1..45 }) {
                    throw IllegalArgumentException("[ERROR] The winning numbers must be 6 unique numbers between 1 and 45.")
                }

                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // 보너스 번호 입력 받기
    fun readBonusNumber(winning: List<Int>): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonus = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] The bonus number must be entered as a number.")

                // 보너스 번호의 유효성 검사
                if (bonus !in 1..45 || bonus in winning) {
                    throw IllegalArgumentException("[ERROR] The bonus number must be between 1 and 45, and it must not duplicate any of the winning numbers.")
                }

                return bonus
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
