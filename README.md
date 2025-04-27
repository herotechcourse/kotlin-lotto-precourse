# kotlin-lotto-precourse

## Program explanation
This program simulates buying lottery tickets, and running lottery to check if user tickets won in the lottery


## Features to be implemented
- Parse and validate purchase amount from user
  - throw an exception if amount is not dividable by 1000
  - throw an exception if amount is negative or zero
- Generate 6 random unique numbers for each ticket 
- Parse and validate unique 6 winning numbers
  - throw an exception if numbers are not unique
  - throw an exception if amount of entered numbers is less than 6
  - throw an exception if numbers are not in range 1-45
- Parse and validate unique bonus number
  - throw an exception if number already present in set of 6 numbers
  - throw an exception if number is not in range 1-45
- After throwing an exception, recover and give a possibility to user to re-enter the values
- Sort and display entered numbers in ascending order for all tickets
- Find the number of matches per ticket
- Group tickets based on the amount of matches between winning numbers and numbers in the ticket plus bonus number
- Calculate and display total winnings
- Calculate and display profit rate
  - Profit rate should be rounded to 1 decimal place


