import java.util.*;

class Solution {
    List<String> answer=new ArrayList<>();
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b)-> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        int n=tickets.length;
        
        visited=new boolean[n];
        List<String> tmp=new ArrayList<>();
        tmp.add("ICN");
        dfs("ICN",tickets, tmp);
        
        return answer.toArray(new String[0]);
    }
    void dfs(String cur, String[][] tickets, List<String> tmp ){
        if(tmp.size()==tickets.length+1){
            answer=new ArrayList<>(tmp);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && cur.equals(tickets[i][0])){
                visited[i]=true;
                tmp.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, tmp);
                
                
                visited[i]=false;
                tmp.remove(tmp.size()-1);
                
                if(!answer.isEmpty()) return;
            }
        }
        
        return;
    }
}