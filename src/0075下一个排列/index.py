'''
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。

示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]

示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]

示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]

示例 4：
输入：nums = [1]
输出：[1]
 
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100
'''


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if n <= 1:
            return nums

        # 从右向左循环数组
        i = n - 1
        while i > 0:
            # 找到相邻的两位元素，右侧的数值大于左侧的数值
            if nums[i] > nums[i - 1]:
                # 从右向左循环 n - 1到 i区间的数组元素
                j = n - 1
                while j >= i:
                    # 找到在此区间内比 i - 1位置的数值大的元素，开始进行换位操作
                    if nums[j] > nums[i - 1]:
                        # 移位交换操作
                        self.exchangeVal(nums, i - 1, j)
                        # 将 n - 1到 i区间的元素调整为升序，即为最小的数值排列
                        self.reverseArr(nums, i, n - 1)
                        return
                    j -= 1
            i -= 1
        # 如果是降序数组，则反转数组，称为最小数值的排列
        self.reverseArr(nums, 0, n - 1)

    def exchangeVal(self, arr, left, right):
        arr[left], arr[right] = arr[right], arr[left]

    def reverseArr(self, arr, begin, end):
        while begin < end:
            self.exchangeVal(arr, begin, end)
            begin += 1
            end -= 1


if __name__ == '__main__':
    points = [1, 2, 3]
    ins = Solution()
    ins.nextPermutation(points)
    print(points)
