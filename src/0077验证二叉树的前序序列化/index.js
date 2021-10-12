/**
 * @param {string} preorder
 * @return {boolean}
 */
var isValidSerialization1 = function (preorder) {
  let i = 0;
  const n = preorder.length;
  const stack = [1];
  while (i < n) {
    if (!stack.length) {
      return false;
    }
    if (preorder[i] === ',') {
      i++;
    } else if (preorder[i] === '#') {
      stack[stack.length - 1] -= 1;
      if (!stack[stack.length - 1]) {
        stack.pop();
      }
      i++;
    } else {
      while (i < n && preorder[i] !== ',') {
        i++;
      }
      stack[stack.length - 1] -= 1;
      if (!stack[stack.length - 1]) {
        stack.pop();
      }
      stack.push(2);
    }
  }
  return !stack.length;
};

var isValidSerialization2 = function (preorder) {
  let i = 0;
  const n = preorder.length;
  let count = 1;
  while (i < n) {
    if (!count) {
      return false;
    }
    if (preorder[i] === ',') {
      i++;
    } else if (preorder[i] === '#') {
      count--;
      i++;
    } else {
      while (i < n && preorder[i] !== ',') {
        i++;
      }
      count++;
    }
  }
  return !count;
};
