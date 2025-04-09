import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left=0;
        int right=people.length-1;
        while(left<=right){
        //가장 무거운사람+가벼운사람 태울수있으면 태움
            if(people[left]+people[right]<=limit){
                left++;
                right--;
                answer++;
            } else{ //못태우면 무거운 사람만 태움
                right--;
                answer++;
            }
        }
    
        return answer;
    }
}