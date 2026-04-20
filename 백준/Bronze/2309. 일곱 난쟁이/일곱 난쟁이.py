arr = [int(input()) for _ in range(9)]

arr.sort()


def simuate():
    for a in range(9):
        for b in range(a + 1, 9):
            for c in range(b + 1, 9):
                for d in range(c + 1, 9):
                    for e in range(d + 1, 9):
                        for f in range(e + 1, 9):
                            for g in range(f + 1, 9):
                                if 100 == arr[a] + arr[b] + arr[c] + arr[d] + arr[e] + arr[f] + arr[g]:
                                    return arr[a], arr[b], arr[c], arr[d], arr[e], arr[f], arr[g]


endians = simuate()

for endian in endians:
    print(endian)
