import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left=1;
        int right=distance;
        
        int[] extended=Arrays.copyOf(rocks, rocks.length+1);
        extended[rocks.length]=distance; //배열의 마지막에 거리 추가
         
        while(left<=right){
            int mid=(left+right)/2;
            int prev=0; //시작지점
            int removed=0; //제거한 돌개수
            
            for(int i=0;i<extended.length;i++){
                if(extended[i]-prev<mid){ //거리가 mid보다 작으면 돌제거
                    removed++;
                } else prev=extended[i];
            }
            
            //mid 거리 유지가능->거리 늘림
            if(removed<=n){
                left=mid+1;
                answer=mid;
            } else right=mid-1; //거리줄임
            
        }
        return answer;
    }
}