# kotlin-lotto-precourse | Hero Tech - Second Challenge

## Lotto Ticket Machine Features
 This project is a mock of a Lotto Machine where users can simulate a purchase of 
lotto tickets and, after input six winning numbers, the logic will output the 
number os tickets issued and their numbers, the list of matches for each prize 
 and the profit rate of the game.

### User Features (UI):

- Interactive form for user to buy lotto tickets;
  - User enters an amount divisible by 1,000;
  - User receives the number of tickets the budget covers;
  - And the list of the tickets, with it's random generated numbers;

- Interactive form prompts user to input winner numbers and a bonus number;
  - User enters 6 winner numbers;
  - User enters 1 bonus separate number;

- If user inputs invalid data, throw error message and re-prompt corresponding prompt again;

### Logic Features:

- Logic to handle the amount of tickets with random numbers;
  - Based on the budget input, function will output the correspondent amount of tickets
    - The function will assign six random numbers, between 1 - 45, for each ticket;
  - Another function will compare the winning numbers with the numbers of the tickets;
    - this function prints results including winnings and profit rate

