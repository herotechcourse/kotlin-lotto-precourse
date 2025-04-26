# kotlin-lotto-precourse

### Overview
This is a simple Kotlin-based lottery game where players can input their lotto numbers, validate the input, and check if they match the winning numbers. The game simulates a lottery drawing, and based on the user's input, it determines whether the player has won or not.

### Features
#### Input Validation
- `Purchase Amount`: Accepts a purchase amount and validates that it is a number and divisible by 1000.

- `Lotto Numbers`: Accepts 6 unique numbers from the player, validates that the numbers are in the range of 1 to 45, ensures uniqueness, and checks that exactly 6 numbers are entered.

- `Bonus Number`: Accepts a bonus number, validates that it is numeric and within the range of 1 to 45.

#### Lotto Game Logic
- Compares the player's lottery numbers to the winning numbers.
- Counts how many numbers match the winning numbers.
- Checks if the player has matched the bonus number.
- Determines the rank and prize based on the matching numbers.

#### Output Formatter
- Displays the player's lottery numbers.
- Displays the winning numbers and the bonus number.
- Shows the player's matching numbers and whether they have won or not.
- Provides the return rate based on total winnings and purchase amount.

### Structure

#### `Lotto`
The `Lotto` class represents a lotto ticket with exactly 6 unique numbers in the range of 1 to 45. It provides functionality to check for matching numbers and validate that the ticket is valid.

#### `InputValidator`
The `InputValidator` object handles all user input validation. It ensures that the purchase amount is a multiple of 1000 and that the player's numbers, as well as the bonus number, are within the specified range (1 to 45) and unique.

#### `LottoGame`
The `LottoGame` class handles the core game logic. It takes the player's tickets, the winning ticket, and the bonus number, and then calculates how many of the player's tickets match the winning numbers and/or bonus number. It also calculates the total winnings and provides the results.

#### `OutputFormatter`
The `OutputFormatter` object is responsible for formatting and printing the results of the lottery game. It displays the player's ticket numbers, the winning numbers, and the calculated statistics like the number of matches, prize amounts, and return rate.

#### `Rank`
The `Rank` enum defines the different ranking levels (FIRST, SECOND, etc.) based on the number of matches and whether the bonus number is matched. Each rank has an associated prize amount.

### Clean Code Practices
- Used Kotlin conventions and idiomatic code.
- Separation of concerns: The logic is divided into clear objects and classes: `InputValidator`, `Lotto`, `LottoGame`, and `OutputFormatter`.
- Ensured that validation logic, game logic, and output formatting are clearly separated and easy to maintain.
- The use of enums (e.g., `Rank`) ensures clarity and maintainability in determining the prize levels.

### Example Usage
1. The program prompts the player to enter the purchase amount, which must be divisible by 1000.
2. After the purchase amount is validated, the program generates a number of tickets based on the purchase amount.
3. The player is then prompted to enter their 6 lotto numbers and the bonus number.
4. The game compares the player's tickets with the winning ticket and determines the player's rank and prize.
5. The results are displayed, showing the player's winnings and return rate.
