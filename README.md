# kotlin-lotto-precourse

## Planned Features

1. **Purchase Amount Input**
    - Accept user input for lottery ticket purchase amount
    - Validate that the amount is divisible by 1,000 KRW (the cost of one ticket)
2. **Lottery Ticket Generation**
    - Generate lottery tickets with 6 unique random numbers (1-45)
    - Display generated tickets with numbers sorted in ascending order
3. **Winning Numbers Input**
    - Accept user input for 6 winning numbers and 1 bonus number
    - Validate that all numbers are unique and within range (1-45)
4. **Prize Calculation**
    - Compare each lottery ticket with winning numbers
    - Determine prize rank based on match count and bonus number
5. **Results Display**
    - Show statistics for each prize rank
    - Calculate and display the total return rate
6. **Error Handling**
    - Implement robust input validation
    - Display appropriate error messages for invalid inputs

## Features

- Purchase lottery tickets with a specified amount of money
- Generate random unique lottery numbers for each ticket
- Enter winning numbers and bonus number to check results
- Calculate prize ranks based on matching numbers
- Display statistics including winnings and profit rate

## Implementation Details

1. **User Input Handling**
   - Process purchase amount for lottery tickets
   - Validate input to ensure it's a valid number and divisible by 1,000
   - Process winning numbers and bonus number

2. **Lottery Ticket Generation**
   - Generate random unique numbers between 1 and 45
   - Sort numbers in ascending order for display

3. **Validation**
   - Ensure purchase amount is divisible by 1,000
   - Validate lottery numbers are within range 1-45
   - Ensure winning numbers and bonus number are valid

4. **Rank Determination**
   - Compare user tickets with winning numbers
   - Determine prize rank based on match count and bonus number

5. **Statistics Calculation**
   - Calculate number of tickets in each prize rank
   - Calculate total winnings and return rate

6. **Error Handling**
   - Handle invalid inputs with appropriate error messages

## How to Run

Use the provided Gradle wrapper to build and run the application:

```bash
./gradlew build
./gradlew run
```

To run tests:

```bash
./gradlew clean test
```