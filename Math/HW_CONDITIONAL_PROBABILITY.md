### <center> Conditional Probability Homework </center>

## Q1)
### E

## Q2)
### C

## Q3)
### B

## Q4)
### $$ |E| = 6  $$
### $$ |F| = 8  $$
### $$ (E \bigcap F) = 1100, \space 1010, \space 0110 $$
### $$ |(E \bigcap F)| = 3 $$
### $$ P(E|F) = {|(E \bigcap F)| \over |(F)|} = {3 \over 8} $$
### $$ P(E) = {6 \over 16} = {3 \over 8} $$
### Since, that 
### $$ P(E) = P(E|F) $$ 
### Then E and F are independent events

## Q5)
### Our Sample space consists of 12 numbers, from 1 to 12.
### We will consider our random variable X to be the probability for this number to appear
### $$ X (r) = P(r) $$ 
### Here, we have two ways to get r, If r is less than 7 then it get can be the number of the first dice, and the other way is the P(2 * tails) times the probability of the sum of the first dice and the second dice to be r.
### $$ P(r) = ({1 \over 8} * {3 \over 4}) + ({1 \over 6} * {1 \over 4} * {1 \over 6} * P(a + b)) $$
### For all r on Sample space
### With this function to calculate the expected
```python
sum = 0

for i in range(1, 8):
    sum += (((i - 1) * (1 / 144)) * i)
    if i >= 1 and i <= 6:
        sum += (1 / 8)

j = 8

for i in range(6, 1, -1):
    sum += (((i - 1) * (1 / 144)) * j)
    j += 1
```
### The expected is 2.5