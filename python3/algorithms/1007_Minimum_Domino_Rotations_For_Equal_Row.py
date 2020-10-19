from typing import List


class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        andAll = 0x3F
        l = len(A)
        for i in range(l):
            andAll &= 1 << A[i] - 1 | 1 << B[i] - 1
            if andAll == 0:
                return -1

        target = 0
        t = andAll & -andAll
        while t != 0:
            t >>= 1
            target += 1

        a = 0
        b = 0
        for i in range(l):
            if A[i] != B[i]:
                if A[i] == target:
                    a += 1
                else:
                    b += 1

        return min(a, b)
