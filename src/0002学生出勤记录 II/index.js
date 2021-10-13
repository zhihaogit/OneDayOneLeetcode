class Solution {
  constructor() {
    arr = ['A', 'L', 'P']
  }

  // 方法1
  checkRecord1(n) {
    const condition = [];
    const work = (n, tmp) => {
      if (n === 0) {
        return condition.push(tmp);
      }
      for (let i = 0; i < this.arr.length; i++) {
        work(n - 1, tmp + arr[i]);
      }
    };
    work(n, '');

    const count = 0;
    const len = condition.length;
    for (let i = 0; i < len; i++) {
      const current = condition[i];
      if (current.include('A') || current.include('LLL')) {
        count += 1;
      }
    }

    return [condition, len - count];
  }
}

const ins = new Solution();
final1 = ins.checkRecord1(2);
console.log(final1);
