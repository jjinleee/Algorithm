import java.util.*;

class Solution {
    char[][] oper = {
        {'*', '+', '-'},
        {'*', '-', '+'},
        {'+', '-', '*'},
        {'+', '*', '-'},
        {'-', '*', '+'},
        {'-', '+', '*'}
    };

    public long solution(String expression) {
        long answer = 0;

        StringBuilder sb = new StringBuilder();
        List<Long> num = new ArrayList<>();
        List<Character> operation = new ArrayList<>();

        for (char c : expression.toCharArray()) {
            if (c == '*' || c == '+' || c == '-') {
                num.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operation.add(c);
            } else {
                sb.append(c);
            }
        }

        // 마지막 숫자 추가
        num.add(Long.parseLong(sb.toString()));

        for (char[] priority : oper) {
            // 우선순위마다 새로운 리스트로 계산
            List<Long> nums = new ArrayList<>(num);
            List<Character> ops = new ArrayList<>(operation);

            for (char op : priority) {
                while (ops.contains(op)) {
                    int idx = ops.indexOf(op);

                    long n1 = nums.get(idx);
                    long n2 = nums.get(idx + 1);
                    long result;

                    if (op == '*') {
                        result = n1 * n2;
                    } else if (op == '-') {
                        result = n1 - n2;
                    } else {
                        result = n1 + n2;
                    }

                    nums.set(idx, result);
                    nums.remove(idx + 1);
                    ops.remove(idx);
                }
            }

            answer = Math.max(answer, Math.abs(nums.get(0)));
        }

        return answer;
    }
}