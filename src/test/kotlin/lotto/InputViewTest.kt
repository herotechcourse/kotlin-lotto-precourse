package lotto

import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertThrows


class InputViewTest{
    val inputView = InputView()


    @Test
    fun `convert string to list`(){
        val input="1,2,3,4,5,6"
        assertThat(inputView.generateWinNum(input)).isEqualTo(listOf(*input.split(',').map { it.toInt() }.toTypedArray()))
    }
    @Test
    fun `should return true if input is numeric`(){
        val input="4"
        assertThat(inputView.isNumeric(input)).isTrue()
    }


    @Test
    fun `should return errorType if purchase amount doesn't satisfy the condition`(){
        val purchaseAmount="100"
        assertThat(inputView.errorPurchase(purchaseAmount)).isEqualTo(InputView.ERROR_MESSAGE_DIV)
    }

    @Test
    fun `should return empty if list satisfies all condition`(){
        val winNumbers="3,6,1,34,5,7"
        assertThat(inputView.errorWinNum(winNumbers)).isEmpty()
    }

    @Test
    fun `should return errorType if  list doesn't satisfy the format`(){
        val input="1,2,"
        assertThat(inputView.checkWinFormat(input)).isEqualTo(InputView.ERROR_MESSAGE_CONFUSE)
    }

    @Test
    fun `should return empty if winning list satisfies specific condition`(){
        val winngNumbers= "1,2,3,4,5,6"
        assertThat(inputView.checkWinType(winngNumbers).isEmpty())
    }

    @Test
    fun `should return errorType if input doesn't contain commas`(){
        val data="12345"
        assertThat(inputView.containCommas(data)).isEqualTo(InputView.ERROR_MESSAGE_COMMA)
    }
    @Test
    fun `should return errorType if duplicate values are found in the list`(){
        val data= listOf("1","1","2","3","4","5")
        assertThat(inputView.hasDuplicate(data)).isEqualTo(InputView.ERROR_MESSAGE_DUPL)
    }

    @Test
    fun `should return errorType if list contains non-number values`(){
        val input="hello,hero,1,2,3"
        assertThat(inputView.checkWinNumeric(input)).isEqualTo(InputView.ERROR_MESSAGE_WINNUM)
    }

    @Test
    fun `should return empty if all conditions are met`(){
        val input="3"
        assertThat(inputView.checkInRange(input)).isEmpty()
    }

    @Test
    fun `should return errorType when fail to parse input as a number`(){
        val input="hero"
        assertThat(inputView.convertNum(input)).isEqualTo(InputView.ERROR_SINGLE)
    }

    @Test
    fun `should return errorType if num is out of range`(){
        val num="0"
        assertSimpleTest{
            assertThat(inputView.numInRange(num)).isEqualTo(InputView.ERROR_MESSAGE_RANGE)
        }
    }


    @Test
    fun `should return errorType if num in list is out of range`(){
        val num="0,1,2,3,4,5"
        assertSimpleTest{
            assertThat(inputView.checkListInRange(num)).isEqualTo(InputView.ERROR_MESSAGE_RANGE)
        }
    }

    @Test
    fun `should throw illegalArgumentException if bonusNum is already in winningNumbers`(){
        val bonus="3"
        val winningNumbers= listOf(1,2,3,4,5,6)

        assertThrows<IllegalArgumentException>{
            inputView.duplicateBonusNum(bonus,winningNumbers)
        }
    }

    @Test
    fun `check bonusNumber is single`(){
        val bonus = "3,5,6"
        assertSimpleTest{
            val result = inputView.isSingleBonus(bonus)
            assertThat(result).isEqualTo(InputView.ERROR_SINGLE)
        }
    }


}