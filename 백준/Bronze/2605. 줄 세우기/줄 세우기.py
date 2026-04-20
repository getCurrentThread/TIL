N = int(input())

arr = list(map(int, input().split()))

result = []
for i in range(N):
    result.insert(len(result) - arr[i], i + 1)

for i in range(N):
    print(result[i], end=' ')
