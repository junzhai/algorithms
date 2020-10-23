from typing import List


class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        ranges = []
        minVal = nums[0]
        for n in nums:
            if n <= minVal:
                minVal = n
                continue

            while len(ranges) > 0 and ranges[-1][0] < n:
                if ranges[-1][1] > n:
                    return True
                del ranges[-1]
            else:
                ranges.append((minVal, n))

        return False
