package lotto
import lotto.views.InputView
import camp.nextstep.edu.missionutils.Randoms


fun generateLottoTickets(): List<List<Int>> {
    val inputView = InputView()
    val numberOfTickets = inputView.inputTickets() / 1000
    val tickets = mutableListOf<List<Int>>()

    repeat(numberOfTickets) {
        val ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        tickets.add(ticket)
    }

    return tickets
}
