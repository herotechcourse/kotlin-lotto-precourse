# kotlin-lotto-precourse

A console-based lottery ticket machine implemented in Kotlin, where the user inputs an amount and the program generates
lottery tickets based on the entered amount.

## Features

### Lotto Class

- Represents a single lottery ticket
- Contains exactly 6 unique numbers between 1 and 45
- Validates that numbers are unique and within valid range
- Provides methods to count matches with winning numbers
- Checks if it contains a specific bonus number
- Override `toString()` to print with correct format

### Input Processing

- Purchase Amount Parser
    - Validates that input is a valid integer
    - Confirms amount is divisible by 1,000 KRW
    - Throws IllegalArgumentException for invalid inputs
- Winning Numbers Parser
    - Accepts comma-separated numbers (e.g., "1,2,3,4,5,6")
    - Validates that exactly 6 unique numbers are provided
    - Confirms all numbers are within range 1-45
    - Throws IllegalArgumentException for invalid inputs
- Bonus Number Parser
    - Validates that input is a valid integer between 1-45
    - Confirms bonus number is not among winning numbers
    - Throws IllegalArgumentException for invalid inputs

### Ticket Generation

- Generates the appropriate number of tickets based on purchase amount
- Each ticket costs exactly 1,000 KRW
- Uses random number generation to create unique sets of 6 numbers per ticket
- Ensures all numbers in each ticket are unique and within valid range (1-45)

### Prize Structure

- Implements the following prize tiers:
    1. 1st Prize (6 matches): 2,000,000,000 KRW
    2. 2nd Prize (5 matches + bonus): 30,000,000 KRW
    3. 3rd Prize (5 matches): 1,500,000 KRW
    4. 4th Prize (4 matches): 50,000 KRW
    5. 5th Prize (3 matches): 5,000 KRW
- Tracks the count of winning tickets in each prize tier

### Result Calculation

- Compares each ticket against winning numbers
- Determines match count for each ticket
- Checks for bonus number when relevant (5 matches)
- Calculates total winnings across all tickets
- Computes return rate (total winnings / purchase amount × 100%)

### Output Display

- Shows the number of purchased tickets
- Displays each generated ticket's numbers in ascending order
- Presents winning statistics for each prize tier
- Shows the total return rate as a percentage with one decimal place (62.5%)
- Format the money to correct decimal format (2,000,000,000 KRW)

### Error Handling

- Uses IllegalArgumentException for invalid user inputs:
    - Non-numeric inputs
    - Amounts not divisible by 1,000
    - Invalid number ranges
    - Duplicate numbers
    - Wrong number of inputs
    - Wrong separator (spaces instead of commas)
- All error messages are prefixed with "[ERROR]"
- Re-prompts for input after any error
