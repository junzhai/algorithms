class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        total = [0] * 26
        for c in s:
            total[ord(c) - ord('a')] += 1

        i = 0
        ret = ""
        while i < len(s):
            count = [0] * 26
            minChar = chr(ord('z') + 1)
            minIdx = len(s)

            for j in range(i, len(s)):
                ch = s[j]
                idx = ord(ch) - ord('a')

                if total[idx] == 0:
                    continue

                count[idx] += 1

                if ch < minChar:
                    minChar = ch
                    minIdx = j

                if count[idx] == total[idx]:
                    break

            for j in range(i, minIdx):
                idx = ord(s[j]) - ord('a')
                if total[idx] > 0:
                    total[idx] -= 1

            if minIdx < len(s):
                ret += minChar
                total[ord(minChar) - ord('a')] = 0

            i = minIdx + 1

        return ret


if __name__ == '__main__':
    s = Solution()
    c = s.removeDuplicateLetters('cbacdcbc')
    a = s.removeDuplicateLetters('bcabc')
    b = s.removeDuplicateLetters('cdadabcc')
    pass
