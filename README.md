# Lotto
This is a simple Lotto program that allows users to purchase lottery ticket and check winning statistics based on user input.
Program is written in Kotlin 1.9.24.

# Features
- ### Feature 1: Input purchase amount
  - Read purchase amount from the user.
  - Each ticket costs 1,000 KRW, so the amount must be divisible by 1,000.
  - Example Input:
  ```
  Please enter the purchase amount.
  8000
  ```
  - Input Validations:
    - The input must be a number.
    - The input must be greater than 0.
    - The input must be divisible by 1,000.
  - If the input is invalid, throw `IllegalArgumentException` and re-prompt the question
    - Example:
     ```
      Please enter the purchase amount.
      1500
      IllegalArgumentException: The purchase amount must be divisible by 1,000.
      Please enter the purchase amount. 
    ```

- ### Feature 2: Generate lottery tickets
  - Generate lottery tickets based on the purchase amount.
  - Each lottery ticket consists of 6 unique random numbers.
  - Numbers must be in the range from 1 to 45.

- ### Feature 3: Display purchased lottery tickets
  - Display the generated lottery tickets one by one and sort the numbers from each ticket in ascending order.
  - Example:
   ```
  You have purchased 8 tickets.
  [8, 21, 23, 41, 42, 43]
  [3, 5, 11, 16, 32, 38]
  [7, 11, 16, 35, 36, 44]
  [1, 8, 11, 31, 41, 42]
  [13, 14, 16, 38, 42, 45]
  [7, 11, 30, 40, 42, 43]
  [2, 13, 22, 32, 38, 45]
  [1, 3, 5, 14, 22, 45]
  ```

- ### Feature 4: Input winning numbers
  - Read last weeks winning numbers from the user.
  - The winning numbers must be 6 unique numbers.
  - Example:
  ```
  Please enter last week's winning numbers.
  1,2,3,4,5,6
  ```
  - Input Validations:
    - The input must be a string of numbers separated by commas.
    - The input must contain 6 numbers.
    - The input must be unique numbers.
    - The input must be in the range from 1 to 45.
  - If the input is invalid, throw `IllegalArgumentException` and re-prompt the question
  - Example:
     ```
      ....
      Please enter last week's winning numbers.
      1,1,3,4,5,6
      IllegalArgumentException: The winning numbers must be unique.
      Please enter last week's winning numbers. 
    ``` 

- ### Feature 5: Input bonus number
  - The bonus number is a single, separate number.
  - Example:
  ```
  Please enter the bonus number.
  7
  ```
  - Input Validations:
    - The input must be a number.
    - The input must be greater than 0.
    - The input must be less than or equal to 45.
  - If the input is invalid, throw `IllegalArgumentException` and re-prompt the question
    - Example:
      ```
       ....
       Please enter the bonus number.
       48
       IllegalArgumentException: The bonus number must be less than or equal to 45.
       Please enter the bonus number.
        ```

- ### Feature 6: Calculate winning statistics
  - Find the prize for each ticket based on the winning numbers and the bonus number according to the following rules:
  ```
    1st Prize: Match 6 numbers / 2,000,000,000 KRW
    2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
    3rd Prize: Match 5 numbers / 1,500,000 KRW
    4th Prize: Match 4 numbers / 50,000 KRW
    5th Prize: Match 3 numbers / 5,000 KRW
  ```
- ### Feature 7: Display winning statistics
  - Display the number of matches and the number of winning tickets.
  - Display total return rate based on below calculation:
    ```
      Total return rate = (Total winning amount / Total purchase amount) * 100
    ```
  - Sample Output:
    ```
      Winning Statistics
      ---
      3 Matches (5,000 KRW) – 1 tickets
      4 Matches (50,000 KRW) – 0 tickets
      5 Matches (1,500,000 KRW) – 0 tickets
      5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
      6 Matches (2,000,000,000 KRW) – 0 tickets
      Total return rate is 62.5%.
    ```

# How to Test
```
For macOS/Linux: ./gradlew clean test
For Windows: gradlew.bat clean test or .\gradlew.bat clean test
```