# kotlin-lotto-precourse

## Data Structures

- **Lotto**: 
  - Store 6 unique numbers representing a lottery ticket.
  
- **WinningLotto**: 
  - Store the winning numbers and bonus number.
  - Methods to compare and count matches with a given `Lotto`.

- **Service**: 
  - Handle ticket generation, comparison, and result calculations.

## UI Logic

- **InputView**: 
  - Ask for and validate:
    - Purchase amount.
    - Last week's winning numbers.
    - Bonus number.

- **OutputView**:
  - Display:
    - Number of tickets and their numbers.
    - Match statistics and return rate.

## Game Logic

- **Generate Tickets**: 
  - Calculate the number of tickets based on the purchase amount and generate random tickets.
  
- **Evaluate Tickets**: 
  - Compare each ticket with the winning numbers and bonus number.
  
- **Display Results**: 
  - Show match statistics (number of matches per rank).
  - Calculate and display the total return rate (profit/loss).

## Error Management

- Handle invalid inputs (e.g., purchase amount < 1000, invalid numbers).
- Validate all inputs before proceeding.

## Tests

- Test individual components like `Lotto`, `WinningLotto`, and `Service`.

