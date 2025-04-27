# kotlin-lotto-precourse

## 1. Get purchase amount from the user
### a. Responsibilities:
- Write a function to get user input: purchase amount
- Divide the purchase amount by 1000 to get the number of tickets that can be purchased
### b. Validation:
- This code also validates the user input for the following conditions
    - The purchase amount should not be empty or 0
    - The purchase amount should be a valid integer
    - And it should be divisible by 1000
### c. IO Args
- The function shall return the following outputs
    - The total number of tickets that can be purchased from the purchase amount
### d. Test cases
- Test case for the following
    - The purchase amount should be a valid integer and not string
    - It should not be empty or 0
    - It should be divisible by 1000
  
## 2. Generate Random number for the number of tickets purchased
### a.Responsibilities:
- Write a function to generate total ticket lists. With the total no of tickets calculated from the above step, generate that many number of tickets-
  each having a list of 6 elements that are generated randomly having the range of 1 to 45. These n number of tickets havinglist of 6 random numbers are
  then stored into another mutable list
### b. IO args:
- The function returns a mutable list of mutable list as output

## 3. Implement a function to get winning number list and bonus number as user input
### a.Responsibilities:
- Write a function that gets winning numbers as input from the user. This winning number is a list of 6 elements which would be used in comparing with the tickets
  containing random numbers generated in the previous step.A bonus number is also received as user input here
### b. Validation:
-This code validates the following
- Winning numbers should not ne null or negative,should be a valid integer,should have a length of 6, should not be more than 45
- Bonus number should not be null or negative, should be a valid integer, should not be more than 45
### c. IO args:
- This function takes the following input from the user
  - Winning numbers-this is a list of 6 numbers
  - Bonus number-This is an integer
### d. Test cases
- Test case for the following
  - Winning numbers-not null, empty, length should be 6, not greater than 45
  - Bonus-not null or zero, not greater than 45

