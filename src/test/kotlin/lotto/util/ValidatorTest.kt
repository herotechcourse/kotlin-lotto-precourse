package lotto.util

import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Throws an exception when input is empty or null")
    fun isEmptyInputTest(input: String?) {
        assertThatThrownBy { Validator.isEmptyInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["12test", "test", "123123abc"])
    @DisplayName("Throws an exception when input contains non-digit characters")
    fun isDigitStringExceptionTest(input: String) {
        assertThatThrownBy { Validator.isDigitString(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "10000", "20000"])
    @DisplayName("Does not throw an exception when input contains only digits")
    fun isDigitStringTest(input: String) {
        assertThatNoException().isThrownBy { Validator.isDigitString(input) }
    }

    @ParameterizedTest
    @MethodSource("validNumberProvider")
    @DisplayName("Does not throw an exception when number is within the range")
    fun isNumberWithinRangeTest(number: Int, minNumber: Int, maxNumber: Int) {
        assertThatNoException().isThrownBy { Validator.isNumberWithinRange(number, minNumber, maxNumber) }
    }

    companion object {
        @JvmStatic
        fun validNumberProvider() = listOf(
            Arguments.of(5, 1, 10),
            Arguments.of(1, 1, 10),
            Arguments.of(10, 1, 10)
        )

        @JvmStatic
        fun invalidNumberProvider() = listOf(
            Arguments.of(5, 0, 4),
            Arguments.of(1, 2, 4),
            Arguments.of(10, 2, 8)
        )

        @JvmStatic
        fun validDivisibleNumber() = listOf(
            Arguments.of(1000, 1000),
            Arguments.of(10000, 2000),
            Arguments.of(20000, 5000)
        )

        @JvmStatic
        fun invalidDivisibleNumber() = listOf(
            Arguments.of(1000, 10000),
            Arguments.of(1234, 1000),
            Arguments.of(10000, 42)
        )

        @JvmStatic
        fun validListAndNumberProvider() = listOf(
            Arguments.of(listOf(1, 2, 3), 3),
            Arguments.of(listOf(1, 2, 3, 4, 5), 5),
            Arguments.of(listOf(1), 1)
        )

        @JvmStatic
        fun inValidListAndNumberProvider() = listOf(
            Arguments.of(listOf(1, 2, 3), 4),
            Arguments.of(listOf(1, 2, 3, 4, 5), 6),
            Arguments.of(listOf(1), 0)
        )

        @JvmStatic
        fun validListProvider() = listOf(
            Arguments.of(listOf("1", "2", "3", "4", "5")),
            Arguments.of(listOf("12", "34", "56", "78"))
        )

        @JvmStatic
        fun inValidListProvider() = listOf(
            Arguments.of(listOf("1", "1", "3", "4", "5")),
            Arguments.of(listOf("12", "12", "56", "78"))
        )

        @JvmStatic
        fun validListAndInputProvider() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5), 6),
            Arguments.of(listOf("12", "34", "56", "67"), "89")
        )

        @JvmStatic
        fun inValidListAndInputProvider() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5), 5),
            Arguments.of(listOf("12", "34", "56", "67"), "67")
        )
    }

    @ParameterizedTest
    @MethodSource("invalidNumberProvider")
    @DisplayName("Throws an exception when number is out of range")
    fun isNumberWithinRangeExceptionTest(number: Int, minNumber: Int, maxNumber: Int) {
        assertThatThrownBy { Validator.isNumberWithinRange(number, minNumber, maxNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2147483647", "1", "11111"])
    @DisplayName("Does not throw an exception when input is within integer range")
    fun isIntegerTest(input: String) {
        assertThatNoException().isThrownBy { Validator.isInteger(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2147483648", "1111111111111"])
    @DisplayName("Throws an exception when input is out of integer range")
    fun isIntegerExceptionTest(input: String) {
        assertThatThrownBy { Validator.isInteger(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @MethodSource("validDivisibleNumber")
    @DisplayName("Does not throw an exception when number is divisible by divisor")
    fun isDivisibleByTest(number: Int, divisor: Int) {
        assertThatNoException().isThrownBy { Validator.isDivisibleBy(number, divisor) }
    }

    @ParameterizedTest
    @MethodSource("invalidDivisibleNumber")
    @DisplayName("Throws an exception when number is not divisible by divisor")
    fun isDivisibleByExceptionTest(number: Int, divisor: Int) {
        assertThatThrownBy { Validator.isDivisibleBy(number, divisor) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @MethodSource("validListAndNumberProvider")
    @DisplayName("Does not throw an exception when list size matches expected number")
    fun isEqualListSizeTest(list: List<Int>, number: Int) {
        assertThatNoException().isThrownBy { Validator.isEqualListSize(list, number) }
    }

    @ParameterizedTest
    @MethodSource("inValidListAndNumberProvider")
    @DisplayName("Throws an exception when list size does not match expected number")
    fun isEqualListSizeExceptionTest(list: List<Int>, number: Int) {
        assertThatThrownBy { Validator.isEqualListSize(list, number) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @MethodSource("validListProvider")
    @DisplayName("Does not throw an exception when list has no duplicates")
    fun isNotDuplicateTest(list: List<String>) {
        assertThatNoException().isThrownBy { Validator.isNotDuplicate(list) }
    }

    @ParameterizedTest
    @MethodSource("inValidListProvider")
    @DisplayName("Throws an exception when list has duplicate elements")
    fun isNotDuplicateExceptionTest(list: List<String>) {
        assertThatThrownBy { Validator.isNotDuplicate(list) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @MethodSource("validListAndInputProvider")
    @DisplayName("Does not throw an exception when input is not in list")
    fun <T> isNotInListTest(list: List<T>, input: T) {
        assertThatNoException().isThrownBy { Validator.isNotInList(list, input) }
    }

    @ParameterizedTest
    @MethodSource("inValidListAndInputProvider")
    @DisplayName("Throws an exception when input is already in list")
    fun <T> isNotInListExceptionTest(list: List<T>, input: T) {
        assertThatThrownBy { Validator.isNotInList(list, input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
