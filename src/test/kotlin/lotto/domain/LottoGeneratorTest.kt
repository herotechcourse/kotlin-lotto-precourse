package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoGeneratorTest {
    private val lottoGenerator = LottoGenerator()
    
    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "2000, 2",
        "14000, 14"
    )
    fun `should generate correct number of tickets based on amount`(
        amount: Int, 
        expectedTickets: Int
    ) {
        val lottos = lottoGenerator.generate(amount)
        
        assertThat(lottos).hasSize(expectedTickets)
    }
    
    @Test
    fun `should throw error when amount is not divisible by 1000`() {
        assertThatThrownBy { lottoGenerator.generate(1500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
    
    @Test
    fun `should throw error when amount is negative`() {
        assertThatThrownBy { lottoGenerator.generate(-1000) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
    
    @Test
    fun `should throw error when amount is zero`() {
        assertThatThrownBy { lottoGenerator.generate(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
} 