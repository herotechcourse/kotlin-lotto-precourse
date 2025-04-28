package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

 class LottoMachineTest
 {
   @Test
   fun `throws an exception with negative purchase amount` () {
       val exception = assertThrows(IllegalArgumentException::class.java) {
           LottoMachine(-1000)
       }
       assertEquals("[ERROR] Purchase amount must be greater than zero.", exception.message)
   }

   @Test
   fun `throws an exception with non-divisible amount` () {
       val exception = assertThrows(IllegalArgumentException::class.java) {
           LottoMachine(1001)
       }
       assertEquals("[ERROR] Purchase amount must be divisible by 1000.", exception.message)
   }

   @Test
   fun `test LottoMachine with valid amount creates instance`() {
       val lottoMachine = LottoMachine(2000)
       assertNotNull(lottoMachine)
   }
 }