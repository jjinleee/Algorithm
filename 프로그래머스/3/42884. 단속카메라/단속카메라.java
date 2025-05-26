import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //진출 지점 순으로 정렬
        Arrays.sort(routes, (a,b)->a[1]-b[1]);
        
        //경계값에 카메라 위치
        int cnt=0;
        int camera=Integer.MIN_VALUE;
        for(int[] route : routes){
            if(camera<route[0]){
                cnt++;
                camera=route[1];
            } 
        }
        
        return cnt;
    }
}