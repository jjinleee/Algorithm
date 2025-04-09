import java.util.*;

//크루스칼 알고리즘
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        
        //비용기준 오름차순 정렬
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        parent=new int[n]; 
        for(int i=0;i<n;i++) parent[i]=i; //자기자신을 부모로 설정
        
        int totalCost=0;
        int count=0;
        
        for(int[] edge:costs){
            int a=edge[0];
            int b=edge[1];
            int cost=edge[2];
            
            //같은 집합이 아니면 합치고 비용더함. n-1개까지했으면 완료
            if(find(a)!=find(b)){
                union(a,b);
                totalCost+=cost;
                count++;
                if(count==n-1) break; 
            }
        }
        
        
        return totalCost;
    }
    //부모를 찾는 함수
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    

    
    //같은 집합으로 합치는 함수
    void union(int a, int b){
        int roota=find(a);
        int rootb=find(b);
        parent[rootb]=roota;
    }
}