package lotto.service

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.main
import lotto.view.FakeConsole
import lotto.view.InputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameServiceTest : NsTest() {

	@BeforeEach
	fun setup() {
		InputView.useFakeInput = true
		FakeConsole.prepare("8000", "1,2,3,4,5,6", "7")
	}

	@Test
	fun `start should create valid GameResult`() {
		val result = GameService.start()

		assertThat(result.lottoList).isNotEmpty
		assertThat(result.winningNumbers).containsExactly(1, 2, 3, 4, 5, 6)
		assertThat(result.bonusNumber).isEqualTo(7)
	}

	override fun runMain() {
		main()
	}

}