import java.util.*;

//동명이인이 있기때문에 map으로 카운트해야함-> 해시 유형
class Solution {
    public String solution(String[] participant, String[] completion) {
        //이름별 카운트
        Map<String,Integer> runners=new HashMap<>();
        for(String people : participant){
            runners.put(people, runners.getOrDefault(people,0)+1);
        }
        
        //완주한 이름-1
        for(String c : completion){
            int n=runners.get(c);
            runners.put(c, n-1);
        }
        //값이 0이 아닌 선수는 완주하지 못한것
        for(String fail : runners.keySet()){
            if(runners.get(fail)!=0){
                return fail;
            }
        }
        return "";
    }
}