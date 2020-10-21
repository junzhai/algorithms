from typing import List


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        ret = []
        for n in asteroids:
            if n < 0:
                n = -n
                while len(ret) > 0 and ret[-1] > 0:
                    v = ret[-1]
                    if v > n:
                        break
                    elif v == n:
                        del ret[-1]
                        break
                    else:
                        del ret[-1]
                else:
                    ret.append(-n)
            else:
                ret.append(n)

        return ret
