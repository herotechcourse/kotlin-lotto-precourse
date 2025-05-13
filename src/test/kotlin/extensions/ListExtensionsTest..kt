/**
 * Test for extension functions to `List<T>`
 */

package extensions

import java.util.stream.Stream

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments

class ListExtensionsTest {
    @ParameterizedTest
    @MethodSource("provideArgumentsForListFirstDuplicatesIndicesNoDuplicatesTest")
    fun <T> `List containsDuplicates no duplicates test`(aList: List<T>, expectedReturn: Pair<Int, Int>) {
        assertThat(aList.containsDuplicates()).isEqualTo(expectedReturn.first != expectedReturn.second)
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForListFirstDuplicatesIndicesDuplicatesTest")
    fun <T> `List containsDuplicates duplicates test`(aList: List<T>, expectedReturn: Pair<Int, Int>) {
        assertThat(aList.containsDuplicates()).isEqualTo(expectedReturn.first != expectedReturn.second)
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForListFirstDuplicatesIndicesNoDuplicatesTest")
    fun <T> `List firstDuplicatesIndices no duplicates test`(aList: List<T>, expectedReturn: Pair<Int, Int>) {
        assertThat(aList.firstDuplicatesIndices()).isEqualTo(expectedReturn)
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForListFirstDuplicatesIndicesDuplicatesTest")
    fun <T> `List firstDuplicatesIndices duplicates test`(aList: List<T>, expectedReturn: Pair<Int, Int>) {
        assertThat(aList.firstDuplicatesIndices()).isEqualTo(expectedReturn)
    }

    companion object {
        @JvmStatic
        private fun provideArgumentsForListFirstDuplicatesIndicesNoDuplicatesTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(emptyList<String>(), Pair(-1, -1)),
                Arguments.of(listOf<String>("alpha"), Pair(-1, -1)),
                Arguments.of(listOf<String>("alpha", "beta"), Pair(-1, -1)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma"), Pair(-1, -1)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta"), Pair(-1, -1)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "epsilon"), Pair(-1, -1)),
            )
        }

        @JvmStatic
        private fun provideArgumentsForListFirstDuplicatesIndicesDuplicatesTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf<String>("alpha", "alpha"), Pair(0, 1)),
                Arguments.of(listOf<String>("alpha", "beta", "alpha"), Pair(0, 2)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "alpha"), Pair(0, 3)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "alpha"), Pair(0, 4)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "epsilon", "alpha"), Pair(0, 5)),

                Arguments.of(listOf<String>("alpha", "beta", "beta"), Pair(1, 2)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "beta"), Pair(1, 3)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "beta"), Pair(1, 4)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "epsilon", "beta"), Pair(1, 5)),

                Arguments.of(listOf<String>("alpha", "beta", "gamma", "gamma"), Pair(2, 3)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "gamma"), Pair(2, 4)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "epsilon", "gamma"), Pair(2, 5)),

                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "delta"), Pair(3, 4)),
                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "epsilon", "delta"), Pair(3, 5)),

                Arguments.of(listOf<String>("alpha", "beta", "gamma", "delta", "epsilon", "epsilon"), Pair(4, 5)),
            )
        }

        
    }
}
