# kotlin-lotto-precourse

This project is a command-line Lotto Ticket Machine built using Kotlin, following the MVC architecture. The starter code contains a basic Lotto model and tests onto which production code is to be added.

## Objectives of the mission
* Group related functions into classes so that objects collaborate to perform a larger feature.
* Write unit tests for each class and function to ensure they work as intended.
* Incorporate as much of the Feedback on Pre-course Week 1 as possible.

## Features Implemented

### 1. Fix Lotto.kt whose test is failing
- add checks and error messages to handle duplicates in input for:
  - Handling duplicates in input
  - Numbers range to be 1-45


### 2. Define the structure with MVC design in mind
| Layer        | Class           | Responsibility                                                                 |
|--------------|-----------------|--------------------------------------------------------------------------------|
| Model        | Lotto           | Represents a lottery ticket (already given).                                   |
| Model        | LottoMachine    | Issues multiple Lotto tickets.                                                 |
| Model        | WinningNumbers  | Stores winning numbers and bonus number.                                       |
| Model        | ResultChecker   | Compares tickets with winning numbers and determines prize rank.               |
| Controller   | LottoController | Controls the application flow.                                                 |
| View         | LottoView       | Handles user input/output.                                                     |

```
/src/main/kotlin/lotto/
    - Application.kt 
    - Lotto.kt
    - LottoMachine.kt
    - WinningNumbers.kt
    - ResultChecker.kt
    - LottoController.kt
    - OutputHandler.kt
    - InputHandler.kt
```

### 3. Define the Input Handler 
- The inputHandler performs the reading and validation of input data by user
- Rearrange  the folder to include Input and outputHandler
- Test it out in the main application
- Modify the class to use constant 1000 as opposed to hard coding
- leave the rest for now as all we need is the amount to implement purchase

### 4. Implement LottoMachine
- Create the feature to generate tickets
- Calculate ticket prices

### 5. Add a getNumber in the Lotto class to capture the numbers created
- add a getter to lotto
- make the code more idiomatic
- test the class in the application class

### 6. Implement an outputHandler
- refactor LottoView earlier created to Input Handler

### 7. implement the input number functions for winning numbers and bonus
- implement input and parsing of winning numbers
- implement input and parsing of winning numbers
- implement printing of the output in the output handler


### 8. Implement the result check of winning numbers
- add a small LottoResult class for the results
- in the results checker check for bonus and match matches
- implement a prize enum to simplify matching
