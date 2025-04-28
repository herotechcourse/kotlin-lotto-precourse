package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OutputViewTest{
     val outputView=OutputView()
    @Test
    fun `ensure that  the correct quantity of tickets is returned corresponding to the purchase amount`(){
        assertThat(outputView.generateTickets("8000").size).isEqualTo(8)
    }

    @Test
    fun `ensure that the eachList with a size of 6 has been generated`(){
        assertThat(outputView.makeRandomTicket().size).isEqualTo(6)
    }

    @Test
    fun `ensure that changeDecimalformat is working as intended`(){
        val profitrate=62.535
        assertThat(outputView.changeDecimalFormat(profitrate)).isEqualTo("62.5")
    }
}