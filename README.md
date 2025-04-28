# kotlin-lotto-precourse

A simple lottery game will be implemented to complete Hero Tech Course Precourse Task 2.

### Overview

This project is a lottery game that allows players to buy tickets in desired amount.
Players should input 6 unique numbers and a bonus number between 1 and 45.
There are five prize ranks. Players win a prize depending on the number of matches. 
The profit rate is calculated based on the prize ranks achieved by players. 

### Features

- Accept the purchase amount input entered by the user
  - Must be divisible by 1000
  - Must be larger than or equal to 1000

- Accept the winning numbers input entered by the user
    - Must be comma-separated
    - Each number must be between 1 and 45
    - Each number must be unique

- Accept the bonus number input entered by the user
  - Must be between 1 and 45
  - Must be different from the winning numbers

#### Winning Prizes
There are five prize ranks based on how many numbers are matched:
- 6 matching numbers: 1st place
- 5 matching numbers + bonus: 2nd place
- 5 matching numbers: 3rd place
- 4 matching numbers: 4th place
- 3 matching numbers: 5th place

### Programming Requirements
- Kotlin 1.9.24
- JUnit for testing
- AssertJ for assertions


### Testing/Unit Testing
- Input validation
- Number generation
- Prize calculations
- Return rate calculation
- Error handling

### Error Messages
The program will let you know if something's not right with clear error messages:
- If your purchase amount isn't valid
- If your numbers are out of range
- If you enter duplicate numbers
- If your bonus number isn't valid
