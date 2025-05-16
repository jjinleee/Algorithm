import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        //동명이인있으니까 해시로 카운트->0이 아닌 사람은 완주못한 사람
        Map<String,Integer> p=new HashMap<>();
        for(String person : participant){
            p.put(person, p.getOrDefault(person,0)+1);
        }
        for(String c : completion){
            p.put(c, p.get(c)-1);
        }
        
        for(String name: p.keySet()){
            if(p.get(name)!=0) return name;
        }
        return "0";
    }
}