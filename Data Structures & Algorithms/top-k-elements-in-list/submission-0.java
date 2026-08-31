class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Bucket: index = frequency
        List<Integer>[] buckets = new List[n + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(num);
        }

        // Collect top k
        int[] result = new int[k];
        int index = 0;

        for (int count = n; count >= 1 && index < k; count--) {
            if (buckets[count] != null) {
                for (int num : buckets[count]) {
                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
