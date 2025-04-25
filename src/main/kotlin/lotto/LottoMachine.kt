package lotto

class LottoMachine(private val money: Int) {

    fun countTickets(): Int {
        return (money / 1000)
    }

}