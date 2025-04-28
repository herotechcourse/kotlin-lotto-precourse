package input

import error.util.getErrorMsgWithPrefix
import input.util.getValidatedLottoNumbers
import input.util.getValidatedTicketAmount
import input.util.readLineAndProcess

fun <T> processInput(operation: (String) -> T): T{
    var result: T? = null
    while(result == null){
        val input: String = readLineAndProcess()
        try{
            result = operation(input)
        } catch (e: NumberFormatException){
            println(e.message?.let { getErrorMsgWithPrefix(it) })
        }catch (e: IllegalArgumentException){
            println(e.message?.let { getErrorMsgWithPrefix(it) })
        }
    }
    return result
}

fun getLottoNumberArrayFromInput(): Array<Int> {
    return processInput { input -> getValidatedLottoNumbers(input) }
}
fun getTicketAmountFromInput(): Int{
    return processInput { input -> getValidatedTicketAmount(input) }
}