package lotto.InputValidation

class `AmountValidation` {
    fun NullCheckAmount(amount : String) : Int{
        if(amount.isEmpty() || amount.toIntOrNull() == null) throw IllegalArgumentException("[ERROR] Input needs to be an integer")
        return amount.toInt()
    }
    fun ValidateAmount(amount: Int){
        if(amount <= 0 ) throw IllegalArgumentException("[ERROR] Amount entered must be a valid number greater than 0")
        if(amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount entered must be multiple of 1000")
    }

}