/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
  const recursion = k => {
    let [index1, index2] = [0, 0];
    while (true) {
      if (index1 === m) return nums2[index2 + k - 1];
      if (index2 === n) return nums1[index1 + k - 1];
      if (k === 1) return Math.min(nums1[index1], nums2[index2]);

      let newIndex1 = Math.min(parseInt(index1 + k / 2 - 1), m - 1);
      let newIndex2 = Math.min(parseInt(index2 + k / 2 - 1), n - 1);
      const [pivot1, pivot2] = [nums1[newIndex1], nums2[newIndex2]];
      if (pivot1 <= pivot2) {
        k -= newIndex1 - index1 + 1;
        index1 = newIndex1 + 1;
      } else {
        k -= newIndex2 - index2 + 1;
        index2 = newIndex2 + 1;
      }
    }
  };

  var [m, n] = [nums1.length, nums2.length];
  const totalLength = m + n;
  return totalLength % 2 === 1
    ? recursion(parseInt((totalLength + 1) / 2))
    : (recursion(parseInt(totalLength / 2)) + recursion(parseInt(totalLength / 2) + 1)) / 2;
};