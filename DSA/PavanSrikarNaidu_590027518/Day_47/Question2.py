class Solution:
    def kthSmallest(self, A, B, k):
        # Ensure A is the smaller array
        if len(A) > len(B):
            A, B = B, A

        m, n = len(A), len(B)
        left, right = max(0, k - n), min(k, m)

        while left <= right:
            cutA = (left + right) // 2
            cutB = k - cutA

            leftA = float('-inf') if cutA == 0 else A[cutA - 1]
            rightA = float('inf') if cutA == m else A[cutA]

            leftB = float('-inf') if cutB == 0 else B[cutB - 1]
            rightB = float('inf') if cutB == n else B[cutB]

            if leftA <= rightB and leftB <= rightA:
                return max(leftA, leftB)
            elif leftA > rightB:
                right = cutA - 1
            else:
                left = cutA + 1


if __name__ == "__main__":
    A = [2, 3, 6, 7]
    B = [1, 4, 5, 8]
    k = 5

    sol = Solution()
    print(sol.kthSmallest(A, B, k))