package input

import camp.nextstep.edu.missionutils.Console
import error.util.getErrorMsgWithPrefix
import input.util.getNumbersFromInput

fun readLineAndProcess(): String {
    val line: String? = Console.readLine();
    if(line.isNullOrBlank())
        throw IllegalArgumentException();
    return line
}

fun getLottoNumberArrayFromInput(): Array<Int>{
    while(true){
        val input: String = readLineAndProcess()
        try{
            return getNumbersFromInput(input)
        } catch (e: NumberFormatException){
            println(e.message?.let { getErrorMsgWithPrefix(it) })
        }catch (e: IllegalArgumentException){
            println(e.message?.let { getErrorMsgWithPrefix(it) })
        }
    }

}