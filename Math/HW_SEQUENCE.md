## Q1)
### C

## Q2)
### C

## Q3)
### E

## Q4)

### $$ F_{n+7} = F_{n+5} + 4F_{n+3} + F_n $$

### let's donate n + 7 by k

## By induction proof if $$ F_k $$ is true then $$ F_{k+1} $$ is also true

### For k = n + 1 then 

### $$ F_{(n+1)+7} = F_{n+6} + 4F_{n + 4} + F_{n + 1} $$

### First lets simplify $$ F_{(n+1)+7} $$

### $$ F_{(n+1)+7} =F_{n+8} $$

### $$ = F_{n+7} + F_{n+6} $$

### $$ = F_{n+6} + F_{n+5} + 4F_{n+3} F_{n} $$

### $$ = F_{n+6} + F_{n+4} + 5F_{n+3} + F_n $$

### $$ = F_{n+6} + 6F_{n+3} + F_{n+2} + F_n $$

### $$ = F_{n+6} + 7F_{n+2} + 6F_{n+1} + F_n $$

### $$ = F_{n+6} + 13F_{n+1}+ 8F_n $$

### Then lets see simplify $$ F_{n+6} + 4F_{n + 4} + F_{n + 1} $$

### $$ = F_{n+6} + 4F_{n+3} + 4F_{n+2} + F_{n+1} $$

### $$ = F_{n+6} + 8F_{n+2} + 5F_{n+1} $$

### $$ = F_{n+6} + 13F_{n+1}+ 8F_n $$

### As we can see both sides of the equation are equal, so this recurrence relation for every $$ n >= 1 $$ is valid

## Q5)

### $$ 2a_n = 7a_{n-2} - a_{n-1} $$

### $$ -2a_{n} + 7a_{n-2} -3a_{n-1} = 0 $$

### Now we form characteristic relation

### $$ -2{x^2} + 7x -3 = 0 $$ 

### $$ (-2x+6) (x - {1\over2}) = 0 $$ 

### $$ x = 3, x = {1\over2} $$

### $$ a_n = a3^n + b^{\sqrt{n}} $$

### $$ a_1 = 1 = 3a + \sqrt{b} $$

### $$ a_2 = 3 = 9a + b $$

### $$ a = {1 - \sqrt{b} \over 3} $$

### $$ 3 - 3\sqrt{b} + b = 3 $$

### $$ - 3\sqrt{b} + b = 0 $$

### $$ b = 0, a = {1\over3} $$ 

### Then recurrence equation is 

### $$a_n = {1\over3}3^{n} $$
