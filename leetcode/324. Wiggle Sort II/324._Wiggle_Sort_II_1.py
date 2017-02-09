import heapq
class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        temp = sorted(nums)
        smaller, bigger = [], []
        h = len(temp) / 2
        if len(temp) % 2 == 1:
            smaller = temp[:h+1]
            bigger = temp[h+1:]
        else:
            smaller = temp[:h]
            bigger = temp[h:]
        smaller = smaller[::-1]
        bigger = bigger[::-1]
        temp2 = []
        for index, i in enumerate(bigger):
            temp2.extend([smaller[index], i])
        if len(temp) % 2 == 1:
            temp2.append(smaller[-1])
        for index, i in enumerate(temp2):
            nums[index] = i