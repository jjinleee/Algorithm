import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b)-> a[1]-b[1]);
        
        int camera=Integer.MIN_VALUE;
        int count=0;
        
        for(int[] route:routes){
            if(camera<route[0]){
                count++;
                camera=route[1];
            }
        }
        
        return count;
    
    }
}