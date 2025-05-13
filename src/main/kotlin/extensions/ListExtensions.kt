/**
 * extension functions to List<T>
 */

package extensions

/**
 * extension function to List<T>
 * Returns whether there are duplicates in the list.
 */
fun <T> List<T>.containsDuplicates() : Boolean {
    // source: https://stackoverflow.com/q/47200440#comment105915149_47200815
    return this.groupingBy { it }
        .eachCount()
        .any { it.value > 1 }
}

/**
 * extension function to `List<T>`
 * Returns a pair of indices of the first duplicate elements in the list.
 * Returns `Pair(-1, -1)` if no duplicates exist in the list.
 * Caller can verify if there are duplicates simply by checking of `.first` and `.second` match.
 */
fun <T> List<T>.firstDuplicatesIndices() : Pair<Int, Int> {
    for (i in 0..<(this.size - 1)) {
        val j = this.subList(i + 1, this.size).indexOf(this[i])
        if (j != -1) {
            return Pair(i, i + j + 1)
        }
    }
    return Pair(-1, -1)
}
