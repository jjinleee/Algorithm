import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int n=dungeons.length;
        int[] orders= new int[n];
        for(int i=0;i<n;i++){
            orders[i]=i;
        }
        boolean[] visited= new boolean[n];
        List<int[]> result=new ArrayList<>();
        
        //순서 순열구함
        dfs(orders, new ArrayList<>(), visited, result);
        
        
        //구한 순서별로 카운트세서 최대구함
        int max=0;
        for(int[] o : result){
            int cnt=0;
            int curk=k;
            for(int or : o){
                if(curk>=dungeons[or][0]){
                    curk-=dungeons[or][1];
                    cnt++;
                } else break;
                if(max<cnt) max=cnt;
            }
        }

        return max;
    }
    static void dfs(int[] orders,List<Integer> current, boolean[] visited, List<int[]> result){
        if(current.size()==orders.length){
            result.add(current.stream().mapToInt(i->i).toArray());
            return;
        }
        
        for(int i=0;i<orders.length;i++){
            if(!visited[i]){
                visited[i]=true;
                current.add(orders[i]);
                dfs(orders,current ,visited, result);
                current.remove(current.size() - 1);
                visited[i]=false;
            }
        }
    }
}