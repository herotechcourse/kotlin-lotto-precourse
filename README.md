# kotlin-lotto-precourse
## Project Overview
- Enter a budget to buy lottery tickets (each costs 1,000 KRW).
- Generate tickets with 6 unique random numbers (1–45).
- Input 6 winning numbers and a bonus number.
- Check for prizes based on matches, with 5 prize ranks.
- See a summary of tickets, winnings, and profit rate.
### I focused on:
- **Clean code**: Meaningful names, small functions, and proper formatting.
- **Error handling**: Catching specific exceptions like `IllegalArgumentException`.
- **User experience**: Clear prompts and output, with retries for invalid inputs.
## Functional Requirements
The program meets all the assignment’s rules. Here’s how it handles each requirement:

| **Requirement** | **Implementation** |
|-----------------|-------------------|
| **Purchase Amount** | Users enter an amount. It must be divisible by 1,000. Invalid inputs (negative, non-numeric, or not divisible by 1,000) throw an `IllegalArgumentException` and prompt re-entry. |
| **Ticket Generation** | Each ticket has 6 unique random numbers (1–45). The program generates tickets based on the budget. |
| **Winning Numbers** | Users input 6 unique numbers (1–45) and a bonus number (1–45, not matching the winning numbers). Invalid inputs (duplicates, out-of-range, non-numeric) trigger an `IllegalArgumentException` and retry. |
| **Prize Calculation** | Tickets are checked against winning numbers for 5 prize ranks:<br>- **1st**: 6 matches → 2,000,000,000 KRW<br>- **2nd**: 5 matches + bonus → 30,000,000 KRW<br>- **3rd**: 5 matches → 1,500,000 KRW<br>- **4th**: 4 matches → 50,000 KRW<br>- **5th**: 3 matches → 5,000 KRW |
| **Output** | Shows:<br>- All tickets with numbers.<br>- Prizes per ticket.<br>- Total winnings.<br>- Profit rate: \[(Winnings - Amount) / Amount\] × 100%. |
| **Error Handling** | Uses `IllegalArgumentException` for invalid inputs and `IllegalStateException` for unexpected states. Avoids generic `Exception`. Retries on errors. |
## Code Structure
### Lotto
**Class** representing a lottery ticket with 6 unique numbers.

**Properties:**
- `numbers`: a list of 6 numbers.

  **Methods:**
- `getNumbers()`: returns the list of numbers.
- `contains(number: Int)`: checks if the number is present in the ticket.

### GeneratorTickets
**Object** responsible for generating random lottery tickets.

**Methods:**
- `generate()`: generates a new ticket with 6 unique numbers between 1 and 45.

### WinnerTickets
**Class** representing a winning ticket with a bonus number.

**Methods:**
- `matchCount(ticket: Lotto)`: returns the number of matching numbers.
- `hasBonus(ticket: Lotto)`: checks if the bonus number matches.
- `getRank(ticket: Lotto)`: returns the rank based on the number of matches.

### Rank
**Enum** representing possible results.

**Values:**
- `FIRST`: 6 matches.
- `SECOND`: 5 matches + bonus.
- `THIRD`: 5 matches.
- `FOURTH`: 4 matches.
- `FIFTH`: 3 matches.
- `WITHOUT`: fewer than 3 matches.

### Result
**Object** that calculates the number of wins for each rank.

**Methods:**
- `calculate`: returns the win count per rank.

### Input
**Object** responsible for getting input from the user.

### Output
**Object** responsible for displaying results to the user.

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