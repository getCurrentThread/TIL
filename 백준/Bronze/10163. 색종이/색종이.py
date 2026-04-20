arr2d = [[0] * 1001 for _ in range(1001)]

N = int(input())

for i in range(1, N + 1):
    x, y, w, h = map(int, input().split())
    for cx in range(x, x + w):
        for cy in range(y, y + h):
            arr2d[cx][cy] = i

cnts = [0] * 101
for i in range(1001):
    for j in range(1001):
        cnts[arr2d[i][j]] += 1

for i in range(1, N + 1):
    print(cnts[i])
