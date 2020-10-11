from sample.utility import p

def aaa():
    p("Module", '', "aaaa")


def bbb():
    print("bbb")


class Point:
    def move(self, topic: str):
        p(topic, 'inheritance', 'move()')

    def draw(self, topic: str):
        p(topic, '', f'draw on [{self.x}, {self.y}]')
