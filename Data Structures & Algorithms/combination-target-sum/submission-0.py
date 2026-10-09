
class Solution:
    def combinationSum(self, nums: list[int], target: int) -> list[list[int]]:
        result = []

        def backtrack(start, remaining, current):
            if remaining == 0:
                result.append(current.copy())
                return

            for i in range(start, len(nums)):
                if nums[i] > remaining:
                    continue

                current.append(nums[i])

                # Reuse the same number by passing i
                backtrack(i, remaining - nums[i], current)

                # Backtrack: remove the last number
                current.pop()

        backtrack(0, target, [])
        return result
