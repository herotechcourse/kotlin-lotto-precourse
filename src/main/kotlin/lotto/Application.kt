package lotto

import lotto.error.UnexpectedException
import lotto.service.GameService
import lotto.view.OutputView

fun main() {
	try {
		val gameResult = GameService.start()
		GameService.show(gameResult)
	} catch (e: UnexpectedException) {
		OutputView.displayErrorMessage("An unexpected error occurred", e)
		return
	} catch (e: Exception) {
		OutputView.displayErrorMessage("Something went wrong", e)
		return
	}
}