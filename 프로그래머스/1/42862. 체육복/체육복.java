import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lo=new HashSet<>();
        Set<Integer> re=new HashSet<>();
        
        for(int l : lost) lo.add(l);
        for(int r : reserve){
            if(lo.contains(r)){
                lo.remove(r);
            } else re.add(r);
        }
        int max=n-lo.size();
        
        for(int l : new ArrayList<>(lo)){
            if(re.contains(l-1)){
                max++;
                re.remove(l-1);
            } else if( re.contains(l+1)){
                max++;
                re.remove(l+1);
            }
        }
        
        return max;
    }
}