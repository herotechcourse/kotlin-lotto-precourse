package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val player = initializePlayer(inputView, outputView)
    val lotto = initializeLotto(inputView)
    val game = playGame(inputView, player, lotto)

    displayResults(outputView, game)
}

private fun initializePlayer(inputView: InputView, outputView: OutputView): Player {
    val amount = inputView.getAmount()
    val player = Player(amount)
    outputView.printTickets(player.tickets)
    return player
}

private fun initializeLotto(inputView: InputView): Lotto {
    return Lotto(inputView.getWinningNumbers())
}

private fun playGame(inputView: InputView, player: Player, lotto: Lotto): Game {
    val bonusNumber = inputView.getBonusNumber()
    return Game(player, lotto, bonusNumber)
}

private fun displayResults(outputView: OutputView, game: Game) {
    outputView.printStatistics(game.statistics)
    outputView.printReturnRate(game.profitRate)
}