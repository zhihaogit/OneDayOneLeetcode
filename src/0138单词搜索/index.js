/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
  const check = (board, word, visited, x, y, index) => {
    if (word[index] !== board[x][y]) {
      return false;
    } else if (index === word.length - 1) {
      return true;
    }
    visited[x][y] = true;
    const directions = [[0, -1], [0, 1], [-1, 0], [1, 0]];
    let result = false;
    for (let direction in directions) {
      const newX = x + direction[0];
      const newY = y + direction[1];
      if (newX >= 0 && newX < board.length
        && newY >= 0 && newY < board[0].length
        && !visited[newX][newY]) {
        const flag = check(board, word, visited, newX, newY, index + 1);
        if (flag) {
          result = flag;
          break;
        }
      }
    }
    visited[x][y] = false;
    return result;
  };

  const m = board.length;
  const n = board[0].length;
  const visited = new Array(m).fill(false).map(_ => new Array(n).fill(false));
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      const flag = check(board, word, visited, i, j, 0);
      if (flag) {
        return true;
      }
    }
  }
  return false;
};
