package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {

    //로또는 6개의 숫자를 가져야함
    @Test
    fun `create lotto with 6 numbers`(){
        // given
        val numbers = listOf(1,2,3,4,5,6)

        // when
        val lotto = Lotto(numbers)

        // then
        assertThat(lotto.getNumbers()).hasSize(6)
    }

    // 중복된 숫자가 있으면 예외를 던짐
    @Test
    fun `throw exception if numbers are duplicated`() {
        // given
        val duplicated = listOf(1, 1, 1, 2, 3, 4)

        // when : The Lotto is created with duplicated numbers
        assertThatThrownBy { Lotto(duplicated) }

        // then : It should throw an IllegalArgumentException
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must contain 6 unique numbers")
    }

    // 숫자가 1~45 범위를 벗어나면 예외를 던짐
    @Test
    fun `throw exception if number is not between 1 and 45`() {
        //given
        val invalid = listOf(0, 1, 2, 3, 4, 50)

        // when & then
        assertThatThrownBy { Lotto(invalid) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must be between 1 and 45")
    }


}