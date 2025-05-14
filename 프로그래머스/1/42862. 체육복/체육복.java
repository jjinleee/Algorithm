import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2]; // 학생 번호: 1~n, 앞뒤 검사 위해 +2

        // 여벌 체육복 표시 (+1)
        for (int r : reserve) {
            students[r]++;
        }

        // 도난 처리 (-1)
        for (int l : lost) {
            students[l]--;
        }

        // 체육복 빌려주기 로직
        for (int i = 1; i <= n; i++) {
            if (students[i] == -1) { // 체육복 없는 학생
                if (students[i - 1] == 1) { // 앞 사람이 여벌 있음
                    students[i]++;
                    students[i - 1]--;
                } else if (students[i + 1] == 1) { // 뒷 사람이 여벌 있음
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        // 체육복 있는 학생 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0) answer++;
        }

        return answer;
    }
}