package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PrizeTest{


    @Test
    fun `match winner type and prize amounts`(){
        assertThat(Prize.getMoney("6")).isEqualTo(2000000000)
    }


}