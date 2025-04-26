# kotlin-lotto-precourse
## Feature List
### 1. Ticket Purchase Flow
- Prompt and take user input for purchase amount
- Validate purchase amount is numeric and divisible by 1,000 KRW
- Generate tickets: 6 unique random numbers per ticket in the range 1–45
- Display issued tickets in ascending order
### 2. Winning Numbers Input
- Prompt and take input for winning numbers (6 unique numbers)
- Validate winning numbers: numeric, range 1–45, and unique
- Prompt and take input for bonus number
- Validate bonus number: numeric, range 1–45, and not included in winning numbers
### 3. Prize Evaluation
- Determine prize rank for each ticket
- Calculate and display total profit rate (rounded to one decimal place)
### 4. Output & Error Handling
- Print all output in specified format
- Handle invalid input with specific exceptions
- Re-prompt user on invalid input with `[ERROR]` message prefix