import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left=0;
        int right=people.length-1;
        
        while(left<=right){
            //가장 가벼운 +무거운 <=제한 이면 둘다태움
            if(people[left]+people[right]<=limit){
                left++;
                right--;
                answer++;
            } else{ //안되면 무거운 사람만 태움
                right--;
                answer++;
            }
        }
        
        return answer;
    }
}