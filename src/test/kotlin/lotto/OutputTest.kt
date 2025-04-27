package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.ApplicationTest.Companion
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {

    private val outputStream = ByteArrayOutputStream()
    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @Test
    fun `should display correct winning statistics`() {

        val resultCount = mutableMapOf(
            LottoEnum.SIX to 1,
            LottoEnum.FIVE_BONUS to 2,
            LottoEnum.FIVE to 3,
            LottoEnum.FOUR to 4,
            LottoEnum.THREE to 5
        )

        Output().displayWinningStatistics(resultCount)
        val output = outputStream.toString().trim()

        assertThat(output).contains(
            "Winning Statistics",
            "---",
            "${LottoEnum.SIX.Output} – 1 tickets",
            "${LottoEnum.FIVE_BONUS.Output} – 2 tickets",
            "${LottoEnum.FIVE.Output} – 3 tickets",
            "${LottoEnum.FOUR.Output} – 4 tickets",
            "${LottoEnum.THREE.Output} – 5 tickets"
        )
    }

    @Test
    fun `should calculate and display correct return rate`() {

        val resultCount = mutableMapOf(
            LottoEnum.SIX to 1,
            LottoEnum.FIVE to 2
        )
        val noOfTickets = 10
        Output().calculateReturnRate(resultCount, noOfTickets)

        val output = outputStream.toString().trim()

        val expectedTotalWinning = LottoEnum.SIX.Amount * 1 + LottoEnum.FIVE.Amount * 2
        val expectedActualAmount = noOfTickets * 1000
        val expectedReturnRate = expectedTotalWinning.toDouble() / expectedActualAmount * 100

        assertThat(output).isEqualTo("Total return rate is %.1f%%.".format(expectedReturnRate))
    }
}

