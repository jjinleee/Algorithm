import java.util.*;

//의상 종류별 카운트 개수세서 +1 한것을 곱함-1 하면 경우의 수 구할 수 있다
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map=new HashMap<>();
        for(String[] c: clothes){
            map.put(c[1], map.getOrDefault(c[1],0)+1);
        }
        
        int answer=1;

        for(String type : map.keySet()){
            answer*=(map.get(type)+1);
        }
        answer--; //아무것도 안입은 경우 제외
        
        return answer; 
    }
}