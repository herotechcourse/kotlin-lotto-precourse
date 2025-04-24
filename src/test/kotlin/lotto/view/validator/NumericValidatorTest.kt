package lotto.view.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class NumericValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", " ", "", "1a", "1-2"])
    fun `Throws when value is not numeric`(input: String) {
        assertThrows<IllegalArgumentException>("input ${input} shold throw error") { NumericValidator.validate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["11", "15", "111", "222"])
    fun `Does not throw when value is numeric`(input: String) {
        assertDoesNotThrow("input ${input} should not throw error") { NumericValidator.validate(input) }
    }

}