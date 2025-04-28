# kotlin-lotto-precourse

1. ### Introduce Prize Ranks
- **Action**:
  * Define the prize ranks based on the number of matching numbers and the bonus number.
- **Rank Definitions**:
  * No Rank: 0 matching numbers.
  * Fifth Rank: 3 matching numbers.
  * Fourth Rank: 4 matching numbers.
  * Third Rank: 5 matching numbers.
  * Second Rank: 5 matching numbers + bonus number.
  * First Rank: 6 matching numbers.

2. ### User Input: Purchase Amount
- **Action**: 
  * Prompt the user to enter the total amount of money they wish to spend on lottery tickets. 
  * Based on the user’s purchase amount, the program calculates how many tickets the user can buy (1 ticket = 1000 KRW).
- **Validation**:
  * The input must be a valid number (integer).
  * The input must not be empty.
  * The input must be divisible by 1000 (since each ticket costs 1000). 
- **Error Handling**: 
  * If the user inputs invalid data (non-digit, empty input, or not divisible by 1000), the program will throw an IllegalArgumentException and prompt the user to re-enter the purchase amount until the input is valid.

3. ### Ticket Generation
- **Action**: 
  * Generate a specified number of lottery tickets. 
- Logic: 
  * Each ticket consists of 6 unique numbers, randomly selected from 1 to 45. 
- Validation:
  * Each ticket must have exactly 6 unique numbers.
  * Numbers must fall within the range from 1 to 45.

4. ### User Input: Winning Numbers
- **Action**: 
  * Prompt the user to enter the 6 winning numbers for the lottery draw, followed by a bonus number. 
- **Validation**:
  * The input must not be empty.
  * The input must be valid integers (numbers between 1 and 45).
  * The 6 winning numbers must be unique.
  * The bonus number must be distinct from the winning numbers. 
- Error Handling:
  * If the input is invalid (non-digit, out of range, not exactly 6 numbers, or bonus number is a duplicate), the program will throw an IllegalArgumentException and re-prompt the user to input the winning numbers until the input is correct.

5. ### Compare User Tickets to Winning Numbers
- **Action**: 
  * For each ticket, compare the numbers to the winning numbers and bonus number.
- **Logic**:
  * Check how many numbers on the ticket match the winning numbers. 
  * Check if the bonus number is included in the ticket. 
  * Based on the match count and whether the bonus number is present, assign a rank to the ticket.

6. ### Total Return Rate Calculation
- **Action**: 
  * Calculate the total winnings based on the prize ranks of all tickets. 
- **Logic**:
  * The total winnings are computed by multiplying the number of tickets in each rank by the prize associated with that rank.
  * The return rate is calculated as the percentage of total winnings relative to the purchase amount.

7. ### Print the Result
- **Action**: 
  * Display the result to the user. 
- **Output**:
  * Print the statistics showing how many tickets achieved each prize rank (e.g., how many first-place, second-place, etc.). 
  * Show the total winnings for each rank. 
  * Display the return rate, which represents the percentage of the total winnings relative to the amount spent.