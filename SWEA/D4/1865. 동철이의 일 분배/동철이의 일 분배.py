def dfs(L, p):
    global result
    if p == 0:
        return

    if p < result:
        return

    if L == n:
        result = max(result, p)

    for i in range(n):
        if not visited[i]:
            visited[i] = 1
            dfs(L + 1, p * arr[L][i] * 0.01)
            visited[i] = 0

T = int(input())

for tc in range(T):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    result = 0
    visited = [0] * n

    dfs(0, 1)
    print(f'#{tc+1} {result * 100:.6f}')