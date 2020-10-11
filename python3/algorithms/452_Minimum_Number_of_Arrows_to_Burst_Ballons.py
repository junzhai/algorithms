from typing import List
from functools import cmp_to_key


class Solution:

    def findMinArrowShots(self, points: List[List[int]]) -> int:
        def compare(o1: List[int], o2: List[int]) -> int:
            if o1[0] < o2[0]:
                return -1
            elif o1[0] > o2[0]:
                return 1
            elif o1[1] < o2[1]:
                return -1
            elif o1[1] > o2[1]:
                return 1
            else:
                return 0

        l = len(points)
        if l == 0:
            return 0

        points = sorted(points, key=cmp_to_key(compare))

        ret = 0
        end = None
        for point in points:
            if end is None or point[0] > end:
                ret += 1
                end = point[1]
            elif point[1] < end:
                end = point[1]

        return ret


if __name__ == '__main__':
    s = Solution()
    ret = s.findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]])
    print(ret)
