def check(arr):
    
    for i in range(9):
        row_check = [0]*10
        col_check = [0]*10
        for j in range(9):
            row = arr[i][j]
            col = arr[j][i]

            if row_check[row]:
                return 0
            if col_check[col]:
                return 0
            
            row_check[row] = 1
            col_check[col] = 1

            if i % 3 == 0 and j % 3 == 0:
                square_check = [0]*10
                for x in range(i, i+3):
                    for y in range(j, j+3):
                        if square_check[arr[x][y]]:
                            return 0
                        
                        square_check[arr[x][y]] = 1
    
    return 1

n = int(input())
for tc in range(1, n+1):
    arr = [list(map(int, input().split())) for _ in range(9)]
    result = check(arr)
    print('#{} {}'.format(tc, result))