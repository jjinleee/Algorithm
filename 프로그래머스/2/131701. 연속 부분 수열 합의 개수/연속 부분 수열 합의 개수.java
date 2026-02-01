import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set= new HashSet<>();
        int n=elements.length;
        
        //길이 1~n 까지 반복
        for(int i=1;i<=n;i++){
            //시작인덱스
            for(int j=0;j<n;j++){
                int sum=0;
                for(int k=j;k<j+i;k++){
                    if(k>=n) sum+=elements[k%n];
                    else sum+=elements[k];
                }
                set.add(sum);
            }            
        }
        
        return set.size();
    }
}