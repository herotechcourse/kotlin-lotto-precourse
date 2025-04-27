package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoResultAnalyzerTest {

    @Test
    fun `analyze method calls matchLotto exactly once for each lotto`() {
        val lottoResultAnalyzer = LottoResultAnalyzer()

        val mockLottos = listOf(
            MockFactory.createMockLotto(),
            MockFactory.createMockLotto(),
            MockFactory.createMockLotto()
        )

        lottoResultAnalyzer.analyze(mockLottos, MockFactory.createMockWinningLotto())

        mockLottos.forEach { mockLotto -> assertEquals(mockLotto.callCount,  1) }
    }

}