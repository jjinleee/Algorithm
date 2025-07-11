import java.util.*;

class Solution {
    static Set<Integer> list=new HashSet<>();
    public int solution(String numbers) {
        boolean[] visited=new boolean[numbers.length()];
        
        dfs("",visited, numbers);
        int cnt=0;
        for(int l : list){
            //stem.out.println("소수 : "+ l);
            if(isPrime(l)) cnt++;
        }
        
        return cnt;
    }
    
    static void dfs(String current, boolean[] visited, String numbers){
        if(!current.isEmpty()){
            list.add(Integer.parseInt(current));

        }
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(current+numbers.charAt(i), visited, numbers);
                visited[i]=false;
            }
        }
    }
    
    static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3 || n==5) return true;
        if(n%2==0 || n% 3==0 || n%5==0) return false;
        for(int i=7;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}