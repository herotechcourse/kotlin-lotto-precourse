# kotlin-lotto-precourse

## Features to Implement

### Lotto Class:

Lotto class represents a single lotto ticket that includes 6 numbers of the ticket and their getter method.

### Lotto Processor:

Lotto processor would serve multiple purposes:

- **Ticket Generation:** 
The user enters a purchase amount (must be dividable by 1000) and the program generates that many lottery tickets with 6 random numbers ranging from 1 to 45.

- **Winning Prize Calculation:**
The user provides 6 winning numbers and a bonus number. Each ticket should be compared to the winning numbers, and the prize is determined based on the number of matches. Based on the number of matching numbers different prize categories will be returned in a specific format.

- **Profit Calculation:**
The profit will be calculated by dividing total winnings to the total money spent and will be shown in a percentage format.

- **Process Lotto:**
Main part of running process where it initiates different processes of input reading and creating statistics.

### Prize Class:

Would be an enum class containing all prizes based on the number of matching cards necessary to win them, together with their monetary value in descending order.

### Input and output views

User input should be received and parsed in a way that can be fed into the ticket generation and winning calculation features.

### Input Validation:

Validate that all user inputs are correct (e.g., amounts must be divisible by 1,000, winning numbers must be between 1 and 45, inputs should be numbers, etc.).

### Error Handling:

Handle exceptions such as invalid input would be in a way that user can enter a valid input again after receiving the error. 
