from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        l0 = [0, nums[1]]
        for n in nums[2:]:
            l0.append(max(n + l0[-2], l0[-1]))
        l1 = [nums[0], nums[0]]
        for n in nums[2:]:
            l1.append(max(n + l1[-2], l1[-1]))

        return max(l0[-1], l1[-2])


if __name__ == '__main__':
    s = Solution()
    print(s.rob([2, 3, 2]))
    print(s.rob([1, 2, 3, 1]))
