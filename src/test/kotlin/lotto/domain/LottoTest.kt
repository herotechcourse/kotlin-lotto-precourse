package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @Test
    fun `should create lotto with valid numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }
    
    @Test
    fun `should throw error when lotto has less than 6 numbers`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
    
    @Test
    fun `should throw error when lotto has more than 6 numbers`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 6, 7)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
    
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `should throw error when lotto has numbers out of range`(invalidNumber: Int) {
        assertThatThrownBy { 
            val numbers = listOf(1, 2, 3, 4, 5, invalidNumber)
            Lotto(numbers) 
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
    
    @Test
    fun `should throw error when lotto has duplicate numbers`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
    
    @Test
    fun `should return correct match count`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(3)
    }
    
    @Test
    fun `should correctly check if number is contained`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        
        assertThat(lotto.containsNumber(1)).isTrue
        assertThat(lotto.containsNumber(7)).isFalse
    }
} 