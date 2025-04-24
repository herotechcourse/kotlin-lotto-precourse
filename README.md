# kotlin-lotto-precourse


## Features to be implemented

### 1. User purchases the tickets

	1.1. User enters the total purchase amount (must be divisible by 1000 KRW)
        1.1.1. The user enters the total purchase amount, along with winning numbers and a bonus number

	1.2. The machine calculates and issues the appropriate number of lottery tickets


### 2. Generating lottery tickets

	2.1. Each ticket contains 6 unique random numbers between 1 to 45


### 3.  Calculating the prize

	3.1. Determine the rank based on the following rules:
		3.1.1. 1st Prize: Match 6 numbers / 2,000,000,000 KRW
		3.1.2. 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
		3.1.3. 3rd Prize: Match 5 numbers / 1,500,000 KRW
		3.1.4. 4th Prize: Match 4 numbers / 50,000 KRW
		3.1.5. 5th Prize: Match 3 numbers / 5,000 KRW


### 4. Display winnings and profit rate

	3.1. Compare each ticket with the winning numbers
	3.2. Calculate the total winnings and profit rate
	3.3. Display the winnings and profit rate 
	
## Test cases
    User input validations, for amount purchased, are done for the following cases:
        1.1 Illegal argument exception is thrown when the user enters 0 for the amount purchased
        1.2 Illegal argument exception is thrown when the user enters a negative number for the amount purchased 
        1.3 Illegal argument exception is thrown when the user enters a number that is not divisible by 1000 for the amount purchased
        1.4 Illegal argument exception is thrown when the user enters the amount purchased as empty
        1.5 The correctness of result is checked when the user enters the amount purchased is a valid number
        
    User input validations, for winning numbers are done for the following cases: 
        2.1 Illegal argument exception is thrown when the user enters null for winning numbers
        2.2 Illegal argument exception is thrown when 6 winning numbers are not entered by the user
        2.3 Illegal argument exception is thrown when winning numbers entered by the user are not in range of 1-45
        2.4 Illegal argument exception is thrown when winning numbers are not unique
        2.5 Feature testing to check correctness when numbers are entered by comma as delimiter and are split into list of integers