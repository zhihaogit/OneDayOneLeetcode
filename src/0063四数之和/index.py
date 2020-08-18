'''
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：
答案中不可以包含重复的四元组。

示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
'''


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        res = []
        if n < 4:
            return res
        nums.sort()
        for first in range(n - 3):
            # 去除重复项
            if first > 0 and nums[first] == nums[first - 1]:
                continue
            for second in range(first + 1, n - 2):
                if second > first + 1 and nums[second] == nums[second - 1]:
                    continue
                third, fourth = second + 1, n - 1
                while third < fourth:
                    sumVal = nums[first] + nums[second] + nums[third] + nums[fourth]
                    if sumVal < target:
                        third += 1
                    elif sumVal > target:
                        fourth -= 1
                    else:
                        res.append([nums[first], nums[second], nums[third], nums[fourth]])
                        while third < fourth and nums[third] == nums[third + 1]:
                            third += 1
                        while third < fourth and nums[fourth] == nums[fourth - 1]:
                            fourth -= 1
                        third += 1
                        fourth -= 1
        return res

