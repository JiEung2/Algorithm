
T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    numbers = list(map(int, input().split()))
    arr = [0 for i in range(101)]
    for i in range(0, 1000):
        arr[numbers[i]] += 1
    t= arr[::-1]
    print('#' + str(n) + ' ' + str(100 - t.index(max(arr))))