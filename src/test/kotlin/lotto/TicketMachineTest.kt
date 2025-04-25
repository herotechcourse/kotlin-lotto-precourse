package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TicketMachineTest {
    @Test
    fun `throws an exception if the purchase amount is less than 1000`(){
        assertThrows<IllegalArgumentException> {
            TicketMachine(0)
        }
    }

    @Test
    fun `throws an exception if the purchase amount is not divisible by 1000`(){
        assertThrows<IllegalArgumentException> {
            TicketMachine(1010)
        }
    }

    @Test
    fun `returns the amount of tickets equal to purchase amount divided by 1000`(){
        val machine = TicketMachine(20000)
        assert(machine.tickets.size == 20)
    }

    @Test
    fun `ticket contains six numbers`(){
        val machine = TicketMachine(4000)
        for (i in 0..3)
            assert(machine.tickets[i].size == 6)
    }

    @Test
    fun `ticket contains unique numbers`(){
        val machine = TicketMachine(4000)
        for (i in 0 until machine.tickets.size)
            assert(machine.tickets[i].size == machine.tickets[i].toSet().size)
    }

    @Test
    fun `ticket contains numbers in range from 1 to 45`(){
        val machine = TicketMachine(4000)
        val range = 1..45
        for (i in 0 until machine.tickets.size)
            for (j in 0..5)
                assert(machine.tickets[i][j] in range)
    }
}