import java.util.*;


//조합가능한 모든 숫자 구해야함 -> dfs
class Solution {
    static Set<Integer> list= new HashSet<>();
    public int solution(String numbers) {
        boolean[] visited= new boolean[numbers.length()];
        
        dfs("",visited, numbers);
        int cnt=0;
        for(int l : list){
            System.out.println(l);
            if(isPrime(l)) cnt++;
        }
        
        return cnt;
    }
    //모든 숫자 조합 구하는 함수(반드시 모든 숫자를 쓰지 않아도됨)
    //맨앞이 0이면 0을 삭제해야함
    static void dfs(String current, boolean[] visited, String numbers){
        if(!current.isEmpty()){
            list.add(Integer.parseInt(current));
        }
        
        //여기를 반복문으로 안하고 방문여부로 체크하고 재귀했음
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(current+numbers.charAt(i),visited, numbers);
                visited[i]=false;
            } 
        }
    }
    //소수판별함수
    static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3 || n==5) return true;
        if(n%2==0 || n%3==0 || n%5==0) return false;
        for(int i=7;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}