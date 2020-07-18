/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
    const Roman2Int = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    };

    let num = 0;
    const sLen = s.length - 1;
    for (let i = 0; i < sLen; i++) {
        if (Roman2Int[s[i]] < Roman2Int[s[i + 1]]) {
            num -= Roman2Int[s[i]];
        } else {
            num += Roman2Int[s[i]];
        }
    }
    return num += Roman2Int[s[sLen]];
};