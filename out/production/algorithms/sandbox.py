from functools import cmp_to_key
from bisect import bisect_left


class Solution:
    def findMinArrowShots(self, points: list[list[int]]) -> int:
        def compare(a: list[int], b: list[int]) -> int:
            ret = a[1] - b[1]
            if ret == 0:
                ret = b[0] - a[0]
            return ret

        sorted(points, key=cmp_to_key(compare))

        l = len(points)
        end = [item[1] for item in points]
        dp = [0] * l

        idx = 0
        while idx < l:
            if idx > 0 and end[idx] == end[idx - 1]:
                dp[idx] = dp[idx - 1]
                continue

            i = bisect_left(end, points[idx][0], 0, idx)
            if i > 0:
                dp[idx] = dp[i - 1] + 1
            else:
                dp[idx] = 1
            idx += 1

        return dp[l - 1]


if __name__ == '__main__':
    solution = Solution()
    solution.findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]])
