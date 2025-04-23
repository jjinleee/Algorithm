import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times); //오름차순 정렬
        
        //가장 긴시간을 right로 지정
        long left=0;
        long right=times[times.length-1] * (long)n;

        //이분탐색
        while(left<=right){
            long mid=(left+right)/2;
            long complete=0;
            //mid시간동안 검사할수있는 사람 수
            for(int i=0;i<times.length;i++){
                complete+=mid/times[i];
            }
            
            //모두 검사를 못했다면 시간을 늘림
            if(complete <n) left=mid+1;
            else { //검사했다면 시간을 줄여봄
                right=mid-1;
                answer=mid;
            }
        }
        return answer;
    }
}