# kotlin-lotto-precourse

## Features to be implemented

### 1. User purchases the tickets

	1.1. User enters the total purchase amount (must be divisible by 1000 KRW)
        1.1.1. The user enters the total purchase amount, along with winning numbers and a bonus number
        1.1.2. The winning numbers and bonus number are within the range of 1 and 45
        1.1.3 The bonus number should not be the same as the winning number

	1.2. The machine calculates and issues the appropriate number of lottery tickets
        1.2.1. The machine calculates number of tickets based on the purchased amount divided by 1000
        
### 2. Generating lottery tickets

	2.1. Each ticket contains 6 unique random numbers between 1 to 45
        2.1.1. The machine allocates unique lotto numbers between 1 to 45 for the number of tickets that the user has purchased

### 3.  Calculating the prize

	3.1. Determine the rank based on the following rules:
		3.1.1. 1st Prize: Match 6 numbers / 2,000,000,000 KRW
		3.1.2. 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
		3.1.3. 3rd Prize: Match 5 numbers / 1,500,000 KRW
		3.1.4. 4th Prize: Match 4 numbers / 50,000 KRW
		3.1.5. 5th Prize: Match 3 numbers / 5,000 KRW
    3.2. Depending the number of matches and the bonus number match, the prizes are calculated accordingly

### 4. Display winnings and profit rate

	3.1. Compare each ticket with the winning numbers
	3.2. Calculate the total winnings and profit rate
	3.3. Display the winnings and profit rate 

_________________
## Test cases
    1. User input validations, for amount purchased, are done for the following cases:
        1.1 Illegal argument exception is thrown when the user enters 0 for the amount purchased
        1.2 Illegal argument exception is thrown when the user enters a negative number for the amount purchased 
        1.3 Illegal argument exception is thrown when the user enters a number that is not divisible by 1000 for the amount purchased
        1.4 Illegal argument exception is thrown when the user enters the amount purchased as empty
        1.5 The correctness of result is checked when the user enters the amount purchased is a valid number
        
    2. User input validations, for winning numbers are done for the following cases: 
        2.1 Illegal argument exception is thrown when the user enters null for winning numbers
        2.2 Illegal argument exception is thrown when 6 winning numbers are not entered by the user
        2.3 Illegal argument exception is thrown when winning numbers entered by the user are not in range of 1-45
        2.4 Illegal argument exception is thrown when winning numbers are not unique
        2.5 Feature testing to check correctness when numbers are entered by comma as delimiter and are split into list of integers

    3. User input validations for bonus numbers are done for the following cases:
        3.1 Illegal argument exception is thrown when the bonus number is null or empty
        3.2 Illegal argument exception is thrown when the bonus number is not in the range of 1-45
        3.3 Illegal argument exception is thrown when the bonus number is already contained in the list of winning numbers

    4. The lottery tickets are generated
        4.1 Validation for the number of tickets generated is done
        4.2 Validation to check if the numbers inside the tickets are duplicates is done

    5. Test case for the entire program was designed and passed

_________________
# Code Structure

### 1. The program starts from the Application.kt file. 
### 2. First the user enters the purchase amount. The amount is then checked if :
    1. It is null.
    2. It is empty.
    3. It is a negative number.
    4. It is divisible by 1000.

***If any validation fails, Illegal argument exception is thrown and the user is asked to enter the purchase amount again.
The user is re-prompted to enter until all validations pass.***
### 3. The user then enters the winning numbers. The winning numbers are checked if :
    1. If it is null.
    2. If not, it is split into list of integers. 
    The Lotto class is also invoked, where the following conditions are checked for the winning numbers :
    3. The winning numbers have 6 unique numbers.
    4. The winning numbers are in the range of 1 to 45.

***If any validation fails, Illegal argument exception is thrown and the user is asked to enter the winning numbers again.
The user is re-prompted to enter until all validations pass.***
### 4. The user then enters the bonus number. It is checked if :
    1. It is not empty or null.
    2. It is in the range of 1 to 45.
    3. It is different from the winning numbers.

***If any validation fails, Illegal argument exception is thrown and the user is asked to enter the bonus number again. 
The user is re-prompted to enter until all validations pass.***

### 5. Next the number of tickets that can be issued is called in the Lotto class. It is calculated as purchase amount divided by 1000.
### 6. The GenerateLottoTickets method is then called, where the tickets are generated. Each ticket contains 6 unique numbers ranging from 1 to 45.
### 7. The tickets are printed in the Output view class. 
### 8. The LottoMachine class is then invoked, where the matching happens. 
        1. Each generated ticket is checked with the winning numbers. The number of matches are counted.
        2. According to the number of matches, the enum returns the respective prize money.
        3. The total prize is also added.
### 9. The ProfitCalculation method in LottoMachine is then called to calculate the total return rate. 
### 10. The Output class then prints the prizes and their ticket count respectively.
### 11. The Output class also prints the total return rate.

_________________
## Test cases for each method is written in the program. 
## The code coverage is above 95% for all the classes. 
_________________
## Example Execution

```plain
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

Please enter last week's winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
---
3 Matches (5,000 KRW) - 1 ticket
4 Matches (50,000 KRW) - 0 tickets
5 Matches (1,500,000 KRW) - 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) - 0 tickets
6 Matches (2,000,000,000 KRW) - 0 tickets
Total return rate is 62.5%.

