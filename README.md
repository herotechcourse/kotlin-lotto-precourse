# kotlin-lotto-precourse | Hero Tech - Second Challenge

This project is a mock of a Lotto Machine where users can simulate a purchase of
lotto tickets and, after input six winning numbers, the logic will output:
 - The number os tickets issued and their numbers, 
 - The list of matches for each prize category 
 - And the profit rate based on the results.

## Features

### User Features (UI):

- Interactive form for user to buy lotto tickets;
  - User enters an amount divisible by 1,000;
  - User receives the number of tickets the budget covers;
  - And the list of the tickets, with its random generated numbers;

- Interactive form prompts user to enter the winning lotto numbers;
  - User enters 6 winner numbers separated by comma;

- Interactive form prompts user one last time to enter the bonus number;
  - User enters 1 bonus number;

- Input validation:
  - If invalid data is entered, the user receives an error message and its corresponding prompt again;

### Logic Features:

- Logic to handle ticket generation;
  - Based on the user's input amount, the system generates a appropriate number of tickets; 
  - Each ticket receives six random numbers between 1 - 45;
- Winning number comparison:
  - The system compares each ticket against the winning numbers and filter the winning ones;
- Printing results:
  - Then the system prints the winning statistics; 
  - And finally, based on the amount spent versus the total winnings, the program calculates and prints the profit rate

