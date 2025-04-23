# kotlin-lotto-precourse

## Program Introduction
The program allows user to purchase lottery tickets, enter winning numbers, and calculate the result and profit rate based on the match between purchased tickets and the winning numbers.

## Feature List

- **Purchase Amount Input**  
  - Get purchase amount from user input
  - Exception handling:
    - Amount must be numeric value
    - Amount must be 0 or greater

- **Ticket Count Calculation**
  - Calculate the number of tickets by dividing the purchase amount by 1000

- **Lottery Tickets Generating Logic**
  - Generate 6 unique random numbers in the range from 1 to 45
  - Generate tickets based on the ticket count
  - Sort in ascending order

- **Winning numbers Input**
  - Get winning numbers from user input (comma-separated)
  - Exception handling:
    - Get Exactly 6 numbers
    - Get numeric value 
    - Numbers must be in the range from 1 to 45
    - Each of numbers must be unique.
  
- **Bonus number Input**
  - Get the bonus number from user input
  - Exception handling:
    - The input must be a numeric value
    - The number must be in the range from 1 to 45
    - The number must not duplicate any of the winning numbers
    
- **Display Lotto Tickets**
  - Display all the tickets purchased by user

- **Lotto Result Calculation**
  - Check how many numbers on each ticket match the winning numbers and the bonus number
  - Save the result based on the number of matching numbers

- **Profit Calculation**
    - Calculate the profit rate based on total prizes and total expenses
    - Round the profit rate to the nearest tenth

- **Display Lotto result statistics**
  - Show the number of tickets per matching result
  - Show the calculated profit rate
