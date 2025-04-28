package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

 class WinningLottoTest {
   @Test
   fun `throws an exception when winning numbers exceed six`() {
       val exception = assertThrows(IllegalArgumentException::class.java) {
        WinningLotto(listOf(1, 2, 3, 4, 5, 6, 7), 10)
       }
       assertEquals(
        "[ERROR] Winning numbers must contain exactly 6 numbers.",
        exception.message
       )
   }

   @Test
   fun `throws an exception with numbers not in range 1-45`() {
       val exception = assertThrows(IllegalArgumentException::class.java) {
           WinningLotto(listOf(0, 10, 46, 23, 32, 5), 10)
       }
       assertEquals(
           "[ERROR] Lotto numbers must be between 1 and 45.",
           exception.message
       )
   }

     @Test
     fun `throws an exception when winning numbers are less than six`() {
         val exception = assertThrows(IllegalArgumentException::class.java) {
             WinningLotto(listOf(1, 2, 3, 4, 5), 10)
         }
         assertEquals(
             "[ERROR] Winning numbers must contain exactly 6 numbers.",exception.message
         )
     }

     @Test
     fun `throws an exception when bonus number is not in range 1-45`() {
         val exception = assertThrows(IllegalArgumentException::class.java) {
             WinningLotto(listOf(1, 2, 3, 4, 5, 6), 0)
         }
         assertEquals(
             "[ERROR] Bonus number must be between 1 and 45.",exception.message
         )
     }

     @Test
     fun `throws an exception when bonus is a part of winning numbers`() {
         val exception = assertThrows(IllegalArgumentException::class.java) {
             WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
         }
         assertEquals(
             "[ERROR] Bonus number cannot be one of the winning numbers.",exception.message
         )
     }

     @Test
     fun `throws an exception when winning numbers are duplicates`() {
         val exception = assertThrows(IllegalArgumentException::class.java) {
             WinningLotto(listOf(1, 2, 3, 4, 5, 5), 10)
         }
         assertEquals(
             "[ERROR] Winning numbers cannot contain duplicates.",exception.message
         )
     }

     @Test
     fun `test WinningLotto with valid numbers creates instance`() {
         val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 10)
         assertNotNull(winningLotto)
     }
 }