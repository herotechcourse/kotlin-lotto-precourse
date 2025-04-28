package lotto

import lotto.Lotto.Companion.createLottoList

fun main() {
    try {
        val price = Input.purchasePrice()
        val lottocount = price / 1000
        println("You have purchased $lottocount tickets.")

        val createdRandomLottos = createLottoList(lottocount)
        for (lotto in createdRandomLottos) {
            println(lotto.getNumbers())
        }

        var first = 0
        var second = 0
        var third = 0
        var fourth = 0
        var fifth = 0

        val numbers = Input.correctNumbers()
        val bonusNumber = Input.bonusNumber(numbers)

        val juan = Lotto(listOf(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]))
        val sortedNumbers = juan.getNumbers()

        for (i in 0 until lottocount) {
            val correctLotto = juan.correctNumbers(createdRandomLottos[i].getNumbers(), sortedNumbers, bonusNumber)
            when (correctLotto) {
                3 -> fifth += 1
                4 -> fourth += 1
                5 -> third += 1
                6 -> second += 1
                7 -> first += 1
            }
        }

        val finalPrint = Output.summary(first, second, third, fourth, fifth, price)
        println(finalPrint)

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
