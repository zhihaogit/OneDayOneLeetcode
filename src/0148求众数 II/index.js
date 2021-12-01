/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function (nums) {
  let num1 = null;
  let num2 = null;
  let vote1 = 0;
  let vote2 = 0;
  for (let num of nums) {
    if (vote1 > 0 && num === num1) {
      vote1++;
    } else if (vote2 > 0 && num === num2) {
      vote2++;
    } else if (!vote1) {
      num1 = num;
      vote1 = 1;
    } else if (!vote2) {
      num2 = num;
      vote2 = 1;
    } else {
      vote1--;
      vote2--;
    }
  }

  let cnt1 = 0;
  let cnt2 = 0;
  for (let num of nums) {
    if (vote1 > 0 && num === num1) {
      cnt1++;
    }
    if (vote2 > 0 && num === num2) {
      cnt2++;
    }
  }

  const ans = [];
  const limit = ~~(nums.length / 3);
  if (vote1 > 0 && cnt1 > limit) {
    ans.push(num1);
  }
  if (vote2 > 0 && cnt2 > limit) {
    ans.push(num2);
  }
  return ans;
};
