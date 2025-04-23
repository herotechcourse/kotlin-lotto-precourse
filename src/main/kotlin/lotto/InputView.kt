package lotto

class InputView {
    fun readMoney(): Int {
        println("로또 구입 금액을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.")
    }

    fun readWinningNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val input = readLine() ?: throw IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.")
        return parseNumbers(input)
    }

    fun readBonusNumber(): Int {
        println("\n보너스 번호를 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.")
    }

    private fun parseNumbers(input: String): List<Int> {
        return input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.") }
    }
} 