import java.util.*;
class Solution {
    static List<Integer>[] tree;
    static int maxSheep=0;
    
    public int solution(int[] info, int[][] edges) {
        tree=new ArrayList[info.length];
        for(int i=0;i<info.length;i++){
            tree[i]=new ArrayList<>();
        }
        
        for(int[] edge:edges){
            tree[edge[0]].add(edge[1]);
        }
        
        dfs(0,0,0,info, new ArrayList<>(List.of(0)));
        
        return maxSheep;
    }
    static void dfs(int sheep, int wolf, int current, int[] info, List<Integer> nextNodes){
        if(info[current]==0) sheep++;
        else wolf++;
        
        if(wolf>=sheep) return;
        
        maxSheep=Math.max(maxSheep, sheep);
        
        List<Integer> newNextNodes=new ArrayList<>(nextNodes);
        newNextNodes.remove(Integer.valueOf(current));
        newNextNodes.addAll(tree[current]);
        
        for(int next: newNextNodes){
            dfs(sheep, wolf, next, info, newNextNodes);
        }
    }
}