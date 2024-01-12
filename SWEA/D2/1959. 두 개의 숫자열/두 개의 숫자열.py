
T = int(input())

for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    cnt = 0
    if len(A) > len(B):
        for i in range(0, len(A) - len(B) + 1):
            result = 0
            for j in range(0, len(B)):
                result += A[j+i] * B[j]
            cnt = max(result, cnt)
    else:
        for i in range(0, len(B) - len(A) + 1):
            result = 0
            for j in range(0, len(A)):
                result += B[j+i] * A[j]
            cnt = max(result, cnt)        
    print('#' + str(test_case) +' '+str(cnt))