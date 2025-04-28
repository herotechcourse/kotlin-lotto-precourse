package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `generates correct number of lottos`() {
        val lottoMachine = LottoMachine()
        val lottos = lottoMachine.generateLottos(5)
        
        assertThat(lottos).hasSize(5)
    }
    
    @Test
    fun `calculateWinningStatistics identifies first prize correctly`() {
        val lottoMachine = LottoMachine()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))) // Matches all numbers
        val results = lottoMachine.calculateWinningStatistics(lottos, winningNumbers, bonusNumber)
        
        assertThat(results[Rank.FIRST]).isEqualTo(1)
    }
    
    @Test
    fun `calculateWinningStatistics identifies second prize correctly`() {
        val lottoMachine = LottoMachine()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7))) // Matches 5 numbers + bonus
        val results = lottoMachine.calculateWinningStatistics(lottos, winningNumbers, bonusNumber)
        
        assertThat(results[Rank.SECOND]).isEqualTo(1)
    }
    
    @Test
    fun `calculateWinningStatistics counts multiple winners correctly`() {
        val lottoMachine = LottoMachine()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 10, 11, 12)), // 3 matches (FIFTH)
            Lotto(listOf(1, 2, 3, 10, 11, 12)), // 3 matches (FIFTH)
            Lotto(listOf(1, 2, 3, 4, 10, 11))   // 4 matches (FOURTH)
        )
        val results = lottoMachine.calculateWinningStatistics(lottos, winningNumbers, bonusNumber)
        
        assertThat(results[Rank.FIFTH]).isEqualTo(2)
        assertThat(results[Rank.FOURTH]).isEqualTo(1)
    }
} 