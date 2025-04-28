package lotto

class LottoError {
    companion object {
        private val errorMessages: Map<String, String> = mapOf(
            "error" to "[ERROR]",
            "isEmpty" to "should not be empty",
            "notDigit" to "should include only digits",
            "%1000" to "should be divided by 1000 without remainder",
            "size<6" to "size less then 6",
            "notUnique" to "elements are not unique",
            "notInRange1-45" to "elements are not in range 1..45",
            "inWinningNumbers" to "match number in winning numbers",
        )

        fun get(attributeName: String, errorCode: String): String {
            if (errorMessages.containsKey(errorCode))
                return "${errorMessages["error"]} $attributeName ${errorMessages[errorCode]!!}"
            return ""
        }
    }
}