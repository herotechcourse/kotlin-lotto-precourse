# kotlin-lotto-precourse

## Overview

This project is my implementation of the Lotto game proposed by Delivery Hero's Tech Course, specifically for the 
pre-work missions.

## List of features
Here you can find the list of features proposed for implementation.
This list may change over time while iterating 
during the mission.

- Input function to get the purchase amount.
- Validation function to check that the purchase amount is higher than 1000. 
- Function to generate the number of tickets according to the input amount.
- Function to populate the ticket arrays with six unique random numbers from 1 to 45.
- ~~Validation function to check if the numbers are unique.~~ No longer needed since the previous function creates unique
values.
- Function to display the generated tickets.
- Input function to get the winning numbers, separated by comma.
- Validation function to check that winning numbers are between 1 and 45. 
This function works for the winning numbers and for the bonus number.
- Validation function to check that the winning numbers are unique.
- ~~Validation function to check that the winning numbers are comma separated.~~ Not required in programming nor 
functional requirements.
- ~~Function to split the winning numbers string into an array of numbers to check individually.~~ No longer needed 
since the comparison can be made using the list of winning tickets agains the list of lists of numbers (each ticket).
- Function to get the bonus number.
- Function that checks for matches of the winning numbers in each ticket array.
- Function that classifies the number of matches.
- Function that displays the matches classification with the winning amount.
- Function that calculates the profit rate to the nearest tenth.
- Function that displays the profit rate.
- Create test for all features