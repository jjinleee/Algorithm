import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int n=targets.length;
        int[] answer = new int[n];
        
        //가장 적은 횟수로 만들수있는 문자 저장
        Map<Character, Integer> key=new HashMap<>();
        for(String k : keymap){
            for(int i=0;i<k.length();i++){
                char c= k.charAt(i);
                
                if(!key.containsKey(c) || (key.get(c)>i+1)) key.put(c,i+1); //적은횟수로갱신
                
            }
        }
        
        for(int i=0;i<n;i++){
            int sum=0;
            boolean flag=true;
            String word=targets[i];
            for(char c : word.toCharArray()){
                if(!key.containsKey(c)){
                    answer[i]=-1;
                    flag=false;
                    break;
                }
                sum+=key.get(c);
                //System.out.print(key.get(c));
            }
            if(flag) answer[i]=sum;
        }
        return answer;
    }
}