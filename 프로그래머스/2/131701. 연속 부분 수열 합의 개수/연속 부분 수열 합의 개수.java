import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        //시작위치, 길이 정함
        for (int start = 0; start < n; start++) {
            int sum = 0;

            for (int length = 0; length < n; length++) {
                sum += elements[(start + length) % n];
                set.add(sum);
            }
        }

        return set.size();
    }
}