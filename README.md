# kotlin-lotto-precourse

### Overview
This is a simple Kotlin-based lottery game where players can input their lottery numbers, validate the input, and check if they match the winning numbers. The game simulates a lottery drawing, and based on the user's input, it determines whether the player has won or not.

### Features
#### Purchase Amount Input & Validation
- Accepts the purchase amount from the player.
- Validates that the amount is a number and divisible by 1000.

#### Lottery Numbers Input & Validation
- Accepts 6 unique numbers from the player (comma-separated or space-separated).
- Validates that the numbers are within the range of 1 to 45.
- Ensures the numbers are unique.
- Checks if the player has entered exactly 6 numbers.

#### Bonus Number Input & Validation
- Accepts a bonus number (from 1 to 45).
- Validates that the bonus number is numeric.

#### Lotto Game Logic
- Compares the player's lottery numbers to the winning numbers.
- Counts how many numbers match the winning numbers.
- Checks if the player has matched the bonus number.
- Determines if the player wins based on the matching numbers.

#### Output Formatter
- Displays the player's lottery numbers.
- Displays the winning numbers and the bonus number.
- Shows the player's matching numbers and whether they have won or not.

#### Clean Code Practices
- Used Kotlin conventions and idiomatic code.
- Separation of concerns. Logic is divided into clear classes: Lottery, InputValidator, OutputFormatter.
- Ensured that validation logic is clearly separated and easy to maintain.
