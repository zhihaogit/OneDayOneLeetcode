class Solution:
    def respace(self, dictionary, sentence):
        length = len(sentence)
        dict_set = set(dictionary)
        d = [0] * (length + 1)
        for i in range(length + 1):
            d[i] = d[i - 1] + 1
            for j in range(i + 1):
                if sentence[j: i] in dict_set:
                    d[i] = min(d[i], d[j])
        return d[-1] - 1


if __name__ == '__main__':
    dictionary = ["looked", "just", "like", "her", "brother", "brother"]
    sentence = "jesslookedjustliketimherbrotherbrotherher"
    ins = Solution()
    final1 = ins.respace(dictionary, sentence)
    print(final1)
