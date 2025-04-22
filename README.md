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

### Programming Requirements
The program must be executable with Kotlin 1.9.24


### Testing/Unit Testing
Unit tests will be implemented using JUnit and AssertJ.
