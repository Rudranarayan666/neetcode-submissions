class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // Binary Search
        while (low < high) {
            int mid = low + (high - low) / 2;

            long hours = 0;

            for (int pile : piles) {
                // ceil(pile / mid)
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                // mid works, try smaller speed
                high = mid;
            } else {
                // mid is too slow
                low = mid + 1;
            }
        }

        return low;
    }
}