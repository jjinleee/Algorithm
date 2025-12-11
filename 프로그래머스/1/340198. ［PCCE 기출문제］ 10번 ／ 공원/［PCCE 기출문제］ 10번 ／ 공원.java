import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int n=park.length;
        int m=park[0].length;
        Arrays.sort(mats);
        
        for(int i=mats.length-1;i>=0;i--){
            int size=mats[i];
            
            for(int r=0;r<=n-size;r++){
                for(int j=0;j<=m-size;j++){
                    if(canPlace(r,j,size,park)) return size;
                }
            }
        }
        return -1;
    }
    boolean canPlace(int n,int m, int size, String[][] park){
        int r=park.length;
        int c=park[0].length;
        
        for(int i=n;i<n+size;i++){
            for(int j=m;j<m+size;j++){
                if(i<0 || i>=r || j<0 || j>=c) return false;
                if(!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}