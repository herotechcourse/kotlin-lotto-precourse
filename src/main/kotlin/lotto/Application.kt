// src/main/kotlin/lotto/Application.kt
package lotto

fun main() {
    try {
        // 1) 구매
        val amount = InputView.readPurchaseAmount()
        val count = Purchase(amount).ticketCount()

        // 2) 티켓 발행 및 출력
        OutputView.printPurchase(count)
        val tickets = LottoGenerator().generate(count)
        OutputView.printTickets(tickets)

        // 3) 당첨 번호 입력
        val winning = InputView.readWinningNumbers()
        val bonus = InputView.readBonusNumber(winning)

        // 4) 결과 평가
        val evaluator = LottoResultEvaluator()
        val results = tickets.map { evaluator.evaluate(it, winning, bonus) }

        // 5) 통계 계산 및 출력
        val stats = LottoStatistics(results, amount)
        OutputView.printStatistics(stats)

    } catch (e: IllegalArgumentException) {
        // 입력 오류 시 이미 InputView에서 [ERROR] 메시지를 찍었으므로
        // 여기서는 추가 출력을 하지 않고 그냥 종료만 시켜줍니다.
    }
}
