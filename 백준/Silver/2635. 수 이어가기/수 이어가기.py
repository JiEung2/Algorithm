N = int(input())
maxV = 0
lst = [N]
maxL = []
# print(lst)

for second_number in range(N//2, N+1):
    lst.append(second_number)
    index = 1
    while lst[-1] >= 0:
        lst.append(lst[index-1] - lst[index])
        index += 1

    lst.pop()
    if maxV < len(lst):
        maxV = len(lst)
        maxL = lst
    index = 1
    lst = [N]

print(maxV)
for i in maxL:
    print(i, end=" ")