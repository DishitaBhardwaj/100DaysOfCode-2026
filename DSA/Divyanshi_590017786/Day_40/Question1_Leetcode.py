from collections import deque

class FrontMiddleBackQueue:

    def __init__(self):
        self.left = deque()
        self.right = deque()

    def balance(self):
        # left can have equal elements or one extra
        if len(self.left) > len(self.right) + 1:
            self.right.appendleft(self.left.pop())
        elif len(self.left) < len(self.right):
            self.left.append(self.right.popleft())

    def pushFront(self, val: int) -> None:
        self.left.appendleft(val)
        self.balance()

    def pushMiddle(self, val: int) -> None:
        if len(self.left) > len(self.right):
            self.right.appendleft(self.left.pop())
        self.left.append(val)
        self.balance()

    def pushBack(self, val: int) -> None:
        self.right.append(val)
        self.balance()

    def popFront(self) -> int:
        if not self.left and not self.right:
            return -1
        val = self.left.popleft()
        self.balance()
        return val

    def popMiddle(self) -> int:
        if not self.left and not self.right:
            return -1
        val = self.left.pop()
        self.balance()
        return val

    def popBack(self) -> int:
        if not self.left and not self.right:
            return -1

        if self.right:
            val = self.right.pop()
        else:
            val = self.left.pop()

        self.balance()
        return val