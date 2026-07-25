import java.util.*;

class Solution {
    public String solution(String p) {
        // 1. 빈 문자열이면 빈 문자열 반환
        if (p.isEmpty()) return "";

        // 2. 문자열을 균형잡힌 괄호 문자열 u, v로 분리
        int sum = 0;
        int idx = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') sum++;
            else sum--;

            if (sum == 0) {
                idx = i;
                break;
            }
        }

        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);

        // 3. u가 올바른 괄호 문자열인 경우
        if (isCorrect(u)) {
            return u + solution(v);
        }

        // 4. u가 올바른 괄호 문자열이 아닌 경우
        StringBuilder sb = new StringBuilder();

        sb.append('(');
        sb.append(solution(v));
        sb.append(')');

        // u의 첫 번째와 마지막 문자 제거 후 괄호 방향 뒤집기
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }

    boolean isCorrect(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;

                if (count < 0) return false;
            }
        }

        return count == 0;
    }
}