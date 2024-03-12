from collections import deque


def bfs(q):
    while q:
        vr, vc = q.popleft()
        for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nr = vr + dr
            nc = vc + dc
            if 0 <= nr < N and 0 <= nc < M and arr[nr][nc] == 0:
                q.append((nr, nc))
                arr[nr][nc] = arr[vr][vc] + 1


M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
q = deque()
for row in range(N):
    for col in range(M):
        if arr[row][col] == 1:
            q.append((row, col))

bfs(q)

maxV = 0
is_zero = False
for row in range(N):
    for col in range(M):
        if arr[row][col] == 0:
            is_zero = True
        maxV = max(maxV, arr[row][col])

if is_zero:
    print(-1)
else:
    print(maxV - 1)
