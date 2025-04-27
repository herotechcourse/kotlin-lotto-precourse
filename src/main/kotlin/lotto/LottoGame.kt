package lotto

class LottoGame (
    private val inputView: InputView,
    private val lottoValidator: LottoValidator
) {
    fun start(){
        getNumberOfTickets()
    }

    private fun getNumberOfTickets(): Int{
        while (true) {
            try {
                val amount = inputView.readPurchaseAmount()
                lottoValidator.validatePurchaseAmount(amount)
                amount.toInt() / 1000
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}