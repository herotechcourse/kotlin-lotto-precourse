# kotlin-lotto-precourse

## Features
- Prompt the user to input the purchase amount for lottery tickets. 
  - The amount entered by the user must be divisible by 1,000 KRW (since each ticket costs 1,000 KRW). 
  - If the amount is not divisible by 1,000, throw an IllegalArgumentException and re-prompt the input. 
  - If the amount entered is not a valid number, throw an IllegalArgumentException and re-prompt the input. 
  - If the amount is not greater than zero, throw an IllegalArgumentException and re-prompt the input. 
- Calculate the number of lottery tickets to issue based on the input amount. 
- Generate unique random lottery numbers for each purchased ticket. 
  - Each ticket should consist of 6 unique random numbers within the range of 1 to 45.
- Prompt the user to input the winning lottery numbers and a bonus number. 
  - The winning numbers must consist of exactly 6 unique numbers within the range of 1 to 45. 
  - If the user enters duplicate numbers, if the set size is not six, or if any number is out of the 1-45 range, throw an IllegalArgumentException.
  -  The bonus number must be a unique number between 1 and 45 that does not overlap with any of the winning numbers.
  - If the bonus number is duplicate, out of range, or already present in the winning numbers, throw an IllegalArgumentException and prompt the user to enter it again.
- Compare each purchased ticket with the winning numbers to determine the prize. 
  - The prize tiers are as follows:
    - 1st Prize: Match 6 numbers / 2,000,000,000 KRW
    - 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
    - 3rd Prize: Match 5 numbers / 1,500,000 KRW
    - 4th Prize: Match 4 numbers / 50,000 KRW
    - 5th Prize: Match 3 numbers / 5,000 KRW
- Calculate the return rate based on total winnings and total amount spent. 
- Display the complete lottery results. 
  - Display the user's purchased tickets, the winning numbers (including the bonus number), the number of matched numbers for each ticket, the prize tier for each ticket, and the overall return rate.

## Functional Requirements
- Input validation for purchase amount:
  - Ensure the input is numeric and divisible by 1,000. 
  - Ensure the input is greater than zero.
- Ticket generation:
  - Each ticket must have 6 unique random numbers between 1 and 45. 
- Winning numbers validation:
  - Ensure the winning numbers are unique and consist of exactly 6 numbers between 1 and 45. 
  - Ensure the bonus number is unique and within the valid range.
- Bounus number validation:
  - The bonus number must be a unique number between 1 and 45 that does not overlap with any of the winning numbers.
- Prize calculation:
  - Compare purchased tickets with winning numbers and assign the corresponding prize.
- Return rate calculation:
  - Calculate the return rate based on total amount spent and total winnings.
- Display results:
  - Show the purchased tickets, matching results, prize tiers, and overall return rate.

**If the input does not meet the specified conditions, the user will be prompted to re-enter the input until valid data is provided.**

