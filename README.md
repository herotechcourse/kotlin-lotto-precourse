# Lotto Program

## Overview

This program simulates a lottery ticket machine where users can purchase tickets, input winning numbers, and check their prizes based on the lottery rules.

## Features

1. Get Purchase Amount and calculate the number of tickets
 * Validates that the amount is divisible by 1000 KRW
 * Calculates the number of tickets (amount / 1000)
 * Re-prompts on invalid input with [ERROR] message
2. Ticket Generation
 * Generates random unique numbers (1-45) for each ticket
 * Sorts numbers in ascending order
 * Stores all purchased tickets
3. Winning Numbers Input
 * Validates 6 unique numbers (1-45)
 * Validates comma-separated format
 * Re-prompts on invalid input with [ERROR] message
4. Bonus Number Input
 * Validates single number (1-45)
 * Validates the number is not in winning numbers
 * Re-prompts on invalid input with [ERROR] message
5. Prize Calculation
 * Compares each ticket with winning numbers
 * Counts matching numbers
 * Checks bonus number for 2nd prize eligibility
 * Calculates prize amounts based on matches:
   + 1st Prize: 6 matches (2,000,000,000 KRW)
   + 2nd Prize: 5 matches + bonus (30,000,000 KRW)
   + 3rd Prize: 5 matches (1,500,000 KRW)
   + 4th Prize: 4 matches (50,000 KRW)
   + 5th Prize: 3 matches (5,000 KRW)
6. Statistics Display
 * Counts tickets per prize rank
 * Calculates total winnings
 * Calculates profit rate (winnings / amount * 100)
 * Displays formatted results
7. Error Handling
 * Custom exceptions with [ERROR] prefix
 * Clear error messages for invalid inputs
 * Re-prompt mechanism for invalid inputs

 ## **Technical Requirements**

 ### Programming Constraints

 * Kotlin 1.9.24
 * No external libraries except provided ones
 * No System.exit() or exitProcess()
 * Strict indentation depth (max 2 levels)
 * Small, focused functions (max 10 lines)
 * Avoid else statements
 * Proper use of Enum classes
 * Separation of business and UI logic

 ### Testing
 * JUnit 5 and AssertJ for unit tests
 * Comprehensive test coverage
 * Parameterized tests where applicable
 

 ### Code Organization
* Dedicated classes for input/output
* Proper package organization
* Follows Kotlin Coding Conventions

### How to Use

 1. Run the program (Application.kt)
 1. Enter purchase amount (must be multiple of 1000)
 1. Program displays purchased tickets
 1. Enter winning numbers (6 unique, comma-separated, 1-45)
 1. Enter bonus number (unique from winning numbers, 1-45)
 1. View results including:

    + Number of winning tickets per rank
    + Total winnings
    + Profit rate

### Error Handling

The program provides clear error messages and re-prompts for:

 * Invalid purchase amounts
 * Invalid ticket numbers
 * Invalid winning number format
 * Duplicate or out-of-range numbers
 * Invalid bonus numbers
