# kotlin-lotto-precourse
## Goals

### Learning Objectives

- Group related functions into classes so that objects collaborate to perform a larger feature.
- Write unit tests for each class and function to ensure they work as intended.
- Incorporate as much of the [Feedback on Pre-course Week 1](https://docs.google.com/document/d/1MXczCggC5-mYRzbgcAIDVec4xaTMojIh3vHLGwhTMgQ/edit?usp=sharing) as possible.

### Feedback by Pre-course and retrospect(in my occasion)
- [ Retrospect ] Write Feature lists by role and behavior.
- [ Feedback ] After carefully analyzing the requirements, features are derived and organized based on the results of the analysis.
- [ Feedback ] Feature must be written as small as possible.
- [ Retrospect ] After implementing each features, write test codes that can verify the feature.

## Feature list
- [x] Receive the purchase amount from the user.
  - [x] If the amount is not divisible by 1,000, throw an exception and prompt for input again.
  - [x] If the amount is not positive, throw exception.
- [x] Calculate how many lottery tickets can be purchased with the given amount.
  - [x] Generate N lottery tickets.
  - [ ] Each ticket must consist of 6 unique numbers between 1 and 45.
  - [ ] The numbers must be sorted in ascending order when printed.
- [x] Receive 6 winning numbers from the user. 
  - [x] Winning numbers must not contain non-numeric values. 
  - [x] Winning numbers must not have duplicates.
  - [x] Winning numbers must be in range (1 ~ 45). 
  - [x] Winning numbers must be 6 numbers.
- [x] Receive 1 bonus number from the user.
  - [x] The bonus number must not overlap with any of the winning numbers.
  - [x] The bonus number must be in range (1 ~ 45).
- [ ] Compare each lottery ticket to the winning numbers and count how many numbers match.
  - [ ] If there are exactly 5 matches, check whether the ticket contains the bonus number.
- [ ] Determine the result for each ticket and count the number of tickets for each prize rank.
- [ ] Calculate the return rate.
  - [ ] Return rate = (total prize money / total purchase amount) * 100.0, rounded to one decimal place.
- [ ] Print the statistics of winning tickets and the return rate.


## UML Object Design
### First Design
Below is the class diagram representing the object-oriented structure of the Lotto mission.
![lotto-precourse-uml](/docs/lotto-precourse.drawio.png)

### Advanced Design
![lotto-precourse-uml](/docs/lotto-precourse_1.drawio.png)