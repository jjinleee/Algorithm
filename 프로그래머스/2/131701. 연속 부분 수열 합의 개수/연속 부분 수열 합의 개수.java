import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n=elements.length;
        int[] prefix=new int[2*n+1];
        
        for(int i=0;i<2*n;i++){
            prefix[i+1]=prefix[i]+elements[i%n];
        }
        
        Set<Integer> set= new HashSet<>();
        for(int i=1;i<=n;i++){
            int sum=0;
            for(int start=0;start<n;start++){
                sum=prefix[start+i]-prefix[start];
                set.add(sum);
            }
        }
            
        return set.size();
    }
}