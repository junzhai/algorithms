from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        if row == 0:
            return False

        col = len(matrix[0])
        if col == 0:
            return False

        l = 0
        r = row * col - 1

        while l <= r:
            m = (l + r) // 2
            rr = m // col
            cc = m % col
            if target == matrix[rr][cc]:
                return True
            if target < matrix[rr][cc]:
                r = m - 1
            else:
                l = m + 1
        else:
            return False
