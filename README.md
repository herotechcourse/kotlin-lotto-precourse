# Lotto Application

This application simulates a lottery game where users can purchase tickets and check their winnings against the weekly results.

## Planned Features

### 1. Ticket Purchase
- Allow users to buy lottery tickets by entering a purchase amount
- Validate that the purchase amount is a multiple of 1,000 KRW
- Generate random lottery tickets (6 unique numbers between 1-45)
- Display all purchased tickets to the user

### 2. Winning Numbers
- Allow users to enter the winning lottery numbers
- Validate that exactly 6 unique numbers between 1-45 are entered
- Allow users to enter a bonus number
- Validate that the bonus number is between 1-45 and not among the winning numbers

### 3. Prize Calculation
- Match user tickets against winning numbers
- Calculate prizes based on the match count and bonus number:
    - First Prize (6 matches): 2,000,000,000 KRW
    - Second Prize (5 matches + bonus): 30,000,000 KRW
    - Third Prize (5 matches): 1,500,000 KRW
    - Fourth Prize (4 matches): 50,000 KRW
    - Fifth Prize (3 matches): 5,000 KRW

### 4. Results Display
- Show detailed statistics of the lottery results
- Display the number of tickets for each prize rank
- Calculate and show the total return rate

### 5. Error Handling
- Provide clear error messages for invalid inputs
- Handle exceptions gracefully with appropriate user feedback
- Allow retry after errors

## Technical Components

### MVC Architecture
- **Model**: Lotto, WinningLotto, LottoResult, PrizeRank
- **View**: InputView, OutputView
- **Controller**: LottoController
- **Service**: LottoService

### Input Validation
- Purchase amount validation
- Lottery number validation
- Bonus number validation

### Unit Testing
- Test cases for model validation
- Test cases for service logic
- Error case testing

## How to Use

1. Run the application
2. Enter the purchase amount (must be a multiple of 1,000 KRW)
3. View your randomly generated lottery tickets
4. Enter last week's winning numbers (6 unique numbers between 1-45)
5. Enter the bonus number (between 1-45, not in winning numbers)
6. View the lottery results and your return rate