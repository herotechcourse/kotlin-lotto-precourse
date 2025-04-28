package lotto

import camp.nextstep.edu.missionutils.Console


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Lotto must contain 6 unique numbers." }
    }

    fun getAmountOfWinningNumbersInTicket(ticket: List<Int>): Int {
        val unionOfNumbers = ticket.toMutableSet()
        unionOfNumbers.addAll(this.numbers)
        return (LottoConfiguration.NUMBER_AMOUNT * 2 - unionOfNumbers.size)
    }

    companion object {

        private fun printMatchResult(matchesAmount: Int, isUsedBonusBall: Boolean, ticketsInfo: MutableList<Int>) {
            if (isUsedBonusBall) {
                val ticketsWithBonusAmount = ticketsInfo.filter { it == 1 }.size
                val ticketsAmount = ticketsInfo.size - ticketsWithBonusAmount
                LottoConfiguration.printWinningStatisticsRow(matchesAmount, false, ticketsAmount)
                LottoConfiguration.printWinningStatisticsRow(matchesAmount, true, ticketsWithBonusAmount)
            } else {
                LottoConfiguration.printWinningStatisticsRow(matchesAmount, false, ticketsInfo.size)
            }
        }

        private fun getPurchaseWinningNumbersErrorMessage(winningNumbers: String): String {
            val attributeName = "Winning numbers"
            val winningNumbersCollection = winningNumbers.split(",")
            val errorMessage = when {
                winningNumbers.isBlank() -> LottoError.get(attributeName, "isEmpty")
                winningNumbersCollection.any { it.any { el -> !el.isDigit() } } -> LottoError.get(
                    attributeName,
                    "notDigit"
                )

                winningNumbersCollection.size < 6 -> LottoError.get(attributeName, "size<6")
                winningNumbersCollection.toSet().size < 6 -> LottoError.get(attributeName, "notUnique")
                winningNumbersCollection.any { it.toInt() !in 1..45 } -> LottoError.get(
                    attributeName,
                    "notInRange1-45"
                )

                else -> ""
            }
            return errorMessage
        }

        private fun checkWinningNumbers(winningNumbers: String): Boolean {
            val errorMessage = getPurchaseWinningNumbersErrorMessage(winningNumbers)
            if (errorMessage.isBlank()) {
                return true
            }
            println(errorMessage)
            return false
        }

        private fun requestWinningNumbersFromUser(): List<Int> {
            LottoPrompt.printMessageToUser("winningNumbers", "")
            var winningNumbersList = Console.readLine()
            while (!checkWinningNumbers(winningNumbersList)) {
                winningNumbersList = Console.readLine()
            }
            return winningNumbersList.split(",").map { it.toInt() }
        }

        private fun getBonusNumberErrorMessage(winningNumbers: List<Int>, bonusNumber: String): String {
            val attributeName = "Bonus number"
            val errorMessage = when {
                bonusNumber.isBlank() -> LottoError.get(attributeName, "isEmpty")
                bonusNumber.any { !it.isDigit() } -> LottoError.get(attributeName, "notDigit")
                bonusNumber.toInt() !in 1..45 -> LottoError.get(
                    attributeName,
                    "notInRange1-45"
                )

                bonusNumber.toInt() in winningNumbers -> LottoError.get(attributeName, "inWinningNumbers")
                else -> ""
            }
            return errorMessage
        }

        private fun checkBonusNumber(winningNumbers: List<Int>, bonusNumber: String): Boolean {
            val errorMessage = getBonusNumberErrorMessage(winningNumbers, bonusNumber)
            if (errorMessage.isBlank()) {
                return true
            }
            println(errorMessage)
            return false
        }

        private fun requestBonusNumberFromUser(winningNumbers: List<Int>): Int {
            LottoPrompt.printMessageToUser("bonusNumber", "")
            var bonusNumber = Console.readLine()
            while (!checkBonusNumber(winningNumbers, bonusNumber)) {
                bonusNumber = Console.readLine()
            }
            return bonusNumber.toInt()
        }

        private fun getLottoResult(
            tickets: List<List<Int>>,
            lotto: Lotto,
            bonusNumber: Int
        ): Map<Int, MutableList<Int>> {
            val keys = LottoConfiguration.WINNING_SUM_DICTIONARY.keys
            val lottoResult = buildMap<Int, MutableList<Int>> {
                keys.forEach { put(it, mutableListOf()) }
            }
            for (ticket in tickets) {
                val wins = lotto.getAmountOfWinningNumbersInTicket(ticket)
                val hasBonusNumber = bonusNumber in ticket
                lottoResult[wins]?.add(if (hasBonusNumber) 1 else 0)
            }
            return lottoResult
        }

        private fun runLottery(tickets: List<List<Int>>, lotto: Lotto, bonusNumber: Int): Int {
            val keys = LottoConfiguration.WINNING_SUM_DICTIONARY.keys
            val lottoResult = getLottoResult(tickets, lotto, bonusNumber)
            LottoPrompt.printMessageToUser("PRINT_WINNING_STATISTICS_HEADER", "")
            var winningSum = 0
            keys.forEach {
                val isUsedBonusBall = it in LottoConfiguration.WINNING_SUM_WITH_BONUS_BALL_DICTIONARY
                lottoResult[it]?.let { it1 -> printMatchResult(it, isUsedBonusBall, it1) }
                winningSum += LottoConfiguration.getSumForEachMatch(it, lottoResult[it]!!.toList())
            }
            return winningSum
        }

        private fun getReturnRate(winningSum: Int, spentAmount: Int): Double {
            val result = winningSum.toDouble() * 100 / spentAmount
            return result
        }

        fun create(): Lotto {
            val usersTickets = UsersTickets()
            val winningNumbers = requestWinningNumbersFromUser()
            val bonusNumber = requestBonusNumberFromUser(winningNumbers)
            val lotto = Lotto(winningNumbers)

            val winningSum = runLottery(usersTickets.getLottoTickets(), lotto, bonusNumber)
            val returnRate = getReturnRate(winningSum, usersTickets.getPurchasedAmount()).toString()
            LottoPrompt.printMessageToUser("PRINT_RETURN_RATE", returnRate)
            return lotto
        }
    }
}
