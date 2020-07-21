'''
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
提示：
  3 <= nums.length <= 10^3
  -10^3 <= nums[i] <= 10^3
  -10^4 <= target <= 10^4
'''


class Solution:
    # def threeSumClosest(self, nums: List[int], target: int) -> int:
    def threeSumClosest(self, nums, target):
        nums.sort()
        n = len(nums)
        best = 10 ** 7
        print(nums)

        def update(cur):
            nonlocal best
            print(abs(cur - target), abs(best - target))
            if abs(cur - target) < abs(best - target):
                best = cur

        for i in range(n):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l, r = i + 1, n - 1
            while l < r:
                sum = nums[i] + nums[l] + nums[r]
                if sum == target:
                    return target
                update(sum)
                if sum > target:
                    while l < r and nums[r] == nums[r - 1]:
                        r -= 1
                    r -= 1
                else:
                    while l < r and nums[l] == nums[l + 1]:
                        l += 1
                    l += 1
        return best


if __name__ == "__main__":
    arr = [-1, 0, 1, 1, 55]
    target = 3
    ins = Solution()
    res = ins.threeSumClosest(arr, target)
    print(res)
