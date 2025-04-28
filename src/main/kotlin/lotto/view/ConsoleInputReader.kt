package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoNumber
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers

class ConsoleInputReader: InputReader {
    override fun readPurchaseAmount(): PurchaseAmount {
        println("Please enter the purchase amount.")

        val amount: Int? = Console.readLine().toIntOrNull()
        require(amount != null) {"[ERR] Purchase amount must be a number."}

        return PurchaseAmount(amount)
    }

    override fun readWinningNumbers(): WinningNumbers {
        println("Please enter the winning numbers.")

        val numbers: List<Int>? = Console.readLine()
            ?.split(",")
            ?.map { it.trim().toInt() }
        require(numbers != null) {"[ERR] Winning numbers must be 6 numbers."}

        return WinningNumbers.of(numbers)
    }

    override fun readBonusNumber(): LottoNumber {
        println("Please enter the bonus number.")

        val number: Int? = Console.readLine().toIntOrNull()
        require(number != null) {"[ERR] Bonus number must be a number."}

        return LottoNumber(number)
    }
}
