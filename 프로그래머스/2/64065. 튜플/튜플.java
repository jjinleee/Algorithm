import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set= new LinkedHashSet<>();
        s=s.substring(2,s.length()-2); //앞뒤제거
        
        String[] tmp=s.split("\\},\\{");
        Arrays.sort(tmp, (a,b)-> a.length()-b.length());
        
        for(String t : tmp){
            String[] num=t.split(",");
            for(String n : num){
                set.add(Integer.parseInt(n));
            }
        }
        
        return set.stream().mapToInt(i->i).toArray();
    }
    
}