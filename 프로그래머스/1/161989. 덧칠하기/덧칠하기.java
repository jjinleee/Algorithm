import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int end=section[0]+m-1;
        for(int i=1;i<section.length;i++){
            if(section[i]>end){
                end=section[i]+m-1;
                answer++;
            }
        }
        return answer;
    }
}