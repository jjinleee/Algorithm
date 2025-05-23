class Solution {
    public int solution(String name) {
        int answer=0;
        
        for(int i=0;i<name.length();i++){
            //다음 알파벳으로 갈지,이전 알파벳으로 갈지
            char s= name.charAt(i);
            answer+=Math.min(s-'A', 91-s);
        }
        int len=name.length();
        int minMove=len-1;
        for (int i = 0; i < len; i++) {
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 여기서 핵심!
            int move = i + len - next + Math.min(i, len - next);
            minMove=Math.min(minMove, move);
        }
        
        return answer+minMove;
    }
}