
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Sort cars by position in descending order
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (position[i] < position[j]) {
                    int temp = position[i];
                    position[i] = position[j];
                    position[j] = temp;

                    temp = speed[i];
                    speed[i] = speed[j];
                    speed[j] = temp;
                }
            }
        }

        int fleets = 0;
        double slowestTime = 0.0;

        for (int i = 0; i < n; i++) {
            double time = (double) (target - position[i]) / speed[i];

            if (time > slowestTime) {
                fleets++;
                slowestTime = time;
            }
        }

        return fleets;
    }
}
