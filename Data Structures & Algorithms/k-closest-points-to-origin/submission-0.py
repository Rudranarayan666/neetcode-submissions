import heapq

class Solution:
    def kClosest(self, points, k):

        max_heap = []

        for x, y in points:

            dist = x * x + y * y

            # Python has a Min Heap,
            # so store negative distance
            heapq.heappush(max_heap, (-dist, x, y))

            if len(max_heap) > k:
                heapq.heappop(max_heap)

        result = []

        for _, x, y in max_heap:
            result.append([x, y])

        return result