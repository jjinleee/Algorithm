import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;
    static int[] nums;
    static int[] operator=new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        nums= new int [n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            operator[i]=Integer.parseInt(st.nextToken());
        }

        backtrack(nums[0],1);

        System.out.println(max);
        System.out.println(min);
    }

    static void backtrack(int num, int dept){
        //정해진 길이만큼 도달했으면 출력
        if(dept==n){
            max=Math.max(max, num);
            min=Math.min(min, num);
            return;
        }

        //백트래킹 재귀호출
        for(int i=0;i<4;i++){
            if(operator[i]>0){
                operator[i]--;

                if(i==0){
                    backtrack(num+nums[dept], dept+1);
                } else if(i==1){
                    backtrack(num-nums[dept], dept+1);
                } else if(i==2){
                    backtrack(num*nums[dept], dept+1);
                } else if(i==3){
                    backtrack(num/nums[dept], dept+1);
                }
                operator[i]++;
            }
        }
    }    
}