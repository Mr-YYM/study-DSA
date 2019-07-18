# 冒泡排序，自底向上，倒序排列
def bubble_sort(list):
    for i in range(len(list)-1):
        for j in range(len(list)-1, i, -1):
            if list[j] > list[j-1]:
                list[j], list[j-1] = list[j-1], list[j]
    return list

print(bubble_sort([1,7,2,5,8,3,22,5]))