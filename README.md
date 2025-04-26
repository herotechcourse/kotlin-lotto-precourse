# kotlin-lotto-precourse

## Planned Features

- [X] Get user inputs
    - A user input for purchase amount (must be divisible by 1,000)
    - A user input for winning numbers (6 unique integers, comma-separated)
    - A user Input for bonus number (must not duplicate winning numbers)
    - Validate inputs and re-prompt on `IllegalArgumentException`

- [X] Generate lotto tickets
    - Create one ticket per 1,000 KRW (e.g., 8,000 → 8 tickets)
    - Each ticket has 6 unique random numbers between 1 and 45
    - Numbers must be sorted in ascending order

- [X] Compare tickets with winning numbers
    - Count how many numbers match
    - Check if the bonus number matches
    - Determine prize rank based on match count and bonus

- [ ] Print results
    - Display all issued lotto tickets
    - Show winning statistics (tickets per prize rank)
    - Calculate and print total return rate (rounded to 1 decimal place)
