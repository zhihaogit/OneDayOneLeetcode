'''
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
'''


class Solution:
    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    def twoSum(self, nums, target):
        hashMap = {}
        for i, ele in enumerate(nums):
            difference = target - ele
            if difference in hashMap:
                return [hashMap[difference], i]
            hashMap[ele] = i


if __name__ == '__main__':
    points = [2, 7, 11, 15]
    sum = 9
    ins = Solution()
    final1 = ins.twoSum(points, sum)
    print(final1)
