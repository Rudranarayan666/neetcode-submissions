import heapq

class Solution:
    def lastStoneWeight(self, stones):
        
        # Python has a Min Heap by default.
        # Store negative values to simulate a Max Heap.
        maxHeap = [-stone for stone in stones]
        heapq.heapify(maxHeap)

        # Smash the two heaviest stones
        while len(maxHeap) > 1:

            x = -heapq.heappop(maxHeap)  # heaviest
            y = -heapq.heappop(maxHeap)  # second heaviest

            if x != y:
                heapq.heappush(maxHeap, -(x - y))

        return -maxHeap[0] if maxHeap else 0