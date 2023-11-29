# <center> Growth of functions Homework  </center>

## Q1) 
### C

## Q2)
### E

## Q3)
### $$ 3^n \le 5^n $$ 
### at c = 1, k =1
### $$ f(n) \le g(n) $$
### $$ f(n) = O(g(n)) $$
### But $$ g(n) \ne O(f(n)) $$
### $$ 5^n \le 3^n $$
### $$ (5^n \le 3^n) \div 3^n $$
### $$ ({5 \over 3})^n \le 1 $$
### since $$ {5\over 3} \ge 1 $$
### then $$ g(n) \ne O(f(n)) $$
### since $$ f(n) = O(g(n)), \space g(n) \ne O(f(n)) $$ 
### then $$ f(n) \ne \theta(g(n)) $$

## Q4)
```python
nums = [34, 68, 83, 84, 59, 94, 89, 100, 53, 80, 76, 26, 6, 70, 28, 67, 10, 78, 40, 17, 75, 24, 23, 31, 35, 90, 38, 18, 39, 99, 97, 61, 44, 48, 11, 60, 21, 81, 1, 42, 77, 82, 55, 95, 47, 54, 20, 57, 56, 65, 14, 59, 85, 52, 8, 12, 73, 79, 63, 87, 33, 2, 93, 50, 92, 45, 30, 32, 15, 49, 86, 58, 74, 96, 9, 29, 69, 16, 19, 98, 64, 5, 66, 88, 51, 43, 25, 27, 46, 7, 37, 3, 91, 62, 4, 36, 41, 13, 72, 22, 71]

added = []

for num in nums:
    if num in added:
        print(str(num) + ' is repeated!')
        exit(1)
    added.append(num)

print('No numbers were repeated') 

``` 
### The time Complexity is 
### $$ O(n^2) $$
### Since 
```python
for num in nums: 
```
### Is $$ O(n) $$
### And  
```python
if num in added:
```
### Is $$ O(n) $$
### Then the Time complexity is 
### $$ O(f(n)) = O(n) * O(n) $$
### $$ O(f(n)) = O(n^2)$$

