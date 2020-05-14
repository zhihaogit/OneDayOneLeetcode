import random

class Resolution(object):
    # 方法1
    def kClosest1(self, points, K):
        '''
        欧几里得距离
        1. 先计算出距离每个点距离 原点的距离
        2. 再排序
        3. 最后取出前 K个
        时间复杂度 O(N log N)
        空间 O(N)
        '''
        points.sort(key=lambda p: p[0]**2 + p[1]**2)
        return points[:K]

    # 方法2
    def kClosest2(self, points, K):
        '''
        快速排序（分治算法）
        取中间值，左右两边分别计算
        根据 K值来决定左右两边需要计算的元素个数
        '''
        dist = lambda i: points[i][0]**2 + points[i][1]**2

        def work(left, right, K):
            if left >= right: return
            oLeft, oRight = left, right
            random_index = random.randint(left, right)
            index = int((left + right) / 2) if random_index == left or random_index == right else random_index
            pivot = dist(index)
            while left < right :
                while left < right and dist(left) < pivot: left += 1
                while left < right and dist(right) > pivot: right -= 1
                if dist(left) == pivot and dist(right) == pivot: break
                points[left], points[right] = points[right], points[left]
            if K < left - oLeft + 1:
                work(oLeft, left, K)
            else:
                work(left + 1, oRight, K - (left - oLeft + 1))
      
        work(0, len(points) - 1, K)
        return points[:K]

if __name__ == '__main__':
    points = [[3, 3], [5, -1], [-2, 4], [1, 3], [-2, 2], [-3, 2], [-4, 2], [-1, 2], [0, 2], [4, 2], [2, 2], [2, 2]]
    K = 2
    ins = Resolution()
    final1 = ins.kClosest1(points, K)
    final2 = ins.kClosest2(points, K)
    print (final1, final2)