class Solution {
    public int solution(int n) { 
        int answer=0;
        String temp="";
        while(n != 0) {
            temp += n%3;
            n /= 3;
        }
        
        return Integer.parseInt(temp,3);
    }
}