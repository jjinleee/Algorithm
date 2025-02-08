import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int cnt=0;
        if(n==1000) n--;

        if(n<100) {
            cnt=n;
        } else {
            cnt=99;
            for(int i=100;i<=n;i++){
                if(check(i)) cnt++;
            }
        }
        System.out.println(cnt);
    }   

    //세자릿수만 확인하면 된다, 1000은 
    private static boolean check(int n){
        int[] nums= new int[3];
        for(int i=0;i<3;i++){
            nums[i]=n%10;
            n/=10;
        }

        if((nums[2]-nums[1])==(nums[1]-nums[0])) return true;
        else return false;
    }    
}