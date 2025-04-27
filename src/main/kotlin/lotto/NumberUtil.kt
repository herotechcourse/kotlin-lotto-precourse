package lotto

import java.text.DecimalFormat

object NumberUtil {

    private const val COMMA_PATTERN = "#,###"
    private const val COMMA_ONE_DECIMAL_PATTERN = "#,##0.0"

    fun Int.formatInt(): String = DecimalFormat(COMMA_PATTERN).format(this)

    fun Double.formatDouble(): String = DecimalFormat(COMMA_ONE_DECIMAL_PATTERN).format(this)
}
