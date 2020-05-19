class Solution {
  findClosedNumbers(num) {
    const [numBin, numOrigin] = this.decimal2Bin(num);
    if (!numOrigin.includes('0')) return [`10${numOrigin.slice(1)}`, -1];
    let [bigger, smaller] = [null, null];
    for (let i = numBin.length - 1; i >= 0; i--) {
      if (numBin.slice(i, i + 2) === '10') {
        let tmp = numBin.slice(i + 2);
        const [count0, count1] = this.findMatchChar(tmp);
        tmp = this.generateSameCharStr('1', count1) + this.generateSameCharStr('0', count0);
        smaller = `${numBin.slice(0, i)}01${tmp}`;
        break;
      }
    }
    for (let i = numBin.length - 1; i >= 0; i--) {
      if (numBin.slice(i, i + 2) === '01') {
        let tmp = numBin.slice(i + 2);
        const [count0, count1] = this.findMatchChar(tmp);
        tmp = this.generateSameCharStr('0', count0) + this.generateSameCharStr('1', count1);
        bigger = `${numBin.slice(0, i)}10${tmp}`;
        break;
      }
    }
    return [this.bin2Decimal(bigger), this.bin2Decimal(smaller)];
  }

  decimal2Bin(num) {
    const origin = num.toString(2);
    return [`0${origin}`, origin];
  }

  bin2Decimal(bin) {
    return parseInt(bin, 2);
  }

  findMatchChar(tmp) {
    const count0 = tmp.match(/0/g);
    const count1 = tmp.match(/1/g);
    return [count0 ? count0.length : 0, count1 ? count1.length : 0]
  }

  generateSameCharStr(char, num) {
    return Array.from(new Array(num))
      .reduce((acc, cv) => `${acc}${char}`, '')
  }
}


ins = new Solution();
final1 = ins.findClosedNumbers(20);
console.log(final1);