class Resolution {
  // 方法1 排序取值
  kClosest1(points, K) {
    return points
      .sort(([x1, y1], [x2, y2]) => ((x1 ** 2 + y1 ** 2) - (x2 ** 2 + y2 ** 2)))
      .slice(0, K);
  }

  // 方法2 分治算法
  kClosest2(points, K) {
    const dist = i => points[i][0] ** 2 + points[i][1] ** 2;
    const work = (left, right, K) => {
      if (left >= right) return;
      const [oLeft, oRight] = [left, right];
      const pivot = dist(Math.floor((left + right) / 2));
      while (left < right) {
        while (left < right && dist(left) < pivot) left += 1;
        while (left < right && dist(right) > pivot) right -= 1;
        if (dist(left) === dist(right)) break;
        [points[left], points[right]] = [points[right], points[left]];
      }
      K < left - oLeft + 1
        ? work(oLeft, left, K)
        : work(left + 1, oRight, K - (left - oLeft + 1));
    };

    work(0, points.length - 1, K);
    return points.slice(0, K);
  }
}

const points = [[3, 3], [5, -1], [-2, 4], [1, 3], [-2, 2], [-3, 2], [-4, 2], [-1, 2], [0, 2], [4, 2], [2, 2]];
const K = 2;

const ins = new Resolution();
const final1 = ins.kClosest1(points, K);
const final2 = ins.kClosest2(points, K);

console.log(final1, final2);