import java.util.*;

class Solution {
    static int zero=0;
    static int one=0;
    public int[] solution(int[][] arr) {
        
        divide(arr.length, arr, 0,0);
        return new int[]{zero, one};
    }
    //쪼개는 함수
    static void divide(int size, int[][] arr, int x,int y){
        
        if(isSame(size,arr,x,y)){
            if(arr[x][y]==0) zero++;
            else one++;
            return;
        }
        int half=size/2;
        divide(half, arr, x,y);
        divide(half,arr,x+half, y);
        divide(half, arr, x, y+half);
        divide(half, arr, x+half, y+half);
        
    }
    //구역이 모두 같은지 확인
    static boolean isSame(int size, int[][] arr,int x, int y){
        int t=arr[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j]!= t) return false;
            }
        }
        
        return true;
    }
}