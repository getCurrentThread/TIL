"""
<입력>
8 <- 스위치의 갯수
0 1 0 1 0 0 0 1 <- 스위치의 상태
2 <- 학생들의 수
1 3 <- 성별, 학생이 받은 수 (스위치 번호)
2 3
"""

# 스위치의 개수 << input...
n = int(input())
# 스위치의 상태 << input...
# "0 1 0 1 0 0 0 1"
# 1. 입력만 나누기
# input().split()  # ["0", "1", "0", "1", ...]
# 2. for문을 사용해서 값 정수로 변환하기
# switch = []
# for i in input().split():
#     switch.append(int(i))
# [0, 1, 0, 1, 0, 0, 0, 1]
# 3. list comprehension 으로 한번에 변환하기
# switch = [int(i) for i in input().split()]
# 4. map함수 사용하기
# map( 각 요소들마다 적용할 함수, 반복가능한 자료형: 리스트, 튜플... ): -> map 객체를 반환해줌 (-> 리스트로 변환)
switch = [-1] + list(map(int, input().split()))  # 스위치의 상태 << input...
t = int(input())  # 학생수 << input...
for i in range(t):
    gender, num = map(int, input().split())  # 성별과 학생이 받는 수
    # 로직 시작...
    if gender == 1:  # 1. 남성일 때
        # 자신의 수의 배수는 모두 스위치를 토글한다.
        for j in range(num, n + 1, num):
            switch[j] = 1 if switch[j] == 0 else 0
    elif gender == 2:  # 2. 여성일 때
        # 자기 자신은 항상 동일하므로 미리 토글
        switch[num] = 1 if switch[num] == 0 else 0

        # 양끝 (왼쪽 오른쪽)을 현재 위치로 하고
        left = num - 1
        right = num + 1
        # 양끝이 동일하지 않을 때까지 반복한다.
        # 자신의 체크하는 범위의 양끝이 동일하다면 양끝을 토글하고, 양끝을 범위에 추가한다.
        # (주의할점! left, right가 리스트의 범위를 벗어나는지도 체크!)
        while (left > 0 and right <= n) and switch[left] == switch[right]:
            # 양끝 스위치를 토글
            switch[left] = 1 if switch[left] == 0 else 0
            switch[right] = 1 if switch[right] == 0 else 0
            # 범위를 늘린다
            left -= 1
            right += 1

# # 1. 출력
# for i in range(1, n + 1):
#     for j in range(20):
#         if i + j > n:
#             break
#         print(switch[i + j], end=' ')
#     print()

# 2. 출력
for i in range(1, n, 20):
    print(*switch[i:i + 20])
