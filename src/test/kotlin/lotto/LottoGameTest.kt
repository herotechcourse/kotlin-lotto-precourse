package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoGameTest {

    @Test
    fun `should return Rank FIRST and correct winnings when all numbers match`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val game = LottoGame(ticket, winning, bonusNumber = 7)

        game.play()
        val results = game.getResults()

        assertThat(results[Rank.FIRST]).isEqualTo(1)
        assertThat(game.getTotalWinnings()).isEqualTo(Rank.FIRST.prizeAmount)
    }

    @Test
    fun `should return Rank SECOND and correct winnings when 5 numbers and bonus match`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = listOf(Lotto(listOf(1, 2, 3, 4, 5, 9)))
        val game = LottoGame(ticket, winning, bonusNumber = 9)

        game.play()
        val results = game.getResults()

        assertThat(results[Rank.SECOND]).isEqualTo(1)
        assertThat(game.getTotalWinnings()).isEqualTo(Rank.SECOND.prizeAmount)
    }

    @Test
    fun `should return Rank THIRD when 5 numbers match but no bonus`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val game = LottoGame(ticket, winning, bonusNumber = 8)

        game.play()

        assertThat(game.getResults()[Rank.THIRD]).isEqualTo(1)
        assertThat(game.getTotalWinnings()).isEqualTo(Rank.THIRD.prizeAmount)
    }

    @Test
    fun `should return Rank FOURTH when 4 numbers match`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = listOf(Lotto(listOf(1, 2, 3, 4, 9, 10)))
        val game = LottoGame(ticket, winning, bonusNumber = 7)

        game.play()

        assertThat(game.getResults()[Rank.FOURTH]).isEqualTo(1)
        assertThat(game.getTotalWinnings()).isEqualTo(Rank.FOURTH.prizeAmount)
    }

    @Test
    fun `should return Rank FIFTH when 3 numbers match`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = listOf(Lotto(listOf(1, 2, 3, 10, 11, 12)))
        val game = LottoGame(ticket, winning, bonusNumber = 7)

        game.play()

        assertThat(game.getResults()[Rank.FIFTH]).isEqualTo(1)
        assertThat(game.getTotalWinnings()).isEqualTo(Rank.FIFTH.prizeAmount)
    }

    @Test
    fun `should return Rank NONE when no numbers match`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = listOf(Lotto(listOf(11, 22, 33, 41, 15, 19)))
        val game = LottoGame(ticket, winning, bonusNumber = 9)

        game.play()
        val results = game.getResults()

        assertThat(results[Rank.NONE]).isEqualTo(1)
        assertThat(game.getTotalWinnings()).isEqualTo(Rank.NONE.prizeAmount)
    }

    @Test
    fun `should handle multiple tickets and calculate total winnings correctly`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 9)),
            Lotto(listOf(1, 2, 3, 4, 5, 10)),
            Lotto(listOf(1, 2, 3, 4, 9, 10)),
            Lotto(listOf(1, 2, 3, 10, 11, 12)),
            Lotto(listOf(11, 22, 33, 44, 13, 26))
        )
        val game = LottoGame(tickets, winning, bonusNumber = 9)

        game.play()
        val results = game.getResults()
        val total = Rank.FIRST.prizeAmount +
                Rank.SECOND.prizeAmount +
                Rank.THIRD.prizeAmount +
                Rank.FOURTH.prizeAmount +
                Rank.FIFTH.prizeAmount +
                0

        assertThat(results[Rank.FIRST]).isEqualTo(1)
        assertThat(results[Rank.SECOND]).isEqualTo(1)
        assertThat(results[Rank.THIRD]).isEqualTo(1)
        assertThat(results[Rank.FOURTH]).isEqualTo(1)
        assertThat(results[Rank.FIFTH]).isEqualTo(1)
        assertThat(results[Rank.NONE]).isEqualTo(1)
        assertThat(game.getTotalWinnings()).isEqualTo(total)
    }
}
