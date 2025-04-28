package input

import error.util.getErrorMsgWithPrefix
import input.util.getNumbersFromInput
import input.util.readLineAndProcess

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

fun getTicketAmountFromInput(): Array<Int>{
    while(true){
        val input: String = readLineAndProcess()
        try{
            return getNumbersFromInput(input)
        } catch (e: NumberFormatException){
            println(e.message?.let { getErrorMsgWithPrefix(it) })
        }catch (e: IllegalArgumentException){
            // validate if number
            println(e.message?.let { getErrorMsgWithPrefix(it) })
        }
    }
}