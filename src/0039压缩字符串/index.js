/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function (chars) {
  let anchor = 0;
  let write = 0;
  for (let read = 0; read < chars.length; read++) {
    if (read === chars.length - 1 || chars[read + 1] != chars[read]) {
      chars[write] = chars[anchor];
      write += 1;
      if (read > anchor) {
        const str = `${read - anchor + 1}`;
        for (let j = 0; j < str.length; j++) {
          chars[write] = str[j];
          write += 1;
        }
      }
      anchor = read + 1;
    }
  }
  return write;
};