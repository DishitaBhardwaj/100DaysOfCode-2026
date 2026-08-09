from collections import deque

class FrontMiddleBackQueue:
    def __init__(self):
        self.left = deque()   # holds the front half
        self.right = deque()  # holds the back half (size >= left size)

    def _balance(self):
        # Keep invariant: len(left) <= len(right) <= len(left) + 1
        if len(self.left) > len(self.right) + 1:
            self.right.appendleft(self.left.pop())
        elif len(self.right) > len(self.left) + 1:
            self.left.append(self.right.popleft())

    def pushFront(self, val: int) -> None:
        self.left.appendleft(val)
        self._balance()

    def pushMiddle(self, val: int) -> None:
        if len(self.left) < len(self.right):
            self.left.append(val)
        else:
            self.right.appendleft(val)
        self._balance()

    def pushBack(self, val: int) -> None:
        self.right.append(val)
        self._balance()

    def popFront(self) -> int:
        if not self.left and not self.right:
            return -1
        val = self.left.popleft() if self.left else self.right.popleft()
        self._balance()
        return val

    def popMiddle(self) -> int:
        if not self.left and not self.right:
            return -1
        if len(self.left) < len(self.right):
            val = self.right.popleft()
        else:
            val = self.left.pop()
        self._balance()
        return val

    def popBack(self) -> int:
        if not self.left and not self.right:
            return -1
        val = self.right.pop() if self.right else self.left.pop()
        self._balance()
        return val


# Your FrontMiddleBackQueue object will be instantiated and called as such:
# obj = FrontMiddleBackQueue()
# obj.pushFront(val)
# obj.pushMiddle(val)
# obj.pushBack(val)
# param_4 = obj.popFront()
# param_5 = obj.popMiddle()
# param_6 = obj.popBack()


# ---- Local testing block (for VS Code, not needed on LeetCode) ----
if __name__ == "__main__":
    q = FrontMiddleBackQueue()
    q.pushFront(1)     # [1]
    q.pushBack(2)      # [1, 2]
    q.pushMiddle(3)    # [1, 3, 2]
    q.pushMiddle(4)    # [1, 4, 3, 2]
    print(q.popFront())   # 1  -> [4, 3, 2]
    print(q.popMiddle())  # 3  -> [4, 2]
    print(q.popMiddle())  # 4  -> [2]
    print(q.popBack())    # 2  -> []
    print(q.popFront())   # -1 -> [] (empty)