class Solution {
    public int solution(String name) {
        int answer = 0;
        int n=name.length();
        
        //세로이동
        for(int i=0;i<n;i++){
            char s=name.charAt(i);
            answer+=Math.min(s-65, 91-s);
        }
        
        
        
        //가로이동
        int min=n-1; //커서 순차이동
        //두가지 경우 중 최소
        for(int i=0;i<n;i++){
            int next=i+1;
            while(next<n && name.charAt(next)=='A') next++;
            
            //순차적 i까지 왔다가 되돌아서 뒤쪽 
            // i까지 감 + 되돌아 옴 + 뒤쪽 남은칸 =2 * i + n-next
            int rightThenLeft=2*i+n-next;
            
            //끝까지 갔다가 되돌아옴
            //n까지 갔다가 n-next만큼 되돌아옴 = i+ 2* (n-next)
            int leftThenRight=i+2*(n-next);
            
            min=Math.min(min, Math.min(rightThenLeft, leftThenRight));
            
        }
        return answer+min;
    }
}