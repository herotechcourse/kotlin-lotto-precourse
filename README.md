# Kotlin Lotto Precourse

## Introduction

A small lottery simulation game. The user can input the amount of money they want to
purchase tickets for and the game generates random lottery tickets. The user then inputs
the winning numbers and a bonus number. The program prints the result including the 
winnings and the according profit rate.

## Features

### User Interface
#### Input
1. [x] read user input
    1. [x] purchase amount (Int)
    2. [x] winning numbers (comma-separated list of Ints)
    3. [x] bonus number (Int)
2. [x] validate user input
    1. [x] purchase amount:
        1. [x] divisible by 1000
        2. [x] positive number
        3. [x] equal or lower than a maximum value
    2. [x] winning numbers:
        1. [x] comma separated
        2. [x] 6
        3. [x] unique
        4. [x] between 1 and 45
    3. [x] bonus number
        1. [x] between 1 and 45
        2. [ ] ? not duplicating a winning number?
3. [x] handle invalid input
    1. [x] throw exception with a message: “[ERROR] my message“
    2. [x] handle only specific exception types
    3. [x] re-prompt from current state 
    4. [x] quit after max retries are exceeded
       
#### Output
3. [ ] output the purchased tickets after reading the purchase amount
    1. [ ] the number of purchased tickets
    2. [ ] the values sorted in ascending order 
4. [ ] output the winning statistics
    1. [ ] the lotto result statistics in the following syntax: [prize rank] [price] – [number of winning tickets]
    2. [ ] the return rate rounded to the nearest tenth

### Core Logic
1. [ ] issue lottery tickets based on budget
   2. [ ] randomly generated 6 unique numbers