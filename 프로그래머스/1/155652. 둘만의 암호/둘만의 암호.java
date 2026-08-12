import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();

        for (char c : skip.toCharArray()) {
            set.add(c);
        }

        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            int count = 0;

            while (count < index) {
                c++;

                if (c > 'z') {
                    c = 'a';
                }

                if (!set.contains(c)) {
                    count++;
                }
            }

            answer.append(c);
        }

        return answer.toString();
    }
}