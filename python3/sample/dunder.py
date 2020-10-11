from sample.Point import Point


class MagicPoint(Point):
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def draw(self, topic: str):
        print("draw on loc [{}, {}]".format(self.x, self.y))

    def __repr__(self):
        return "MagicPoint(%d, %d)" % (self.x, self.y)

    def __str__(self):
        return f"MagicPoint, {self.x}, {self.x}"

    def __add__(self, other):
        if not isinstance(other, Point):
            return NotImplemented
        return self.x * self.y + other.x * other.y

    def __len__(self):
        return self.x * self.y


point = MagicPoint(10, 20)
print(repr(point))
print(point.__repr__())

print(str(point))
print(point.__str__())

print(len(point))
print(point.__len__())

print(int.__add__(2, 4))
print(str.__add__('a', 'b'))

p1 = MagicPoint(1, 2); p2 = MagicPoint(3, 4)
print(p1 + p2)
print(p1 + 'aaa')