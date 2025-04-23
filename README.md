# Kotlin Lotto Precourse

## Introduction

A small lottery simulation game. The user can input the amount of money they want to
purchase tickets for and the game generates random lottery tickets. The user then inputs
the winning numbers and a bonus number. The program prints the result including the 
winnings and the according profit rate.

## Features

### User Interface
#### Input
1. read user input
    1. purchase amount (Int)
    2. winning numbers (comma-separated list of Ints)
    3. bonus number (Int)
2. validate user input
    1. purchase amount:
        1. divisible by 1000
        2. positive number
        3. ? minimum and/or maximum values?
    2. winning numbers:
        1. comma separated
        2. 6
        3. unique
        4. between 1 and 45
    3. bonus number
        1. between 1 and 45
        2. ? not duplicating a winning number?
    4. throw exception with an error message and re-prompt if invalid
        1. syntax: “[ERROR] my message“
       
#### Output
3. output the purchased tickets after reading the purchase amount
    1. the number of purchased tickets
    2. the values sorted in ascending order
4. output the winning statistics
    1. the lotto result statistics in the following syntax: [prize rank] [price] – [number of winning tickets]
    2. the return rate rounded to the nearest tenth

### Core Logic
