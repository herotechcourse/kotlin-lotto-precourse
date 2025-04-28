package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UsersTicketsTest : NsTest() {
    private lateinit var instance: UsersTickets

    @Test
    fun `non-digit purchase amount test`() {
        assertSimpleTest {
            runException("8000j", "hh")
            assertThat(output()).contains("$ERROR_MESSAGE ${argumentsNames["purchaseAmount"]} ${errorMessages["notDigit"]}")
        }
    }

    @Test
    fun `empty purchase amount test`() {
        assertSimpleTest {
            runException(" ")
            assertThat(output()).contains("$ERROR_MESSAGE ${argumentsNames["purchaseAmount"]} ${errorMessages["isEmpty"]}")
        }
    }

    @Test
    fun `divided by 1000 with remainder purchase amount test`() {
        assertSimpleTest {
            runException("1100")
            assertThat(output()).contains("$ERROR_MESSAGE ${argumentsNames["purchaseAmount"]} ${errorMessages["%1000"]}")
        }
    }

    @Test
    fun `check purchase amount test`() {
        val amount = 10000
        assertSimpleTest {
            run(amount.toString())
            assertThat(instance.getPurchasedAmount()).isEqualTo(amount)
        }
    }

    @Test
    fun `generate one lotto ticket`() {
        val amount = 1000
        val ticket = listOf(8, 21, 23, 41, 42, 43)
        assertRandomUniqueNumbersInRangeTest(
            {
                run(amount.toString())
                assertThat(instance.getLottoTickets()).contains(ticket)
            },
            ticket,
        )
    }

    override fun runMain() {
        instance = UsersTickets()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
        private val argumentsNames: Map<String, String> = mapOf(
            "purchaseAmount" to "Purchase amount"
        )
        private val errorMessages: Map<String, String> = mapOf(
            "isEmpty" to "should not be empty",
            "notDigit" to "should include only digits",
            "%1000" to "should be divided by 1000 without remainder"
        )
    }
}