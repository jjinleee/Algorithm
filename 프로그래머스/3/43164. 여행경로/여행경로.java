import java.util.*;

class Solution {
    List<String> list=new ArrayList<>();
    List<String> tmp=new ArrayList<>();
    boolean[] visited;
    int n;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b)->a[1].compareTo(b[1]));
        n=tickets.length;
        visited=new boolean[n];
        
        tmp.add("ICN");
        dfs("ICN",tickets,0 );
        
        return list.toArray(new String[0]);
    }
    void dfs(String cur, String[][] tickets, int cnt ){
        if(cnt==n){
            list=new ArrayList<>(tmp);
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]&& tickets[i][0].equals(cur)){
                String dest=tickets[i][1];
                visited[i]=true;
                tmp.add(dest);
                dfs(dest, tickets, cnt+1);
                
                if(!list.isEmpty()) return;
                
                visited[i]=false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}