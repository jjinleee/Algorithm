import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        long[] nums=new long[n];
        long[] prime=new long[n];

        //수 입력받기
        for(int i=0;i<n;i++){
            nums[i]=Long.parseLong(br.readLine());   
        }

        //n보다 같거나 큰 소수
        for(int i=0;i<n;i++){
            long j=nums[i];
            while(true){
                if(isPrime(j)){
                    prime[i]=j;
                    break;
                }
                j++;
            }
        }

        //소수 출력
        for(long p:prime){
            System.out.println(p);
        }

    }

    //소수 판별 함수->런타임에러발생 
    public static boolean isPrime(long n){
        if(n<=1) return false;
        if (n == 2) return true; // 2는 소수
        if (n % 2 == 0) return false; // 2를 제외한 짝수는 소수가 아님
        for (long i = 3; i * i <= n; i += 2) { // 홀수만 검사
            if (n % i == 0) return false;
        }
        return true;
    }
}