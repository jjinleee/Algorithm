import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int size = 1; size <= s.length() / 2; size++) {
            StringBuilder sb = new StringBuilder();

            String prev = s.substring(0, size);
            int count = 1;

            for (int i = size; i < s.length(); i += size) {
                String cur = s.substring(i, Math.min(i + size, s.length()));

                if (prev.equals(cur)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }

                    sb.append(prev);

                    prev = cur;
                    count = 1;
                }
            }

            if (count > 1) {
                sb.append(count);
            }

            sb.append(prev);

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}