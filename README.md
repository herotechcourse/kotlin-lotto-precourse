# kotlin-lotto-precourse

### Features
1. **Enter the purchase amount**
   - The minimum amount is 1,000 KRW.
   - Only numeric values are allowed.

2. **Issue lotto tickets**
   - Each lotto ticket costs 1,000 KRW.
   - Each ticket must contain six unique integers between 1 and 45.
   - No duplicate numbers are allowed.
   - Display the number of tickets purchased.
   - Display the numbers on each purchased ticket.

3. **Enter the winning numbers**
   - The winning numbers must consist of six integers between 1 and 45.
   - No duplicate numbers are allowed.
   - Numbers must be separated by commas.

4. **Enter the bonus number**
   - The bonus number must be a single integer between 1 and 45.
   - It must not duplicate any of the winning numbers.

5. **Display the number of winning tickets**
   - Display the count of tickets that match the winning conditions.

6. **Display the return rate of winnings**
   - The return rate must be printed up to two decimal places.

### Exceptions
1. If the purchase amount is less than 1,000 KRW.
2. If a non-numeric value is entered.
3. If the winning numbers do not consist of exactly six numbers.
4. If the winning numbers are not within the range of 1 to 45.
5. If the bonus number is not exactly one number.
6. If the bonus number is not within the range of 1 to 45.
7. If the bonus number is duplicated among the winning numbers.