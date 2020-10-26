class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        cups = [poured]
        for i in range(0, query_row):
            cups.append(0.0)
            for j in reversed(range(0, i + 1)):
                cups[j] = 0.0 if cups[j] <= 1.0 else (cups[j] - 1) / 2
                if j + 1 <= i + 1:
                    cups[j + 1] += cups[j]

        return min(cups[query_glass], 1.0)
