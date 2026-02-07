import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. 사전 초기화 (A~Z)
        Map<String, Integer> dict = new HashMap<>();
        int idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), idx++);
        }
        
        List<Integer> output = new ArrayList<>();
        int n = msg.length();
        int i = 0; // 현재 위치
        
        while (i < n) {
            int end = i + 1;
            String w = msg.substring(i, end); //한글자
            
            // 2. 사전에 있는 가장 긴 문자열 찾기
            while (end <= n && dict.containsKey(msg.substring(i, end))) {
                w = msg.substring(i, end); // 현재까지는 사전에 있음
                end++;
            }
            
            // 3. w의 색인 번호 출력
            output.add(dict.get(w));
            
            // 4. w + 다음 글자(c)를 사전에 추가
            //    end - 1 까지가 w였고, end가 범위 안이면 w + c가 됨
            if (end <= n) {
                String wc = msg.substring(i, end); // w + c
                if (!dict.containsKey(wc)) {
                    dict.put(wc, idx++);
                }
            }
            
            // 5. i를 w 길이만큼 이동
            i += w.length();
        }
        
        int[] answer = new int[output.size()];
        for (int k = 0; k < output.size(); k++) {
            answer[k] = output.get(k);
        }
        
        return answer;
    }
}