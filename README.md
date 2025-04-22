# Lotto

This project written in Kotlin simulates a simple ticket machine for the Lottery.

User can buy lottery tickets and then compare if their numbers match the winning ones. Depending on how many numbers match, an amount of money will be assigned as a prize and the winning rate of return will be displayed.

> **Note:** when the user enters the winning numbers to compare against their tickets, they are not choosing a new winning number, they are entering the result of the last draw.

## Key features

### 1. Input purchase amount

- Validate that the input is a number divisible by 1000
- Invalid input triggers an IllegalArgumentException and a retry
- Calculate number of tickets to issue

### 2. Generate random tickets

- Each ticket contains 6 random numbers between 1 and 45
- Validate that the numbers are not repeated
- Sort the numbers in ascending order

### 3. Display tickets

- Show generated tickets on screen

### 4. Input winner numbers

- Validate that entered numbers are 6, separated by a comma
- Validate that numbers are unique and within the range 1-45
- Invalid input triggers an IllegalArgumentException and a retry.

### 5. Input bonus number

- Validate there is a single number and within the range 1-45
- Validate it is not one of the winning numbers
- Invalid input triggers an IllegalArgumentException and a retry.

### 6. Show winning stadistics

- Compare each ticket´s numbers to the winning numbers
- Determine prize rank based on the matchs
- Display the amount of tickets per rank

### 7. Show return rate

- Calculate return rate, rounded to one decimal place
- Display the return percentage on screen

## Testing

- Unit tests are written using **JUnit 5** and **AssertJ**.
- Tests cover input validation, ticket generation, number comparison, and prize calculation.

## Example execution

```
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
```
