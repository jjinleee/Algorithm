import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set=new HashSet<>();
        int n=elements.length;
        
        for(int size=1;size<=n;size++){
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=i;j<i+size;j++ ){
                    sum+=elements[j%n];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}