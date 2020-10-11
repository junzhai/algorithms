#input("word: ")

from sample import utility
from sample.Point import aaa, Point
import random
from sample.Dice import Dice
from pathlib import Path

aaa()

topic = "build-in methods"
sub_topic = "int()"
example = int("1972"); print(f"{topic} : {sub_topic} --> {example}")

sub_topic = "str()"
example = str(23.22)
print(f"{topic} : {sub_topic} --> {example}")

sub_topic = "float()"
example = float(1); print(f"{topic} : {sub_topic} --> {example}")


example = bool(-1); print(f"{topic} : {sub_topic} --> {example}")
example = bool(0); print(f"{topic} : {sub_topic} --> {example}")

sub_topic = "type()"
print(f"{topic} : {sub_topic} --> {type(23.2)}")
print(f"{topic} : {sub_topic} --> {type((1, 3))}")
print(f"{topic} : {sub_topic} --> {type([1, 3])}")
print(f"{topic} : {sub_topic} --> {type({'aa' : 1, 'a' : 3.0})}")


print(repr('ssss'))
print(len('ssssss'))
print(round(12.33))
print(abs(-22.3))
print(max(10, 13, 45))

topic = "String"
msg = """
sssa
asdada
"""

msg1 = '''asdadas
adadasd
adadadadadada'''

msg = "aa bb sss"
print(msg[2])
print(msg[-1])
print(msg[3:6])
print(msg[3:])
print(msg[:6])
print(msg[:])
print(msg[1:-1])

a = 'aaa'
b = 'bbb'
msg = f"{a} [{b}] shit"
print("bb" in msg)
"sssss".upper().lower().replace('ss', 'ss').count('s')
print(f"{topic} : {'split()'} --> {msg.split(' ')}")

topic = "arithmetic Operators"
for operator in ("addition", "subtraction", "multiplication", "division", "int division", "exp", "module"):
    if operator == 'addition':
        print(f"{topic} : {operator} --> {10 + 3}")
    elif operator == 'subtraction':
        print(f"{topic} : {operator} --> {10 - 3}")
    elif operator == 'multiplication':
        print(f"{topic} : {operator} --> {10 * 3}")
    elif operator == 'division':
        print(f"{topic} : {operator} --> {10 / 3}")
    elif operator == 'int division':
        print(f"{topic} : {operator} --> {10 // 3}")
    elif operator == 'module':
        print(f"{topic} : {operator} --> {10 % 3}")
    else:
        print(f"{topic} : {operator} --> {10 ** 3}")

print(10 + 4 * 3 ** 2)

topic = "logical operators"
for c1 in [False, True]:
    for c2 in (False, True):
        if not c1 and not c2:
            print(f"{topic} --> {not c1 and not c2}")
        elif c1 or not c2:
            print(f"{topic} --> {c1 or not c2}")


import math
topic = "math module"
sub_topic = "math.ceil()"; print(f"{topic} : {sub_topic} --> {math.ceil(2.9)}")
sub_topic = "math.floor()"; print(f"{topic} : {sub_topic} --> {math.floor(2.9)}")

topic = "while loop"
i = 1
while i < 8:
    print("*" * i)
    i += 1
else:
    print(f"{topic} --> done")

topic = "Range"
example = ""
for item in range(10):
    example += f"{item} ,"
print(f"{topic} --> {example}")

example = ""
for item in range(6, 10):
    example += f"{item} ,"
print(f"{topic} --> {example}")

example = ""
for item in range(2, 10, 3):
    example += f"{item} ,"
print(f"{topic} --> {example}")

#######################################################################################################################
for i in (7, 2, 7, 2, 2):
    print("|" * i)


topic = "list/tuple"; print("#" * 120)
names = ['item1', 'item4', 'item2', 'item3', 'item5']
names[1] = 'item4.4'
names.insert(0, 'item0')
names.append('item6')
names.pop()
names.sort()
print(names.reverse())
print(f"{topic} --> {names}")
print(f"{topic} --> {names[2]}")
print(f"{topic} --> {names[1:-2]}")
print(f"{topic} --> {names[1:-2]}")
print(f"{topic} : {'in'} --> {'ssss' in names}")
print(f"{topic} : {'index()'} --> {names.index('item1')}")
utility.p(topic, example=names.count('item31'), sub_topic='count()')

numbers = [2, 2, 4, 6, 3, 4, 6]
ret = []
for i in numbers:
    if i not in ret:
        ret.append(i)
print(ret)

cord = (1, 2, 3); cord1 = [4, 5, 6]
x, y, z = cord; a, b, c = cord1
print(f"{topic} : {'unpacking'} --> {x}, {y}, {z}, {a}, {b}, {c}")

free = [(1,2), [3,4], (5,6,7)]
print(f"{topic} --> {free[2][2]}")

topic = "dictionary"; print("#" * 120)
customer = {
    "name" : 'ssss',
    "age" : 92,
    'boo' : False
}
customer['name'] = "books"
customer['child'] = 'trum'
utility.p(example=customer['name'], sub_topic='', topic=topic)
utility.p(topic, '', customer.get('aaa', 'default'))

topic = 'Exception'; print("#" * 120)
try:
    int('asas')
except ValueError as e:
    utility.p(topic, '', 'caught ValueError: {}'.format(e))
    try:
        v = 10 // 0
    except ZeroDivisionError:
        utility.p(topic, '', 'caught ZeroDivisionError')
except Exception as e:
    print("wont be here")


topic = 'Class'; print("#" * 120)
point1 = Point()
point1.x = 11; point1.y = 2
point1.draw(topic)


class NewPoint(Point):
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def draw(self, topic: str):
        utility.p(topic, '__init__()', f'draw on loc [{self.x}, {self.y}]')


point2 = NewPoint(30, 40)
point2.x = 600
point2.draw(topic)
point2.move(topic)
print(point2)

topic = "Random"
utility.p(topic, 'randint()', random.randint(10, 30))
utility.p(topic, 'choice()', random.choice((1, 2, 3, 4, 5)))
dice = Dice()
utility.p(topic, '', dice.roll())

topic = "pathlib"
path = Path("../../Documents/GitHub/algorithms/python3/sample")
utility.p(topic, 'exists()', path.exists())
path = Path()
for f in path.glob("*.py"):
    utility.p(topic, 'glob()', f)

# arithmetic operators
# logical operators
# comparation operators
# flow control
# function, parameters;
# variable types: numbers (int, float), string, boolean, list, tuple, dict
# exception
# class, inheritance
# package -> module -> class/method

# how to access caught error
# null/None value
# variable length parameters to methods, ...
# module or class?
# magic methods