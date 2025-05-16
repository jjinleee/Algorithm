import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        //내림차순 정렬위한 리스트
        List<Integer> list=new ArrayList<>();
        for(int s:score){
            list.add(s);
        }
        list.sort(Collections.reverseOrder());
        
        //m개씩 묶어서 answer+=i번째 원소*m
        //단 i가 list.size()를 벗어나지 않는지 체크
        int i=m-1;
        while(true){
            if(i>=list.size()) break;
            
            answer+=list.get(i)*m;
            i+=m;
        }
        
        return answer;
    }
}