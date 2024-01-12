T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]

    arr_90 = [[0 for _ in range(n)] for _ in range(n)]
    arr_180 = [[0 for _ in range(n)] for _ in range(n)]
    arr_270 = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            arr_90[i][j] = arr[n-j-1][i]

    for i in range(n):
        for j in range(n):
            arr_180[i][j] = arr_90[n-j-1][i]

    for i in range(n):
        for j in range(n):
            arr_270[i][j] = arr_180[n-j-1][i]

    print('#' + str(test_case))
    
    for i in range(n):
        for j in range(n):
            print(arr_90[i][j], end='')
        print(end=' ')
        for j in range(n):
            print(arr_180[i][j], end='')
        print(end=' ')
        for j in range(n):
            print(arr_270[i][j], end='')
        print()