import java.util.*;

class Solution {
    public String solution(String p) {
        return convert(p);
    }

    private String convert(String p) {
        if (p.isEmpty()) return "";

        // 1. u, v 분리
        int balance = 0;
        int idx = 0;
        do {
            if (p.charAt(idx) == '(') balance++;
            else balance--;
            idx++;
        } while (balance != 0);

        String u = p.substring(0, idx);
        String v = p.substring(idx);

        // 2. u가 올바른 괄호 문자열인지 확인
        if (isCorrect(u)) {
            return u + convert(v);
        }

        // 3. 올바르지 않은 경우
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(convert(v));
        sb.append(")");

        // u의 첫/마지막 제거 후 괄호 뒤집기
        for (int i = 1; i < u.length() - 1; i++) {
            sb.append(u.charAt(i) == '(' ? ')' : '(');
        }

        return sb.toString();
    }

    private boolean isCorrect(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            else cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }
}