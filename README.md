# Lotto

## Description
Ths project is a console-based simulation of a simple ticket machine with the following rules:
- The user enters purchase amount, the program issues tickets based on the purchase amount
- Each ticket costs 1,000 KRW, so the amount must be divisible by 1,000
- Each lottery ticket consists of 6 unique random numbers - from 1 to 45
- The user then enters the winning numbers - 6 unique numbers, and a bonus number - a single, separate number. 
- There are five prize ranks. The criteria and prize amounts are as follows:
  - 1st Prize: Match 6 numbers / 2,000,000,000 KRW
  - 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
  - 3rd Prize: Match 5 numbers / 1,500,000 KRW
  - 4th Prize: Match 4 numbers / 50,000 KRW
  - 5th Prize: Match 3 numbers / 5,000 KRW
- The program compares the user's tickets to the winning numbers.
- Then prints the result, including winnings and profit rate.

## Features
1. Handle input of purchase amount
   - validate that input is a positive integer, divisible by 1,000
   - handle invalid input, throw IllegalArgumentException and re-prompt input
2. Generate lottery tickets
   - determine number of purchased tickets based on input amount
   - generate corresponding number of tickets, each has 6 unique numbers from 1 to 45
3. Display purchased tickets
4. Handle input of winning numbers
   - validate that input numbers are integer, unique, in correct range and the amount of numbers is correct
   - handle invalid input, throw IllegalArgumentException and re-prompt input
5. Handle input of bonus number
   - validate that input number is integer, different from winning numbers
   - handle invalid input, throw IllegalArgumentException and re-prompt input
6. Compare winning numbers with ticket numbers
7. Calculate how many numbers match in each ticket
8. Assign prize ranks to amount of matching numbers
9. Determine tickets that correspond to a prize rank
10. Calculate total earnings
11. Calculate profit rate
12. Display winnings statistics and profit rate
13. Implement unit tests for all logic except UI
