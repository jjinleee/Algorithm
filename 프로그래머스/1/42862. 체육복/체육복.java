import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer> lostPeople = new ArrayList<>();
        List<Integer> reservePeople = new ArrayList<>();

        // 여벌이 있지만 도난당한 경우 제거
        for (int l : lost) {
            boolean isSelfReserve = false;
            for (int i = 0; i < reserve.length; i++) {
                if (l == reserve[i]) {
                    reserve[i] = -1; // 사용 표시
                    isSelfReserve = true;
                    break;
                }
            }
            if (!isSelfReserve) lostPeople.add(l); // 진짜로 체육복 없는 사람만 추가
        }

        // 빌려주기
        for (int r : reserve) {
            if (r == -1) continue;
            if (lostPeople.contains(r - 1)) {
                lostPeople.remove(Integer.valueOf(r - 1));
            } else if (lostPeople.contains(r + 1)) {
                lostPeople.remove(Integer.valueOf(r + 1));
            }
        }

        return n - lostPeople.size();
    }
}