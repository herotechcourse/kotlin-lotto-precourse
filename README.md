# kotlin-lotto-precourse

## 1. Get purchase amount and validate
* Prompt the user to input the amount of money they want to spend on lottery tickets.
* The input must be a positive integer and divisible by 1,000.
* If the input is invalid (e.g., not a number, negative, or not divisible by 1,000), display an error message and request the input again.

## 2. Generate lottery numbers
* For every 1,000 won, one lottery ticket is automatically generated.
* Each ticket contains 6 unique random numbers between 1 and 45.
* Print the generated lottery numbers.

## 3. Get winning numbers and validate
* Prompt the user to input last week's winning numbers, separated by commas.
* Parse the input into a list of integers.
* The winning numbers must consist of exactly 6 unique numbers, each between 1 and 45.
* If the input is invalid (e.g., duplicate numbers, wrong range, incorrect amount), display an error message and request the input again.

## 4. Get bonus number and validate
* Prompt the user to input the bonus number separately.
* The bonus number must be a valid integer between 1 and 45.
* If the input is invalid (e.g., non-integer input, out-of-range number), display an error message and request the input again.

## 5. Compare each ticket's numbers with the winning numbers
* Compare each lottery ticket against the winning numbers.
* Count how many numbers match.
* If 5 numbers match and the bonus number also matches, handle it as a special second-place case.
* Determine the prize based on the following rules:
  * 6 matches: 1st prize
  * 5 matches + bonus: 2nd prize
  * 5 matches: 3rd prize
  * 4 matches: 4th prize
  * 3 matches: 5th prize
  * Fewer than 3 matches: No prize

## 6. Print the result statistics
* Display the number of tickets that achieved each prize rank.
* Calculate the total winnings based on the prize amounts.
* Calculate and print the overall return rate (total earnings divided by purchase amount, expressed as a percentage).