package lotto

object LottoInitializer {
    fun cashierFromInput(): Cashier{
        val lotto = lottoFromInput()
        val bonusNumber = bonusNumberFromInput(lotto)
        return Cashier(lotto, bonusNumber)
    }
    private fun lottoFromInput(): Lotto {
        while (true)
            try {
                return Lotto(InputView.getWinningNumbers())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
    }
    private fun bonusNumberFromInput(lotto:Lotto):Int{
        while (true)
            try {
                return checkBonusNumber(InputView.getBonusNumber(), lotto)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
    }
    private fun checkBonusNumber(bonusNumber:Int, lotto:Lotto):Int{
        require(bonusNumber in 1..45){"[ERROR] Bonus number must be between 1 and 45."}
        require(!lotto.bonusRepeatsNumber(bonusNumber))
        {"[ERROR] bonus number must be different from winning numbers."}
        return bonusNumber
    }
    fun ticketMachineFromInput():TicketMachine{
        while (true){
            try{
                return TicketMachine(InputView.getPurchaseAmount())
            }
            catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }
}