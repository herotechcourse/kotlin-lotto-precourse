# kotlin-lotto-precourse

1. set up purchase
    - prompt the user to input the purchase amount
    - validate the input (must be divided by 1,000, positive, number)
    - calculate the number of lottery tickets 

2. generate and display lottery tickets
    - generate 6 unique random numbers within range(1~45) for each tickets
    - sort the number in ASC order
    - display all purchased lottery tickets


3. input winning numbers
    - prompt the user to input 6 winning numbers
    - prompt the user to input 1 bonus number0
    - validate that all numbers are within range (1~45), unique, not duplication between winning and bonus numbers

4. evaluate results
    - compare purchased tickets with the winning numbers and bonus number
    - classify each ticket into prize categories based on matching nubmers
    - calculate the total prize amount and return rate(rounded to one decimal place)

5. display results and handle errors
    - print the number of tickets in each prize category and return rate
    - handle invalid inputs by throwing an specific exception such as IlligatArgumentException, IllegalStateException