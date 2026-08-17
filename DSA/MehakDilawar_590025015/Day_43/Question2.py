#Write an efficient function to pair up 2n integers into n pairs such that the sum of the minimum values of each pair is maximized.
#Input: [1, 4, 3, 2]. Output: 4.
def arrayPairSum(nums):
    nums.sort()
    return sum(nums[::2])

nums = list(map(int, input("Enter the integers separated by spaces: ").split()))
if len(nums) % 2 != 0:
    print("Please enter an even number of integers.")
else:
    print("Maximum sum of minimums:", arrayPairSum(nums))
