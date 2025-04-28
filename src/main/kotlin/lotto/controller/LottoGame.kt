package lotto.domain

class LottoGame(
    private val lottoMachineService: LottoMachine
) {
    fun run() {
        val player = Player()
        lottoMachineService.buyTickets(player)
        lottoMachineService.submitWinningData()
        lottoMachineService.showWinningStats(player)
    }
}
