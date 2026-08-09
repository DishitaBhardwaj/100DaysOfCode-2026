from collections import deque

class FrontMiddleBackQueue:
    def __init__(self):
        self.left = deque()
        self.right = deque()

    def balance(self):
        while len(self.left) > len(self.right):
            self.right.appendleft(self.left.pop())
        while len(self.right) > len(self.left) + 1:
            self.left.append(self.right.popleft())

    def pushFront(self, val):
        self.left.appendleft(val)
        self.balance()

    def pushMiddle(self, val):
        if len(self.left) == len(self.right):
            self.right.appendleft(val)
        else:
            self.left.append(val)
        self.balance()

    def pushBack(self, val):
        self.right.append(val)
        self.balance()

    def popFront(self):
        if not self.left and not self.right:
            return -1
        if self.left:
            val = self.left.popleft()
        else:
            val = self.right.popleft()
        self.balance()
        return val

    def popMiddle(self):
        if not self.left and not self.right:
            return -1
        if len(self.left) == len(self.right):
            val = self.left.pop()
        else:
            val = self.right.popleft()
        self.balance()
        return val

    def popBack(self):
        if not self.left and not self.right:
            return -1
        val = self.right.pop()
        self.balance()
        return val