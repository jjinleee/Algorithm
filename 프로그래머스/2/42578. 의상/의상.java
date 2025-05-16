import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        //종류별로 map에 넣어줌
        Map<String,Integer> map=new HashMap<>();
        for(String[] c : clothes){
            String type=c[1];
            map.put(type,map.getOrDefault(type,0)+1);
        }
        //옷 조합(각 원소 합+원소 곱)
        int mul=1;
        for(String m : map.keySet()){
            int cnt=map.get(m);
            mul*=(cnt+1); //원소곱 (안입는 경우의 수도 포함)
        }
        
        return mul-1;
    }
}