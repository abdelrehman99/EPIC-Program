sum = 0

for i in range(1, 8):
    sum += (((i - 1) * (1 / 144)) * i)
    if i >= 1 and i <= 6:
        sum += (1 / 8)

j = 8
for i in range(6, 1, -1):
    sum += (((i - 1) * (1 / 144)) * j)
    j += 1

print(sum)

