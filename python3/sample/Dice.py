import random

class Dice:
    def roll(self) -> tuple:
        first = random.randint(1, 6)
        second = random.randint(1, 6)
        return first, second


