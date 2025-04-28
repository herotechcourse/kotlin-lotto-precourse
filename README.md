# Lotto

Lotto is a console application where users can purchase lottery tickets, input winning numbers, and calculate their profit rate based on the results.

## Flow

1. Input purchase amount for buy the lottery tickets.
2. Print purchased lottery tickets with issued numbers (sorted)
3. Input last week's numbers
4. Input a bonus number.
5. Print lotto result statistics.
6. Print calculated Profit rate.

example:
```text
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
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
```

## Feature List

- **Purchase Lotto Tickets**
   - Allows users to input a purchase amount and issues the corresponding number of lottery tickets.
   - Each ticket contains 6 unique numbers ranging from 1 to 45, sorted in ascending order.
   - Prompts the user to re-enter if the input is invalid (e.g., negative numbers, non-numeric input).

- **Input Last Week's Winning Numbers**
   - Allows users to input the 6 winning numbers from the previous week.
   - Validates inputs to ensure there are no duplicates and all numbers are within the valid range.

- **Input Bonus Number**
   - Allows users to input a single bonus number.
   - Validates that the bonus number is within the range of 1 to 45 (it may overlap with the winning numbers).

- **Print Lotto Result Statistics**
   - Compares each purchased ticket against the winning numbers.
   - Categorizes results into 3 Matches, 4 Matches, 5 Matches, 5 Matches + Bonus Ball, and 6 Matches.
   - Displays the number of tickets and corresponding prize money for each category.

- **Calculate Profit Rate**
   - Calculates the total profit rate by comparing the total prize winnings to the total purchase amount.
   - Outputs the profit rate as a percentage.

- **Input Validation and Re-Prompting**
   - Performs input validation at every stage.
   - If invalid input is detected, displays an error message and re-prompts for correct input.

## Project Structure
```text
src/
├── main/
│    └── kotlin/
│         ├── lotto/            # Application entry point, views, and controllers
│         └── lotto/domain/     # Domain models (Lotto, LottoNumber, Rank, etc.)
└── test/
└── kotlin/
└── lotto/            # Unit and integration tests
```
- lotto/ : Main application logic such as input reading, output display, and game controller.
- lotto/domain/ : Core domain models and business logic (e.g., Lotto ticket, winning numbers, prize ranking).
- test/lotto/ : Test codes for verifying application and domain logic correctness.

## Build

```bash
./gradlew build
```

## Run

```bash
./gradlew run
```

## Run Test
```bash
./gradlew test
```
