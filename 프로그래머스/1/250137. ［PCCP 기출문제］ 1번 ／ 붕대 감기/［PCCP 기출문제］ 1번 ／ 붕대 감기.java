import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int power=health;
        int time=0;
        
        for(int[] a : attacks){
            int mid=a[0]-time-1;
            power+=mid*bandage[1];
            if(mid>=bandage[0]) { //연속성공
                power+=(mid/bandage[0])*bandage[2];
            }
            if(power>health) power=health; //최댓값넘기지않게
            
            power-=a[1]; //공격
            if(power<=0) return -1; //죽음
            time=a[0]; //시간경과
            //System.out.println(power);
        }
        
        return power;
    }
}