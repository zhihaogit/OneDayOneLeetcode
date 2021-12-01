var MinStack = function () {
  this.stack = [];
  this.pointer = 0;
  this.min = Number.MAX_SAFE_INTEGER;
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function (val) {
  this.stack[this.pointer++] = val;
  this.min = Math.min(this.min, val);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  const num = this.stack[--this.pointer];
  if (num === this.min) {
    this.min = Number.MAX_SAFE_INTEGER;
    for (let i = 0; i < this.pointer; i++) {
      this.min = Math.min(this.min, this.stack[i]);
    }
  }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  return this.stack[this.pointer - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
  return this.min;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
