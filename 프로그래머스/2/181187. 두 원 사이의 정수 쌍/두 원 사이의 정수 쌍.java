class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        long r1_p = (long) r1 * r1;
        long r2_p = (long) r2 * r2;

        for (long x = 1; x <= r2; x++) {

            long x_p = x * x;

            long maxY = (long) Math.floor(
                Math.sqrt(r2_p - x_p)
            );

            long minY;

            if (x < r1) {
                minY = (long) Math.ceil(
                    Math.sqrt(r1_p - x_p)
                );
            } else {
                minY = 0;
            }

            answer += maxY - minY + 1;
        }

        return answer * 4;
    }
}