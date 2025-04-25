package lotto

class LottoService() {

    private var lottoTickets: List<Lotto> = emptyList()
    private var winnerNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = -1

    fun purchaseTickets(amount: Int) {
        val lottoGenerator = LottoGenerator()
        val numberOfTickets = amount / LottoConstants.TICKET_PRICE
        lottoTickets = List(numberOfTickets) {
            lottoGenerator.createLottoTicket()
        }
    }

    fun getTickets(): List<Lotto> {
        return lottoTickets
    }

    fun setWinnerNumbers(numbers: List<Int>) {
        winnerNumbers = numbers
    }

    fun setBonusNumber(number: Int) {
        bonusNumber = number
    }

    fun getWinnerNumbers(): List<Int> {
        return winnerNumbers
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }

}