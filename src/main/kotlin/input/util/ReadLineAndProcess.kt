package input.util

import camp.nextstep.edu.missionutils.Console


fun readLineAndProcess(): String {
    val line: String? = Console.readLine();
    if(line.isNullOrBlank())
        throw IllegalArgumentException();
    return line
}
