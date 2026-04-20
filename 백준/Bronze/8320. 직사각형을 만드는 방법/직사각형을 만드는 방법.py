N = int(input())

cnt = 0
for i in range(1, 10001):
    for j in range(i, 10001):
        if i * j <= N:
            cnt += 1

print(cnt)
