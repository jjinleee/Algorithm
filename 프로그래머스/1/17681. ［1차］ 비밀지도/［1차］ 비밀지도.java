class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 1. 비트 OR 연산 → 지도 겹침 결과
            int merged = arr1[i] | arr2[i];

            // 2. 이진수 문자열로 변환 + 앞에 0채우기
            String binary = String.format("%" + n + "s", Integer.toBinaryString(merged)).replace(' ', '0');

            // 3. 1이면 "#"으로, 0이면 " "으로 치환
            answer[i] = binary.replace('1', '#').replace('0', ' ');
        }

        return answer;
    }
}