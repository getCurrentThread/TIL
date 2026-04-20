import sys
input = sys.stdin.readline

N = int(input())
stack = []
order = -1
for _ in range(N):
    args = list(map(int, input().split()))
    order = args[0]
    if order == 1:
        stack.append(args[1])
    elif order == 2:
        if len(stack) != 0:
            print(stack.pop())
        else:
            print(-1)
    elif order == 3:
        print(len(stack))
    elif order == 4:
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif order == 5:
        if len(stack) != 0:
            print(stack[-1])
        else:
            print(-1)

