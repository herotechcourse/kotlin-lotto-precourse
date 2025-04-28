// src/main/kotlin/lotto/LottoExtensions.kt
package lotto

// private numbers 필드에 리플렉션으로 접근
private val numbersField = Lotto::class.java
    .getDeclaredField("numbers")
    .apply { isAccessible = true }

/** private numbers 필드를 꺼내 List<Int>로 반환 */
fun Lotto.getNumbers(): List<Int> =
    numbersField.get(this) as List<Int>

/** 꺼낸 숫자를 오름차순 정렬 */
fun Lotto.sortedNumbers(): List<Int> =
    getNumbers().sorted()

/** 당첨 번호 리스트와 비교해 일치 개수 계산 */
fun Lotto.countMatches(winning: List<Int>): Int =
    getNumbers().count { it in winning }

/** 보너스 번호 포함 여부 검사 */
fun Lotto.hasNumber(num: Int): Boolean =
    getNumbers().contains(num)
