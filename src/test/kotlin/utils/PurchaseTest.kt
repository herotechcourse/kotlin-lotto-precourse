package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PurchaseTest{
    @Test
    fun `the number of lotto must be equal to user input`(){
        val userInput = 2
        var purchase = Purchase.make(2)
        assertEquals(userInput,purchase.item.size)
    }
}