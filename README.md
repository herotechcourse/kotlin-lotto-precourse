# kotlin-lotto-precourse


### Feature List
| No. |         Feature Name          |       Category        | Requirement Details                                                                                                                                    |
|:--:|:-----------------------------:|:---------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------|
| F01 |    Purchase Amount Validation |         input         | The user must enter a positive integer amount that is divisible by 1,000.                                                                              |
| F02 |     Ticket Quantity Issuing   |         logic         | The program issues as many tickets as the purchase amount allows, with each ticket costing 1,000 KRW.                                                  |
| F03 |     Ticket Number Generation  |         logic         | Each ticket consists of 6 unique random numbers between 1 and 45.                                                                                      |
| F04 |     Winning Numbers Input     |         input         | The user must enter 6 unique winning numbers and 1 bonus number, all between 1 and 45.                                                                 |
| F05 |       Input Validation        |    error handling     | If the user inputs invalid data, the program must throw an `IllegalArgumentException` and re-prompt for input.                                         |
| F06 |    Specific Exception Handling|    error handling     | Only specific exceptions like `IllegalArgumentException` or `IllegalStateException` must be handled, not generic `Exception`.                          |
| F07 |      Prize Evaluation Logic   |         logic         | Each ticket is compared against the winning numbers and the bonus number to determine the prize rank based on the matching rules.                      |
| F08 |     Prize Distribution Rules  |         logic         | The prize ranks and rewards are: 1st (6 matches), 2nd (5 + bonus), 3rd (5), 4th (4), 5th (3), with respective amounts from 2 billion to 5 thousand KRW. |
| F09 |     Result Output Format      |        output         | The program must display the number of winning tickets per prize rank, total winnings, and the return on investment (profit rate).                     |
