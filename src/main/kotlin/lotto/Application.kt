package lotto

import lotto.OutputView
//main 함수는 로또 구매 금액을 입력받고, 
//로또 티켓을 생성한 후, 당첨 번호와 
//보너스 번호를 받아 결과를 계산하고 출력
fun main() {
    val amount = InputView.readAmount()
    val machine = LottoMachine()
    val tickets = machine.createTickets(amount)

    OutputView.printTickets(tickets)

    val winning = InputView.readWinningNumbers()
    val bonus = InputView.readBonusNumber(winning)
    val winningNumbers = WinningNumbers(winning, bonus)

    val results = tickets.map { winningNumbers.match(it) }
    val resultStats = LottoResult(results)

    val rate = resultStats.calculateRate(amount)
    OutputView.printStats(resultStats, rate)
}
