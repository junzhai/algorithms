from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        l = len(nums)
        k %= l
        if k != 0:
            count = 0
            for i in range(k):
                if count >= l:
                    return
                v = nums[i]
                j = i
                while (j + k) % l != i:
                    j = (j + k) % l
                    tmp = nums[j]
                    nums[j] = v
                    v = tmp
                    count += 1
                else:
                    nums[i] = v
                    count += 1


if __name__ == '__main__':
    s = Solution()
    l = [1, 2, 3, 4, 5, 6, 7]
    s.rotate(l, 3)
    print(l)
