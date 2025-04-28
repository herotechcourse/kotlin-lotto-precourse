# kotlin-lotto-precourse

## Features

### Lotto class
- [x] Encapsulate lottery ticket data with 6 unique numbers
- [x] Validate ticket constraints

### Input 
- [x] Get lottery ticket purchase amount. (Higher than 1000)
- [x] Get Winning numbers. (Consist of 6 unique numbers between 1~45)
- [x] Get bonus number. (A number between 1~45)
- [x] Throw IllegalArgumentException and get new input if the input is invalid.  

### Generate lottery ticket
- [x] Issue as many lottery tickets as the budget allows. (1000KRW per lottery ticket)
- [x] Generate 6 random unique numbers between 1~45 to make lottery ticket.

### Check Lotto result
- [x] Check how many numbers match the winning number.
- [x] Check the number of matching tickets for each prize category
- [x] Prize categories:
- 1st Prize (6 matches): 2,000,000,000 KRW
- 2nd Prize (5 matches + bonus number): 30,000,000 KRW
- 3rd Prize (5 matches): 1,500,000 KRW
- 4th Prize (4 matches): 50,000 KRW
- 5th Prize (3 matches): 5,000 KRW

### Calculate profit rate 
- [x] Calculate profit rate as (winnings / purchase amount) * 100

### Output 
- [x] Print lottery tickets that are purchased. 
- [x] Print result statistics. 
- [x] Print profit rate.

### Test
- [x] Gets new input when input is invalid. 
- [x] Generates as many lottery tickets as the budget allows.
- [x] Generates 6 random unique numbers between 1~45 to make lottery ticket.
- [x] Checks lotto results.
- [x] Calculates profit rate. 
- [x] Handles zero purchase amount cases
- [x] Tests statistics collection for all prize ranks (3,4,5,5+bonus,6 matches)
- [x] Verifies profit rates for different winning combinations

### Class Structure
- Application: Main entry point for the program
- Lotto: Represents a lottery ticket
- LottoGenerator: Creates random lottery tickets
- InputView: Handles user input
- OutputView: Displays output to the user
- TicketChecker: Compares tickets with winning numbers
- Rank: Enum representing prize tiers
- ProfitRateCalculator: Calculates return rate