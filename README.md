# Lotto Application

## Overview
A simple lottery ticket simulator where users can purchase lotto tickets, input winning numbers, and view their winning statistics.

## Features
- Purchase lotto tickets based on user-inputted amount
- Display issued lotto numbers in ascending order
- Accept last week's winning numbers input
- Accept a bonus number input
- Compare each lotto ticket with the winning numbers
- Determine prize ranks according to the number of matches and bonus ball
- Display winning statistics by prize rank
- Calculate and display the total return rate
- Validate inputs and display appropriate error messages for invalid inputs (e.g., invalid amount, duplicate numbers, numbers out of range)

## Error Handling
- Inputs outside the allowed range (1–45) trigger an error.
- Duplicate numbers in a single ticket or in winning numbers are rejected.
- The purchase amount must be a multiple of 1,000.

## Requirements
- Kotlin 1.9.24
- JUnit5 and AssertJ for testing
- Follow Kotlin Coding Conventions